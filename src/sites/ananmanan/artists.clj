(ns sindu.sites.ananmanan.artists
  (:require [net.cgrand.enlive-html :as html]))

(def ^:dynamic *artists-base-url* "http://www.ananmanan.lk/free-sinhala-mp3/artists/")

(defn fetch-url [url]
  (html/html-resource (java.net.URL. url)))

(defn artists []
  (map html/text (html/select (fetch-url *artists-base-url*) [:div.mp3 :a])))

