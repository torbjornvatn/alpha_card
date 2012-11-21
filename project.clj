(defproject alpha-card "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://exampl.com/FIXME"
  :dependencies [[noir-cljs "0.3.6" :exclusions [org.clojure/clojure jayq]]
                 [jayq "0.2.2"]
                 [crate "0.2.1"]
                 [noir "1.3.0-beta10"]
                 [org.clojure/clojure "1.4.0"]]
  :cljsbuild {:builds [{}]}
  :main ^{:skip-aot true} alpha-card.server)
