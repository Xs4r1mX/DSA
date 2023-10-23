class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==1)
        return true;
        int val=0;
        if(n>0)
        {
            double numerator=Math.log(n);
            double denominator=Math.log(4);
            val = (int)(numerator/denominator);
        }

        if(Math.pow(4,val)==n)
        return true;

        return false;
        
    }
}