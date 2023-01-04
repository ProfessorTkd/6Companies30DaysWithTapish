//Solution 1
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length,max = 0,prev = 0,idx=0;
        int dp[] = new int[n];
        
        Arrays.sort(nums);
        
        for(int i = 0;i<nums.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if((nums[i] % nums[j] == 0) && (dp[j] >= dp[i])){
                    dp[i] = dp[j] + 1;
                }
            }
            if(dp[i] > max){
                max = dp[i];
                prev = nums[i];
                idx = i;
            }
        }
        
        for(int i = idx;i>=0;i--){
            if(max == 0)break;
            if(dp[i] == max && prev % nums[i] == 0){
                res.add(nums[i]);
                prev = nums[i];
                max--;
            }
        }
        
        return res;
    }
}


//Solution 2
class Solution {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		int[] dp = new int[nums.length];
		return constructLDS(nums, dp, getLDSSize(nums, dp));
	}

	private int getLDSSize(int[] nums, int[] dp) {
		Arrays.sort(nums);
		Arrays.fill(dp, 1);
		int ldsSize = 1;

		for (int i = 1; i < nums.length; i++)
			for (int j = 0; j < i; j++)
				if (nums[i] % nums[j] == 0) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					ldsSize = Math.max(ldsSize, dp[i]);
				}

		return ldsSize;
	}

	private List<Integer> constructLDS(int[] nums, int[] dp, int ldsSize) {
		int prev = -1;
		LinkedList<Integer> lds = new LinkedList<Integer>();

		for (int i = dp.length - 1; i >= 0; i--)
			if (dp[i] == ldsSize && (prev == -1 || prev % nums[i] == 0)) {
				lds.addFirst(nums[i]);
				ldsSize--;
				prev = nums[i];
			}

		return lds;
	}
}
