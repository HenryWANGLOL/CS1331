import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
* the Merge Sort Method
* @author Yufeng Wang
* @version 1.0
* @param <T> the generic class
*/
public class MergeSort<T> {
    private List<T> items;
    private List<T> helper;
    private Comparator<T> comprtr;
    private int cnt;

    /**
    * one of the constructors that sort list
    * @param values generic array putted into the constructor
    * @param comprtr comparator implemented
    */
    public void sort(List<T> values, Comparator<T> comprtr) {
        items = values;
        cnt = values.size();
        this.helper = new ArrayList<T>(cnt);
        helper.addAll(items);
        this.comprtr = comprtr;
        mergesort(0, cnt - 1);
    }
    /**
    * split the dataset into two different parts
    * @param low the lower bound
    * @param high the higher bound
    */
    private  void mergesort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergesort(low, middle);
            mergesort(middle + 1, high);
            merge(low, middle, high);
        }
    }
    /**
    * merge the datas
    * @param low the lower bound
    * @parram middle the middle on
    * @param high the higher bound
    */
    private  void merge(int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helper.set(i, items.get(i));
        }
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            int cm = comprtr.compare(helper.get(i), helper.get(j));
            if (cm <= 0) {
                items.set(k, helper.get(i));
                i++;
            } else {
                items.set(k, helper.get(j));
                j++;
            }
            k++;
        }
        while (i <= middle) {
            items.set(k, helper.get(i));
            k++;
            i++;
        }
    }
}