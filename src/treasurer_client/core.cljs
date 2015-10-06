(ns treasurer-client.core
  (:require [rum.core :as rum]))

(rum/defc expense [{:keys [company ts amount]}]
  [:tr
   [:td company]
   [:td (.toUTCString ts)]
   [:td amount]])
