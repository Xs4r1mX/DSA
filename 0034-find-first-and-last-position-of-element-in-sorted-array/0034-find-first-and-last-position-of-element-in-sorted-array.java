class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{getFirst(nums,target),getLast(nums,target)};
    }

    public int getFirst(int[] nums, int x){
        int n=nums.length;
        int l=0;
        int r=n-1;
        int ans=-1;

        while(l<=r){
            int m=l+(r-l)/2;

            if(nums[m]==x){
                ans=m;
                r=m-1;
            }
            else if(nums[m]<x){
                l=m+1;
            }
            else{
                r=m-1;
            }
        }
        return ans;
    }
    public int getLast(int[] nums, int x){
        int n=nums.length;
        int l=0;
        int r=n-1;
        int ans=-1;

        while(l<=r){
            int m=l+(r-l)/2;

            if(nums[m]==x){
                ans=m;
                l=m+1;
            }
            else if(nums[m]<x){
                l=m+1;
            }
            else{
                r=m-1;
            }
        }
        return ans;
    }
}