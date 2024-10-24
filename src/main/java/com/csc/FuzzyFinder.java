package com.csc;

import java.util.ArrayList;

public class FuzzyFinder {
    public int linearSearch(ArrayList<Fuzzy> fuzzies){
        for (int i = 0; i < fuzzies.size(); i++){
            if(fuzzies.get(i).color.equals("gold")){
                return i;
            }
        }
        return -1;
    }

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
