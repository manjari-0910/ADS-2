public class DiGraph{
    int V;
    Bag<Integer>[]adj;
    public DiGraph(int V){
        this.V = V;
        adj = (Bag<Integer>[])new Bag[V];
        for(int i = 0 ; i < V; i++){
            adj[i] = new Bag<Integer>();
        }
    }
    public void addEdge(int v1, int v2){
        adj[v1].add(v2);
        // adj[v2].add(v1);
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
	public int size() {
		return adj.length;
	}
}