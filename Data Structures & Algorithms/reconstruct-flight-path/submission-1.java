class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> adj=new HashMap<>();
        for(List<String> ticket:tickets){
            String src=ticket.get(0);
            String dst=ticket.get(1);
            adj.computeIfAbsent(src,k->new PriorityQueue<>()).offer(dst);
        }
        List<String> res=new ArrayList<>();
        dfs(adj,"JFK",res);
        Collections.reverse(res);
        return res;
    }
    private void dfs(Map<String,PriorityQueue<String>> adj,String src,List<String> res){
        PriorityQueue<String> curr=adj.get(src);
        while(curr!=null && !curr.isEmpty()){
            String dst=curr.poll();
            dfs(adj,dst,res);
        }
        res.add(src);
    }
}
