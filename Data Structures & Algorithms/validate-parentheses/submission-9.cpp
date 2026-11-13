class Solution {
public:
    bool isValid(string s) {
        unordered_map<char,char> mp;
        mp['}']='{';
        mp[')']='(';
        mp[']']='[';
        stack<char> st;
        for(char c:s){
            if(mp.count(c)){
                if(!st.empty() && st.top()==mp[c]){
                    st.pop();
                }else{
                    return false;
                }
            }
            else{
                st.push(c);
            }
        }
        return st.empty();
    }
};
