package algorithm;

import java.util.Arrays;

/**
 * https://bumbums.tistory.com/4
 */
public class Dijkstra {

    private int n; // 노드 수.
    private int[][] maps;   // 노드들 간의 가중치.

    public Dijkstra(int n) {
        this.n = n;
        maps = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(maps[i], Integer.MAX_VALUE);
        }
    }

    public void input(int start, int end, int weight) {
        maps[start - 1][end - 1] = weight;
        maps[end - 1][start - 1] = weight;

        maps[start - 1][start - 1] = 0;
        maps[end - 1][end - 1] = 0;
    }

    public int[] dijkstra(int node) {
        boolean[] visited = new boolean[this.n];
        int[] distances = new int[this.n];

        // initialize visited
        Arrays.fill(visited, false);

        // initialize distances
        Arrays.fill(distances, Integer.MAX_VALUE);

        distances[node - 1] = 0;
        visited[node - 1] = true;

        // update linked node weight.
        for (int i = 0; i < this.n; i++) {
            if (maps[node - 1][i] != 0 && maps[node - 1][i] != Integer.MAX_VALUE) {
                distances[i] = maps[node - 1][i];
            }
        }

        // 탐색
        for (int i = 0; i < this.n; i++) {
            // 방문하지 않은 노드 중에 최단 거리 노드 찾기.
            int minDistance = Integer.MAX_VALUE;
            int indexOfMinNode = 0;
            for (int j = 0; j < this.n; j++) {
                if (!visited[j] && distances[j] < minDistance) {
                    minDistance = distances[j];
                    indexOfMinNode = j;
                }
            }

            // 현재 방문한 노드로 부터의 최단 거리 찾기.
            visited[indexOfMinNode] = true;
            for (int j = 0; j < this.n; j++) {
                int accumulatedWeight = 0;
                if (maps[indexOfMinNode][j] == Integer.MAX_VALUE || distances[indexOfMinNode] == Integer.MAX_VALUE) {
                    accumulatedWeight = Integer.MAX_VALUE;
                } else {
                    accumulatedWeight = maps[indexOfMinNode][j] + distances[indexOfMinNode];
                }

                if (!visited[j] && accumulatedWeight < distances[j]) {
                    distances[j] = accumulatedWeight;
                }
            }
        }

        for (int i = 0; i < this.n; i++) {
            System.out.printf(distances[i] + ", ");
        }

        return distances;
    }
}
