(ns alpha-card.client.main
  (:require [noir.cljs.client.watcher :as watcher]
            [clojure.browser.repl :as repl]
            [crate.core :as crate]
            [clojure.string :as string])
  (:use [jayq.core :only [$ append bind]])
  (:use-macros [crate.macros :only [defpartial]]))

;;************************************************
;; Dev stuff
;;************************************************

(watcher/init)
;;(repl/connect "http://localhost:9000/repl")

;;************************************************
;; Code
;;************************************************

(def $content ($ :#content))

(def key-map {40 "↓" 37 "←" 38 "↑" 39 "→" 32 "—"})

(def $body ($ :body))

(def key-presses (atom #{}))

(bind $body :keydown
  (fn [event]
  (swap! key-presses conj (. event -which))
  (append $content (print-keys @key-presses))))

(defn print-keys [keys-pressed]
  (str "Du har trykket: " (string/join " " keys-pressed)))


