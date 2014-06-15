package com.corejava.exam1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtil {
    
    public static List<Integer> sort(List<Integer> list){
        List<Integer> l = new ArrayList<>(list);
        Collections.sort(l);
        return l;
    }
    
    public static List<Integer> reverse(List<Integer> list){
        List<Integer> l = new ArrayList<>(list);
        Collections.reverse(l);
        return l;
    }
    
    public static boolean isMonotonous(List<Integer> list){
        if (list.isEmpty() || list.size() <= 2) return true;
        for (int i=0;i<list.size()-2;i++) {
            if ((list.get(i) <= list.get(i+1) && list.get(i+1) <= list.get(i+2)) || 
                (list.get(i) >= list.get(i+1) && list.get(i+1) >= list.get(i+2))) {
                continue;
            }
            else
                return false;
        }
        return true;
        /* Here's a one line solution but the above is much faster:
         * return (sort(list).equals(list) || sort(list).equals(reverse(list)));
         */
    }
}
