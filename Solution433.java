
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution433 {

    public static int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0 || start.equals(end)) {
            return -1;
        }

        Set<String> bankSet = new HashSet<String>();
        for (int i = 0; i < bank.length; i++) {
            bankSet.add(bank[i]);
        }
        
        Queue<String> queue = new LinkedList<String>();
        char[] geneChar = {'A', 'C', 'G', 'T'};
        int count = 0;
        
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(end)) {
                    return count;
                }
                for (int j = 0; j < curr.length(); j++) {
                    StringBuilder sb = new StringBuilder(curr);
                    for (char c : geneChar) {
                        sb.setCharAt(j, c);
                        String word = sb.toString();
                        if (bankSet.contains(word)) {
                            bankSet.remove(word);
                            queue.offer(word);
                        }
                    }
                }
            }
            count++;
        }
        return -1;
    }
    public static void main(String[] args) {
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        int count = minMutation(start, end, bank);
        System.out.println(count);

    }

}
