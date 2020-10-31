(ns personal-treatments-api.http-in.medicines
  (:require [clojure.data.json :as json]
            [personal-treatments-api.controllers.medicines :as c.medicines]))

(defn create!
  [request]
  (let [body (json/read-str (slurp (:body request)) :key-fn keyword)]
    {:status  200
     :body    (c.medicines/register-new-medicine! body)}))

(defn list!
  [_request]
  {:status  200
   :body    (c.medicines/list!)})