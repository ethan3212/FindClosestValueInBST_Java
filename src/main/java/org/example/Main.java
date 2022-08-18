package org.example;

public class Main {
    public static void main(String[] args) {
        var root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);
        int targetValue = 12;
        System.out.println(findClosestValueInBSTIterative(root, targetValue));
        System.out.println(findClosestValueInBSTRecursive(root, targetValue));
    }

    // WORST: O(n) time | O(1) space
    // AVERAGE: O(log(n)) time | O(1) space
    public static int findClosestValueInBSTIterative(BST rootNode, int targetValue) {
        int closestValueFound = rootNode.value;
        BST currentNode = rootNode;
        while(currentNode != null) {        // O(n) time
            if(Math.abs(targetValue - currentNode.value) < Math.abs(targetValue - closestValueFound)) {
                closestValueFound = currentNode.value;
            } if(currentNode.value < targetValue) {
                currentNode = currentNode.right;
            } else if(currentNode.value > targetValue) {
                currentNode = currentNode.left;
            } else {
                break;
            }
        }
        return closestValueFound;
    }

    // WORST: O(n) time | O(n) space
    // AVERAGE: O(log(n)) time | O(log(n)) space
    public static int findClosestValueInBSTRecursive(BST rootNode, int targetValue) {
        return helperMethod(rootNode, targetValue, rootNode.value);
    }

    // WORST: O(n) time | O(n) space
    // AVERAGE: O(log(n)) time | O(log(n)) space
    public static int helperMethod(BST currentNode, int targetValue, int closestValueFound) {
        if(Math.abs(targetValue - closestValueFound) > Math.abs(targetValue - currentNode.value)) {
            closestValueFound = currentNode.value;
        }
        if(targetValue < currentNode.value && currentNode.left != null) {
            return helperMethod(currentNode.left, targetValue, closestValueFound);
        } else if(targetValue > currentNode.value && currentNode.right != null) {
            return helperMethod(currentNode.right, targetValue, closestValueFound);
        } else {
            return closestValueFound;
        }
    }
}