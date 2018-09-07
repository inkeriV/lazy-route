


package lazyroute.graph;
import lazyroute.pathing.Path;

/**
 *
 * @author inkeriv
 */


public class Graph {
    
    //start node coordinates in graph
    private int ai;
    private int aj;

    //end node coordinates in graph
    private int li;
    private int lj;
    
    //infinite value
    private static final int INFINITE_VALUE=1000000000;
    
    public int[] nodes;
    private final int a; //ordinal of the start node in "nodes"-array
    private final int l; //ordinal of the end node in "nodes"-array
    private final int m; //graph width
    private final int n; //graph length
    private final String alg; //chosen algorithm, d or a

    
    public Graph (int[] s, int alku, int loppu, int lev, int pit, String al) {
        
        nodes = s;
        a = alku;
        l = loppu;
        m = lev;
        n = pit;
        alg = al;
    }
     
    /**
     *  Method creates presentations of the graph.
     *  
     * @return path as a String
     */
    public String getPath() {

        Node[] list = new Node[nodes.length] ;
        int[][] graph = new int[m][n];
        
        
        //Node-type list of nodes
        int value=0;
        for (int j=0; j<m; j++) {
            
            for (int i=0; i<n; i++) {
                
                
                //start node coordinates
                if (value==a-1) {
                    ai=i;
                    aj=j;
                }
                
                //end node coordinates
                if (value==l-1) {
                    li=i;
                    lj=j;
                }
                
                graph[i][j] = nodes[value];
                value++;
            }
        }
        
        //Adjacency list
        int[][] vl = new int[nodes.length][];
        
        for (int i=0; i<nodes.length; i++) {
            
            vl[i]=new int[4];
        }
        
        int[] dists = new int[nodes.length];
        int[] weights = new int[nodes.length];
        
        if (alg.equalsIgnoreCase("a")) {
           
            for (int i=0; i<nodes.length; i++) {
                
                weights[i]=INFINITE_VALUE;
            }
            AdjacencyListAStar(nodes, vl, m, n, list, weights, dists);
        }
        
        if (alg.equalsIgnoreCase("d")) { 
            
            for (int i=0; i<nodes.length; i++) {
                
                dists[i] = INFINITE_VALUE;
            }
            
            AdjacencyListDijkstra(nodes, vl, m, n, list, dists);
        }
        
        Path path=Path.shortestPath(list, vl, a, l, alg, nodes, weights, dists);
        String string = path.ToString(a,l,alg);
        return string;   
    }
    
    
    /**
     * heuristic function, Manhattan distance.
     * @param ai is the end node i-coordinate
     * @param aj is the end node j-coordinate
     * @param bi is nodes i-coordinate
     * @param bj is nodes j-coordinate
     * @return distance between those nodes
     */
    public int h( int ai, int aj, int bi, int bj) { 
        int lop = Math.abs(ai-bi)+Math.abs(aj-bj);
        return lop;
    }
    
    /**
     * creates the adjacency list for A-star
     * initialises also weight, dists and node lists.
     * 
     * @param nodes node weights as integers
     * @param vl adjacency list
     * @param m 2d graph's width
     * @param n 2d graph's length
     * @param list yet null, will have initialised node-objects
     * @param weights yet empty, will have nodes' initialised weights 
     * @param dists yet empty, will have nodes' initialised distances 
     * @return adjacency list
     */
    public int[][] AdjacencyListAStar(int[] nodes, int[][] vl, int m, int n, Node[] list, int[] weights, int[] dists) {
        int x = 0;
        
        list[1]=new Node(1, INFINITE_VALUE, h(1,0,li,lj));
        weights[1]=INFINITE_VALUE;
        dists[1]=list[1].dist;
        
        for (int j=0; j<n; j++) {
            for (int i=0; i<m; i++) {
                if (list[x]==null) { 
                
                    list[x]=new Node(x, INFINITE_VALUE, h(i,j,li,lj));
                    weights[x]=INFINITE_VALUE;
                    dists[x]=list[x].dist;
                    
                }
                //upper node
                if (isWithinBounds(i,j-1,m,n)) {
                    vl[x][0]=x-m;
                    
                } else { vl[x][0]=-1; }
                
                //previous node
                if (isWithinBounds(i-1,j,m,n)) {
                    vl[x][1]=x-1;
                    
                } else { vl[x][1]=-1; }
                
                //next node
                if (isWithinBounds(i+1,j,m,n)) {
                    vl[x][2]=x+1;
                    
                } else { vl[x][2]=-1; }
                
                //bottom node
                if (isWithinBounds(i,j+1,m,n)) {
                    vl[x][3]=x+m;
                    
                } else { vl[x][3]=-1; }
                
                x++;
            }    
        }
        return vl;
    }
    
    /**
     * creates the adjacency list for Dijkstra
     * initialises also dists and node lists.
     * 
     * @param nodes node weights as integers
     * @param vl adjacency list
     * @param m 2d graph's width
     * @param n 2d graph's length
     * @param list yet null, will have initialised node-objects
     * @param dists yet empty, will have nodes' initialised distances 
     * @return adjacency list
     */
    public int[][] AdjacencyListDijkstra(int[] nodes, int[][] vl, int m, int n, Node[] list, int[] dists) {
     
        int x = 0;
        
        list[1]=new Node(1, nodes[1], INFINITE_VALUE);
        dists[1]=INFINITE_VALUE;
        
        for (int j=0; j<n; j++) {
            for (int i=0; i<m; i++) {
                if (list[x]==null) { 
                
                    list[x]=new Node(x, nodes[x], INFINITE_VALUE);
                    dists[x]=INFINITE_VALUE;
                    
                }
                //upper node
                if (isWithinBounds(i,j-1,m,n)) {
                    vl[x][0]=x-m;
                    
                } else { vl[x][0]=-1; }
                
                //previous node
                if (isWithinBounds(i-1,j,m,n)) {
                    vl[x][1]=x-1;
                    
                } else { vl[x][1]=-1; }
                
                //next node
                if (isWithinBounds(i+1,j,m,n)) {
                    vl[x][2]=x+1;
                    
                } else { vl[x][2]=-1; }
                
                //bottom node
                if (isWithinBounds(i,j+1,m,n)) {
                    vl[x][3]=x+m;
                    
                } else { vl[x][3]=-1; }
                
                x++;
            }    
        }
        return vl;
    }
    
    
    /**
     * Returns true if node-coordinates are within the graph
     * used for checking what neighbour nodes a node has (previous,next,upper,bottom).
     * (thanks to my code reviewer)
     * 
     * @param i i and j are supposed neighbour node's coordinates
     * @param j
     * @param m m and n are the width and length of the graph
     * @param n
     * @return true or false
     */
    private boolean isWithinBounds(int i, int j, int m, int n) {
        if (i>=0 && i<m && j>=0 && j<n) {
            return true;
        }
        return false;
    }
    
    public int getStartNodeCoordinateI() { return ai; }
    public int getStartNodeCoordinateJ() { return aj; }
    public int getEndNodeCoordinateI() { return li; }
    public int getEndNodeCoordinateJ() { return lj; }    

}
