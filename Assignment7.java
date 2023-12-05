import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Assignment7 {
    static void findSubset(int[] set,int target){
        Arrays.sort(set);
        List<Integer> possibleAns = new ArrayList<>();
        helper(set,target,0,0,possibleAns);
    }

    static void helper(int[] set,int target,int index,int currentSum,List<Integer> possibleAns){
        if(currentSum == target){
            System.out.println(possibleAns);
            return;
        }
        int prevElement = -1;

        for(int i=index;i<set.length;i++){
            if(prevElement != set[i]){
                if(set[i] + currentSum > target) break;
                possibleAns.add(set[i]);
                prevElement = set[i];
                helper(set, target, index+1, currentSum + set[i], possibleAns);
                possibleAns.remove(possibleAns.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] set = {1,2,5,6,8};
        findSubset(set, 9);
    }
}
