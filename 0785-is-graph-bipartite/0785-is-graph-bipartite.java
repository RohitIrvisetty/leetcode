class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                colors[i] = 1;
                if (!dfs(graph, colors, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int node) {
        for (int neighbor: graph[node]) {
            if (colors[neighbor] == -1) {
                colors[neighbor] = colors[node] ^ 1;
                if (!dfs(graph, colors, neighbor)) {
                    return false;
                }
            } else if (colors[node] == colors[neighbor]) {
                    return false;
            }
        }

        return true;
    }
}