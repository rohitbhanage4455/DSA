class Solution {  void solve(int[] candidates, int target, int idx, List<List<Integer>> ans, List<Integer> output, int count, int k){
        if(count > k){
            return;
        }
        if(count == k && target ==0){
            ans.add(new ArrayList(output));
            return;
        }
        if(idx >= candidates.length){
            return;
        }
        if(target < 0){
            return;
        }

        output.add(candidates[idx]);
        solve(candidates, target - candidates[idx], idx +1, ans, output, count +1, k);

        output.remove(output.size()-1);
        while(idx +1 < candidates.length && candidates[idx] == candidates[idx +1]){
            idx ++;
        }

        solve(candidates, target, idx +1, ans, output, count, k);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = {1,2,3,4,5,6,7,8,9};
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int idx = 0;
        int target = n;
        int count = 0;

        solve(candidates, target, idx, ans, output, count, k);
        return ans;
    }
}