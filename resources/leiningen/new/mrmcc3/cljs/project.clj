(defproject {{raw}} "0.1.0-SNAPSHOT"

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.9.946"]
                 [rum "0.11.1"]]

  :plugins [[lein-figwheel "0.5.14"]
            [lein-cljsbuild "1.1.7"]]

  :aliases {"dev"  ["figwheel"]
            "dist" ["do" ["clean"] ["cljsbuild" "once" "dist"]]}

  :clean-targets ^{:protect false} ["resources/public/cljs"
                                    "resources/public/app.js"
                                    "target"]

  :cljsbuild {:builds [{:id           "dev"
                        :source-paths ["src"]
                        :figwheel     {:on-jsload "{{ns}}/mount-app"}
                        :compiler     {:main                 {{ns}}
                                       :output-to            "resources/public/app.js"
                                       :output-dir           "resources/public/cljs"
                                       :asset-path           "cljs"
                                       :source-map-timestamp true}}
                       {:id           "dist"
                        :source-paths ["src"]
                        :compiler     {:main            {{ns}}
                                       :output-to       "resources/public/app.js"
                                       :optimizations   :advanced
                                       :pretty-print    false}}]}

  :figwheel {:repl false
             :server-logfile "target/figwheel.log"
             :css-dirs ["resources/public"]})
