(ns alpha-card.views.main
  (:require [alpha-card.views.common :as common])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/" []
  (common/layout
    [:div.hero-unit
      [:h1#tittel "Bokstavkort"]]
    [:div.container-fluid
      [:div.row-fluid
        [:div#bokstav.span6]
        [:div#bilde.span6]]]))


