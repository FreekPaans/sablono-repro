(ns sablono-repro.core
  (:require [cljsjs.react]
            [cljsjs.react.dom]
            [sablono.core :refer [html]] ))


(enable-console-print!)

(println "This text is printed from src/sablono-repro/core.cljs. Go ahead and edit it and see reloading in action.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!"}))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)

(.render js/ReactDOM
         (html [:div [:input {:type "text"
                              :value "hello world"
                              :on-change (fn [e] (println e))}]])
         (.getElementById js/document "app"))

(.render js/ReactDOM
         (.createElement
           js/React "div" nil
           (.createElement
             js/React
             "input"
             #js {:type "text"
                  :value "hello world too"
                  :onChange (fn [e] (println e))}))
         (.getElementById js/document "app2"))
