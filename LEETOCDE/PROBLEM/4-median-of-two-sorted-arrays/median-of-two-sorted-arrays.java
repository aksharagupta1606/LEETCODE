// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int n1=nums1.length;
//         int n2=nums2.length;
//         int[] ans=new int[n1+n2];
//         int i=0;
//         int j=0;
//         int k=0;
//         while(i<n1 && j<n2){
//             if(nums1[i]<nums2[j]){
//                 ans[k]=nums1[i];
//                 i++;
//                 k++;
//             }else{
//                 ans[k]=nums2[j];
//                 k++;
//                 j++;
//             }
//         }while(i<n1){
//             ans[k]=nums1[i];
//             i++;
//             k++;
//         }while(j<n2){
//             ans[k]=nums2[j];
//             k++;
//             j++;
//         }
//         int n=n1+n2;
//         if(n%2==1){
//             return (double) ans[n/2];
//         }
//         return (double) (ans[n/2]+ans[n/2-1])/2.0;
//     }
// }

//optimized solution
class Solution{
    public double findMedianSortedArrays(int [] nums1, int[] nums2){
    int n1= nums1.length;
    int n2= nums2.length;

    int n=n1+n2;
    int ind2 = n/2;
    int ind1 = ind2 -1;
    int cnt = 0;
    int ind1el = -1, ind2el=-1;

    int i=0;
    int j=0;
    while(i<n1 && j<n2){
        if (nums1[i] < nums2[j]){
            if(cnt == ind1) ind1el = nums1[i];
            if(cnt == ind2) ind2el = nums1[i];
            cnt++;
            i++;

        }
        else{
            if(cnt == ind1) ind1el = nums2[j];
            if(cnt == ind2) ind2el = nums2[j];
            cnt++;
            j++;   
        }

    }
    while(i<n1){
        if(cnt == ind1) ind1el = nums1[i];
        if(cnt == ind2) ind2el =nums1[i];
        cnt++;
        i++;
    }
    while(j<n2){
        if(cnt == ind1) ind1el = nums2[j];
        if(cnt == ind2) ind2el = nums2[j];
        cnt++;
        j++;

    }
    if(n%2==1){
        return (double)ind2el;
    }
    return (double)((double)(ind1el + ind2el)) / 2.0;
   
    }
}