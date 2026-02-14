# Plants vs Zombies Clone

A Java/Swing implementation of the classic Plants vs Zombies tower defense game.

## Getting Started

### Prerequisites

- Java 17 or later
- Assets in `assets/` directory (plants, zombies, UI, sounds)

### Building and Running

1. Compile the project (output goes to `bin/` by default)
2. Run `Main.Main` as the application entry point
3. Ensure `data/settings.ser` exists or create it via the Level Editor

### Level Editor

Use the Level Editor to configure game settings, select plants and zombies, and customize gameplay parameters. Settings are saved to `./data/settings.ser`.

## Folder Structure

- `src/` - Java source code
  - `Main/` - Entry point, constants, game state
  - `Entities/` - Plants, zombies, projectiles, misc entities
  - `GUI/` - Game UI, seed packets, level display
  - `GameUtils/` - Game loop, rendering, input, sound
  - `LevelEditor/` - Level editor and game settings
- `lib/` - JAR dependencies
- `bin/` - Compiled output
- `assets/` - Sprites, sounds, UI assets
- `data/` - Serialized settings and save data

## Dependency Management

The `JAVA PROJECTS` view allows you to manage dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
