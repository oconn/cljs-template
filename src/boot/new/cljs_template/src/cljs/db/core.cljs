(ns {{name}}.db.core
  (:require [cljs.spec.alpha :as s]
            [re-frame-notifier.core :as rf-notifier]
            [re-frame-request.core :as rf-request]
            [re-frame-routing.core :as rf-routing]))

(def default-db
  {:notifier rf-notifier/initial-state
   :request rf-request/initial-state
   :router rf-routing/initial-state})

(s/def ::db (s/keys :req-un [:re-frame-notifier.core/notifier
                             :re-frame-request.core/request
                             :re-frame-routing.core/router]))
