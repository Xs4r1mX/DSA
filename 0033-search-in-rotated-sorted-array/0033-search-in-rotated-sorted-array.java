class Solution {
    public int search(int[] nums, int k) {
       int l=0;
       int r=nums.length-1;
       int ans=-1;

       while(l<=r){
            int m=l+(r-l)/2;

            if(nums[m]==k){
                return m;
            }

            if(nums[l]<=nums[m]){
                if(nums[l]<=k && nums[m]>=k){
                    r=m-1;
                }
                else{
                    l=m+1;
                }
            } else{
                if(nums[m]<=k && nums[r]>=k){
                    l=m+1;
                }
                else{
                    r=m-1;
                }
            }
        }
        return ans;
    }
}
