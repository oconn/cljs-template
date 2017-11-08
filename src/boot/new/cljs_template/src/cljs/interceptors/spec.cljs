(ns {{name}}.interceptors.spec
  (:require [cljs.spec.alpha :as s]
            [re-frame.core :as re-frame]))

(def ^:private attribution
  "https://github.com/Day8/re-frame/blob/master/examples/todomvc/src/todomvc")

(defn check-and-throw
  ^{:doc "Throws an exception if `db` doesn't match the Spec `a-spec`."
    :attribution attribution}
  [a-spec db]
  (when-let [error (s/explain-data a-spec db)]
    (js/console.error (clj->js error))))

(def
  ^{:doc "Ensures the db remains in a proper state"
    :attribution attribution}
  check-spec-interceptor (re-frame/after
                          (partial check-and-throw :{{name}}.db.core/db)))
