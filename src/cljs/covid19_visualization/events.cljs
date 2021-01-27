(ns covid19-visualization.events
  (:require
   [re-frame.core :as rf]
   [covid19-visualization.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]
   [day8.re-frame.http-fx]
   [ajax.core :as ajax]
   [clojure.string :as str]))

(rf/reg-event-fx
 ::initialize-db
 (fn-traced [_ _]
            {:db db/default-db
             :dispatch [::get-countries]}))

(rf/reg-event-db
 ::set-active-panel
 (fn-traced [db [_ active-panel]]
            (assoc db ::db/active-panel active-panel)))

(rf/reg-event-fx
 ::get-countries
 (fn-traced [_ _]
            {:http-xhrio {:method          :get
                          :uri             "https://api.covid19api.com/countries"
                          :timeout         8000
                          :response-format (ajax/json-response-format {:keywords? true})
                          :on-success      [::save-countries]
                          :on-failure      [::save-error]}}))

(rf/reg-event-fx
 ::save-countries
 (fn-traced [{:keys [db]} [_ countries]]
            {:db (assoc db
                        ::db/countries
                        (->> countries
                             (map (fn [country]
                                    (update country
                                            :Country
                                            #(str/replace % #"(.*), (.*)" "$2 $1"))))))}))

(rf/reg-event-db
 ::set-selected-country
 (fn-traced [db [_ slug]]
            (assoc db ::db/selected-country slug)))

(rf/reg-event-fx
 ::initialize-country-page
 (fn [{:keys [db]} [_ slug]]
   {:fx [[:db (dissoc db ::db/confirmed-cases ::db/deaths)]
         [:dispatch [::set-country slug]]
         [:dispatch [::get-country-confirmed-cases slug]]
         [:dispatch [::get-country-deaths slug]]]}))

(rf/reg-event-db
 ::set-country
 (fn-traced [db [_ slug]]
            (assoc db ::db/country slug)))

(rf/reg-event-fx
 ::get-country-confirmed-cases
 (fn-traced [_ [_ slug]]
            {:http-xhrio {:method          :get
                          :uri             (str "https://api.covid19api.com/total/dayone/country/"
                                                slug
                                                "/status/confirmed")
                          :timeout         8000
                          :response-format (ajax/json-response-format {:keywords? true})
                          :on-success      [::save-result [::db/confirmed-cases]]
                          :on-failure      [::save-error]}}))

(rf/reg-event-fx
 ::get-country-deaths
 (fn-traced [_ [_ slug]]
            {:http-xhrio {:method          :get
                          :uri             (str "https://api.covid19api.com/total/dayone/country/"
                                                slug
                                                "/status/deaths")
                          :timeout         8000
                          :response-format (ajax/json-response-format {:keywords? true})
                          :on-success      [::save-result [::db/deaths]]
                          :on-failure      [::save-error]}}))

(rf/reg-event-db
 ::save-result
 (fn-traced [db [_ path result]]
            (assoc-in db path result)))

(rf/reg-event-db
 ::save-error
 (fn-traced [db [_ error]]
            (assoc db :error error)))
