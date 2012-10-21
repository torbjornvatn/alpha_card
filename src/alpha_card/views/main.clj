(ns alpha-card.views.main
  (:require [alpha-card.views.common :as common])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/" []
         (common/layout
           [:div#content]))
