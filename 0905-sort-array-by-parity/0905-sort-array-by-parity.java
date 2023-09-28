class Solution {
    public int[] sortArrayByParity(int[] nums) {
        
        if(nums.length<2)
        return nums;

        int i=0;
        int j=1;

        while(i<nums.length && j<nums.length){
            if(nums[i]%2==1 && nums[j]%2==0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j++;
            }
            else{
                if(nums[i]%2==1 && nums[j]%2==1){
                    j++;
                    continue;
                }
                if(nums[i]%2==0){
                    i++;
                }
                if(nums[j]%2==0){
                    j++;
                }
            }
        }
        return nums;

        
        
    }
}