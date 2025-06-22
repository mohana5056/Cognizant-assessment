public class ProductSearch {
    int productId;
    String productName;
    String category;
    public ProductSearch(int id, String name, String cat) {
        this.productId = id;
        this.productName = name;
        this.category = cat;
    }
    public String toString() {
        return productId + " - " + productName + " (" + category + ")";
    }
}
public class SearchDemo {
    public static ProductSearch linearSearch(ProductSearch[] arr, String name) {
        for (ProductSearch p : arr) {
            if (p.productName.equalsIgnoreCase(name)) return p;
        }
        return null;
    }
    public static ProductSearch binarySearch(ProductSearch[] arr, String name) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = arr[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0) return arr[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }
   public static void main(String[] args) {
        ProductSearch[] items = {
            new ProductSearch(1, "Book", "Education"),
            new ProductSearch(2, "Charger", "Electronics"),
            new ProductSearch(3, "Laptop", "Computers")
        };
        Arrays.sort(items, Comparator.comparing(p -> p.productName));
        System.out.println("Linear: " + linearSearch(items, "Laptop"));
        System.out.println("Binary: " + binarySearch(items, "Laptop"));
    }
}



