class Solution {
    public String removeOuterParentheses(String s) {
        int bracketCount=0;

        StringBuilder sb = new StringBuilder(s.length());

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(ch=='('){
                bracketCount++;
                if(bracketCount>1){
                    sb.append(ch);
                }
            }
            else{
                bracketCount--;
                if(bracketCount>0){
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
}