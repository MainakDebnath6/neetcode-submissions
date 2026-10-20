class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l=0,r=people.length-1;
        int res=0;
        while(l<=r){
            res++;
            int remaining=limit-people[r];
            if(people[l]<=remaining) l++;
            r--;
        }
        return res;
    }
}