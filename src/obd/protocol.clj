(ns obd.protocol
  (:require
   [manifold.stream :as s]
   [gloss.core :refer [defcodec]:as g]
   [gloss.io :as io]))

(defcodec at-protocol
  (g/string :utf-8 :delimiters ["\n"]))

(defn wrap-duplex-stream
  [protocol s]
  (let [out (s/stream)]
    (s/connect
     (s/map #(io/encode at-protocol %) out)
     s)
    (s/splice
     out
     (io/decode-stream s at-protocol))))

(def wrap-stream-with-at-protocol (partial wrap-duplex-stream at-protocol))

