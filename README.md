# JavaFX-Arcade-Game

A JavaFX arcade game built in Java. Red enemy blocks fall from the 
top of the screen. Control the black player block to collect them 
for points. Miss three enemies and the game ends.

## Features
- Real-time game loop with concurrent enemy movement timeline
- Collision detection between player and enemy blocks
- Lives system with Game Over screen
- Restart functionality without relaunching the application
- Wrapping boundaries — player reappears on opposite side of screen

## Architecture
The project uses a 7-class object oriented design:

- **App** — JavaFX entry point, initializes the stage
- **PaneOrganizer** — sets up the scene layout using BorderPane
- **Game** — core game logic, timelines, and state management
- **MainCharacter** — player movement, collision detection, boundary wrapping
- **Enemies** — enemy creation, movement, and removal
- **ScoreController** — score and lives tracking with UI labels
- **Constants** — centralized game configuration values

## Controls
- Arrow keys to move the player block

## How to Run

### Prerequisites
- Java 11 or higher
- JavaFX SDK
### IntelliJ IDEA Setup
1. Clone the repository
2. Open in IntelliJ IDEA
3. Go to File > Project Structure > Libraries
4. Add the JavaFX SDK lib folder
5. Edit your Run Configuration and add VM options:
   --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls
6. Run App.java

## Known Limitations
- Enemies spawn at random x positions which can occasionally overlap
- Enemy movement speed is fixed regardless of score or level
- No persistent high score between sessions

## What I Learned
This was my first complete software project built from scratch.
It introduced me to event-driven programming, concurrent animation 
timelines, JavaFX scene graph management, and designing a multi-class 
architecture where each class has a single clear responsibility.

## Author
Cai Talwar
