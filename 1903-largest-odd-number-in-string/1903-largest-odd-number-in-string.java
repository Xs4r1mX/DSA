class Solution {
    public String largestOddNumber(String s) {
        if((int)s.charAt(s.length()-1)%2==1) return s;
        int i=s.length()-1;

        while(i>=0){
            if((int)s.charAt(i)%2==1){
                return s.substring(0,i+1);
            }

            i--;
        }
        return "";
    }
}