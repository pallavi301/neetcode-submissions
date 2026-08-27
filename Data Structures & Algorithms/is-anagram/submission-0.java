class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        //convert both strings into character array and sort them 
        char[] sArr= s.toCharArray();
        char[] tArr= t.toCharArray();

        //if they are anagrams sorted arrays will be identical
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
        /*return Arrays.equals(Arrays.sort(sArr),  Arrays.sort(tArr));
        You are trying to pass the "result" of Arrays.sort(...) into Arrays.equals(...), but since Arrays.sort returns nothing (void), Java gives the error: 'void' type not allowed here.
        public static void sort(char[] a) // Notice 'void'

        */
        
    }
}
