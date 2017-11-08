(ns {{name}}.router
  (:require [re-frame.core :as re-frame]

            [{{name}}.containers.home :refer [home]]
            [{{name}}.containers.not-found :refer [not-found]]))

(def routes
  ["/" {""       :home
        "home"   :home}])

;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Containers
;;
;; Containers are the top level wrappers of a "page".
;; Each container can be found under oconn.containers.[container]
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(defmulti containers identity)

;; PUBLIC ROUTES
(defmethod containers :home    [] [home])

;; CATCH-ALL ROUTE
(defmethod containers :default [] [not-found])

;; ROUTER
(defn router []
  (let [route (re-frame/subscribe [:router/route])
        route-params (re-frame/subscribe [:router/route-params])]
    (fn []
      (set! (-> js/document .-body .-scrollTop) 0)
      (set! (-> js/document .-documentElement .-scrollTop) 0)

      [containers @route @route-params])))
