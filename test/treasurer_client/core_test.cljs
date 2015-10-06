(ns treasurer-client.core-test
  (:require [cljs.test :refer-macros [deftest is testing async run-tests]]
            [treasurer-client.core]))

(enable-console-print!)

(deftest basic-1
  (testing "addition"
    (is (= 42 (+ 9 10 11 12)))))
