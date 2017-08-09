(ns {{ns}}
  (:require
    [rum.core :as rum]))

(rum/defc app []
  [:.app "{{quote}}"])

(defn mount-app []
  (rum/mount (app) (js/document.getElementById "app")))

(defn ^:export init []
  (mount-app))
