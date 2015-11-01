(ns obd.commands)

(def commands {:command "AT@1"    :description "Display the device description"
               :command "ATZ"     :description "Reset"
               :command "ATSP 0"  :description "Automatic protocol"})

(def mode-1 [["0C" "Engine RPM"          #(/ % 4)   "RPM"]
             ["05" "Coolant temperature" #(- % 40)  "C"  ]])
