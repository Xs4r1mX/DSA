class Solution {
    public int minEatingSpeed(int[] nums, int h) {
        int l=1;
        int r=getMax(nums);;
        int ans=r;

        while(l<=r){
            int m=l+(r-l)/2;

            if(hoursToEat(nums,m,h)>h){
                l=m+1;  //increase banana count to reduce hours
            }
            else{
                ans=m;
                r=m-1;
            }

        }
        return ans;
    }

    private int hoursToEat(int[] nums, int bananas, int h){
        int totalHours=0;

        for(int n:nums){
            totalHours+=(n + bananas - 1) / bananas; // ceil value n/bananas

            if(totalHours>h)
                return totalHours;
        }

        return totalHours;
    }

    private int getMax(int[] nums){
        int max=Integer.MIN_VALUE;
        for(int n:nums) max=Math.max(max,n);
        return max;

    }
}