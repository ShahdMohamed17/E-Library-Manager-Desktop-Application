# E‑Library Manager (Desktop Application)

## Table of Contents

* [About](#about)
* [Features](#features)
* [Technologies & Architecture](#technologies--architecture)
* [Getting Started](#getting-started)

  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
  * [Running the Application](#running-the-application)
* [Usage](#usage)
* [Contributing](#contributing)
* [Contact](#contact)

---

## About

E‑Library Manager is a desktop application for managing library operations: books, users (students, teachers, etc.), borrowing/returning, search, reporting, and related features. It is aimed to simplify the workflow of small to medium-sized libraries and provide a user-friendly interface for non‑technical users.

---

## Features

* Add, update, delete books
* Manage library users (members)
* Borrow and return books
* Search for books (by title, author, category, etc.)
* Generate reports (e.g. overdue, borrowed books)
* Simple and intuitive GUI interface
* Data persistence with a database

---

## Technologies & Architecture

* **Programming Language:** Java
* **GUI Framework:** JavaFX
* **Database / Storage:** (e.g. SQLite/MySQL or file-based, depending on your implementation)
* **Architecture Pattern:** MVC (Model‑View‑Controller)

---

## Getting Started

### Prerequisites

Before you begin, ensure you have:

* Java JDK (version 11 or above)
* SQLite/MySQL installed and configured

### Installation

1. Clone this repository:

   ```bash
   git clone https://github.com/E-Library-Manager/E-Library-Manager-Desktop-Application.git
   cd E-Library-Manager-Desktop-Application
   ```

2. Configure database connection:

   * Update `src\models\Database.java` file with database credentials.


### Running the Application

```
run the main class directly from your IDE (e.g. `com.example.library.MainApp`).
```
---

### Usage

1. Launch the application.
2. Login with your account or register a new user.
3. Use the GUI menus to:

   * Add, update, or delete books
   * Manage library users
   * Borrow and return books
   * Search the catalog
   * Generate reports

---

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/YourFeature`)
3. Commit your changes (`git commit -m "Add feature"`)
4. Push your branch (`git push origin feature/YourFeature`)
5. Open a Pull Request

---

## Contact

**Author:** Shahd
**GitHub:** [ShahdMohamed17](https://github.com/ShahdMohamed17)
**Email:** [shahdmohamed172005@gmail.com](mailto:shahdmohamed172005@gmail.com)

---

> *This README is a template. Update technologies, configuration details, and screenshots according to your actual project implementation.*
