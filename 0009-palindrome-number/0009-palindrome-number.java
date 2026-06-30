class Solution {
    public boolean isPalindrome(int x) {
        int New = 0;
        int duplicate = x;
        while(x > 0 ){
            int ld = x%10;
            New = (New * 10) + ld;
            x = x/10;
        }
        return duplicate == New;
    }
    public static void main(String[] args){
        Solution obj = new Solution();
        int num = 59561;
        if(obj.isPalindrome(num)){
            System.out.println("is palindtrome");
        }
        else{
            System.out.println("not");
        }
    }
}