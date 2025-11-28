class Solution {
    List<Integer>[] adj;
    long[] vals;
    int k;
    int components = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;
        this.vals = new long[n];

        // convert int → long because values[i] can be up to 1e9
        for (int i = 0; i < n; i++) vals[i] = values[i];

        // adjacency list
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        dfs(0, -1);   // root at node 0

        return components;
    }

    private long dfs(int node, int parent) {
        long sum = vals[node];

        for (int child : adj[node]) {
            if (child == parent) continue;
            sum += dfs(child, node);
        }

        // If this subtree is divisible by k → it becomes one component
        if (sum % k == 0) {
            components++;
            return 0;  // cut this component from parent
        }

        return sum; // return remaining sum upward
    }
}
