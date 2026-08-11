class Solution {
    public int openLock(String[] deadends, String target) {
        /* Pattern Recognition
        1) Asks about number or words
        2) Each Digit or Character can be changed.
        3) You have to reach a target number/word in minimum moves.
        4) List of words/number allowed/denied.
        5) Why BFS? When asked for shortest path i.e minimum number of steps (nodes) 
           because we can travel only one length at a time, so consider all nodes 
           a new level which is at 1 difference to the previous one.
         */
        
        // Create a set to store deadends and visited states
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        
        // Edge Case: If starting state is a deadend, we cannot proceed
        if (!isValidCell("0000", visited)) {
            return -1;
        }
        
        // BFS traversal
        return bfs("0000", visited, target);
    }
    
    private boolean isValidCell(String state, Set<String> visited) {
        return !visited.contains(state);
    }
    
    private int bfs(String start, Set<String> visited, String target) {
        Queue<String> q = new LinkedList<>();
        q.add(start);
        visited.add(start); // Mark start state as visited
        
        int turns = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                
                // If we reach the target, return the number of turns
                if (curr.equals(target)) {
                    return turns; 
                }
                
                // Convert string to character array since String is immutable
                char[] arr = curr.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char original = arr[j];
                    
                    // Option 1: Turn wheel j up (+1)
                    arr[j] = (original == '9') ? '0' : (char) (original + 1);
                    String neighborUp = new String(arr);
                    if (isValidCell(neighborUp, visited)) {
                        visited.add(neighborUp);
                        q.add(neighborUp);
                    }
                    
                    // Option 2: Turn wheel j down (-1)
                    arr[j] = (original == '0') ? '9' : (char) (original - 1);
                    String neighborDown = new String(arr);
                    if (isValidCell(neighborDown, visited)) {
                        visited.add(neighborDown);
                        q.add(neighborDown);
                    }
                    
                    // Restore the original character to test other wheels
                    arr[j] = original;
                }
            }
            // Increment the turn counter after exploring the entire current level
            turns++;
        }
        return -1;
    }
}