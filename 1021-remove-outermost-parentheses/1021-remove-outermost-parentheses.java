class Solution {
    public String removeOuterParentheses(String s) {
        int open=0;
        int close=0;
        String ans="";
        int startIndex=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                open++;
            }
            else{
                close++;
            }

            if(open==close){
                ans+=s.substring(startIndex+1,i);
                startIndex=i+1;
                open=0;
                close=0;
            }
        }
        return ans;
    }
}