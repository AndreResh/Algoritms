package alg.dataStructure2;

import java.util.ArrayList;
import java.util.List;

public class ThirdDay {
    public static void main(String[] args) {

    }
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list =new ArrayList<>();
        List<Integer> last = List.of(1);
        list.add(last);
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            for (int j = 1; j < last.size(); j++) {
                newList.add(last.get(j)+last.get(j-1));
            }
            newList.add(1);
            list.add(newList);
            last = newList;
        }
        return list.get(list.size()-1);
    }
}
