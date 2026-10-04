class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>(n);
        boolean[] visited = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                components++;
                if (!dfs(adjList, visited, i, -1)) {
                    return false;
                }
            }

        }
        return components == 1;
    }

    private boolean dfs(List<List<Integer>> adjList, boolean[] visited, int node, int parent) {
        System.out.println(node + " " + parent);
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                if (!dfs(adjList, visited, neighbor, node)) {
                    return false;
                }
            } else if (neighbor != parent) {
                return false;
            }

        }

        return true;
    }
}