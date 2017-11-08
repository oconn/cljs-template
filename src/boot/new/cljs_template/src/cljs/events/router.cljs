(ns {{name}}.events.router
  (:require [bidi.bidi :as bidi]
            [pushy.core :as pushy]
            [re-frame.core :as re-frame]

            [{{name}}.interceptors.core :refer [app-interceptors]]
            [{{name}}.router :refer [routes]]))

(re-frame/reg-event-db
  :router/set-route
  [app-interceptors]
  (fn [db [_ {:keys [handler route-params]}]]
    (-> db
        (assoc-in [:router :route] handler)
        (assoc-in [:router :route-params] route-params))))

(re-frame/reg-event-fx
 :router/nav-to
 [app-interceptors]
 (fn [{:keys [db]} [_ route]]
   {:db db
    :nav-to route}))

(re-frame/reg-event-db
 :router/initialized
 [app-interceptors]
 (fn [db _] (assoc-in db [:router :initialized] true)))

(defn- listen-for-navigation!
  "Wraps the history object and begins listening for history events"
  [history]
  (re-frame/reg-fx
   :nav-to
   (fn [route]
     (pushy/set-token! history route))))

(re-frame/reg-fx
 :pushy-init
 (fn [_]
   (let [history (pushy/pushy #(re-frame/dispatch [:router/set-route %])
                              #(bidi/match-route routes %))]

     (listen-for-navigation! history)

     (pushy/start! history)

     (re-frame/dispatch [:router/initialized]))))
