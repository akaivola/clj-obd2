(ns obd.core
  (:gen-class)
  (:require [obd.tcp :as tcp]))

(defn -main
  [& args]
  (apply tcp/client (first args) (second args))
  (println "Hello, World!"))
