package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	
	/**
     * Adds two positive integers.
     * @param a First integer
     * @param b Second integer
     * @return The sum of a and b
     * @throws IllegalArgumentException if either a or b is not positive
     */
	// Instance method to add two positive integers
    public int addPositive(int a, int b) {
        // Check if both parameters are positive
        if (a > 0 && b > 0) {
            return a + b; // Return the sum if both are positive
        } else {
            // Throw IllegalArgumentException if either parameter is zero or negative
            throw new IllegalArgumentException("Both parameters must be positive!");
        }
    }

    // Example usage
    public static void main(String[] args) {
        TestDemo testDemo = new TestDemo();
        
        try {
            int result = testDemo.addPositive(5, 10);
            System.out.println("Sum: " + result); // Output: Sum: 15
            
            // This will throw an exception
            testDemo.addPositive(-1, 5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Output: Both parameters must be positive!
        }
        
    }
    /**
     * Multiplies two integers and returns the result.
     * @param a First integer
     * @param b Second integer
     * @return The product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }
    
    /**
     * Returns the square of a random integer between 1 and 10.
     * @return The square of the random integer.
     */
    public int randomNumberSquared() {
        int randomInt = getRandomInt();
        return randomInt * randomInt;
    }

    int getRandomInt() { // Package visibility
        Random random = new Random();
        return random.nextInt(10) + 1; // Return a random int between 1 and 10
    }

}
