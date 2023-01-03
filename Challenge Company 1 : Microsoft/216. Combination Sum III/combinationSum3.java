//Solution 1
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList();
        combinations(1, k, n, new LinkedList(), result);
        return result;
    }

    private void combinations(int start, int k, int n, LinkedList ll, List<List<Integer>> result){
        if(k < 0 || n < 0) return;

        if(k == 0 && n == 0){
            result.add(new ArrayList(ll));
            return;
        }

        for(int i = start; i <= 9; i++){
            ll.add(i);
            combinations(i+1, k-1, n-i, ll, result);
            ll.removeLast();//BACKTRACK
        }
    }
}

//Solution 2
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        Set<List<Integer>>  set = new HashSet<>();
        combinationSum3Helper(set, k, n, new HashSet<>());
        return new ArrayList<>(set);
    }

    private void combinationSum3Helper(Set<List<Integer>> ans, int noOfElements, int remainingSum, Set<Integer> runningSet) {
        if(noOfElements ==0){
            if(remainingSum==0){
                ans.add(new ArrayList<>(runningSet));
                return ;
            } else {
                return ;
            }
        }

        if(remainingSum<0){
            return ;
        }

        for(int i=1;i<=9;i++) {
            if(!runningSet.contains(i)){
                runningSet.add(i);
                combinationSum3Helper(ans,noOfElements-1, remainingSum- i, runningSet);
                runningSet.remove(i);
            }
        }
    }
}

//Solution 3
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        Set<List<Integer>>  set = new HashSet<>();
        combinationSum3Helper(set, k, n, new HashSet<>(), 1);
        return new ArrayList<>(set);
    }

    private void combinationSum3Helper(Set<List<Integer>> ans, int noOfElements, int remainingSum, Set<Integer> runningSet, int startVal) {
        if(noOfElements ==0){
            if(remainingSum==0){
                ans.add(new ArrayList<>(runningSet));
                return ;
            } else {
                return ;
            }
        }

        if(remainingSum<0){
            return ;
        }

        for(int i=startVal;i<=9;i++) {
            runningSet.add(i);
            combinationSum3Helper(ans,noOfElements-1, remainingSum- i, runningSet, i+1);
            runningSet.remove(i);

        }
    }
}
