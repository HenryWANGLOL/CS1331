import java.util.*;

/**
 * @author Yufeng Wang
 * @version 1.0
 */
public class GraphSearch {

    /**
     * Searches the Graph passed in as an adjacency list(adjList) to find if a
     * path exists from the start node to the goal node using General Graph
     * Search.
     *
     * Assume the adjacency list contains adjacent nodes of each node in the
     * order they should be added to the Structure. If there are no adjacent
     * nodes, then an empty list is present.
     *
     * The structure(struct) passed in is an empty structure that may behave as
     * a Stack or Queue and this function should execute DFS or BFS on the
     * graph, respectively.
     *
     * DO NOT use {@code instanceof} to determine the type of the Structure!
     *
     * @param start the object representing the node you are starting at.
     * @param struct the Structure you should use to implement the search.
     * @param adjList the adjacency list that represents the graph we are
     *        searching.
     * @param goal the object representing the node we are trying to reach.
     * @param <T> the data type representing the nodes in the graph.
     * @return true if path exists, false otherwise.
     */
    private static <T> boolean generalGraphSearch(T start, Structure<T> struct,
            Map<T, List<T>> adjList, T goal) {
        if (start == null || adjList == null || goal == null || struct == null) {
            throw new IllegalArgumentException("cant be null");
        }
        Set<T> known = new HashSet<>();
        if (!(adjList.containsKey(start) && adjList.containsKey(goal))) {
            throw new IllegalArgumentException("not valid graph");
        }
        struct.add(start);
        known.add(start);
        while (!struct.isEmpty()) {
            start = struct.remove();
            if (goal.equals(start)) {
                return true;
            }
            List<T> adjs = adjList.get(start);
            if (adjs != null) {
                for (T adding : adjs) {
                    if (!known.contains(adding)) {
                        struct.add(adding);
                    }
                }
            }
        }
        return false;
    }

    /**
     * Searches the Graph passed in as an adjacency list(adjList) to find if a
     * path exists from the start node to the goal node using Breadth First
     * Search.
     *
     * Assume the adjacency list contains adjacent nodes of each node in the
     * order they should be added to the Structure. If there are no adjacent
     * nodes, then an empty list is present.
     *
     * This method should be written in one line.
     *
     * @throws IllegalArgumentException if any input is null, or if
     * {@code start} or {@code goal} doesn't exist in the graph
     * @param start the object representing the node you are starting at.
     * @param adjList the adjacency list that represents the graph we are
     *        searching.
     * @param goal the object representing the node we are trying to reach.
     * @param <T> the data type representing the nodes in the graph.
     * @return true if path exists false otherwise
     */
    public static <T> boolean breadthFirstSearch(T start,
            Map<T, List<T>> adjList, T goal) {
            return generalGraphSearch(start, new StructureQueue(), adjList, goal);
    }

    /**
     * Searches the Graph passed in as an adjacency list(adjList) to find if a
     * path exists from the start node to the goal node using Depth First
     * Search.
     *
     * Assume the adjacency list contains adjacent nodes of each node in the
     * order they should be added to the Structure. If there are no adjacent
     * nodes, then an empty list is present.
     *
     * This method should be written in one line.
     *
     * @throws IllegalArgumentException if any input is null, or if
     * {@code start} or {@code goal} doesn't exist in the graph
     * @param start the object representing the node you are starting at.
     * @param adjList the adjacency list that represents the graph we are
     *        searching.
     * @param goal the object representing the node we are trying to reach.
     * @param <T> the data type representing the nodes in the graph.
     * @return true if path exists false otherwise
     */
    public static <T> boolean depthFirstSearch(T start,
            Map<T, List<T>> adjList, T goal) {
            return generalGraphSearch(start, new StructureStack(), adjList, goal);

    }

    /**
     * Find the shortest distance between the start node and the goal node
     * given a weighted graph in the form of an adjacency list where the
     * edges only have positive weights. If there are no adjacent nodes for
     * a node, then an empty list is present.
     *
     * Return the aforementioned shortest distance if there exists a path
     * between the start and goal, -1 otherwise.
     *
     * There are guaranteed to be no negative edge weights in the graph.
     *
     * You may import/use {@code java.util.PriorityQueue}.
     *
     * @throws IllegalArgumentException if any input is null, or if
     * {@code start} or {@code goal} doesn't exist in the graph
     * @param start the object representing the node you are starting at.
     * @param adjList the adjacency list that represents the graph we are
     *        searching.
     * @param goal the object representing the node we are trying to reach.
     * @param <T> the data type representing the nodes in the graph.
     * @return the shortest distance between the start and the goal node
     */
    public static <T> int dijkstraShortestPathAlgorithm(T start,
            Map<T, List<VertexDistancePair<T>>> adjList, T goal) {
        if (start == null || adjList == null || goal == null) {
            throw new IllegalArgumentException("cant be null");
        }
        if (!(adjList.containsKey(start) && adjList.containsKey(goal))) {
            throw new IllegalArgumentException("not valid graph");
        }
        PriorityQueue<VertexDistancePair<T>> arr = new PriorityQueue<>();
        Map<T,Integer> known = new HashMap<>();
        arr.add(new VertexDistancePair<T>(start, 0));
        known.put(start, 0);
        while (!arr.isEmpty()) {
            List<VertexDistancePair<T>> adjs = adjList.get(start);
            for (VertexDistancePair<T> t : adjs) {
                int len = known.get(start) + t.getDistance();
                if (goal.equals(t.getVertex())) {
                    if (known.get(goal) == null) {
                        known.put(goal, len);
                        arr.add(t);
                    } else {
                        if (len < known.get(goal)) {
                            known.replace(goal, len);
                        }
                    }
                } else {
                    if (known.get(t.getVertex()) == null) {
                        known.put(t.getVertex(), len);
                        arr.add(t);
                    } else {
                        if (len < known.get(t.getVertex())) {
                            known.replace(t.getVertex(), len);
                        }
                    }
                }
            }
            start = arr.poll().getVertex();

        }
        if (known.containsKey(goal)) {
            return known.get(goal);
        }
        return -1;

    }

}
