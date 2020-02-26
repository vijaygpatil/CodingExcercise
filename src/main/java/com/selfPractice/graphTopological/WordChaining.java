package com.selfPractice.graphTopological;

import java.util.List;

public class WordChaining {
    private List<vertex> g;

    boolean check_cycle(int list_size) {
        //TODO: Write - Your - Code
        return false;
    }

    public WordChaining(List<vertex> g) {
        super();
        this.g = g;
    }

    public List<vertex> getG() {
        return g;
    }

    void setG(List<vertex> g) {
        this.g = g;
    }

    // This method creates a graph from a list of words. A node of
    // the graph contains a character representing the start or end
    // character of a word.
    void create_graph(List<String> words_list) {
        for (int i = 0; i < words_list.size(); i++) {
            String word = words_list.get(i);
            char start_char = word.charAt(0);
            char end_char = word.charAt(word.length() - 1);

            vertex start = vertex_exists(start_char);
            if (start == null) {
                start = new vertex(start_char, false);
                g.add(start);
            }

            vertex end = vertex_exists(end_char);
            if (end == null) {
                end = new vertex(end_char, false);
                g.add(end);
            }

            // Add an edge from start vertex to end vertex
            add_edge(start, end);
        }
    }

    // This method returns the vertex with a given value if it
    // already exists in the graph, returns NULL otherwise
    vertex vertex_exists(char value) {
        for (int i = 0; i < g.size(); i++) {
//            if (g.get(i).getValue() == value) {
//                return g.get(i);
//            }
        }
        return null;
    }

    // This method returns TRUE if all nodes of the graph have
    // been visited
    boolean all_visited() {
        for (int i = 0; i < getG().size(); i++) {
            if (getG().get(i).isVisited() == false) {
                return false;
            }
        }
        return true;
    }

    // This method adds an edge from start vertex to end vertex by
    // adding the end vertex in the adjacency list of start vertex
    // It also adds the start vertex to the in_vertices of end vertex
    void add_edge(vertex start, vertex end) {
//        start.getAdj_vertices().add(end);
//        end.getIn_vertices().add(start);
    }
}
