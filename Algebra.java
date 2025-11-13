// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
        int iterations = 0;
        int value =  x1;
        while (iterations < x2){
            value ++;
            iterations ++;
        }

		return value;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
        int iterations = 0;
        int value = x1;
        while (iterations < Math.abs(x2)){
            if (x2 > 0) {
                value--;
            } else {
                value++;
            }
            iterations++;
        }
		return value;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
        if (x2 == 0) return 0;
        int iterations = 0;
        int value = 0;
        boolean negative = (x1 < 0) ^ (x2 < 0);
        int absX1 = Math.abs(x1);
        int absX2 = Math.abs(x2);
        
        while (iterations < absX2){
            value = plus(value, absX1);
            iterations++;
        }
        return negative ? minus(0, value) : value;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
        if (n == 0){
            return 1;
        }
        int iterations = 0;
        int value = 1;
        while (iterations < n){
            value = times(value, x);
            iterations++;
        }
        return value;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
        if (x2 == 0) return 0; // Handle division by zero
        int iterations = 0;
        boolean negative = (x1 < 0) ^ (x2 < 0);
        int absX1 = Math.abs(x1);
        int absX2 = Math.abs(x2);
        int value = 0;
        
        while (plus(value, absX2) <= absX1){
            value = plus(value, absX2);
            iterations++;
        }
		return negative ? minus(0, iterations) : iterations;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
        if (x2 == 0) return 0; // Handle modulo by zero
        int divResult = div(x1, x2);
        int product = times(divResult, x2);
        return minus(x1, product);
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        
        int g = div(x, 2);
        int prevG = 0;
        
        while (g != prevG) {
            prevG = g;
            g = div(plus(g, div(x, g)), 2);
        }
        
        // Ensure we return the floor of the square root
        while (times(g, g) > x) {
            g = minus(g, 1);
        }
        
        return g;
	}	  	  
}