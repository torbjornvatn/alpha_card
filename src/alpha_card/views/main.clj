(ns alpha-card.views.main
  (:require [alpha-card.views.common :as common])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/" []
         (common/layout
           [:div.hero-unit
            [:h1 "Bokstavkort"]]
           [:div
            [:h3 "Du har trykket: "]]
            [:div#bokstav]
            [:div#bilde]))

