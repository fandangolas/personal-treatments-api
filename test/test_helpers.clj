(ns test_helpers
  (:require
    [personal-treatments-api.core :as core]
    [clojure.test :refer :all]
    [io.pedestal.http :as http]))

(def service
  (:io.pedestal.http/service-fn
    (http/create-servlet core/service-map)))
