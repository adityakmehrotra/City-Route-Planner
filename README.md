# City-Route-Planner

## Overview

This Java library provides utility functions for handling paths, including operations such as computing intersections and various manipulations of path data. It is designed to support applications requiring geometric path calculations, such as graphic editors, simulation environments, or any software dealing with graphical path manipulation.

## Components

The project includes several key Java classes:

- **`Path.java`**: Defines the structure and operations of a path.
- **`Intersection.java`**: Contains methods to determine intersections between paths.
- **`PathUtils.java`**: Provides static utility methods for path operations.
- **`PathUtilsTester.java`**: A tester class for demonstrating and validating the functionality provided by the `PathUtils` class.

## Features

- **Path Manipulation**: Efficient management and transformation of path data.
- **Intersection Detection**: Robust algorithms to find intersections between multiple paths.
- **Utility Functions**: A collection of utility functions that enhance the manipulation and operational capabilities on paths.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher.

### Installation

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/java-path-utilities.git
   cd java-path-utilities
   ```
   
2. **Compile the code**:

  Ensure that all Java files are in the same directory or properly referenced.
  ```bash
  javac Path.java Intersection.java PathUtils.java PathUtilsTester.java
  ```

4. **Run the tests**:
  To see the library in action and verify its operations:
  ```bash
  java PathUtilsTester
  ```

## Usage Example
After compiling the classes, you can use the PathUtilsTester to test various functionalities of the library. The tester class will demonstrate how to use the library methods, including creating paths, finding intersections, and utilizing other utility functions.

## Contributing
Contributions are welcome! For major changes, please open an issue first to discuss what you would like to change. Please ensure to update tests as appropriate.

### Last Updated:
04/13/2024
