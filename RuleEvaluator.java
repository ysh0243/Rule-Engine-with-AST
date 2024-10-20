package com.example.rule_engine.service;

import com.example.rule_engine.model.Rule; // Ensure the path is correct
import com.example.rule_engine.model.Node; // Import the Node class
import java.util.Map; // For storing user attributes

public class RuleEvaluator {

    // Method to evaluate the rule based on the AST
    public boolean evaluate(Rule rule, Map<String, Object> attributes) {
        // Parse the AST from the rule's ruleAst string
        Node rootNode = parseRuleToAST(rule.getRuleAst());

        // Evaluate the AST against the user attributes
        return evaluateNode(rootNode, attributes);
    }

    // Method to parse the rule string into an AST (simplified example)
    private Node parseRuleToAST(String ruleAst) {
        // Implement parsing logic here
        // This is a simplified placeholder; actual implementation depends on your rule format
        // You should return the root Node of the constructed AST
        // For demonstration, a sample AST structure is shown
        Node root = new Node("operator", "AND");
        root.setLeft(new Node("operand", "age > 30"));
        root.setRight(new Node("operand", "department = 'Sales'"));
        return root;
    }

    // Recursive method to evaluate the AST nodes
    private boolean evaluateNode(Node node, Map<String, Object> attributes) {
        if (node.getType().equals("operand")) {
            // Here you would implement the logic to evaluate the condition
            // For example, if the condition is "age > 30":
            String[] parts = node.getValue().split(" "); // Split condition parts
            String attributeName = parts[0]; // e.g., "age"
            String operator = parts[1]; // e.g., ">"
            String value = parts[2]; // e.g., "30"

            // Retrieve the attribute value from the map
            Object attributeValue = attributes.get(attributeName);
            if (attributeValue instanceof Number) {
                // Compare numeric values
                return evaluateNumericCondition((Number) attributeValue, operator, Double.parseDouble(value));
            } else if (attributeValue instanceof String) {
                // Compare string values
                return evaluateStringCondition((String) attributeValue, operator, value.replace("'", ""));
            }
        } else if (node.getType().equals("operator")) {
            // Evaluate left and right nodes based on the operator
            boolean leftResult = evaluateNode(node.getLeft(), attributes);
            boolean rightResult = evaluateNode(node.getRight(), attributes);
            return evaluateLogicalOperator(leftResult, rightResult, node.getValue());
        }

        return false; // Default case
    }

    // Helper methods for evaluations
    private boolean evaluateNumericCondition(Number attributeValue, String operator, double comparisonValue) {
        switch (operator) {
            case ">":
                return attributeValue.doubleValue() > comparisonValue;
            case "<":
                return attributeValue.doubleValue() < comparisonValue;
            case "=":
                return attributeValue.doubleValue() == comparisonValue;
            // Add more operators as needed
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private boolean evaluateStringCondition(String attributeValue, String operator, String comparisonValue) {
        switch (operator) {
            case "=":
                return attributeValue.equals(comparisonValue);
            // Add more string comparison operators as needed
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private boolean evaluateLogicalOperator(boolean leftResult, boolean rightResult, String operator) {
        switch (operator) {
            case "AND":
                return leftResult && rightResult;
            case "OR":
                return leftResult || rightResult;
            // Add more logical operators as needed
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}
