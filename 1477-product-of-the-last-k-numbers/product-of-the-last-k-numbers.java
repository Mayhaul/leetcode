class ProductOfNumbers {
    public ArrayList<Integer>prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1);
    }
    
    public void add(int num) {
        if(num == 0){
            // we clear the array is num = 0 because irrespective of what k is.. the product would become 0 each time.

            prefix.clear();
            prefix.add(1);
        }else{
            int last = prefix.get(prefix.size()-1);
            prefix.add(last*num);
        }
    }
    
    public int getProduct(int k) {
        int n = prefix.size();

        // and ofc if we clear the array then it will be shorter than no of test cases entered. so whenever k is more than n we know that this happened because we cleared the array because we encountered a 0.. so we return a 0;

        if(k >= n)
            return 0;

        return prefix.get(n - 1) / prefix.get(n - k - 1);

    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */