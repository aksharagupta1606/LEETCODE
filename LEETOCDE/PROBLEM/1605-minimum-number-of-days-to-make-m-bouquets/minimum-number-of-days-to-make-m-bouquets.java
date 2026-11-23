class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low=0;
        int high=0;
        int ans=-1;
        for(int val:bloomDay){
            low=Math.min(low,val);
            high=Math.max(high,val);
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(bloomDay,m,k,mid)){
                ans=mid;
                high=mid-1;
            } else{
                low=mid+1;
            }
        }
        return ans; 
    }
    public boolean isPossible(int[] nums,int m,int k,int mid){
        int count=0;
        int bq=0;
        for(int val:nums){
            if(val<=mid){
                count++;
            }else{
                bq+=count/k;
                count=0;
            }

        }
        bq+=count/k;
        return bq>=m;
    }
}