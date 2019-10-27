import Part3Object.Part3ServerObject;

import static org.junit.jupiter.api.Assertions.*;


class Part3ServerObjectTest {
    @org.junit.jupiter.api.Test
    void testUpperCase() {
        assertEquals("HELLO", Part3ServerObject.upperCase("hello"));
    }

    @org.junit.jupiter.api.Test
    void testUpperCaseMultipleWords() {
        assertEquals("HELLO WORLD", Part3ServerObject.upperCase("hello world"));
    }


    @org.junit.jupiter.api.Test
    void testUpperCaseNonCharacters() {
        assertEquals("!?.,<>12345\"\\/", Part3ServerObject.upperCase("!?.,<>12345\"\\/"));
    }

    @org.junit.jupiter.api.Test
    void testDoubleInt() {
        assertEquals(4, Part3ServerObject.doubleInt(2));
    }

    @org.junit.jupiter.api.Test
    void testDoubleIntZero() {
        assertEquals(0, Part3ServerObject.doubleInt(0));
    }

    @org.junit.jupiter.api.Test
    void testDoubleNegative() {
        assertEquals(-4, Part3ServerObject.doubleInt(-2));
    }

    @org.junit.jupiter.api.Test
    void testSquareInt() {
        assertEquals(4, Part3ServerObject.squareInt(2));
    }

    @org.junit.jupiter.api.Test
    void testSquareIntZero() {
        assertEquals(0, Part3ServerObject.squareInt(0));
    }

    @org.junit.jupiter.api.Test
    void testSquareIntNegative() {
        assertEquals(4, Part3ServerObject.squareInt(-2));
    }

    @org.junit.jupiter.api.Test
    void testGetFirstName() {
        assertEquals("John", Part3ServerObject.getFirstName("John", "Doe"));
    }
}