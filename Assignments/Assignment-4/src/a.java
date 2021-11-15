import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class a {
    public int[] twoSUm( int[]nums, int target){
        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            if(list.contains(Math.atarget - nums[i])){
                return new int[]{i,list.indexOf(target-nums[i])};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        a a = new a();
        System.out.println(a.twoSUm(new int[]{3,2,4}, 9)[0] + " " + a.twoSUm(new int[]{2,7,11,15}, 9)[1]);
    }
}
