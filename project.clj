(defproject clj-obd2 "0.1.0-SNAPSHOT"
  :description ""
  :url ""
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/core.async "0.2.371"]
                 [org.clojure/core.match "0.3.0-alpha4"]
                 [clj-serial "2.0.4-SNAPSHOT"]
                 [aleph "0.4.1-beta1"]
                 [manifold "0.1.1"] ; transitive of aleph
                 [gloss "0.2.5"]    ; byte protocol abstraction library
                 [byte-streams "0.2.0"]
                 [com.taoensso/timbre "4.1.4"]
                 ]
  :main ^:skip-aot obd.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
