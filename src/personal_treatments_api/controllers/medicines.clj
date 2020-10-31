(ns personal-treatments-api.controllers.medicines
  (:require [clojure.data.json :as json]
            [personal-treatments-api.storage.db :as db]))

(defn register-new-medicine!
  [medicine]
  (db/insert! :medicines medicine)
  (json/write-str medicine))

(defn list!
  []
  (let [medicines (db/query! :medicines)]
    (json/write-str medicines)))