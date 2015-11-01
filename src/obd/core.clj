(ns obd.core
  (:gen-class)
  (:require [clojure.core.async :refer [go go-loop chan >! <!]]
            [manifold.stream :as s]))

(defn -main
  [& args]
  (println "Hello, World!"))
