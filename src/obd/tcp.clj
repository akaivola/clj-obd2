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
   (gloss/string :utf-8 :delimiters ["\n"])
   identity
   identity))

(defn wrap-duplex-stream
  [protocol s]
  (let [out (s/stream)]
    (s/connect
     (s/map #(io/encode at-protocol %) out)
     s)
    (s/splice
     out
     (io/decode-stream s at-protocol))))


(defn client
  ([] (client "192.168.0.10" 35000))
  ([host port]
   (d/chain (tcp/client {:host host, :port port})
            #(wrap-duplex-stream at-protocol %))))

(def c (client "127.0.0.1" 1234))
