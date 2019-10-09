import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Jordan Pearson and Thalia Barr-Malec
 * @version Date
 */

public class GraphClass<V> implements GraphIfc<V> {

    HashMap<V, ArrayList<V>> map = new HashMap<V, ArrayList<V>>();
    Set<V> set = new HashSet<V>();

    public static void main(String [] args) {
        GraphClass<String> graph = new GraphClass<String>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");

        graph.addEdge("A", "C");
        graph.addEdge("A", "E");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("D", "A");
        graph.addEdge("D", "E");
        graph.addEdge("A","B");
        graph.addEdge("A","C");
        graph.addEdge("E","D");
        System.out.println(graph.degree("A"));
        System.out.println(graph.numEdges());
        System.out.println(graph.getNeighbors("A"));
        System.out.println(graph.edgeExists("E","D"));
        System.out.println(graph.edgeExists("D","E"));
        System.out.println(graph.toString());
        System.out.println("Number of vertices: " + graph.numVertices());
        System.out.println("Number of edges: " + graph.numEdges());
        System.out.println("Get vertices: " + graph.getVertices());
        System.out.println("Get neighbors of D: " + graph.getNeighbors("D"));
        System.out.println("Contains vertex A: " + graph.containsVertex("A"));
        System.out.println("Contains vertex F: " + graph.containsVertex("F"));
        System.out.println("Contains edge A -> C: " + graph.edgeExists("A", "C"));
        System.out.println("Contains edge C -> A: " + graph.edgeExists("C", "A"));

        System.out.println(graph.toString());

    }

    /**
     * Returns the number of vertices in the graph
     * @return The number of vertices in the graph
     */
    //Jordan
    public int numVertices() {
        return set.size();
    }

    /**
     * Returns the number of edges in the graph
     * @return The number of edges in the graph
     */
    //Thalia
    public int numEdges() {
        int totalEdges = 0;
        for (Map.Entry<V,ArrayList<V> > entry : map.entrySet()) { // loop through and count the number of edges at each vertex
            totalEdges += entry.getValue().size();
        }
        return totalEdges;
    }

    /**
     * Removes all vertices from the graph
     */
    //Jordan
    public void clear(){
        map.clear();
        set.clear();
    }

    /**
     * Adds a vertex to the graph. This method has no effect if the vertex already exists in the graph.
     * @param v The vertex to be added
     */
    //Jordan
    public void addVertex(V v) {
        if (set.contains(v)) {
            throw new AssertionError("Vertex already exists.");
        }
        ArrayList<V> list = new ArrayList<V>();
        map.put(v, list);
        set.add(v);
    }

    /**
     * Adds an edge between vertices u and v in the graph.
     * @param u A vertex in the graph
     * @param v A vertex in the graph
     * @throws IllegalArgumentException if either vertex does not occur in the graph.
     */
    //Thalia
    public void addEdge(V u, V v) {
        if (!map.containsKey(u) || !map.containsKey(v)) {
            throw new IllegalArgumentException("At least one of the vertices does not exist");
        }
        if (edgeExists(u, v)) { // if the edge already exists, do nothing
            return;
        }
        map.get(u).add(v);
    }

    /**
     * Returns the set of all vertices in the graph.
     * @return A set containing all vertices in the graph
     */
    //Jordan
    public Set<V> getVertices() {
        return set;
    }

    /**
     * Returns the neighbors of v in the graph. A neighbor is a vertex that is connected to
     * v by an edge. If the graph is directed, this returns the vertices u for which an
     * edge (v, u) exists.
     *
     * @param v An existing node in the graph
     * @return All neighbors of v in the graph.
     * @throws IllegalArgumentException if the vertex does not occur in the graph
     */
    //Thalia
    public List<V> getNeighbors(V v){
        if (!map.containsKey(v)) {
            throw new IllegalArgumentException("No vertex present");
        }
        return map.get(v);
    }

    /**
     * Determines whether the given vertex is already contained in the graph. The comparison
     * is based on the <code>equals()</code> method in the class V.
     *
     * @param v The vertex to be tested.
     * @return True if v exists in the graph, false otherwise.
     */
    //Jordan
    public boolean containsVertex(V v) {
        return set.contains(v);
    }

    /**
     * Determines whether an edge exists between two vertices. In a directed graph,
     * this returns true only if the edge starts at v and ends at u.
     * @param v A node in the graph
     * @param u A node in the graph
     * @return True if an edge exists between the two vertices
     * @throws IllegalArgumentException if either vertex does not occur in the graph
     */
    //Thalia
    public boolean edgeExists(V v, V u) {
        if (!map.containsKey(u) || !map.containsKey(v)) {
            throw new IllegalArgumentException("No edge present");
        }
        ArrayList<V> nodes = map.get(v); // get the list of edges for the given vertex
        for(Object node : nodes) { // loop through and return true if the vertex at the index equals the given vertex
            if (node.equals(u)) {
                return true;
            }
        }

        return false; // otherwise return false
    }

    /**
     * Returns the degree of the vertex. In a directed graph, this returns the outdegree of the
     * vertex.
     * @param v A vertex in the graph
     * @return The degree of the vertex
     * @throws IllegalArgumentException if the vertex does not occur in the graph
     */
    //Thalia
    public int degree(V v) {
        if (!map.containsKey(v)) {
            throw new IllegalArgumentException("No vertex present");
        }
        return map.get(v).size(); // return the size of the list at the given vertex

    }

    /**
     * Returns a string representation of the graph. The string representation shows all
     * vertices and edges in the graph.
     * @return A string representation of the graph
     */
    //Jordan
    public String toString() {
        String str = "";
        Iterator<V> iterator = set.iterator();

        while (iterator.hasNext()) {
            V v = iterator.next();
            str += "" + v + ": " + map.get(v) + "\n";
        }

        return str;
    }
}
