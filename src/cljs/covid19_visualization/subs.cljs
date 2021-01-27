(ns covid19-visualization.subs
  (:require
   [re-frame.core :as rf]
   [covid19-visualization.db :as db]
   [clojure.set :as set]))

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

(defn smooth
  [data]
  (map (fn [{prev :Cases} curr {next :Cases}]
         (update curr :Cases #(quot (+ prev (:Cases curr) next) 3)))
       (cons (first data) data)
       data
       (concat (rest data) (repeat (last data)))))

(rf/reg-sub
 ::confirmed-cases-data
 :<- [::confirmed-cases]
 (fn [data]
   {:label "Confirmed Cases"
    :data  (map #(set/rename-keys (select-keys % [:Cases :Date])
                                  {:Date :x, :Cases :y}) data)}))

(rf/reg-sub
 ::daily-confirmed-cases-data
 :<- [::confirmed-cases]
 (fn [data]
   (let [daily-data  (map (fn [a b]
                            {:Date  (:Date b)
                             :Cases (- (:Cases b) (:Cases a))})
                          data
                          (rest data))]
     {:label "Confirmed Cases"
      :data  (map #(set/rename-keys (select-keys % [:Cases :Date])
                                    {:Date :x, :Cases :y}) daily-data)})))

(rf/reg-sub
 ::deaths
 (fn [db _]
   (::db/deaths db)))

(rf/reg-sub
 ::deaths-data
 :<- [::deaths]
   (fn [data]
     {:label "Deaths"
      :data (map #(set/rename-keys (select-keys % [:Cases :Date])
                                   {:Date :x, :Cases :y}) data)}))

(rf/reg-sub
 ::daily-deaths-data
 :<- [::deaths]
 (fn [data]
   (let [daily-data (map (fn [a b]
                           {:Date  (:Date b)
                            :Cases (- (:Cases b) (:Cases a))})
                         data
                         (rest data))]
     {:label "Deaths"
      :data (map #(set/rename-keys (select-keys % [:Cases :Date])
                                   {:Date :x, :Cases :y}) daily-data)})))

(rf/reg-sub
 ::active-panel
 (fn [db _]
   (::db/active-panel db)))

(rf/reg-sub
 ::total-cases
 :<- [::confirmed-cases]
 (fn [cases]
   (-> cases last :Cases int)))

(rf/reg-sub
 ::daily-cases
 :<- [::confirmed-cases]
 (fn [cases]
   (->> cases
        (take-last 2)
        reverse
        (map :Cases)
        (apply -)
        int)))

(rf/reg-sub
 ::total-deaths
 :<- [::deaths]
 (fn [deaths]
   (-> deaths last :Cases int)))

(rf/reg-sub
 ::daily-deaths
 :<- [::deaths]
 (fn [deaths]
   (->> deaths
        (take-last 2)
        reverse
        (map :Cases)
        (apply -)
        int)))
