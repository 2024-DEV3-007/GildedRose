## Gilded Rose

The Gilded Rose is a small inn with a system that updates the `sellIn` and `quality` values of its inventory items daily. The following rules describe how the system must behave:

- **All items** have a `sellIn` value which denotes the number of days we have to sell the item.
- **All items** have a `quality` value which denotes how valuable the item is.
- At the end of each day, the system updates both values for every item.

### General Rules

- At the end of each day, decrease the `sellIn` value by 1.
- At the end of each day, decrease the `quality` value by 1 for normal items.
- Once the `sellIn` value is less than 0, `quality` degrades twice as fast (i.e., decreases by 2).
- The `quality` of an item is never negative.
- The `quality` of an item is never more than 50.

### Special Items

- **Aged Brie** : Increases in `quality` the older it gets.

- **Sulfuras** (Legendary Item)  : `quality` and `sellIn` never change.

- **Backstage passes** : Increases in `quality` as its `sellIn` value approaches:
  - `quality` increases by 2 when there are 10 days or less.
  - `quality` increases by 3 when there are 5 days or less.
  - `quality` drops to 0 after the concert.

- **Conjured Items** : Degrade in `quality` twice as fast as normal items.

---
### Requirements

- **Java** : 1.8
- **Maven** : For Dependency management
- **JUnit** : 5.x

### Commit Message Style Guide
The project have followed the [Udacity Git Commit Message Style Guide](https://udacity.github.io/git-styleguide/), which provides a consistent format for writing commit messages.
Each commit messages contains **Title**. The title consists of the type of the message and subject. `type: Subject`

#### Commit Types

- **feat**: A new feature
- **fix**: A bug fix
- **docs**: Changes to documentation
- **style**: Code formatting changes (e.g., fixing indentation, removing spaces, etc.)
- **refactor**: Code refactoring without affecting functionality
- **test**: Adding or refactoring tests
- **chore**: Updates to build processes or auxiliary tools (e.g., package manager configs)

### How to Build the Application

- Clone this repository:
   ```bash
   https://github.com/2024-DEV3-007/GildedRose.git
- Build the project and run the tests by running
    ```bash
    mvn clean install

### Test reports

- Once after successful build of
  `mvn clean install`, navigate to target folder of the project root directory
- **Jacoco code coverage report :** Code Coverage report will be available in `target\site\jacoco` folder. View the report by launching **index.html**
- **pi test coverage report:** Mutation Coverage report will be available in `target\pit-reports` folder. View the report by launchig **index.html**