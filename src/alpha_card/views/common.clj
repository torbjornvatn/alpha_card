(ns alpha-card.views.common
  (:require [noir.cljs.core :as cljs])
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css include-js html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "alpha-card"]
               (include-css "/css/reset.css")
               (include-css "/css/bootstrap.min.css")
               (include-css "/css/default.css")]
              [:body
               [:div#wrapper
                content]
               (cljs/include-scripts :with-jquery)
               (include-js "http://code.jquery.com/jquery-latest.js")
               (include-js "js/bootstrap.min.js")]))
