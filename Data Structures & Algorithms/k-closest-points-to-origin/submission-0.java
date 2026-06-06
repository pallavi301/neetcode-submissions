class Solution {

    public int[][] kClosest(int[][] points, int k) {

        Map<Integer, List<int[]>> map = new HashMap<>();

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        int totalPoints = 0;

        for (int[] point : points) {

            int x = point[0];
            int y = point[1];

            int distance = x * x + y * y;

            if (!map.containsKey(distance)) {
                map.put(distance, new ArrayList<>());
                maxHeap.offer(distance);
            }

            map.get(distance).add(point);
            totalPoints++;
        }

        while (totalPoints > k) {

            int dist = maxHeap.poll();

            List<int[]> list = map.get(dist);

            if (totalPoints - list.size() >= k) {

                totalPoints -= list.size();
                map.remove(dist);

            } else {

                int removeCount = totalPoints - k;

                while (removeCount > 0) {
                    list.remove(list.size() - 1);
                    removeCount--;
                    totalPoints--;
                }

                break;
            }
        }

        int[][] result = new int[k][2];

        int index = 0;

        for (List<int[]> list : map.values()) {

            for (int[] point : list) {

                if (index == k) {
                    break;
                }

                result[index++] = point;
            }
        }

        return result;
    }
}
