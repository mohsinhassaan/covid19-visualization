(ns covid19-visualization.views
  (:require
   [covid19-visualization.subs :as subs]
   ["@material-ui/core" :as ui]
   [re-frame.core :as rf]
   [reagent.core :as r]
   [covid19-visualization.events :as events]
   ["react-chartjs-2" :as chart]))


;; home


(defn country-select []
  [:> ui/FormControl
   [:> ui/InputLabel {:id "country-label"} "Country"]
   [:> ui/Select {:labelId  "country-label"
                  :native   true
                  :value    @(rf/subscribe [::subs/selected-country])
                  :onChange #(rf/dispatch [::events/set-selected-country (.. % -target -value)])}
    (cons [:option {:key        "empty"
                    :value      ""
                    :aria-label "None"}]
          (for [country @(rf/subscribe [::subs/sorted-countries])]
            ^{:key (:ISO2 country)} [:option {:value (:Slug country)}
                                     (:Country country)]))]])

(defn country-submit-button []
  [:> ui/Button {:variant "contained"
                 :href    @(rf/subscribe [::subs/country-link])
                 :color   "primary"}
   "Submit"])

(defn home-panel []
  [:> ui/Grid {:container true
               :justify   "center"
               :direction "row"}
   [country-select]
   [country-submit-button]])

;; charts


(defn bar-chart [id title data]
  [:> ui/Card {:id id
               :style {:margin-bottom "5vh"
                       :margin-top "5vh"}}
   [:> ui/CardContent
    [:> ui/Typography {:variant "h5"
                       :align "center"} title]
    [:> chart/Bar {:data data
                   :options {:scales {:xAxes [{:type "time"
                                               :time {:unit "month"}}]
                                      :yAxes [{:type "linear"
                                               :precision 1000}]}}}]]])

;; country


(defn country-panel []
  (let [{:keys [Slug Country]} @(rf/subscribe [::subs/country])]
    [:> ui/Container {:maxWidth "lg"}
     [:> ui/Typography {:variant "h4"} Country]
     [:> ui/Grid {:container true
                  :direction "row"
                  :justify "space-around"}]
     [bar-chart
      "confirmed-cases-chart"
      "Total Confirmed Cases"
      @(rf/subscribe [::subs/confirmed-cases-data])]
     [bar-chart
      "deaths-chart"
      "Total Deaths"
      @(rf/subscribe [::subs/deaths-data])]]))

;; app-bar

(defn app-bar []
  [:div
   [:> ui/AppBar
    [:> ui/Toolbar
     [:> ui/Link {:href    "/#"
                  :color   "inherit"
                  :variant "h4"
                  :style   {:text-decoration "none"}} "Covid19 Visualizations"]]]])

;; main

(defn- panels [panel-name]
  (case panel-name
    :home-panel    [home-panel]
    :country-panel [country-panel]
    [:div]))

(defn show-panel [panel-name]
  [:div
   [app-bar]
   [:> ui/Toolbar]
   [panels panel-name]])

(defn main-panel []
  (let [active-panel (rf/subscribe [::subs/active-panel])]
    [show-panel @active-panel]))
