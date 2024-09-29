import java.util.List;

public class SelectionSort {
    
    public static void selectionSort(List<Customer>customers){
        int n = customers.size();
        for (int i = 0; i<n-1;i++){
            int minIndex = i;
            for (int j = i +1; j <n; j++){
                if (customers.get(j).getAge()<customers.get(minIndex).getAge()){
                    minIndex = j;
                }
            }
            // swap customers [minIndex] with customers[i]
            Customer temp = customers.get(minIndex);
            customers.set(minIndex, customers.get(i));
            customers.set(i, temp);
        }
    }

}
