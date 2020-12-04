(ns adventofcode.day1
  (:require [clojure.string :as str]))


;; part 1

(let [nums (as-> (slurp "./src/adventofcode/day1.txt") $
             (str/split $ #"\n")
             (map #(Long/parseLong %) $)
             (vec $))]
  (for [i (range (count nums))
        j (range (inc i) (count nums))
        :let [a (nums i)
              b (nums j)]
        :when (= (+ a b) 2020)]
    (* a b)))


;; part 2

(let [nums (as-> (slurp "./src/adventofcode/day1.txt") $
             (str/split $ #"\n")
             (map #(Long/parseLong %) $)
             (vec $))
      n (count nums)]
  (for [i (range n)
        j (range (inc i) n)
        k (range (inc j) n)
        :let [a (nums i)
              b (nums j)
              c (nums k)]
        :when (= (+ a b c) 2020)]
    (* a b c)))
