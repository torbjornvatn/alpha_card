(ns alpha-card.client.main
  (:require [noir.cljs.client.watcher :as watcher]
            [clojure.browser.repl :as repl]
            [crate.core :as crate])
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

(defpartial key-down [key_code]
  [:p.alert (str "Du har trykket:" (. key_code -which))])

(def $body ($ :body))

(bind $body :keydown
      (fn [event]
        (append $content (key-down event))))

