(ns adventofcode.day3
  (:require [clojure.string :as str]))

(def input (-> (slurp "./src/adventofcode/day3.txt")
               (str/split #"\n")))

input
