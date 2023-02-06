package org.apoorv.laaksonencp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class AdjacencyList {
    public AdjacencyList() {
        list = new HashMap<>();
    }

    private static HashMap<Integer, ArrayList<Integer>> list;
    private static ArrayDeque<Integer> deque = new ArrayDeque<>();
    private static int[] dfsorder;
    private static boolean[] visited;

    public void add(int node, int[] connections) {
        list.putIfAbsent(node, new ArrayList<>());
        for (int connection : connections) {
            list.get(node).add(connection);
        }
    }

    public ArrayList<Integer> getConnections(int node) {
        return list.get(node);
    }

    public int size() {
        return list.size();
    }

    public static void dfs(int node) {
        // base case
        if (visited[node - 1]) {
            return;
        }
        // recursive case
        visited[node - 1] = true;
        System.out.println(node);
        for (int adj : list.get(node)) {
            dfs(adj);
        }
    }

    public static void bfs(int a) {
        deque.add(a);
        visited[a - 1] = true;
        while (!deque.isEmpty()) {
            int node = deque.removeFirst();
            System.out.println(node);
            for (int i : list.get(node)) {
                if (!visited[i - 1]) {
                    visited[i - 1] = true;
                    deque.add(i);
                }
            }
        }
    }

    public void add(int node, int connections) {

    }

    public static void main(String[] args) {
        AdjacencyList a = new AdjacencyList();
        a.add(1, new int[]{2, 4});
        a.add(2, new int[]{1, 3, 5});
        a.add(3, new int[]{2, 5});
        a.add(4, new int[]{1});
        a.add(5, new int[]{2, 3});
        visited = new boolean[list.size()];
        bfs(1);
    }
}
