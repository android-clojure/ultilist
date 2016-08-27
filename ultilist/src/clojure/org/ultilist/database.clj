(ns org.ultilist.database
  (:require [neko.data.sqlite :as db]))


(def ultilist-schema
(db/make-schema
   :name "ultilist.db"
   :version 1
   :tables {:categories
            {:columns
             {:_id "integer primary key"
              :name (str "text not null")
              }}

            :items
            {:columns
             {:_id "integer primary key"
              :name "text not null"
              }}}))

(def get-db-helper
  (memoize
    (fn [] (db/create-helper ultilist-schema))))

(defn ultilist-db [] (db/get-database (get-db-helper) :write))
