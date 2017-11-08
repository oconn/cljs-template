(ns {{name}}.events.bootstrap
  (:require [re-frame.core :as re-frame]

            [{{name}}.db.core :refer [default-db]]))

(re-frame/reg-event-fx
 :bootstrap/start
 (fn [_ _]
   {:db default-db
    :dev-tools-init nil
    :pushy-init nil}))
