(defproject alpha-card "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://exampl.com/FIXME"
  :dependencies [[jayq "0.2.2"]
                 [crate "0.2.1"]
                 [noir "1.3.0-beta10"]
                 [org.clojure/clojure "1.4.0"]]
  :plugins [[lein-cljsbuild "0.2.9"]]
  :cljsbuild {
    :builds [{:source-path "src/alpha_card/client"
      :compiler {:output-to "resources/public/js/main.js"
                  :optimizations :whitespace
                  :pretty-print true}}]}
  :main alpha-card.server)
