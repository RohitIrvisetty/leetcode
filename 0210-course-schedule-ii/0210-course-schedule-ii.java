class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        List<List<Integer>> adjList = new ArrayList<>(numCourses);
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> topoSort = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currNode = queue.poll();
            topoSort.add(currNode);

            for (int neighbor: adjList.get(currNode)) {
                inDegree[neighbor]--;

                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (topoSort.size() == numCourses) {
            return topoSort.stream().mapToInt(i -> i).toArray();
        }

        return new int[] {};
    }
}