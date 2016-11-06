(def +project+ '{{raw}})
(def +version+ "0.1.0-SNAPSHOT")

(set-env!
  :source-paths #{"src"}
  :resource-paths #{"resources"}
  :dependencies '[[org.clojure/clojure "1.8.0"]])

(task-options!
  pom {:project +project+ :version +version+})
