package goldmansachs;

import java.util.*;

public class AverageScores {
    public static void main(String[] args) {

        List<List<String>> studentScore = new ArrayList<>();
        studentScore.add(Arrays.asList("A", "87"));
        studentScore.add(Arrays.asList("B", "60"));
        studentScore.add(Arrays.asList("C", "22"));
        studentScore.add(Arrays.asList("C", "100"));
        System.out.println(findHighestAverage(studentScore));
    }

    /**
     * Find the highest average score from a list of students
     * @param studentScore: a list of list with student id and their scores
     * @return maximum average score
     */
    public static int findHighestAverage(List<List<String>> studentScore) {
        if (studentScore == null || studentScore.size() == 0) {
            return 0;
        }
        Map<String, List<Integer>> map = new HashMap<>();
        for (List<String> curr : studentScore) {
            String id = curr.get(0);
            if (!map.containsKey(id)) {
                map.put(id, new ArrayList<>(Arrays.asList(0,0)));
            }
            List<Integer> prev = map.get(id);
            int count = prev.get(0) + 1;
            int scoreSum = prev.get(1) + Integer.valueOf(curr.get(1));
            map.put(id, Arrays.asList(count, scoreSum));
        }
        // get the average score
        int max = 0;
        for (String id : map.keySet()) {
            List<Integer> score = map.get(id);
            int avg = score.get(1) / score.get(0);
            max = Math.max(max, avg);
        }
        return max;
    }
}
