/*  Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106 {
    
}*/


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        // Ensure nums1 is smaller array
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        
        int x = nums1.length;
        int y = nums2.length;
        
        int low = 0, high = x;
        
        while(low <= high)
        {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX-1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY-1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];
            
            // Correct partition
            if(maxLeftX <= minRightY && maxLeftY <= minRightX)
            {
                // even length
                if((x + y) % 2 == 0)
                {
                    return (Math.max(maxLeftX, maxLeftY) + 
                            Math.min(minRightX, minRightY)) / 2.0;
                }
                else // odd length
                {
                    return Math.max(maxLeftX, maxLeftY);
                }
            }
            else if(maxLeftX > minRightY)
            {
                high = partitionX - 1;
            }
            else
            {
                low = partitionX + 1;
            }
        }
        
        return 0.0;
    }
}
