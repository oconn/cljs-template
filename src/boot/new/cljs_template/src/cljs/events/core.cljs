(ns {{name}}.events.core
  (:require [re-frame-notifier.core :as rfn]
            [re-frame-request.core :as rfr]

            [{{name}}.events.bootstrap]
            [{{name}}.events.development]
            [{{name}}.events.router]
            [{{name}}.interceptors.core :refer [app-interceptors]]))

(rfn/register-events {:notifier-interceptors app-interceptors})
(rfr/register-events {:request-interceptors app-interceptors})
