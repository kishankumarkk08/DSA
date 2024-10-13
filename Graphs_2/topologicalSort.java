package Graphs_2;

import java.util.*;

public class topologicalSort {

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
    graph[2].add(new Edge(2, 3));
    graph[3].add(new Edge(3, 1));
    graph[4].add(new Edge(4, 1));
    graph[4].add(new Edge(4, 0));
    graph[5].add(new Edge(5, 0));
    graph[5].add(new Edge(5, 2));
  }

  // topological sort dfs
  public static void topologicalSort(ArrayList<Edge> graph[]) {
    boolean isVisited[] = new boolean[graph.length];
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < graph.length; i++) {
      if (!isVisited[i]) {
        topologicalSortUtil(graph, isVisited, s, i);
      }
    }
    while (!s.isEmpty()) {
      System.out.print(s.pop() + " ");
    }
  }

  public static void topologicalSortUtil(ArrayList<Edge> graph[], boolean isVisited[], Stack<Integer> s, int curr) {
    isVisited[curr] = true;
    for (int i = 0; i < graph[curr].size(); i++) {
      Edge e = graph[curr].get(i);
      if (!isVisited[e.dest]) {
        topologicalSortUtil(graph, isVisited, s, e.dest);
      }
    }
    s.push(curr);
  }

  // topological sorting bfs (KAHN'S ALGORITHM)
  public static void inDegree(ArrayList<Edge> graph[], int indeg[]) {
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[i].size(); j++) {
        Edge e = graph[i].get(j);
        indeg[e.dest]++;
      }
    }
  }

  public static void bfsTopSort(ArrayList<Edge> graph[]) {
    int indeg[] = new int[graph.length];
    inDegree(graph, indeg);

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < indeg.length; i++) {
      if (indeg[i] == 0) {
        q.add(i);
      }
    }
    // bfs
    while (!q.isEmpty()) {
      int curr = q.remove();
      System.out.print(curr + " ");
      for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        indeg[e.dest]--;
        if (indeg[e.dest] == 0) {
          q.add(e.dest);
        }
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int V = 6;
    ArrayList<Edge> graph[] = new ArrayList[V];
    createGraph(graph);
    topologicalSort(graph);
    System.out.println();
    bfsTopSort(graph);

  }
}
