class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
        sort(people.begin(),people.end());
        int l=0,r=people.size()-1;
        int res=0;
        while(l<=r){
            if(people[r]<=limit){
                res++;
                int remaining=limit-people[r];
                if(remaining>=people[l]) l++;
            }
            r--;
        }
        return res;
    }
};