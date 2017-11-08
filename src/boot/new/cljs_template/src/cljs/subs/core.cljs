(ns {{name}}.subs.core
  (:require [re-frame-notifier.core :as rfn]
            [re-frame-request.core :as rfr]

            [{{name}}.subs.bootstrap]
            [{{name}}.subs.router]))

(rfn/register-subscriptions)
(rfr/register-subscriptions)
