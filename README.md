  # CS 211 - Object Oriented Programming Final Project
  
  <h1 align="center"> /̵͇̿̿/’̿’̿ ̿ ̿̿ ̿̿ ̿̿  Riskless Roulette /̵͇̿̿/’̿’̿ ̿ ̿̿ ̿̿ ̿̿</h1>
  
  ## Table of Contents
  - Introduction
  - Game Description
  - Features & Mechanics
  
  # 💥Introduction💥
  Welcome to Riskless Roulette, an eerie yet thrilling luck-based game where every pull of the trigger can either make you rich... or end your run. This version is entirely digital, in contrast to traditional Russian Roulette, but the tension is real. Every gun has it's own number of chambers, money multiplier, and death odds. <br> 
  
  <i><strong>Step in, load your gun, bet everything you can, and pray before 'CLICK'</strong></i>
  
  # 📜Game Description📜
  Riskless Roulette is a Java program game that simulates betting/gambling using various firearms, each with different chamber sizes and reward multipliers.<br><br>
  You start with <strong>₱1000</strong>. Place a bet, choose your gun, load how many bullets you want, and pull the trigger.<br><br>
  <strong>Survive a shot</strong> -> multiply your bet based on the gun and chamber multiplier.<br>
  <strong>If a bullet comes out</strong> -> you lose and your run will end.<br><br>
  Every decision counts:
  - What gun will you choose?
  - How many bullets will you load?
  - How much will you bet?
  - Will you push your luck.... or walk away?
  
  # 🎮Features & Mechanics🎮
  Variations of Weapons (each weapons have different function)
  | Weapon                | Chamber Count | Multiplier      | Danger Level                               |
  | --------------------- | ------------- | --------------- | ------------------------------------------ |
  | Desert Eagle          | 9             | x5              | 💀 Instant death on trigger (always fires) |
  | Revolver              | 6             | x1.5 per bullet | ⚠️ Medium risk                             |
  | Pepperbox Pistol      | 4             | x2.5 per bullet | ⚠️ High risk                               |
  | Double Barrel Shotgun | 2             | x3.5 per bullet | 🔥 Very high risk                          |

  # OOP Concepts Applied
  
  ### Encapsulation
  - Player Class: Keeps player name, balance, and life status private.
  - Gun Class & Subclasses: Store gun-related data (name, chambers, multipliers) privately.
  - Input Validation: Handled entirely by the InputChecker utiility class.
  ### Inheritance
  - <strong> desertEagle, revolver, pepperBox, and DoubleBarrel </strong> all inherit from the base <strong> Gun </strong> class.
  - This allows them to share common behaviors such as firing, loading, and reward multipiers.
  ### Abstraction
  - The main game only interacts with the abstract behaviors of Gun, not its internal implementation.
  - This hides complexity from the main program loop.
  # 
  
  # Program Structure
  ### Main Classes
  - risklessRouletter: Contains the main game loop, user, prompts, and betting system.
  - Player: Stores player name, balance, and life status. Handles adding or subtracting money.
  - Gun (Abstract): Base class for all guns. Defines shared gun properties and methods (chambers, firing logic, multiplier).
  - InputChecker: Handles user input validation such as bet amounts, yes/no prompts, and gun selection.
  ### Gun Subclasses
  - desertEagle: 9 chambers, highest risk.
  - revolver: 6 chambers.
  - pepperBox: 4 chambers.
  - DoubleBarrel: 2 chambers, high multiplier.
  ### Relationships
  - risklessRoulette uses Player and Gun objects.
  - Gun subclasses inherit from Gun.
  - InoutChecker assists the main program with input validation.
  
  # How to Run the Program
  ### 1. Open Project Folder
  Open your terminal, Command Prompt, or Visual Studio Code.
   - VS Code: Click file -> open folder.
   - Select the folder containing your src folder.
  #### Your folder structure should look like this:
  project-folder/src/risklessRoulette.java/guns/player/util/
  ### 2. VS Code Requirements
  if you are using VS Code, ensure you have the following installed:
   - Extension Pack for Java (by Microsoft)
   - Java Debugger
   - Java Development Kit (JDK) - At least JDK 17 or higher.
  ### 3. Run the Command
  Run the program using the following command in your terminal:
  java risklessRoulette.java
  ### 4. Play the Game
  Once running, the program will display: <br><br>
   Welcome to Riskless Roulettte! You get to play without any risk!
   Enter your name: <br><br>
  Follow the on-screen instructions to pick a gun, place a bet, and play.
  # Sample Output
  ### <img width="636" height="220" alt="Screenshot 2025-12-01 222511" src="https://github.com/user-attachments/assets/3ddd1c59-75b7-4270-a927-8a06997bec8a" />
  ### <img width="493" height="268" alt="Screenshot 2025-12-01 222544" src="https://github.com/user-attachments/assets/bac8890d-fe48-4489-93b9-05b9be5a26f1" />
  ### <img width="624" height="274" alt="Screenshot 2025-12-01 222552" src="https://github.com/user-attachments/assets/c5ee7b3f-afda-4475-9efd-edc41f0bfa78" />
  ### <img width="550" height="236" alt="Screenshot 2025-12-01 222607" src="https://github.com/user-attachments/assets/78d4e374-7f0e-435d-9a21-348582a8ead8" />

  # 👥 Authors / Contributors
| Name | GitHub Username |
| :--- | :--- |
| **Frances Iroll M. Fabellar** | [@noobit2](https://github.com/noobit2) |
| **Brandon Josef Y. Bernal** | [@Brandon-JYB](https://github.com/Brandon-JYB) |
| **Lance Kert O. Mendoza** | [@sleepingPotato17](https://github.com/sleepingPotato17) |
  
  # Future Improvements
  - Add more gun types with different chamber counts and multipliers.
  - Add sound effects (like clicks and gunshots) to make the game feel more alive.
  - Add animations if turned into a GUI version later.
  - Add difficulty levels (easy, normal, hard) that affect multiplier and death chance.
  - Add special events. like bonus rounds or double multiplier rounds.
  - Improve error handling to make the game more beginner-friendly.
  - Add a statistics page that shows number of games played, wins, deaths, highest balance, etc.
  #
  ## References
  - Tutorials from class.
  - Online guides for OOP concepts.
  - Classroom materials.
  - Help from our Professor.
