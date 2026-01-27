import java.util.*;

class Solution {

    static class Edge {
        int to, cost;
        Edge(int t, int c) {
            to = t;
            cost = c;
        }
    }

    static class State {
        int node;
        long cost;
        State(int n, long c) {
            node = n;
            cost = c;
        }
    }

    public int minCost(int n, int[][] edges) {

        List<Edge>[] out = new ArrayList[n];
        List<Edge>[] in  = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            out[i] = new ArrayList<>();
            in[i]  = new ArrayList<>();
        }

        for (int[] e : edges) {
            out[e[0]].add(new Edge(e[1], e[2]));
            in[e[1]].add(new Edge(e[0], e[2]));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<State> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));

        dist[0] = 0;
        pq.offer(new State(0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            if (cur.cost > dist[cur.node]) continue;

            // Normal edges
            for (Edge e : out[cur.node]) {
                long newCost = cur.cost + e.cost;
                if (newCost < dist[e.to]) {
                    dist[e.to] = newCost;
                    pq.offer(new State(e.to, newCost));
                }
            }

            // Reverse incoming edges
            for (Edge e : in[cur.node]) {
                long newCost = cur.cost + 2L * e.cost;
                if (newCost < dist[e.to]) {
                    dist[e.to] = newCost;
                    pq.offer(new State(e.to, newCost));
                }
            }
        }

        return dist[n - 1] == Long.MAX_VALUE ? -1 : (int) dist[n - 1];
    }
}
