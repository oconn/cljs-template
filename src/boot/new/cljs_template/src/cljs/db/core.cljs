(ns {{name}}.db.core
  (:require [cljs.spec.alpha :as s]
            [re-frame-notifier.core :as rfn]
            [re-frame-request.core :as rfr]

            [{{name}}.db.router :refer [initial-router-state]]))

(def default-db
  {:notifier rfn/initial-state
   :request rfr/initial-state
   :router initial-router-state})

(s/def ::db (s/keys :req-un [:{{name}}.db.router/router]))
