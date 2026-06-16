class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int [][] pair=new int[position.length][2];
        for(int i=0;i<position.length;i++){
            pair[i][0]=position[i];
            pair[i][1]=speed[i];
        }
        Arrays.sort(pair,(a,b)->Integer.compare(b[0],a[0]));
        double prevTime = 0;
        int fleets = 0;
        for (int[] car : pair) {
            double time = (double)(target - car[0]) / car[1];
            if(time>prevTime){
                fleets++;
                prevTime = time;
            }
        }
        return fleets;
    }
}
