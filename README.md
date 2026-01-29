# Jenkins Shared Library

This repository contains a **Jenkins Shared Library** that provides reusable pipeline functions to standardize and simplify CI/CD workflows for Java-based applications.

---

## 📌 Purpose

- Reduce duplicated Jenkinsfile code
- Enforce CI/CD best practices
- Improve pipeline readability and maintainability
- Enable reusable and scalable Jenkins pipelines

---

## 📁 Repository Structure

```text
.
├── vars/
│   ├── buildTestJavaApp.groovy
│   ├── buildDockerImage.groovy
│   └── pushDockerImage.groovy
├── src/
│   └── (optional helper classes)
└── README.md
