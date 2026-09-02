class Solution {
    public int countPairs(List<Integer> nums, int target) {

        Collections.sort(nums);

        int count = 0;

        for (int i = 0; i < nums.size(); i++) {

            int j = i + 1;

            while (j < nums.size()) {

                int sum = nums.get(i) + nums.get(j);

                if (sum < target) {
                    count++;
                    j++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}