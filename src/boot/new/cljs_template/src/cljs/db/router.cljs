(ns {{name}}.db.router
    (:require [cljs.spec.alpha :as s]))

(def initial-router-state
  ^{:doc "Handles routing state for the application"}
  {:unauthenticated-links [{:href "/home"
                            :display "Home"
                            :key :home}]
   :route nil
   :route-params nil
   :initialized false})

(s/def ::href string?)
(s/def ::display string?)
(s/def ::key keyword?)
(s/def ::initialized boolean?)
(s/def ::unauthenticated-links (s/coll-of
                                (s/keys :req-un [::href
                                                 ::display
                                                 ::key])))
(s/def ::route (s/nilable keyword?))
(s/def ::route-params (s/nilable map?))
(s/def ::router (s/keys :req-un [::route
                                 ::route-params
                                 ::unauthenticated-links
                                 ::initialized]))
