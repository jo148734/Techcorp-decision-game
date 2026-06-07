# Techcorp-decision-game



TechCorp Decision Game
Overview

TechCorp Decision Game is a turn-based business management simulation developed in Java.

The player manages a technology company, hires employees, develops projects, earns revenue, and competes against an AI-controlled company. The game demonstrates object-oriented programming concepts including inheritance, polymorphism, encapsulation, interfaces, enums, exception handling, and modular software design.

This project was developed as the final coursework project for the Java Programming module.

Features
Company Management
Manage company finances
Hire employees
Monitor company performance
Track reputation and company value
Employee System

Different employee types are available:

Developer
Tester
Manager

Each employee contributes differently to project progress.

Project Management
Create and manage projects
Assign employees to projects
Track project progress
Receive rewards when projects are completed
Turn-Based Gameplay

Each turn represents a period of company activity.

During a turn:

The player selects actions.
Projects progress.
Salaries are paid.
Revenue is collected.
Random business events may occur.
Victory conditions are evaluated.
AI Competitor

The player competes against an AI-controlled company that develops projects and attempts to outperform the player.

Random Events

The game includes business events that may positively or negatively affect company performance.

Object-Oriented Concepts Demonstrated
Encapsulation

Private fields with controlled access through methods.

Inheritance

Employee serves as a base class for:

Developer
Tester
Manager
Polymorphism

Employees are handled through common abstractions while preserving specialised behaviour.

Interfaces

Interfaces are used to define common behaviour independently of implementation.

Enums

The game uses enums to represent:

ProjectStatus
GameResult
Exception Handling

Input validation is implemented using:

IllegalArgumentException
IllegalStateException
Project Structure
src
├── main
│   └── java
│       └── com.example.techcorp
│           ├── Main.java
│           ├── domain
│           ├── engine
│           ├── events
│           ├── ui
│           └── util
│
└── test
    └── java
Requirements
Java 17
Maven 3.9+
Build Instructions

Compile and run tests:

mvn clean test

Build the project:

mvn package

Run the application:

java -jar target/techcorp-decision-game-1.0-SNAPSHOT.jar
Example Gameplay
=== TECHCORP DECISION GAME ===

Turn 1

1. Work on Projects
2. Hire Employee
3. View Company Status
0. Exit

Select an option:
Learning Outcomes

This project demonstrates:

Object-Oriented Programming
Software Design Principles
Class Hierarchies
Interfaces and Abstraction
Exception Handling
Turn-Based Game Logic
Maven Project Structure
Unit Testing with JUnit

Author

Student:Junwei Ou

Course: Java Programming

Project: TechCorp Decision Game

Year: 2026
