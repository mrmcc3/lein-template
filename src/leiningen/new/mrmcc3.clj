(ns leiningen.new.mrmcc3
  (:require [leiningen.new.templates :as t]
            [leiningen.core.main :as main]))

(def quotes
  ["The best way to predict the future is to invent it. -Alan Kay"
   "Lisp isn't a language, it's a building material. -Alan Kay"
   "Simple things should be simple, complex things should be possible. -Alan Kay"
   "Everything should be as simple as possible, but not simpler. -Albert Einstein"
   "Controlling complexity is the essence of computer programming. -Brian Kernighan"
   "The unavoidable price of reliability is simplicity. -C.A.R. Hoare"
   "Simplicity is prerequisite for reliability. -Edsger W. Dijkstra"
   "Elegance is not a dispensable luxury but a quality that decides between success and failure. -Edsger W. Dijkstra"
   "Deleted code is debugged code. -Jeff Sickel"
   "First, solve the problem. Then, write the code. -John Johnson"
   "Simplicity is the ultimate sophistication. -Leonardo da Vinci"
   "Programming is not about typing... it's about thinking. -Rich Hickey"
   "Design is about pulling things apart. -Rich Hickey"
   "The true delight is in the finding out rather than in the knowing. -Isaac Asimov"
   "The enjoyment of one's tools is an essential ingredient of successful work. -Donald E. Knuth"
   "Not all those who wander are lost. -J.R.R. Tolkien"
   "The best way to learn is to do. -P.R. Halmos"
   "Learn the rules like a pro, so you can break them like an artist. -Pablo Picasso"
   "Your hacking starts... NOW!"
   "Write you some Clojure for Great Good!"])

(defn mrmcc3 [name]
  (let [render (t/renderer "mrmcc3")
        main-ns (t/multi-segment (t/sanitize-ns name))
        data {:raw  name
              :name (t/project-name name)
              :ns   main-ns
              :path (t/name-to-path main-ns)
              :quote (rand-nth quotes)}]
    (main/info "Generating a new clojure project!")
    (t/->files
      data
      ["src/{{path}}.clj" (render "core.clj" data)]
      ["project.clj" (render "project.clj" data)]
      [".gitignore" (render "gitignore" data)]
      "resources")))
