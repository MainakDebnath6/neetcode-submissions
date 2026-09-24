class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> mp=new HashMap<>();
        for(List<String> ticket:tickets){
            mp.computeIfAbsent(ticket.get(0),key->new PriorityQueue<>()).add(ticket.get(1));
        }
        List<String> res=new ArrayList<>();
        dfs("JFK",mp,res);
        Collections.reverse(res);
        return res;
    }
    private void dfs(String src,Map<String,PriorityQueue<String>> mp,List<String> res){
        PriorityQueue<String> curr=mp.get(src);
        while(curr!=null && !curr.isEmpty()){
            String dst=curr.poll();
            dfs(dst,mp,res);
        }
        res.add(src);
    }
}
