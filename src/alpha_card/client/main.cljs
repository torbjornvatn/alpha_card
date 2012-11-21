(ns alpha_card.client.main
  (:require [clojure.browser.repl :as repl]
            [crate.core :refer [html] :as c]
            [crate.element :refer [image] :as ce]
            [jayq.core :as jq]
            [jayq.util :as ju]
            [clojure.string :as string])
  (:use-macros [crate.def-macros :only [defpartial]]))

;;************************************************
;; Code
;;************************************************

(def $ jq/$)
(def $bokstav ($ :#bokstav))
(def $bilde ($ :#bilde))
(def $body ($ :body))

(def letters '("A" "B" "C" "D" "E" "F" "G" "H" "I" "J" "K" "L" "M" "N" "O" "P" "Q" "R" "S" "T" "U" "V" "W" "X" "Y" "Z" "Æ" "Ø" "Å"))

(defn letter-at [index]
  (nth letters (- index 1)))

(def key-exp {40 4 37 3 38 2 39 1 32 0})

(defn binary [x]
  (reduce * (repeat x 2)))

(defn letter-for-key-combo [key-combo]
  (let [index (reduce + (map #(binary (key-exp %)) key-combo))]
  (letter-at index)))

(def key-presses (atom #{}))

(defn find-letter [keys-pressed]
  (if (seq (filter #(key-exp %) keys-pressed))
    (letter-for-key-combo keys-pressed)
    ""))

(defn print-image [letter]
  (let [$children (jq/children ($ :#bilde))]
    (if (= (.size $children) 0 )
      (jq/append $bilde (c/html (ce/image (str "/img/" letter ".jpg")))))))

(jq/bind $body :keydown
  (fn [event]
    (swap! key-presses conj (. event -which))
    (let [letter (find-letter @key-presses)]
      (if (not-empty letter)
        ((jq/inner $bokstav (c/html [:p (str letter "☞")]))
        (print-image letter))))))

(jq/bind $body :keyup
  (fn [event]
    (swap! key-presses disj (. event -which))
    (jq/text $bokstav (find-letter @key-presses))
    (jq/empty $bilde)))

