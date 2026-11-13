class Solution {
public:
    int calPoints(vector<string>& operations) {
        vector<int> st;
        for(const string& op:operations){
            if(op=="+"){
                int top=st.back();
                st.pop_back();
                int newTop=top+st.back();
                st.push_back(top);
                st.push_back(newTop);
            }
            else if(op=="D"){
                st.push_back(2*st.back());
            }else if(op=="C"){
                st.pop_back();
            }else{
                st.push_back(stoi(op));
            }
        }
        return accumulate(st.begin(),st.end(),0);
    }
};