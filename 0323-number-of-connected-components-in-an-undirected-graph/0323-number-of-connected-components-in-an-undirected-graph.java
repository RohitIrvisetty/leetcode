class Solution {
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        List<Integer>[] adjList = new ArrayList[n];
        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);

        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                components++;
                bfs(i, visited, adjList);
            }
        }

        return components;
    }

    private void bfs(int node, int[] visited, List<Integer>[] adjList) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.add(node);

        while(!queue.isEmpty()) {
            int currNode = queue.pop();

            visited[currNode] = 1;

            for (int neighbour: adjList[currNode]) {
                if (visited[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
    }
}