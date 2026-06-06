class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> MaxHeap = new PriorityQueue<>(Collections.reverseOrder());
       for(int stone : stones) {
        MaxHeap.offer(stone);
       }

       while(MaxHeap.size() > 1){
        int Y = MaxHeap.poll();
        int X = MaxHeap.poll();
        if(Y != X) {
            MaxHeap.offer(Y - X);
        }
       }
            return MaxHeap.isEmpty() ? 0 : MaxHeap.peek(); 
    }
}
