class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        Queue<Integer> q=new LinkedList<>();
        for(int[] pre:prerequisites){
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int finish=0;
        while(!q.isEmpty()){
            finish++;
            int node=q.poll();
            for(int nei:adj.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }
        return finish==numCourses;
    }
}
