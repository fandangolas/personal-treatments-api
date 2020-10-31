(ns personal-treatments-api.routes
  (:require [io.pedestal.http.route :as route]
            [personal-treatments-api.http-in.medicines :as medicines]))

(def greeting
  (route/expand-routes
    #{["/medicines" :get medicines/list! :route-name :list-medicines]
      ["/medicines" :post medicines/create! :route-name :create-medicine]}))