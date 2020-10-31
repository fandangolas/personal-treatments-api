(ns personal-treatments-api.controllers.medicines
  (:require [clojure.data.json :as json]
            [personal-treatments-api.storage.db :as db]
            [personal-treatments-api.utils :as utils]))

(defn register-new-medicine!
  [medicine]
  (let [id (utils/uuid)
        medicine-with-id (conj {:id id} medicine)]
    (db/insert! :medicines medicine-with-id)
    (json/write-str medicine-with-id)))

(defn list!
  []
  (let [medicines (db/query! :medicines)]
    (json/write-str medicines)))