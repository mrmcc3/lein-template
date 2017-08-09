(defproject {{raw}} "0.1.0-SNAPSHOT"

  :dependencies [[org.clojure/clojure "1.9.0-alpha17"]
                 [org.clojure/clojurescript "1.9.854"]

                 #_[com.cognitect/transit-cljs "0.8.239"]
                 #_[org.clojure/spec.alpha "0.1.123"]
                 #_[org.clojure/test.check "0.9.0"]
                 #_[datascript "0.16.1"]

                 [rum "0.10.8"]]

  :plugins [[lein-figwheel "0.5.11"]
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
                                       :language-in          :ecmascript5
                                       :source-map-timestamp true}}
                       {:id           "dist"
                        :source-paths ["src"]
                        :compiler     {:main            {{ns}}
                                       :output-to       "resources/public/app.js"
                                       :optimizations   :advanced
                                       :closure-defines {goog.DEBUG false}
                                       :language-in     :ecmascript5
                                       :pretty-print    false}}]}

  :figwheel {:repl false
             :server-logfile "target/figwheel.log"
             :css-dirs ["resources/public"]})
