(ns kasiopea-2021-domaci-b.core
  (:require [clojure.string :as str]))

;; even weeks: 2 (YES)
;; odd weeks: 3 (NO)

(defn read-input []
  (->> "input.txt" slurp
       str/split-lines
       rest
       (partition 2)
       (map (fn [[_ weeks]]
              (->> (str/split weeks #"\ ")
                   (map read-string))))))

;; (rounded up -> even > half total) is equal to  (2 * even > total)

(defn process-input [input]
  (let [len (count input)
        num-even (count (filter even? input))]
    (> (* 2 num-even) len)))

(defn -main [& _args]
  (let [input (read-input)
        outputs (->> input (map process-input)
                     (map #(if % "ANO" "NE")))]
    (->> outputs (str/join "\n") (spit "output.txt"))))