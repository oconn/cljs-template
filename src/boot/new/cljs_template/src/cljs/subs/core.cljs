(ns {{name}}.subs.core
  (:require [re-frame-notifier.core :as rf-notifier]
            [re-frame-request.core :as rf-request]
            [re-frame-routing.core :as rf-routing]

            [{{name}}.subs.bootstrap]))

(rf-notifier/register-subscriptions)
(rf-request/register-subscriptions)
(rf-routing/register-subscriptions)
