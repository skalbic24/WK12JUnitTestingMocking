package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.Test;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

public class TestDemoJUnitTest {
    
    private TestDemo testDemo; // Step 1-4: Declare instance variable

    @BeforeEach
    void setUp() {
        testDemo = new TestDemo(); // Step 1-4a: Create TestDemo object
    }
    
    @Test // Step 2-1: New test method for addPositive
    void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
        assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
        assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
        assertThat(testDemo.addPositive(1, 1)).isEqualTo(2);
        assertThat(testDemo.addPositive(10, 20)).isEqualTo(30);
    }

    @ParameterizedTest // Step 1-4b: Change to @ParameterizedTest
    @MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive") // Step 1-4k: MethodSource annotation
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) { // Step 1-4c and d
        
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected); // Step 1-4e ii
        } else {
            assertThatThrownBy(() -> testDemo.addPositive(a, b)) // Step 1-4f and g
                .isInstanceOf(IllegalArgumentException.class); // Step 1-4h
        }
    }

    // Step 1-4j: Parameter source method
    static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
            arguments(2, 4, 6, false), // Example of valid positive parameters
            arguments(1, 1, 2, false), // Another valid case
            arguments(0, 5, 0, true),  // Zero as a parameter
            arguments(-1, 5, 0, true), // Negative parameter
            arguments(5, -5, 0, true), // Negative parameter
            arguments(-1, -1, 0, true) // Both negative
        );
    }
    @Test
    void assertThatMultiplicationIsCorrect() {
        assertThat(testDemo.multiply(2, 3)).isEqualTo(6);
        assertThat(testDemo.multiply(4, 5)).isEqualTo(20);
        assertThat(testDemo.multiply(-1, 5)).isEqualTo(-5);
        assertThat(testDemo.multiply(0, 100)).isEqualTo(0);
    }

    @Test // Step 4: Test for randomNumberSquared
    void assertThatNumberSquaredIsCorrect() {
        TestDemo mockDemo = spy(testDemo); // Create a spy of testDemo
        doReturn(5).when(mockDemo).getRandomInt(); // Mock getRandomInt to return 5

        int fiveSquared = mockDemo.randomNumberSquared(); // Call the method

        assertThat(fiveSquared).isEqualTo(25); // Assert that the square is correct
    }
    
}