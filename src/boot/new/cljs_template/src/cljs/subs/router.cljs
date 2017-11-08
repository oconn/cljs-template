(ns {{name}}.subs.router
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :router/core
 (fn [{:keys [router]} _] router))

(re-frame/reg-sub
 :router/route
 (fn [_ _] (re-frame/subscribe [:router/core]))
 (fn [{:keys [route]} _] route))

(re-frame/reg-sub
 :router/route-params
 (fn [_ _] (re-frame/subscribe [:router/core]))
 (fn [{:keys [route-params]} _] route-params))

(re-frame/reg-sub
 :router/unauthenticated-links
 (fn [_ _] (re-frame/subscribe [:router/core]))
 (fn [{:keys [unauthenticated-links]} _] unauthenticated-links))
