class Solution {
    public int splitArray(int[] nums, int k) {
        int l=0;
        int r=0;

        for(int n:nums){
            l=Math.max(l,n);
            r+=n;
        }

        int ans=r;

        while(l<=r){
            int mid=l+(r-l)/2;

            if(isPossible(nums,k,mid)){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int k, int maxAllowed){
        int subArrayCount=1;
        int totalSum=0;

        for(int n:nums){
            if(totalSum+n>maxAllowed){
                subArrayCount++;
                totalSum=n;
            }
            else{
                totalSum+=n;
            }
        }
        return subArrayCount<=k;
    }
}