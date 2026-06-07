class Solution {
    public int findKthLargest(int[] nums, int k) {
        //will take minHeap since asked for kth largest
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        //loop through array poll largest and then peek secondlargest
        // 
        for(int num : nums) {
            maxHeap.offer(num);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
