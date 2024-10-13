package Graphs_2;

import java.util.*;

public class cycleDirectional {

  static class Edge {
    int src;
    int dest;

    public Edge(int src, int dest) {
      this.src = src;
      this.dest = dest;
    }
  }

  static void createGraph(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      graph[i] = new ArrayList<>();
    }

    graph[0].add(new Edge(0, 2));
    graph[1].add(new Edge(1, 0));
    graph[2].add(new Edge(2, 3));
    graph[3].add(new Edge(3, 4));

  }

  // cycle detection in directional graphs dfs
  public static boolean isCycle(ArrayList<Edge> graph[]) {
    boolean isVisited[] = new boolean[graph.length];
    boolean stack[] = new boolean[graph.length];
    for (int i = 0; i < graph.length; i++) {
      if (!isVisited[i]) {
        if (isCycleUtil(graph, i, isVisited, stack)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean[] isVisited, boolean[] stack) {
    isVisited[curr] = true;
    stack[curr] = true;
    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (stack[e.dest]) {
        return true;
      } else if (!isVisited[e.dest]) {
        if (isCycleUtil(graph, e.dest, isVisited, stack)) {
          return true;
        }
      }
    }
    stack[curr] = false;
    return false;
  }

  public static void main(String[] args) {
    int V = 7;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
    System.out.println(isCycle(graph));
  }
}
