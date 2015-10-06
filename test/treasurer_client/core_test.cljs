(ns treasurer-client.core-test
  (:require [cljs.test :refer-macros [deftest is testing async run-tests use-fixtures are]]
            [rum.core :as rum]
            [cljs-react-test.simulate :as sim]
            [cljs-react-test.utils :as tu]
            [dommy.core :as dommy :refer-macros [sel1 sel]]
            [treasurer-client.core :refer [expense expense-list]]))

(enable-console-print!)

(def ^:dynamic c)

(use-fixtures :each (fn [test-fn]
                      (binding [c (tu/new-container!)]
                        (test-fn)
                        (tu/unmount! c))))

(deftest expense-comp
  (testing "renders expenses correctly as a table row"
    (let [data {:amount 42 :ts (js/Date. "2014-12-24") :company "Aldi"}
          tc (.createElement js/document "table")
          _ (tu/insert-container! tc)
          mnt (rum/mount (expense data) tc)
          [company ts amount] (sel tc :td)]
      (.log js/console company)
      (is (= (.-textContent company) "Aldi"))
      (is (= (.-textContent ts) (.toUTCString (js/Date. "2014-12-24"))))
      (is (= (js/parseInt (.-textContent amount)) 42))
      (tu/unmount! tc))))

(deftest expense-list-comp
  (testing "renders a list of expenses"
    (let [data [{:amount 42 :ts (js/Date. "2014-12-24") :company "Aldi"}
                {:amount 66 :ts (js/Date. "2014-12-24") :company "Rewe"}]
          _ (rum/mount (expense-list data) c)
          cmpnt (sel c :tr)]
      (is (= (count cmpnt) 3)))))

(deftest expense-input-comp
  (testing "changes state with new input"))
