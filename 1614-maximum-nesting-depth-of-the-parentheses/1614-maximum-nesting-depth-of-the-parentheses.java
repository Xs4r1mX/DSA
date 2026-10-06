class Solution {
    public int maxDepth(String s) {
        int count=0;
        int ans=0;

        for(char ch:s.toCharArray()){
            if(ch=='(') count++;
            else if(ch==')') count--;
            else continue;
            ans=Math.max(ans,count);
        }

        return ans;
    }
}