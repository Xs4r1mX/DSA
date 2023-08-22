class Solution {
    public String convertToTitle(int columnNumber) {
        String ans="";
        while(columnNumber>0)
        {
            columnNumber--;
            int n = columnNumber%26;
            ans=(char)('A'+n)+ans;
            columnNumber/=26;
        }
        return ans;
    }
}