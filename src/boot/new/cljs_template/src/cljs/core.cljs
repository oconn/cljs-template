(ns {{name}}.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]

            [{{name}}.containers.main :refer [main]]
            [{{name}}.events.core]
            [{{name}}.subs.core]))

(defn mount-root []
  (reagent/render [main]
                  (js/document.getElementById "app")))

(defn init []
  (re-frame/dispatch [:bootstrap/start])
  (mount-root))
