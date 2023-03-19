package org.apoorv.laaksonencp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

public class Graph {
    public Graph() {
        this.adjList = new HashMap<>();
        this.edgeList = new HashSet<>();
    }

    public Graph(File template, boolean weighted) throws IOException {
        this.adjList = new HashMap<>();
        this.edgeList = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(template));
        if (weighted) {
            readWeighted(reader);
        } else {
            readUnweighted(reader);
        }
    }

    private void readWeighted(BufferedReader r) throws IOException {
        String line = r.readLine();
        while (line != null) {
            StringTokenizer t = new StringTokenizer(line);
            int node = Integer.parseInt(t.nextToken());
            HashSet<int[]> adj = new HashSet<>();
            while (t.hasMoreTokens()) {
                int adjNode = Integer.parseInt(t.nextToken());
                int weight = Integer.parseInt(t.nextToken());
                adj.add(new int[]{adjNode, weight});
                this.edgeList.add(new int[]{node, adjNode});
            }
            this.adjList.putIfAbsent(node, adj);
            line = r.readLine();
        }
    }

    private void readUnweighted(BufferedReader r) throws IOException {
        String line = r.readLine();
        while (line != null) {
            StringTokenizer t = new StringTokenizer(line);
            int node = Integer.parseInt(t.nextToken());
            HashSet<int[]> adj = new HashSet<>();
            while (t.hasMoreTokens()) {
                int adjNode = Integer.parseInt(t.nextToken());
                adj.add(new int[]{adjNode, 1});
                this.edgeList.add(new int[]{node, adjNode});
            }
            this.adjList.putIfAbsent(node, adj);
            line = r.readLine();
        }
    }

    private HashMap<Integer, Set<int[]>> adjList;
    private Set<int[]> edgeList;
    private ArrayDeque<Integer> deque = new ArrayDeque<>();
    private int[] dfsorder;
    private boolean[] visited;

    public void add(int node, int[] connections, int[] weights) {
        this.adjList.putIfAbsent(node, new HashSet<>());
        for (int i = 0; i < connections.length; i++) {
            this.adjList.get(node).add(new int[]{connections[i], weights[i]});
//            this.edgeList.add(new int[]{node, connection});
        }
    }

    public Set<int[]> getConnections(int node) {
        return this.adjList.get(node);
    }

    public int size() {
        return this.adjList.size();
    }

    public void dfs(int node, Consumer<Integer> c) {
        // base case
        if (visited[node - 1]) {
            return;
        }
        // recursive case
        visited[node - 1] = true;
        c.accept(node);
        System.out.println(node);
        for (int[] adj : this.adjList.get(node)) {
            dfs(adj[0], c);
        }
    }

    public void bfs(int startNode, Consumer<Integer> c) {
        deque.add(startNode);
        visited[startNode - 1] = true;
        while (!deque.isEmpty()) {
            int node = deque.removeFirst();
            c.accept(node);
            for (int[] i : this.adjList.get(node)) {
                if (!visited[i[0] - 1]) {
                    visited[i[0] - 1] = true;
                    deque.add(i[0]);
                }
            }
        }
    }

    public void bfs(int startNode, int[] parent, int[] distance, Consumer<Integer> c) {
        deque.add(startNode);
        visited[startNode - 1] = true;
        distance[startNode] = 0;
        parent[startNode] = 0;
        while (!deque.isEmpty()) {
            int node = deque.removeFirst();
            c.accept(node);
            for (int[] i : this.adjList.get(node)) {
                if (!visited[i[0] - 1]) {
                    visited[i[0] - 1] = true;
                    deque.add(i[0]);
                    parent[i[0]] = node;
                    distance[i[0]] = distance[node] + 1;
                }
            }
        }
    }

    public void adjList() {
        System.out.println(this.adjList);
    }

    public void edgeList() {
        this.edgeList.forEach(ints -> System.out.print(Arrays.toString(ints)));
    }


    public void dijkstra(int startNode) {
        Map<Integer, Integer> distance = new HashMap<>();
        adjList.forEach((k, v) -> distance.put(k, Integer.MAX_VALUE));
        distance.replace(startNode, 0);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.push(startNode);
        while (!deque.isEmpty()) {
            int node = deque.pop();
            int min = adjList
        }
    }

    public static void main(String[] args) {
        Graph a = new Graph();
        a.add(1, new int[]{2, 4}, new int[]{1, 1});
        a.add(2, new int[]{1, 3, 5}, new int[]{1, 1, 1});
        a.add(3, new int[]{2, 5}, new int[]{1, 1});
        a.add(4, new int[]{1}, new int[]{1});
        a.add(5, new int[]{2, 3}, new int[]{1, 1});
        a.visited = new boolean[a.size()];
//        a.bfs(1, System.out::println);
        a.adjList();
        int[] parent = new int[6];
        int[] distance = new int[6];
        Arrays.fill(parent, -1);
        Arrays.fill(distance, -1);
        a.bfs(1, parent, distance, x -> {});
        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(distance));
    }
}
