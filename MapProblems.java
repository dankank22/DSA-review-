package problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * See the spec on the website for example behavior.
 */
public class MapProblems {

    /**
     * Returns true if any string appears at least 3 times in the given list; false otherwise.
     */
    public static boolean contains3(List<String> list) {
        Map<String, Integer> tripleStr = new HashMap<String, Integer>();
        for (int i = 0; i < list.size(); i++) {
            String word = list.get(i);
            if (tripleStr.containsKey(word)) {
                tripleStr.put(word, tripleStr.get(word)+1);
            }
            else {
                tripleStr.put(word, 1);
            }
        }
        boolean flag = false;
        for (int i : tripleStr.values()) {
            if (i >= 3) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * Returns a map containing the intersection of the two input maps.
     * A key-value pair exists in the output iff the same key-value pair exists in both input maps.
     */
    public static Map<String, Integer> intersect(Map<String, Integer> m1, Map<String, Integer> m2) {
        if (m1.isEmpty()) {
            return m1;
        }
        if (m2.isEmpty()) {
            return m2;
        }
        Map<String, Integer> intersectMap = new HashMap<>();
        for (String i : m1.keySet()) {
            if (m2.containsKey(i)) {
                if (m2.get(i).equals(m1.get(i))) {
                    intersectMap.put(i, m1.get(i));
                }
            }
        }
        return intersectMap;
    }
}
