(ns personal-treatments-api.routes
  (:require [io.pedestal.http.route :as route]
            [personal-treatments-api.http-in.greeting :as greeting]
            [personal-treatments-api.http-in.medicines :as medicines]))

(def greeting
  (route/expand-routes
    #{["/greet" :get greeting/respond-hello :route-name :greet]
      ["/medicines" :get medicines/list! :route-name :list-medicines]
      ["/medicines" :post medicines/create! :route-name :create-medicine]}))