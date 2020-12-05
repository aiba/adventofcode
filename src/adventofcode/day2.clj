(ns adventofcode.day2
  (:require [clojure.string :as str]))

;; part 1
(as-> (slurp "./src/adventofcode/day2.txt") $
  (str/split $ #"\n")
  (filter (fn [s]
          (let [[_ a b c s] (re-find #"^(\d+)\-(\d+)\s(\w)\:\s(.*)$" s)
                a (Long/parseLong a)
                b (Long/parseLong b)
                c (first c)
                n (count (filter #{c} s))]
            (<= a n b)))
          $)
  (count $))

;; part 2

(defn xor [a b]
  (and (or a b)
       (not (and a b))))

(as-> (slurp "./src/adventofcode/day2.txt") $
  (str/split $ #"\n")
  (filter (fn [s]
          (let [[_ a b c s] (re-find #"^(\d+)\-(\d+)\s(\w)\:\s(.*)$" s)
                i (dec (Long/parseLong a))
                j (dec (Long/parseLong b))
                c (first c)
                v (vec s)]
            (xor (= (v i) c)
                 (= (v j) c))))
          $)
  (count $))
