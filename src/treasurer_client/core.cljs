(ns treasurer-client.core
  (:require [rum.core :as rum]
            [cljs-uuid-utils.core :as uuid]))

(enable-console-print!)

(defn create-uuid []
  (uuid/uuid-string (uuid/make-random-uuid)))

(rum/defc expense [{:keys [company ts amount]}]
  [:tr 
   [:td {:class-name "expense-company" :key (create-uuid)}  company]
   [:td {:class-name "expense-ts" :key (create-uuid)}  (.toUTCString ts)]
   [:td {:class-name "expense-amount" :key (create-uuid)} amount]])

(rum/defc expense-list [expenses]
  [:table
   [:tr [:th "Company"] [:th "Date"] [:th "Amount"]]
   (map expense expenses)])
