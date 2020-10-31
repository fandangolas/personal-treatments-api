(ns personal-treatments-api.core
  (:require [io.pedestal.http :as http]
            [personal-treatments-api.routes :as routes]))

(def service-map
  {::http/routes routes/greeting
   ::http/type   :jetty
   ::http/port   8890})

(defn create-server []
  (http/create-server service-map))

(defn start []
  (http/start (create-server)))


;dev
(comment
  (defonce server (atom nil))

  (defn start-dev []
    (reset! server
      (http/start (http/create-server
        (assoc service-map ::http/join? false)))))

  (defn stop-dev []
    (http/stop @server))

  (defn restart []
    (stop-dev)
    (start-dev))

  (restart)
  [])