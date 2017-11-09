(ns {{name}}.interceptors.core
  (:require [re-frame.core :as re-frame]
            [re-frame-dev-tools.tools.time-travel
             :refer [time-travel-interceptor]]

            [{{name}}.interceptors.spec :refer [check-spec-interceptor]]))

(def app-interceptors
  [(when ^boolean js/goog.DEBUG check-spec-interceptor)
   (when ^boolean js/goog.DEBUG time-travel-interceptor)
   (when ^boolean js/goog.DEBUG re-frame/debug)])
