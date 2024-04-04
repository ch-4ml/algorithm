import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Airport implements Comparable<Airport> {
    int index;
    String name;

    public Airport(int index, String name) {
        this.index = index;
        this.name = name;
    }

    @Override
    public int compareTo(Airport o) {
        return this.name.compareTo(o.name);
    }
}

class Solution {
    static int N;
    static List<String> airportList = new LinkedList<>();
    static Map<String, Integer> airports = new HashMap<>();
    static Map<String, LinkedList<Airport>> ticketsFrom = new HashMap<>();

    public String[] solution(String[][] tickets) {
        N = tickets.length;

        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];

            if (!airports.containsKey(from)) {
                airportList.add(from);
                airports.put(from, airports.size());
                ticketsFrom.put(from, new LinkedList<>());
            }

            if (!airports.containsKey(to)) {
                airportList.add(to);
                airports.put(to, airports.size());
                ticketsFrom.put(to, new LinkedList<>());
            }

            ticketsFrom.get(from).add(new Airport(airports.get(to), to));
        }

        for (String airport : airportList) {
            ticketsFrom.get(airport).sort(Airport::compareTo);
        }

        LinkedList<String> path = new LinkedList<>();
        path.add("ICN");
        dfs(path, "ICN", 0);
        return path.toArray(new String[0]);
    }

    public void dfs(LinkedList<String> path, String airport, int depth) {
        if (depth == N) return;

        LinkedList<Airport> ticketsFromAirport = ticketsFrom.get(airport);
        if (!ticketsFromAirport.isEmpty()) {
            for (int i = 0; i < ticketsFromAirport.size(); i += 1) {
                Airport next = ticketsFromAirport.remove(i);
                path.add(next.name);
                dfs(path, next.name, depth + 1);
                if (path.size() == N + 1) return;
                ticketsFromAirport.add(i, next);
                path.removeLast();
            }
        }
    }
}