(ns personal-treatments-api.routes
  (:require [io.pedestal.http.route :as route]
            [personal-treatments-api.http-in.greeting :as greeting]))

(def greeting
  (route/expand-routes
    #{["/greet" :get greeting/respond-hello :route-name :greet]}))