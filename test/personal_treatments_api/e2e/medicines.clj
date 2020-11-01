(ns personal-treatments-api.e2e.medicines
  (:require
    [io.pedestal.test :refer [response-for]]
    [clojure.test :refer [deftest testing is]]
    [clojure.data.json :as json]
    [test_helpers :as helpers]
    [personal-treatments-api.storage.db :as db]))

(deftest medicine-creation-test
  (testing "it should be able to register a new medicine and the new medicine should be on db"
    (let [expected-status 200
          medicine {:name "medicine 1"
                    :quantity 4
                    :pills 24
                    :rules "Every 8 hours"
                    :price 4321}
          response (response-for helpers/service :post "/medicines"
                                         :body (json/write-str medicine)
                                         :headers {"Content-Type" "application/json"})]

      (is (= expected-status (:status response))))))