(ns personal-treatments-api.utils
  (:import (java.util UUID)))

(defn uuid [] (str (UUID/randomUUID)))