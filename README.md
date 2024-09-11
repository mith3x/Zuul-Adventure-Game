# Project Title: Text-Based Adventure Game

## Overview

This repository contains a text-based adventure game implemented in Java. The player navigates through various rooms, interacting with objects and using commands to perform actions such as moving, picking up items, or using specific objects like a beamer. The game follows a command-line interface where players input text-based commands to explore a fictional world.

## Features

- **Room Exploration:** Players can move between rooms using commands like `go`, and each room has a description and potentially some items.
- **Item Interaction:** Players can pick up, drop, and examine items. Each item has properties like name, description, and weight.
- **Beamer:** A special type of item that can be charged to remember a room and later transport the player back to that room.
- **Transporter Room:** A unique room that transports the player to a random room within the game.
- **Command System:** Players can issue a variety of commands such as `look`, `take`, `drop`, `eat`, `charge`, and `fire`. Commands can be either known or unknown, and they can involve one or two words.
- **State Persistence:** The game maintains player information like current room, previous room, and a stack of visited rooms.

## Class Breakdown

### 1. **Game**
   - Manages the overall game flow and state, including the current room, items, and player commands.
   - **Key attributes:**
     - `currentRoom`: The room the player is currently in.
     - `previousRoom`: Tracks the last room the player was in.
     - `hungerLevel`: A mechanic that affects the player's gameplay.
     - `random`: Used to implement random events (like in the Transporter Room).
   - **Key methods:**
     - `createRooms()`: Initializes and sets up the rooms and their connections.
     - `play()`: Main game loop.
     - `processCommand(Command)`: Handles the logic for processing player commands.
     - `goRoom(Command)`, `take(Command)`, `drop(Command)`: Manage player movement and item interaction.

### 2. **Room**
   - Represents a room in the game, containing exits to other rooms and items.
   - **Key attributes:**
     - `description`: A description of the room.
     - `exits`: A HashMap that maps directions (e.g., north, south) to other rooms.
     - `items`: An ArrayList of items present in the room.
   - **Key methods:**
     - `setExit(direction, Room)`: Adds an exit to another room.
     - `addItem(Item)`: Adds an item to the room.
     - `takeItem(String)`: Removes an item from the room based on its name.

### 3. **Item**
   - Represents any object that the player can interact with.
   - **Key attributes:**
     - `name`: The name of the item.
     - `description`: A detailed description of the item.
     - `weight`: The weight of the item (which may affect gameplay).
   - **Key methods:**
     - `getDescription()`: Returns the description of the item.
     - `getName()`: Returns the name of the item.

### 4. **Beamer (extends Item)**
   - A specialized item that can be charged to store the current room and later fired to return the player to that room.
   - **Key attributes:**
     - `isCharged`: Boolean flag to track whether the beamer is charged.
     - `roomCharged`: The room that the beamer is charged with.
   - **Key methods:**
     - `charge(currentRoom)`: Stores the current room.
     - `fire()`: Transports the player back to the charged room.

### 5. **TransporterRoom (extends Room)**
   - A special room that, when entered, randomly transports the player to any other room in the game.
   - **Key attributes:**
     - `random`: Generates random room selections.
   - **Key methods:**
     - `getExit(String)`: Returns a random room instead of a fixed room.

### 6. **Command**
   - Handles player input commands.
   - **Key attributes:**
     - `commandWord`: The main command word (e.g., go, take, look).
     - `secondWord`: An optional second word (e.g., direction or item name).
   - **Key methods:**
     - `getCommandWord()`, `getSecondWord()`: Return the first and second words of the command.
     - `isUnknown()`: Checks if the command is unknown.
     - `hasSecondWord()`: Checks if the command has a second word.

### 7. **CommandWords**
   - Maintains the list of valid commands that the player can use.
   - **Key attributes:**
     - `validCommands`: A list of valid command words.
   - **Key methods:**
     - `isCommand(String)`: Checks if a given string is a valid command.
     - `getCommandList()`: Returns the list of all valid commands.

### 8. **Parser**
   - Parses the player's input and returns a Command object.
   - **Key attributes:**
     - `commands`: The CommandWords object containing the valid commands.
     - `reader`: A scanner to read user input.
   - **Key methods:**
     - `getCommand()`: Reads user input and returns a parsed Command.

## How to Play

1. **Compile the Java Files:**
   - Compile all the Java files in the repository using a Java compiler (e.g., `javac`).
     ```bash
     javac *.java
     ```

2. **Run the Game:**
   - Run the main class (`Game.java`) to start the game.
     ```bash
     java Game
     ```

3. **Commands:**
   - The player can input commands like:
     - `go [direction]`: Moves to a room in the specified direction.
     - `look`: Provides a description of the current room.
     - `take [item]`: Picks up an item in the room.
     - `drop [item]`: Drops an item from your inventory.
     - `charge`: Charges the beamer with the current room.
     - `fire`: Teleports to the charged room using the beamer.
     - `quit`: Exits the game.

## Future Improvements

- **Inventory Management:** Add a limit on the number of items a player can carry based on item weight.
- **Enhanced User Interface:** Implement a graphical user interface for better user experience.
- **Save/Load Feature:** Allow players to save and load game progress.

## UML Diagram

A UML diagram outlining the class structure and relationships is included in this repository (`uml_diagram.png`).

---

This game is a simple implementation for learning purposes and can be extended with new commands, features, or items. Contributions are welcome!
