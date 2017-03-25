import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedCollection {
    Map<Integer, Set<Integer>> randomMap;
    List<Integer> randomList;
    Set<Integer> indexSet;
    int index;
    Random generator;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        randomMap = new HashMap<Integer, Set<Integer>>();
        randomList = new ArrayList<Integer>();
        generator = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!randomMap.containsKey(val)) {
            indexSet = new LinkedHashSet<Integer>();
            indexSet.add(randomList.size());
            randomMap.put(val, indexSet);
            randomList.add(val);
            return true;
        }
        indexSet = randomMap.get(val);
        indexSet.add(randomList.size());
        randomMap.put(val, indexSet);
        randomList.add(val);
        return false;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (randomMap.containsKey(val)) {
            indexSet = randomMap.get(val);
            index = indexSet.iterator().next();
            indexSet.remove(index);
            //randomMap.put(val, indexList);
            if (index < randomList.size() - 1) {
                int last = randomList.get(randomList.size() - 1);
                randomList.set(index, last);
                Set<Integer> lastSet = randomMap.get(last);
                lastSet.remove(randomList.size() - 1);
                lastSet.add(index);             
            }
            randomList.remove(randomList.size() - 1);
            if (indexSet.isEmpty()) {
                indexSet.remove(val);
            }
            return true;
        }
        return false;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        if (randomList.size() != 0) {
            index = generator.nextInt(randomList.size());
            return randomList.get(index);
        }
        return 0;
    }


/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RandomizedCollection obj = new RandomizedCollection();
        obj.insert(9);
        obj.insert(9);
        obj.insert(1);
        obj.insert(1);
        obj.insert(2);
        obj.insert(1);
        
        obj.remove(2);
        obj.remove(1);
        obj.remove(1);
        obj.insert(9);
        obj.remove(1);
        
        //int param_3 = obj.getRandom();

    }
}

