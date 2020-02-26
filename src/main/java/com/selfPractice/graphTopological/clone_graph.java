package com.selfPractice.graphTopological;

import java.util.*;

class Node {
    public int data;
    public List<Node> neighbors = new ArrayList<Node>();
    public Node(int d) {data = d;}
}

class Graph {
    private static Node clone_rec(
            Node root,
            HashMap<Node, Node> nodes_completed) {
        if (root == null) {
            return null;
        }

        Node pNew = new Node(root.data);
        nodes_completed.put(root, pNew);

        for (Node p : root.neighbors) {
            Node x = nodes_completed.get(p);
            if (x == null){
                pNew.neighbors.add(clone_rec(p, nodes_completed));
            } else {
                pNew.neighbors.add(x);
            }
        }
        return pNew;
    }

    public static Node clone(Node root) {
        HashMap<Node, Node> nodes_completed =
                new HashMap<Node, Node>();

        return clone_rec(root, nodes_completed);
    }
}

class Pair<I extends Number, I1 extends Number> {
    Integer first;
    Integer second;

    Pair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }
}

class clone_graph {
    // if there is an edge from x to y
// that means there must be an edge from y to x
// and there is no edge from a node to itself
// hence there can maximim of (nodes * nodes - nodes) / 2 edgesin this graph
    static ArrayList<Node> create_test_graph_undirected(int nodes_count, int edges_count) {
        ArrayList<Node> vertices = new ArrayList<Node>();
        for (int i = 0; i < nodes_count; ++i) {
            vertices.add(new Node(i));
        }

        List<Pair<Integer, Integer>> all_edges = new ArrayList<Pair<Integer, Integer>>();
        for (int i = 0; i < vertices.size(); ++i) {
            for (int j = i + 1; j < vertices.size(); ++j) {
                all_edges.add(new Pair<Integer, Integer>(i, j));
            }
        }

        Collections.shuffle(all_edges);

        for (int i = 0; i < edges_count && i < all_edges.size(); ++i) {
            Pair<Integer, Integer> edge = all_edges.get(i);
            vertices.get(edge.first).neighbors.add(vertices.get(edge.second));
            vertices.get(edge.second).neighbors.add(vertices.get(edge.first));
        }

        return vertices;
    }

    static void print_graph(List<Node> vertices) {
        for (Node n : vertices) {
            System.out.print(n.data + ": {");
            for (Node t : n.neighbors) {
                System.out.print(t.data + " ");
            }
            System.out.println();
        }
    }

    static void print_graph(Node root, HashSet<Node> visited_nodes) {
        if (root == null || visited_nodes.contains(root)) {
            return;
        }

        visited_nodes.add(root);

        System.out.print(root.data + ": {");
        for (Node n : root.neighbors) {
            System.out.print(n.data + " ");
        }
        System.out.println("}");

        for (Node n : root.neighbors) {
            print_graph(n, visited_nodes);
        }
    }

    static void print_graph(Node root) {
        HashSet<Node> visited_nodes = new HashSet<Node>();
        print_graph(root, visited_nodes);
    }

    static boolean are_graphs_equal_rec(Node root1, Node root2, HashSet<Node> visited) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        }

        if (root1.neighbors.size() != root2.neighbors.size()) {
            return false;
        }

        for (Node nbr1 : root1.neighbors) {
            boolean found = false;
            for (Node nbr2 : root2.neighbors) {
                if (nbr1.data == nbr2.data) {
                    if (!visited.contains(nbr1)) {
                        visited.add(nbr1);
                        are_graphs_equal_rec(nbr1, nbr2, visited);
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayList<Node> vertices = create_test_graph_undirected(7, 18);

        print_graph(vertices.get(0));

        Node cp = Graph.clone(vertices.get(0));
        System.out.println();
        System.out.println("After copy.");
        print_graph(cp);

        HashSet<Node> set = new HashSet<Node>();
        System.out.println(are_graphs_equal_rec(vertices.get(0), cp, set));
    }
}