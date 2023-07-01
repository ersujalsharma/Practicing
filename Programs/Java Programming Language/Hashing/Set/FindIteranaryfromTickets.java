package Hashing.Set;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * FindIteranaryfromTickets
 */
public class FindIteranaryfromTickets {

    public static void main(String[] args) {
        HashMap<String,String> tickets = new HashMap<>();
        tickets.put("Chennai","Bengaluru");
        tickets.put("Mumbai","Delhi");
        tickets.put("Goa","Chennai");
        tickets.put("Delhi","Goa");
        HashMap<String,String> map2 = new HashMap<>();
        for(String s : tickets.keySet()){
            map2.put(tickets.get(s), s);
        }
        String startingPoint = "";
        for (String string : tickets.keySet()) {
            if(!map2.containsKey(string)){
                startingPoint = string;
                break;
            }
        }
        ArrayList<String> tour = new ArrayList<>();
        tour.add(startingPoint);
        while(tickets.containsKey(startingPoint)){
            startingPoint = tickets.get(startingPoint);
            tour.add(startingPoint);
        }
        System.out.println(tour);
    }
}