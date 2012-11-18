(ns alpha_card.tests
  (:require [alpha_card.models.letters :as letters])
  (:use [clojure.test]))

(deftest letters
  (testing "Letters"
    (testing "at index"
      (is (= "a" (letters/letter-at 1))))
    (testing "letters for key combo"
      (is (= "a" (letters/letter-for-key-combo #{32})))
      (is (= "c" (letters/letter-for-key-combo #{32 39})))
      (is (= "c" (letters/letter-for-key-combo #{39 32})))
      (is (= "g" (letters/letter-for-key-combo #{39 32 38})))
      (is (= "q" (letters/letter-for-key-combo #{32 40})))
          )))
