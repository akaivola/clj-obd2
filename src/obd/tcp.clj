(ns obd.tcp
  (:require
    [manifold.deferred :as d]
    [manifold.stream :as s]
    [aleph.tcp :as tcp]
    [gloss.core :as gloss]
    [gloss.io :as io]))

; http://ideolalia.com/aleph/literate.html#aleph.examples.tcp

(def at-protocol
  (gloss/compile-frame
   (gloss/string :utf-8 :delimiters ["\r" "\r\n"])
   identity
   identity))

(defn client
  ([] (client "192.168.0.10" 35000))
  ([host port]
    (d/chain (tcp/client {:host host, :port port}))))

