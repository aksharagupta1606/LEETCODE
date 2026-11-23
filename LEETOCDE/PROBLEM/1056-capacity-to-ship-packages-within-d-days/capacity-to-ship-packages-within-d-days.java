class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int val:weights){
            low=Math.max(low,val);
            high+=val;
        }
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(weights,days,mid)){
                ans=mid;
                high=mid-1;
            } else{
                low=mid+1;
            }
        }
        return ans; 
    }
    public boolean isPossible(int[] nums,int d,int mid){
        int count=1;
        int sum=0;
        for(int val:nums){
            if(sum+val>mid){
                count++;
                sum=val;
            }else{
                sum+=val;
            }

        }
        return count<=d;
    }
}