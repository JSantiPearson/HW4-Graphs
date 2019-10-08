import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

/**
 * @author Jordan Pearson and Thalia Barr-Malec
 * @version Date
*/

public class GraphClass<V> implements GraphIfc<V> {
	
	Set<ArrayList<V>> set = new HashSet<ArrayList<V>>();

    /**
     * Returns the number of vertices in the graph
     * @return The number of vertices in the graph
     */
    //Jordan
    public int numVertices() {
        return 0;
    }

    /**
     * Returns the number of edges in the graph
     * @return The number of edges in the graph
     */
    //Thalia
    public int numEdges() {
        return 0;
    }

    /**
     * Removes all vertices from the graph
     */
    //Jordan
    public void clear(){

    }

    /**
     * Adds a vertex to the graph. This method has no effect if the vertex already exists in the graph.
     * @param v The vertex to be added
     */
    //Jordan
    public void addVertex(V v) {
    	ArrayList<V> list = new ArrayList<V>();
    	set.add(list);
    }

    /**
     * Adds an edge between vertices u and v in the graph.
     * @param u A vertex in the graph
     * @param v A vertex in the graph
     * @throws IllegalArgumentException if either vertex does not occur in the graph.
     */
    //Thalia
    public void addEdge(V u, V v) {

    }

    /**
     * Returns the set of all vertices in the graph.
     * @return A set containing all vertices in the graph
     */
    //Jordan
    public Set<V> getVertices() {
        Set<V> hashSet = new HashSet<V>();
        return hashSet;
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
        List<V> list = new ArrayList<V>();
        return list;
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
        return true;
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
        return true;
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
        return 0;
    }

    /**
     * Returns a string representation of the graph. The string representation shows all
     * vertices and edges in the graph.
     * @return A string representation of the graph
     */
    //Jordan
    public String toString() {
        return "";
    }
}
