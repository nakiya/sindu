(ns sindu.db.core
  (:require [ragtime.jdbc :as jdbc]))

(def ^:dynamic *db-host* "localhost")
(def ^:dynamic *db-port* 3306)
(def ^:dynamic *db-name* "sindu")
(def ^:dynamic *db-user* "sindu")
(def ^:dynamic *db-user-pass* "sindu")

(def db-config {:classname "com.mysql.jdbc.Driver"
                :subprotocol "mysql"
                :subname (str "//" *db-host* ":" *db-port* "/" *db-name*)
                :user *db-user*
                :password *db-user-pass*})

(def migration-config
  {:datastore  (jdbc/sql-database db-config)
   :migrations (jdbc/load-directory "resources/migrations")})

;; In repl, do this:
  ;(require '[ragtime.repl :as repl])

;; To migrate:
  ;(repl/migrate migration-config)

;; To rollback:
  ;(repl/rollback migration-config)
