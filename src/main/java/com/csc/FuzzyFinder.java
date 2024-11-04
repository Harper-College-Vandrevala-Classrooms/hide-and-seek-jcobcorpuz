package com.csc;

import java.util.ArrayList;

public class FuzzyFinder {

    /**
     * Worst-case scenario for linear analysis:
     * In the worst case for a linear search on a randomized list of fuzzies,
     * the target element, "gold", is at the last position in the list or not present at all.
     * The algorithm must check each element once if the target is at the last position or not present at all.
     * If the list has n elements, the number of checks in the worst case is n.
     * Mathematical expression: O(n)
     *
     * @param fuzzies
     * @return
     */

    public int linearSearch(ArrayList<Fuzzy> fuzzies){
        for (int i = 0; i < fuzzies.size(); i++){
            if(fuzzies.get(i).color.equals("gold")){
                return i;
            }
        }
        return -1;
    }


    /**
     * Worst-case scenario for binary analysis:
     * In the worst case for a binary search on a randomized list of fuzzies,
     * the target element, "gold", is either not present or requires the maximum number
     * of checks to be found. Binary search works by repeatedly halving the search space,
     * so the number of checks in the worst case is proportional to the logarithm of the list
     * size. If the list has n elements, the number of checks in the worst case is about log2(n).
     * Mathematical expression: O(log n)
     *
     * @param fuzzies
     * @return
     */

    public int binarySearch(ArrayList<Fuzzy> fuzzies){
        int left = 0;
        int right = fuzzies.size()-1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            String midColor = fuzzies.get(mid).color;

            if (midColor.equals("gold")){
                return mid;
            }
            else if (midColor.compareTo("gold") < 0){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
