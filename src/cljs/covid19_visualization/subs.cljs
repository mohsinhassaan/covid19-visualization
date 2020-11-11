(ns covid19-visualization.subs
  (:require
   [re-frame.core :as rf]
   [covid19-visualization.db :as db]))

(rf/reg-sub
 ::country-slug
 (fn [db _]
   (::db/country db)))

(rf/reg-sub
 ::countries
 (fn [db _]
   (::db/countries db)))

(rf/reg-sub
 ::sorted-countries
 :<- [::countries]
 (fn [countries _]
   (sort-by :Country countries)))

(rf/reg-sub
 ::country
 :<- [::country-slug]
 :<- [::countries]
 (fn [[slug countries] _]
   (first
    (filter #(= slug (:Slug %))
            countries))))

(rf/reg-sub
 ::selected-country
 (fn
   [db _]
   (if-let [country (::db/selected-country db)]
     country
     "")))

(rf/reg-sub
 ::country-link
 :<- [::selected-country]
 (fn [country _]
   (str "/#/country/" country)))

(rf/reg-sub
 ::confirmed-cases
 (fn [db _]
   (::db/confirmed-cases db)))

(rf/reg-sub
 ::confirmed-cases-data
 :<- [::confirmed-cases]
 (fn [data]
   {:labels (map :Date data)
    :datasets [{:label "Confirmed Cases"
      :backgroundColor "rgba(255,99,132,0.2)"
      :borderColor "rgba(255,99,132,1)"
      :borderWidth 1
      :hoverBackgroundColor "rgba(255,99,132,0.4)"
      :hoverBorderColor "rgba(255,99,132,1)"
      :data (map :Cases data)}]}))

(rf/reg-sub
 ::deaths
 (fn [db _]
   (::db/deaths db)))

(rf/reg-sub
 ::deaths-data
 :<- [::deaths]
 (fn [data]
   {:labels (map :Date data)
    :datasets [{:label "Deaths"
                :backgroundColor "rgba(99,132,255,0.2)"
                :borderColor "rgba(99,132,255,1)"
                :borderWidth 1
                :hoverBackgroundColor "rgba(99,132,255,0.4)"
                :hoverBorderColor "rgba(99,132,255,1)"
                :data (map :Cases data)}]}))

(rf/reg-sub
 ::active-panel
 (fn [db _]
   (::db/active-panel db)))
