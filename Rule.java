package com.example.rule_engine.model;


import jakarta.persistence.*; // JPA annotations for persistence
import java.time.LocalDateTime; // LocalDateTime for timestamps

@Entity  // Indicates that this class is a JPA entity
@Table(name = "rules")  // Maps this entity to the "rules" table in the database
public class Rule {

    @Id  // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generates a unique value
    private Long id;

    private String ruleName;  // Field to store the name of the rule

    @Column(columnDefinition = "TEXT")  // Specifies the column type as TEXT in the database
    private String ruleAst;  // Field to store the AST representation of the rule

    private LocalDateTime createdAt;  // Timestamp for when the rule was created
    private LocalDateTime updatedAt;  // Timestamp for the last time the rule was updated

    // Default constructor
    public Rule() {
        this.createdAt = LocalDateTime.now();  // Set creation time
        this.updatedAt = LocalDateTime.now();  // Set update time
    }

    // Constructor with parameters
    public Rule(String ruleName, String ruleAst) {
        this.ruleName = ruleName;
        this.ruleAst = ruleAst;
        this.createdAt = LocalDateTime.now();  // Set creation time
        this.updatedAt = LocalDateTime.now();  // Set update time
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleAst() {
        return ruleAst;
    }

    public void setRuleAst(String ruleAst) {
        this.ruleAst = ruleAst;
        this.updatedAt = LocalDateTime.now();  // Update timestamp when the AST is modified
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // Method to update the updatedAt timestamp
    public void updateTimestamp() {
        this.updatedAt = LocalDateTime.now();  // Set updatedAt to now
    }
}

