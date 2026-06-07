class Solution {
    public int findKthLargest(int[] nums, int k) {
        //will take minHeap since asked for kth largest
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //loop through array poll largest and then peek secondlargest
        // 
        for(int num : nums) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
