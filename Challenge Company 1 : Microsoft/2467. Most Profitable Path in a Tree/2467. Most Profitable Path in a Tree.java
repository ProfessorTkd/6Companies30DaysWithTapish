class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n= edges.length+1;
        ArrayList<Integer>[] graph = new ArrayList[n];

// 1st  step : graph building
        for(int i=0; i<n; i++)
            graph[i] = new ArrayList<Integer>();

        for(int[] e : edges)
        {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

// creating a map which will store time taken by bob to reach each node
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

//to keep track of visited nodes
        boolean[] visited = new boolean[n];

// calculating time taken by bob to reach each node and storing it in map
        dfsdist(bob, 0, 0, visited, graph, map);
        // now we are done with bob

// ALICE"S TURN
        // taking array because integer is a call by value
        int netincome[] = new int[1];
        netincome[0] = Integer.MIN_VALUE;
        // there may bemultiple number of leafnodes, so we will calculate total income of each leaf node and store each of them in income, and the maximumof them all will be stored in netincome
        int income=0;
        // reusing visited array
        visited=new boolean[n];
        /// to calculate correct value of netincome
        maxSum(0,0, graph, visited, map, netincome, income, amount);

        return netincome[0];
    }

    public void maxSum(int src, int time, ArrayList<Integer>[] graph, boolean[] visited,  HashMap<Integer, Integer> map, int netincome[], int income, int[] amount){

// set visited[src] = true for node being visited
        visited[src] = true;

// adding amount in income
        // if bob haven't visited the node or if bob take more time to reach the node than Alice then Alice will have to do full payment'
        if(map.get(src) == null || time < map.get(src))
            income+=amount[src];
        // if both alice and bob reach the node at the same time then alice will have to pay half only
        else if(time == map.get(src))
            income+= amount[src]/2;
        
        // leaf node condition
        // a node is a leaf node only when it has only one node connected to it and it's not the source itself
        if(src!=0 && graph[src].size()==1){
            // updating netIncome value for each node
            netincome[0] = Math.max(netincome[0], income);
        }

    // visiting all the non-visited nodes in the path to perform above oprations
        for(int v : graph[src])
        {
            if(!visited[v])
                maxSum(v, time+1, graph, visited, map, netincome, income, amount);
        }
    } 

    // Basically, src or desst jab same hoga to it'll return true
    // or ye src se given dest pahunchne ka time store kare ja raha hai map mein jo ki we are using above

    public boolean dfsdist(int src, int time, int dest, boolean[] visited, ArrayList<Integer>[] graph,  HashMap<Integer, Integer> map){
        
        // set visited true for the node
        visited[src] = true;
        // put time in the map for reaching src for bob from its initial position
        map.put(src, time);
        // if src==dest then it means we have reached destination so return true
        if(src == dest) return true;

        // repeat the process for all non-visited nodes in the path
        for(Integer adj :graph[src] )
        {
            if(!visited[adj])
               if(dfsdist(adj, time+1, dest,visited, graph, map))
                return true;
        }

        // remove from map and return false if we do not reach dest 
        map.remove(src);
        return false;
    }
}
