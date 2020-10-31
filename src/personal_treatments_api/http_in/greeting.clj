(ns personal-treatments-api.http-in.greeting)

(defn respond-hello [_request]
  {:status 200 :body "Hello, world!"})
