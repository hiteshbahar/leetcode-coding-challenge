
public class VMware {
    public long subarraySum(int[] arr) {
        long result = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            for (int j = 0; j < arr.length - i; j++) {
                temp += arr[i + j];
                result += temp;
            }
        }
        return result;
    }
    public long subarraySum2(int[] arr) {
        long result = 0;
        
        for (int i = 0; i < arr.length; i++) {
            result += (arr.length - i ) * (i + 1) * arr[i];
        }
        return result;
    }
    public int buddleShop(int[] numNotebook, int[] buddleCost, int budget) {
        int numShop = numNotebook.length;
        int[] dp = new int[budget + 1];
        
        
        for (int i = 0; i < numShop; i++) {     
            for (int j = buddleCost[i]; j <= budget; j++) {
                dp[j] = Math.max(dp[j], dp[j - buddleCost[i]] + numNotebook[i]);
            }
        }
//        for (int i = 0; i <= numShop; i++) {
//            for (int j = 0; j <= budget; j++) {
//                System.out.print(dp[j] + "\t");
//            }
//            System.out.println();
//        }
        return dp[budget];
    }
    public static void main(String[] args) {
        VMware vm = new VMware();
        int[] arr = new int[] {1, 2, 3};
        System.out.println(vm.subarraySum(arr));
        System.out.println(vm.subarraySum2(arr));
        
        int[] numNotebook = new int[] {6, 5, 10, 2, 16, 8};
        int[] buddleCost = new int[] {3, 2, 5, 1, 6, 4};
        int budget = 10;
        System.out.println(vm.buddleShop(numNotebook, buddleCost, budget));
    }
}
