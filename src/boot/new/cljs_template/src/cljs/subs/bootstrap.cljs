(ns {{name}}.subs.bootstrap
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :bootstrap/finished?
 (fn [{:keys [router]}]
   (and (:initialized router))))
