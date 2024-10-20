package com.example.rule_engine.model;

public class Node {
    private String type;  // "operator" or "operand"
    private String value;  // Holds the value of the node
    private Node left;  // Left child
    private Node right;  // Right child

    // Constructor for operators
    public Node(String type, String value) {
        this.type = type;
        this.value = value;
    }

    // Constructor for operands
    public Node(String type) {
        this.type = type;
    }

    // Getters and setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
