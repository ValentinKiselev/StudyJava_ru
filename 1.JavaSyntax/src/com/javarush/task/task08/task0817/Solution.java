package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> NS = new HashMap<String, String>();
        for(int i = 0; i < 10; i++){
            NS.put("s"+i, "n"+i);
        }
        return NS;

    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {

        Iterator<HashMap.Entry<String, String>> it = map.entrySet().iterator();
        ArrayList<String> names = new ArrayList<String>();

        while(it.hasNext()){
            HashMap.Entry<String, String> pair = it.next();
            String value = pair.getValue();
            names.add(value);

        }
        for (int j = 0; j < names.size(); j++){
            String nameT = names.get(j);
            for (int jj = j+1; jj < names.size(); jj++){
                if (nameT.equals(names.get(jj))) removeItemFromMapByValue(map, names.get(jj));
            }
        }

        }

        /*HashMap<String, String> copy0 = new HashMap<String, String>(map);

        for (Map.Entry<String, String > pair2 : map.entrySet()) {
        String g = pair2.getValue();
        int h = 1;
        for (Map.Entry<String, String> pair : copy0.entrySet()) {

            if (pair.getValue().equals(g) && h == 1) {
                map.remove(pair.getKey());
                h = 1;
            }
            else h++;
        */

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        //HashMap<String, String> NS = createMap();
        //System.out.println(NS);
        //removeTheFirstNameDuplicates(NS);
        //System.out.println(NS);

    }
}
