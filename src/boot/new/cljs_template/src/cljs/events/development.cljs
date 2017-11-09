(ns {{name}}.events.development
  (:require [re-frame.core :as re-frame]
            [re-frame-dev-tools.core :refer [enable-dev-tools!]]
            [re-frisk.core :refer [enable-re-frisk!]]))

(re-frame/reg-fx
 :dev-tools-init
 (fn [_]
   (when js/goog.DEBUG
     (enable-console-print!)
     (enable-dev-tools!)
     (enable-re-frisk!))))
