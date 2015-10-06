(ns treasurer-client.core
  (:require [rum.core :as rum]))

(rum/defc expense [{:keys [company ts amount]}]
  [:tr
   [:td company]
   [:td (.toUTCString ts)]
   [:td amount]])

(rum/defc expense-list [expenses]
  [:table
   [:tr [:th "Company"] [:th "Date"] [:th "Amount"]]
   (map expense expenses)])
