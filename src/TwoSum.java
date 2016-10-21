import java.rmi.NotBoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * 16 testcase , 10ms.
 * Created by crainax on 2016/10/20.
 */
public class TwoSum {


    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put( nums[i],i);
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int other;
            if (map.containsKey(target-num) && (other = map.get(target-num)) != i){

                return new int[]{i,other};

            }
        }
        throw new IllegalArgumentException("No such result");


    }
}
