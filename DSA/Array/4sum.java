class Solution{
  public List<List<Integer>> fourSum(int[] nums, int target) {
  int n = nums.length;
  // sorting
  Arrays.sort(nums);
  // fourSum
  List<List<Integer>> result = new ArrayList<>();
/*  for (int i = 0; i < n; ++i) {
  if (i > 0 && nums[i - 1] == nums[i]) continue;                           //alternate
    threeSum(nums, i + 1, n - 1, target - nums[i], result);
  }
  return result;
*/
        
  for (int i = 0; i < n; ++i) {
  if (i==0|| i > 0 && nums[i - 1] != nums[i]) {
    threeSum(nums, i + 1, n - 1, target - nums[i], result);
  }
  }
  return result;
  
      
      
  }
  
private void threeSum(int[] nums, int lo, int hi, int target, List<List<Integer>> result) {
   for(int i=lo;i<=hi;++i){
       if(i==lo||(i>lo && nums[i]!=nums[i-1])){
           int low=i+1;
           int high=hi; //hi=nums.length-1
           int sum=target-nums[i];
           while(low<high){
               if(nums[low]+nums[high] == sum){
                   result.add(Arrays.asList(nums[lo-1],nums[i],nums[low],nums[high]));
                   while(low<high && nums[low] == nums[low+1]) low++;
                    while(low<high && nums[high] == nums[high-1]) high--;
                   low++;
                   high--;
               }
               else if(nums[low]+nums[high]>sum){
                   high--;
               }
               else{
                   low++;
               }
           }
           
       }
        }
   }
}
/*
class Solution{
  public List<List<Integer>> fourSum(int[] nums, int target) {
  int n = nums.length;
 Arrays.sort(nums); // sorting
  // fourSum
  List<List<Integer>> result = new ArrayList<>();
  for (int i = 0; i < n; ++i) {
    if (i > 0 && nums[i - 1] == nums[i]) continue;
    threeSum(nums, i + 1, n - 1, target - nums[i], result);
  }
  return result;
}
private void threeSum(int[] nums, int lo, int hi, int target, List<List<Integer>> result) {
  int n = nums.length;
  int subLen = hi - lo + 1;
  for (int i = lo; i <= hi; ++i) {
    if (i > lo && nums[i] == nums[i - 1]) continue;  // skip same result
    // two pointers
    int j = i + 1, k = hi;
    int t = target - nums[i];
    while (j < k) { // each element is only used once
      if (nums[j] + nums[k] < t) {
        ++j;
      } else if (nums[j] + nums[k] > t) {
        --k;
      } else { // equal
        result.add(Arrays.asList(nums[lo - 1], nums[i], nums[j], nums[k]));
        ++j;
        --k;
        while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
        while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
      }
    }
  }
}

}
*/
