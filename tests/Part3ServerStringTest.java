import Part3String.Part3ServerString;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Part3ServerStringTest {
    @org.junit.jupiter.api.Test
    void testUpperCase() {
        assertEquals("HELLO", Part3ServerString.upperCase("hello"));
    }

    @org.junit.jupiter.api.Test
    void testUpperCaseMultipleWords() {
        assertEquals("HELLO WORLD", Part3ServerString.upperCase("hello world"));
    }


    @org.junit.jupiter.api.Test
    void testUpperCaseNonCharacters() {
        assertEquals("!?.,<>12345\"\\/", Part3ServerString.upperCase("!?.,<>12345\"\\/"));
    }

    @org.junit.jupiter.api.Test
    void testDoubleInt() {
        assertEquals(4, Part3ServerString.doubleInt(2));
    }

    @org.junit.jupiter.api.Test
    void testDoubleIntZero() {
        assertEquals(0, Part3ServerString.doubleInt(0));
    }

    @org.junit.jupiter.api.Test
    void testDoubleNegative() {
        assertEquals(-4, Part3ServerString.doubleInt(-2));
    }

    @org.junit.jupiter.api.Test
    void testSquareInt() {
        assertEquals(4, Part3ServerString.squareInt(2));
    }

    @org.junit.jupiter.api.Test
    void testSquareIntZero() {
        assertEquals(0, Part3ServerString.squareInt(0));
    }

    @org.junit.jupiter.api.Test
    void testSquareIntNegative() {
        assertEquals(4, Part3ServerString.squareInt(-2));
    }

    @org.junit.jupiter.api.Test
    void testGetFirstName() {
        assertEquals("John", Part3ServerString.getFirstName("John", "Doe"));
    }
}