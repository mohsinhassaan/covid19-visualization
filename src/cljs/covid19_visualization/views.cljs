(ns covid19-visualization.views
  (:require
   [covid19-visualization.subs :as subs]
   ["@material-ui/core" :as ui]
   ["@material-ui/core/colors" :as color]
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
    [:> chart/Bar {:data {:datasets [(into {:backgroundColor (.-A400 color/pink)
                                            :hoverBackgroundColor (.-A200 color/pink)}
                                           data)]}
                   :options {:scales {:xAxes [{:type "time"
                                               :time {:unit "month"}}]
                                      :yAxes [{:type "linear"
                                               :maxTicksLimit 5}]}}}]]])

(defn line-chart [id title data]
  [:> ui/Card {:id id
               :style {:margin-bottom "5vh"
                       :margin-top "5vh"}}
   [:> ui/CardContent
    [:> ui/Typography {:variant "h5"
                       :align "center"} title]
    [:> chart/Line {:data {:datasets [(into {:borderColor (.-A400 color/pink)
                                             :hoverBorderColor (.-A200 color/pink)
                                             :backgroundColor "transparent"}
                                           data)]}
                   :options {:scales {:xAxes [{:type "time"
                                               :time {:unit "month"}}]
                                      :yAxes [{:type "linear"
                                               :maxTicksLimit 5}]}}}]]])

(defn confirmed-chart []
  [line-chart
   "total-confirmed-cases-chart"
   "Total Confirmed Cases"
   @(rf/subscribe [::subs/confirmed-cases-data])])

(defn daily-confirmed-chart []
  [bar-chart
   "daily-confirmed-cases-chart"
   "Daily New Confirmed Cases"
   @(rf/subscribe [::subs/daily-confirmed-cases-data])])

(defn deaths-chart []
  [line-chart
   "deaths-chart"
   "Total Deaths"
   @(rf/subscribe [::subs/deaths-data])])

(defn daily-deaths-chart []
  [bar-chart
   "daily-deaths-chart"
   "Daily New Deaths"
   @(rf/subscribe [::subs/daily-deaths-data])])

(defn number [label num]
  [:> ui/Card {:style {:margin-bottom "5vh"
                       :margin-top "5vh"}}
   [:> ui/CardContent
    [:> ui/Typography {:variant "h5"} label]
    [:> ui/Typography {:variant "h3"} num]]])

;; country


(defn country-panel []
  (let [{:keys [Slug Country]} @(rf/subscribe [::subs/country])]
    [:> ui/Container {:maxWidth "lg"}
     [:> ui/Typography {:variant "h4"} Country]
     [:> ui/Grid {:container true
                  :direction "row"}
      [:> ui/Grid {:container true
                   :item true
                   :direction "row"
                   :xs 12
                   :justify "space-around"}
       [:> ui/Grid {:item true
                    :lg 5}
        [number "Total Cases" @(rf/subscribe [::subs/total-cases])]]
       [:> ui/Grid {:item true
                    :lg 5}
        [number "Daily Cases" @(rf/subscribe [::subs/daily-cases])]]
       [:> ui/Grid {:item true
                    :lg 5}
        [number "Total Deaths" @(rf/subscribe [::subs/total-deaths])]]
       [:> ui/Grid {:item true
                    :lg 5}
        [number "Daily Deaths" @(rf/subscribe [::subs/daily-deaths])]]
       [:> ui/Grid {:item true
                    :lg 5}
        [confirmed-chart]]
       [:> ui/Grid {:item true
                    :lg 5}
        [daily-confirmed-chart]]]
      [:> ui/Grid {:container true
                   :item true
                   :direction "row"
                   :xs 12
                   :justify "space-around"}
       [:> ui/Grid {:item true
                    :lg 5}
        [deaths-chart]]
       [:> ui/Grid {:item true
                    :lg 5}
        [daily-deaths-chart]]]]]))

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
