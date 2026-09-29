class Solution {
    public int minEatingSpeed(int[] nums, int h) {
        int l=1;
        int r=getMax(nums);;
        int ans=r;

        while(l<=r){
            int m=l+(r-l)/2;

            if(hoursToEat(nums,m)>h){
                l=m+1;  //increase banana count to reduce hours
            }
            else{
                ans=m;
                r=m-1;
            }

        }
        return ans;
    }

    private int hoursToEat(int[] nums, int bananas){
        int ans=0;

        for(double n:nums){
            ans+=Math.ceil(n/bananas);
        }

        return ans;
    }

    private int getMax(int[] nums){
        int max=Integer.MIN_VALUE;
        for(int n:nums) max=Math.max(max,n);
        return max;

    }
}