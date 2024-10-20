# Rule Engine with Abstract Syntax Tree (AST)
Overview
This project implements a simple 3-tier rule engine that determines user eligibility based on attributes like age, department, salary, experience, etc. It uses an Abstract Syntax Tree (AST) to represent conditional rules and allows for dynamic creation, combination, and modification of rules.


<img width="1398" alt="Screenshot 2024-10-20 at 12 02 06 PM" src="https://github.com/user-attachments/assets/3a4a0b38-539b-4fbf-bedf-67be066e88b6">
<img width="1398" alt="Screenshot 2024-10-20 at 12 01 30 PM" src="https://github.com/user-attachments/assets/e38a6fb2-5a56-4f03-a580-7b443ecb45fe">
<img width="1398" alt="Screenshot 2024-10-20 at 11 59 53 AM" src="https://github.com/user-attachments/assets/33e203d8-2d66-44a0-8849-e141c6e0c65d">
<img width="1398" alt="Screenshot 2024-10-20 at 11 58 30 AM" src="https://github.com/user-attachments/assets/64c4df0d-93b4-40e6-be72-a97d1679f91d">
<img width="1398" alt="Screenshot 2024-10-20 at 11 52 20 AM" src="https://github.com/user-attachments/assets/764b8243-4d13-404f-95bf-be996ecb8ced">
<img width="1440" alt="Screenshot 2024-10-20 at 12 08 36 PM" src="https://github.com/user-attachments/assets/ca48ffa0-ec86-4616-9a2e-aa30e0034cc6">
# Objective
Parse rules from strings into an AST structure.
Store the rules and AST nodes in a relational database.
Evaluate user data against these rules to determine eligibility.
# Features
Dynamic Rule Parsing: Converts rule strings into ASTs for flexibility in rule evaluation.
Rule Combination: Combines multiple rules into a single AST using efficient strategies.
Real-Time Evaluation: Evaluates rules against user data to provide eligibility results.
Error Handling: Detects and handles invalid rule strings or data formats.
Modifiable Rules: Supports modifying existing rules, changing conditions, and combining logic.
Extensible: Built with a modular design to accommodate future enhancements like user-defined functions.
Technologies Used
Java for backend logic and AST representation.
Spring Boot for API development.
PostgreSQL as the relational database for storing rules and metadata.
React for building a simple UI.
Maven for dependency management.
# Architecture
Backend: Handles rule parsing, AST creation, and evaluation logic using Java and Spring Boot.
Database: PostgreSQL stores rule definitions and AST nodes for persistence.
API Layer: Exposes endpoints to create, combine, and evaluate rules.
Frontend: A simple React dashboard to interact with the rule engine (e.g., creating rules, viewing evaluations).
Setup Instructions
# Prerequisites
Java 23
Maven
PostgreSQL
Node.js (for the React frontend)
