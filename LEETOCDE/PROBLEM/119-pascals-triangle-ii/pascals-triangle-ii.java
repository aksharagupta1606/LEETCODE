class Solution {
    public List<Integer> getRow(int rowIndex) {
        int n = rowIndex;
        List<Integer> row = new ArrayList <>();
        row.add(1);    
        long ans =1;
        for(int i = 1; i <= n; i++){
            ans = ans * (n - i + 1);
            ans = ans/i;
            row.add((int) ans);
        }   
    return row;
    }
}