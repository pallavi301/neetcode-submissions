class Solution {

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {

            boolean destroyed = false;

            // Collision possible only when:
            // stack top > 0 and current asteroid < 0
            while (!stack.isEmpty() &&
                   stack.peek() > 0 &&
                   asteroid < 0) {

                // Top asteroid is smaller
                if (stack.peek() < Math.abs(asteroid)) {

                    stack.pop();
                }

                // Equal size
                else if (stack.peek() == Math.abs(asteroid)) {

                    stack.pop();
                    destroyed = true;
                    break;
                }

                // Top asteroid is bigger
                else {

                    destroyed = true;
                    break;
                }
            }

            // Push asteroid if it survives
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}