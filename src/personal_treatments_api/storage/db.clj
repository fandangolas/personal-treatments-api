(ns personal-treatments-api.storage.db)

(defonce data (atom {}))

(defn insert!
  [key value]
  (swap! data assoc key (conj (key @data) value)))

(defn query!
  [key]
  (get @data key))

(comment
  (deref data)

  (query! :medicines))