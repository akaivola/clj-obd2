(ns obd.tcp
  (:require
   [manifold.deferred :as d]
   [aleph.tcp :as tcp]
   [obd.protocol :refer [wrap-stream-with-at-protocol]]))

; http://ideolalia.com/aleph/literate.html#aleph.examples.tcp

(defn client
  ([] (client "192.168.0.10" 35000))
  ([host port]
   (d/chain (tcp/client {:host host, :port port})
            wrap-stream-with-at-protocol)))
