import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Write a function to return a list of Tweet IDs in
 * sorted order that should be recommended for a certain user.
 * @author xinwang
 *
 */
public class TwitterRecommend {

    public List<Integer> getRecommendedTweets(int[][] follow, int[][]like, int userID, int threshold) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, List<Integer>> followeeMap = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < follow.length; i++) {
            if (!followeeMap.containsKey(follow[i][0])) {
                followeeMap.put(follow[i][0], new ArrayList<Integer>());
            }
            followeeMap.get(follow[i][0]).add(follow[i][1]);
        }
        List<Integer> followeeList = followeeMap.get(userID);
        Map<Integer, Integer> likeMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < like.length; i++) {
            if (followeeList.contains(like[i][0])) {
                likeMap.put(like[i][1], likeMap.getOrDefault(like[i][1], 0) + 1);
            }
        }
        for (Integer key : likeMap.keySet()) {
            int likeNum = likeMap.get(key);
            if (likeNum > threshold) {
                result.add(key);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TwitterRecommend tr = new TwitterRecommend();
        int[][] follow = {{1, 2}, {1, 3}, {2, 3}, {1, 4}};
        int[][] like = {{1, 400}, {2, 401}, {3, 402}, {4, 402}};
        int threshold = 0;
        int userID = 1;
        List<Integer> result = tr.getRecommendedTweets(follow, like, userID, threshold);
        for (int i : result) {
            System.out.println(i);
        }
    }

}
