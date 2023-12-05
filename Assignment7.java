import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Assignment7 {
    static void findSubset(int [] set, int target){
        Arrays.sort(set);
        List<Integer> possibleAnsList = new ArrayList<>();
        helper(set, target, 0, 0, possibleAnsList);
    }

    static void helper(int set[] , int target, int currentSum, int index, List<Integer> possibleAnsList){

        if(currentSum==target) {
            System.out.println(possibleAnsList);
            return;
        }

        int prevElement = -1;
        for (int i = index; i <set.length ; i++) {
            if(prevElement != set[i]) {
                if(currentSum + set[i] > target) break;
                possibleAnsList.add(set[i]);
                helper(set, target, currentSum + set[i], i + 1, possibleAnsList);
                possibleAnsList.remove(possibleAnsList.size() - 1);
                prevElement = set[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] set = {1,2,5,6,8};
        findSubset(set, 9);
    }
}
