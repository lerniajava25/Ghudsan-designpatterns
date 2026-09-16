# Design Patterns Project - Part 1: The Builder Pattern

This repository contains Java implementations of software design patterns.
Part 1 focuses on the **Builder Pattern** (Creational), which is used to construct complex, immutable objects step-by-step.

---

## 🛠️ The Problem Being Solved

Creating a `Product` object using a traditional constructor requires passing a long list of parameters in a strict sequence:
```java
Product product = new Product("id1", "SuperWidget", Category.TOOLS, 8, LocalDate.now(), LocalDate.now());
```

### Disadvantages of the old approach:
1. **Poor Readability:** It is highly difficult to determine which argument maps to which class property at a glance.
2. **Fragility:** Swapping parameters of identical data types (like the two `LocalDate` objects or multiple strings) creates silent runtime bugs that skip past compiler validation.
3. **Inflexibility:** Adding optional fields in the future forces code modifications across every single instantiation instance throughout your codebase.

---

## ✨ The Solution: The Builder Pattern

By moving the setup process into a dedicated, fluent static inner `Builder` class, objects are assembled transparently using readable method chaining:

```java
Product product = new Product.Builder()
        .id("id1")
        .name("SuperWidget")
        .category(Category.TOOLS)
        .rating(8)
        .build();
```

### Core Features Implemented:
* **Private Constructor Protection:** Direct class instantiation is locked down via a `private` constructor. The builder acts as the singular portal to manufacture a product.
* **Automatic Field Defaults:** Essential audit metrics (`createdDate` and `modifiedDate`) initialize seamlessly behind the scenes with `LocalDate.now()` if they are left out of the builder sequence.
* **Data Validation Guards:** The final `.build()` invocation validates information before object creation, throwing clean `IllegalStateException` alerts if structural fields like `id` or `name` arrive blank.

---

## 📂 Project Package Structure

The system uses standard Maven directory layouts inside the `org.example.builder` namespace:

```text
src/main/java/
└── org/
    └── example/
        └── builder/
            ├── Category.java  # Enum holding rigid classifications
            ├── Product.java   # Core domain target containing the nested static Builder
            └── Main.java      # Test harness orchestrating product creation
```

---

## 🚀 Execution

Since this is an officially structured Maven project, you can compile and run the application instantly using a single command in your terminal:

```bash
mvn clean compile exec:java -Dexec.mainClass="org.example.builder.Main"
```

### Expected Application Output
```text
--- Product Created Successfully ---
Product [id=id1, name=SuperWidget, category=TOOLS, rating=8, createdDate=2026-09-16, modifiedDate=2026-09-16]
```
## ✨ Part 2: The Decorator Pattern (Structural)

The Decorator Pattern allows you to add new functionality to an object dynamically under runtime without altering its original class structure. This implementation demonstrates wrapping a regular `Product` to dynamically calculate a price discount.

---

## 🚀 Execution Guide

Since this is an officially structured Maven project, you can compile and run each individual part instantly from your terminal:

### 1. Run Part 1: The Builder Pattern
```bash
mvn clean compile exec:java -Dexec.mainClass="org.example.builder.Main"
```

### 2. Run Part 2: The Decorator Pattern
```bash
mvn clean compile exec:java -Dexec.mainClass="org.example.decorator.Main"
```

### 🧪 3. Run All Unit Tests
To verify code coverage and structural integrity for public methods:
```bash
mvn clean test
```
Använd koden med försiktighet.🚀 Steg 2: Spara och skicka upp till din branch decorateEftersom du vet att din kod har 4 godkända tester, sparar vi denna README direkt via IntelliJ GUI:Klicka på den gröna Commit-ikonen ✔️ till vänster.Markera kryssrutan för README.md (och pom.xml om den har ändringar).Skriv ett meddelande: docs: update README with execution steps for part 1 and 2Klicka på den blåa knappen Commit.Tryck på ditt tangentbord: Ctrl + Shift + K och klicka på den blåa knappen Push!När det har laddat klart ligger din uppdaterade README uppe på din GitHub-profil under din branch decorate! Det blir supertydligt för din lärare att se. [1] (https://www.guideflow.com/tutorial/how-to-update-a-readme-file-in-github)Gick din Push till GitHub igenom utan problem? Om du går in på webbläsaren, kan du se den nya texten på GitHub-hemsidan under branchen decorate?AI-svar kan innehålla fel. Läs merGuideflowHow to update a README file in GitHub - Guideflow Tutorials12 mars 2026 — To update a README file in GitHub, you can do the following: 1. Open the repository that contains the README file 2. Click the **E...