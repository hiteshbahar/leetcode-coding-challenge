import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();
        dfs(nums,0,new ArrayList<Integer>(),result);
        return result;
    }
    
    public void dfs(int[] nums,int index,List<Integer> path,List<List<Integer>> result){
        result.add(path);
        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]) continue;
            List<Integer> nPath= new ArrayList<>(path);
            nPath.add(nums[i]);
            dfs(nums,i+1,nPath,result);
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length <= 1) {
            return result;
        }
        
        List<Integer> subList = new ArrayList<Integer>();
        helper(result, subList, nums, 0);
        return result;
    }
    private void helper(List<List<Integer>> result, List<Integer> subList, int[] nums, int pos) {
        if (subList.size() >= 2) {
            result.add(new ArrayList<Integer>(subList));
        }
        
        for (int i = pos; i < nums.length; i++) {
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            subList.add(nums[i]);
            helper(result, subList, nums, i + 1);
            subList.remove(subList.size() - 1);
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Subsets s = new Subsets();
        int[] nums = new int[]{1, 2, 2};
        System.out.println(s.subsetsWithDup(nums));
        System.out.println(s.findSubsequences(nums));

    }

}
