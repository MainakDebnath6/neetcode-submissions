class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n=heights.size();
        int maxArea=0;
        stack<pair<int,int>> st;
        for(int i=0;i<heights.size();i++){
            int start=i;
            while(!st.empty() && st.top().second>heights[i]){
                pair<int,int> top=st.top();
                int index=top.first;
                int height=top.second;
                maxArea=max(maxArea,height*(i-index));
                start=index;
                st.pop();
            }
            st.push({start,heights[i]});
        }
        while(!st.empty()){
            int index=st.top().first;
            int height=st.top().second;
            maxArea = max(maxArea, height * (static_cast<int>(heights.size()) - index));
            st.pop();
        }
        return maxArea;
    }
};
