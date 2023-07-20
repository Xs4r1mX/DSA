class Solution {
    public void nextPermutation(int[] nums) {
        int index=-1;
        int n = nums.length;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                index=i;
                break;
            }
        }

        if(index==-1)
        revArr(nums,0,n-1);

        else{
            for(int i=n-1;i>index;i--)
        {
            if(nums[i]>nums[index])
            {
                int temp=nums[index];
                nums[index]=nums[i];
                nums[i]=temp;
                break;
            }
        }

        revArr(nums,index+1,nums.length-1);

        }

        
        
    }

    public void revArr(int[] nums,int start , int end)
    {
        int l=start;
        int r=end;
        while(l<r)
        {
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
}