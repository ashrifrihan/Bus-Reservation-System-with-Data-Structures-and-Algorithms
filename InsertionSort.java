import java.util.List;

public class InsertionSort {
    
    public static void insertionSort(List<Customer> customers) {
        int numberOfCustomer = customers.size();
        for (int i=1; i<numberOfCustomer; i++) {
            Customer key = customers.get(i);
            int j = i-1;
            while (j>=0 && customers.get(j).getAge() > key.getAge()) {
                customers.set(j+1, customers.get(j));
                j--;
            }
            customers.set(j+1, key);
        }
    }
    
}
