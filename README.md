# 🔢 Sudoku Solver in Java

A command-line **Sudoku puzzle solver** that reads unsolved puzzles from files and solves them using a classic **backtracking algorithm**. This project showcases your understanding of constraint satisfaction problems, recursive logic, file handling, and object-oriented design in Java.

---

## 🧠 Overview

Sudoku is a logic-based number-placement puzzle. This program implements a solver that fills in all empty cells (denoted by `0`) by recursively trying all valid numbers that follow Sudoku rules for rows, columns, and 3×3 subgrids.

---

## 🧩 Core Features

- ✅ Solves any **9×9 Sudoku** puzzle using backtracking
- 📁 Loads puzzles from predefined difficulty files (Easy → Very Hard)
- 🔢 Validates all Sudoku constraints (rows, columns, subgrids)
- 🖨️ Cleanly prints the solved grid to the terminal
- 🧪 Modular and extensible class structure

---

## ⚙️ Tech Stack

| Technology | Usage |
|------------|-------|
| **Java 8+** | Primary programming language |
| **OOP** | Clean, modular class design |
| **Backtracking** | Recursive search algorithm |
| **File I/O** | Loads puzzle grids from `.txt` files |

---

## 📂 Project Structure

```
SudokuSolver/
│
├── Driver.java # Main entry point of the program
├── SudokuSolver.java # Solver logic with backtracking
├── Helper.java # File input and puzzle loader
├── mode/ # Folder containing Sudoku puzzles
│ ├── easy.txt
│ ├── medium.txt
│ ├── hard.txt
│ └── very_hard.txt
```
