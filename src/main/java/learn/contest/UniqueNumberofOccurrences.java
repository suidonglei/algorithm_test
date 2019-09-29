package learn.contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author suidonglei
 * @title: UniqueNumberofOccurrences
 * @projectName algorithm-test
 * @description: TODO
 * @date 2019/9/2910:37
 */
public class UniqueNumberofOccurrences {

  /**
   *
   * @param arr
   * @return
   */
  public boolean uniqueOccurrences(int[] arr) {
    //check param
    if (null == arr || arr.length <= 1) return true;
    //count occurrence
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int key: arr) {
      Integer count = countMap.get(key);
      if (null == count) {
        countMap.put(key, 1);
      } else {
        countMap.put(key, ++count);
      }
    }
    Iterator iter = countMap.entrySet().iterator();
    Set<Integer> countSet = new HashSet<>();
    while (iter.hasNext()) {
      Map.Entry entry = (Map.Entry) iter.next();
      if(!countSet.add((Integer) entry.getValue())) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] array = new int[]{1,2,2,1,1,3};
    UniqueNumberofOccurrences uniqueNumberofOccurrences = new UniqueNumberofOccurrences();
    System.out.println(uniqueNumberofOccurrences.uniqueOccurrences(array));
  }
}
