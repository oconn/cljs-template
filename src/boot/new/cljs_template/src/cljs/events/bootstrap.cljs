(ns {{name}}.events.bootstrap
  (:require [re-frame.core :as re-frame]

            [{{name}}.db.core :refer [default-db]]
            [{{name}}.interceptors.core :refer [app-interceptors]]))

(re-frame/reg-event-fx
 :bootstrap/start
 [app-interceptors]
 (fn [_ _]
   {:db default-db
    :dev-tools-init nil
    :pushy-init nil}))
