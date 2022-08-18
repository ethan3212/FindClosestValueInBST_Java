package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IterativeMethodTest {
    @Test
    public void Test1() {
        var root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);
        var expected = 13;
        var actual = Main.findClosestValueInBSTIterative(root, 12);
        assertEquals(expected, actual);
    }
}