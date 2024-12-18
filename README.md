
# GameOfGames

A comprehensive Java-based game application featuring both Player and Test modes, designed to provide an engaging gaming experience while maintaining robust testing capabilities.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
## Overview

GameOfGames is an interactive Java application that combines entertainment with development flexibility. The dual-mode system allows players to enjoy the game while providing developers with comprehensive testing capabilities. Built with modern Java practices, the application supports both command-line and IDE-based execution.

## Features

### Player Mode


### Test Mode



## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/GameOfGames.git
   cd GameOfGames
   ```

2. Verify your Java installation:
   ```bash
   java -version
   ```

## Running the Program

### Option 1: Terminal Execution

1. **Navigate to Game Mode**
   ```bash
   cd PlayerMode    # For Player Mode
   # OR
   cd TestMode     # For Test Mode
   ```

2. **Compile the Code**
   ```bash
   javac *.java
   ```

3. **Launch the Game**
   ```bash
   java PlayGames
   ```

### Option 2: IDE Execution

1. **Project Setup**
   - Open your IDE
   - Select `File > Open Project`
   - Navigate to and select the GameOfGames directory
   - Choose desired mode folder (PlayerMode/TestMode)

2. **Configuration**
   - Configure JDK in `File > Project Structure > SDK`
   - Verify source directories are marked correctly
   - Ensure all dependencies are resolved

3. **Execution**
   - Locate `PlayGames.java`
   - Right-click and select `Run 'PlayGames.main()'`


## Troubleshooting

### Common Issues

| Issue | Solution |
|-------|----------|
| "Java not recognized" | Add Java to system PATH |
| "Main class not found" | Verify PlayGames.java location |
| Build failures | Check for missing source files |
| Runtime errors | Verify JDK version compatibility |



