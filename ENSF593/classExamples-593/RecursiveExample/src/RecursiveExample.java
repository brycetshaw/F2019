public class RecursiveExample {

    //Recursion: when a function calls itself.. directly or indirectly.
    // a recursive function will have:
    // 1. a base case
    // 2. a function call.
    public static int factorial (int n) {
        return (n == 0) ? 1 : n * factorial( n-1 );
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        int n =10;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++) {
                System.out.println(Integer.toString(i) + "i, j "+ Integer.toString(j));
            }
        }
    }
}
