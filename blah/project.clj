(defproject blah "0.1.0-SNAPSHOT"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.293"]]

  :plugins [[lein-figwheel "0.5.8"]
            [lein-cljsbuild "1.1.4"]]

  :clean-targets ^{:protect false} ["resources/public/cljs"
                                    "resources/public/core.js"
                                    "target"]

  :cljsbuild {:builds [{:id           "dev"
                        :source-paths ["src"]
                        :figwheel     true
                        :compiler     {:main                 blah.core
                                       :asset-path           "cljs"
                                       :output-to            "resources/public/core.js"
                                       :output-dir           "resources/public/cljs"
                                       :closure-defines      {goog.DEBUG true}
                                       :language-in          :ecmascript5
                                       :source-map-timestamp true}}
                       {:id           "dist"
                        :source-paths ["src"]
                        :compiler     {:main            blah.core
                                       :output-to       "resources/public/core.js"
                                       :output-dir      "target/cljs"
                                       :optimizations   :advanced
                                       :closure-defines {goog.DEBUG false}
                                       :language-in     :ecmascript5
                                       :pretty-print    false}}]}

  :figwheel {:repl false
             :server-logfile "target/figwheel.log"
             :css-dirs ["resources/public"]})
