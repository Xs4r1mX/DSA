class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        int cutOff=0;
        for(char c:s.toCharArray())
        {
            freq[c-'a']++;
            cutOff=Math.max(cutOff,freq[c-'a']);
        }
        int del=0;
        Arrays.sort(freq);
        for(int i=25;i>=0;i--)
        {
            if(freq[i]>cutOff)
            {
                if(cutOff>0)
                del+=freq[i]-cutOff;
                else
                del+=freq[i];
            }
            cutOff=Math.min(cutOff-1,freq[i]-1);
        }
        return del;
        
    }
}