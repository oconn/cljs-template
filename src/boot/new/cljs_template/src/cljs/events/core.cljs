(ns {{name}}.events.core
  (:require [re-frame-form.core :as rf-form]
            [re-frame-notifier.core :as rf-notifier]
            [re-frame-request.core :as rf-request]
            [re-frame-routing.core :as rf-routing]

            [{{name}}.events.bootstrap]
            [{{name}}.events.development]
            [{{name}}.interceptors.core :refer [app-interceptors]]
            [{{name}}.router :as router]))

(rf-form/register-events {:form-interceptors app-interceptors})
(rf-notifier/register-events {:notifier-interceptors app-interceptors})
(rf-request/register-events {:request-interceptors app-interceptors})
(rf-routing/register-events {:routing-interceptors app-interceptors
                             :routes router/routes})
