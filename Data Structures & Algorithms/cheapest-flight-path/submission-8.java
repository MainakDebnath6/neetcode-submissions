class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight:flights){
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        int[] prices=new int[n];
        Arrays.fill(prices,Integer.MAX_VALUE);
        Queue<int[]> q=new LinkedList<>();
        prices[src]=0;
        q.offer(new int[]{0,src,0});
        while(!q.isEmpty()){
            int[] p=q.poll();
            int wt1=p[0];
            int n1=p[1];
            int steps=p[2];
            if(steps>k) continue;
            for(int[] nei:adj.get(n1)){
                int n2=nei[0];
                int wt2=nei[1];
                if(wt1+wt2<prices[n2]){
                    prices[n2]=wt1+wt2;
                    q.offer(new int[]{prices[n2],n2,steps+1});
                }
            }
        }
        return prices[dst]==Integer.MAX_VALUE?-1:prices[dst];
    }
}
