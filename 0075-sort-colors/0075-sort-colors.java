class Solution {
    public void sortColors(int[] nums) {
        int[] freq= new int[3];
        for(int i=0;i<nums.length;i++)
        {
            freq[nums[i]]++;
        }
        int i=0;
        int j=0;
        while(i<freq.length)
        {
            if(freq[i]==0)
            i++;
            else
            {
                nums[j++]=i;
                freq[i]--; 
            }
            

        }
        
    }
}