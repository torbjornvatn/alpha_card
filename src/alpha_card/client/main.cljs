(ns alpha_card.client.main
  (:require [noir.cljs.client.watcher :as watcher]
            [clojure.browser.repl :as repl]
            [crate.core :as crate]
            [crate.element :as element]
            [clojure.string :as string])
  (:use [jayq.core :only [$ append inner text bind empty]])
  (:use-macros [crate.def-macros :only [defpartial]]))

;;************************************************
;; Dev stuff
;;************************************************

(watcher/init)
;;(repl/connect "http://localhost:9000/repl")

;;************************************************
;; Code
;;************************************************

(def $bokstav ($ :#bokstav))
(def $bilde ($ :#bilde))
(def $body ($ :body))

(def letters '("a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z" "æ" "ø" "å"))

(defn letter-at [index]
  (nth letters (- index 1)))

(def key-exp {40 4 37 3 38 2 39 1 32 0})

(defn binary [x]
  (reduce * (repeat x 2)))

(defn letter-for-key-combo [key-combo]
  (let [index (reduce + (map #(binary (key-exp %)) key-combo))]
  (letter-at index)))

(def key-presses (atom #{}))

(bind $body :keydown
  (fn [event]
    (let [new-key-press (. event -which)]
        (swap! key-presses conj new-key-press)
        (append $bilde (crate/html (element/image "/img/a.jpg" "Noir")))
        (text $bokstav (print-keys @key-presses)))))

(bind $body :keyup
  (fn [event]
    (swap! key-presses disj (. event -which))
    (empty $bilde)
    (text $bokstav (print-keys @key-presses))))

(defn print-keys [keys-pressed]
  (if (seq (filter #(key-exp %) keys-pressed))
    (letter-for-key-combo keys-pressed)
    ""))


