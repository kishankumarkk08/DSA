package Graphs_2;

import java.util.*;

public class cycleDetect {

  static class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int src, int dest, int wt) {
      this.src = src;
      this.dest = dest;
      this.wt = wt;
    }
  }

  static void createGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }
    graph[0].add(new Edge(0, 1, 1));
    graph[0].add(new Edge(0, 2, 1));

    graph[1].add(new Edge(1, 0, 1));
    graph[1].add(new Edge(1, 3, 1));

    graph[2].add(new Edge(2, 0, 1));
    graph[2].add(new Edge(2, 4, 1));

    graph[3].add(new Edge(3, 1, 1));
    graph[3].add(new Edge(3, 4, 1));
    graph[3].add(new Edge(3, 5, 1));

    graph[4].add(new Edge(4, 2, 1));
    graph[4].add(new Edge(4, 5, 1));
    graph[4].add(new Edge(4, 3, 1));

    graph[5].add(new Edge(5, 6, 1));
    graph[5].add(new Edge(5, 3, 1));
    graph[5].add(new Edge(5, 4, 1));

    graph[6].add(new Edge(6, 5, 1));

  }

  // cycle-detection dfs
  public static boolean isCycle(ArrayList<Edge> graph[]) {
    boolean isVisited[] = new boolean[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (!isVisited[i]) {
        if (isCycleUtil(graph, isVisited, i, -1)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean isCycleUtil(ArrayList<Edge> graph[], boolean isVisited[], int curr, int parent) {
    isVisited[curr] = true;
    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (!isVisited[e.dest]) {
        if (isCycleUtil(graph, isVisited, e.dest, curr)) {
          return true;
        }
      } else if (isVisited[e.dest] && e.dest != parent) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int V = 7;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
    System.out.println(isCycle(graph));
  }

}
