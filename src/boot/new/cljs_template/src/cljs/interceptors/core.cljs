(ns {{name}}.interceptors.core
  (:require [re-frame.core :as re-frame]

            [{{name}}.interceptors.spec :refer [check-spec-interceptor]]))

(def app-interceptors
  [(when ^boolean js/goog.DEBUG check-spec-interceptor)
   (when ^boolean js/goog.DEBUG re-frame/debug)])
