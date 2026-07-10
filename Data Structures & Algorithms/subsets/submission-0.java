class Solution {
    public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> subs = new ArrayList<>();
        subsetsHelper(0, nums, ans, subs);
		return ans;
    }
	public void subsetsHelper(int index, int[] nums, List<List<Integer>> ans, List<Integer> subs) {
		
	//base case
		if(index >= nums.length) {
			ans.add(new ArrayList<>(subs));
			return;
	}
	//recursion call to add
		subs.add(nums[index]);
		subsetsHelper(index+1, nums, ans, subs);
	//recursion call to remove
		subs.remove(subs.size()-1);
		subsetsHelper(index+1, nums, ans, subs);

	}
}

