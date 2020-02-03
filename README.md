# TDT4240 Pattern Exercise

This repository is used as the answer for the pattern exercise in the Software Architecture course.
Explanation and dicussion around the steps in the exercise is listed below.

## Step 1 - Which progam is chosen as the base code?
The Pong game (task 4) from the first exercise is chosen for implementing the patterns. Some tweak (not related to the exercise) have also been done.

## Step 2 - Implementation of the Singleton pattern
The game introduces two game states, i.e. 'MenuState' and 'PongState'. A game will never include more than one menu and hence only one instance of the MenuState. Additionally, there is a 'GameStateManager' keeping track of the game state. Similar to MenuState there will only be one instance of GameStateManager. Therefore both the MenuState and GameStateManager implemented as Singletons. In Kotlin the Singleton pattern can easily be implemented by using an [object declaration](https://kotlinlang.org/docs/reference/object-declarations.html#object-declarations). This will ensure that the rules for the Singleton pattern si adhered to.

## Step 3 - Implementing additional patterns
My code from the introduction exercise used many of the same principles and techniques as Brent Aureli in his [Flappy Bird-tutorial](https://www.youtube.com/watch?v=rzBVTPaUUDg). In this series he utilized the [State pattern](https://en.wikipedia.org/wiki/State_pattern) and to some degree the [Template pattern](https://en.wikipedia.org/wiki/Template_method_pattern). Consequently my code from the introduction exercise already had already implemented some of the objectives for this exercise. In this exercise my focus has therefore been to extend the use of these patterns (e.g. by creating new templates) and tweak the implementation from the code base from the first exercise.
The state and template pattern os used in the following way, in the delivered code:
- **Template pattern**:
  - State: Both 'MenuState' and 'PongState' are extensions of the abstract 'State' class, overriding its abstract methods and inherting variables.
  - Sprites: Defined as an abstract class for all drawn objects in the game (includes button, paddle and ball). Includes abstract variables shared by these classes, i.e. texture, position and bounds. All drawn object (Button, RightPaddle, LeftPaddle and Ball) extends this class.
  - Paddles: The LeftPaddle and the RightPaddle previously inlcuded a lot of similiar code. This is now gathered in the abstract class 'Paddle' which is overriden by the concrete implementation of 'LeftPaddle' and 'RightPaddle'.
- **State pattern**:
  - Game states: In order to keep track of the game the state pattern is used to keep track of where the user are in the game. The 'GameStateManager' holds information about which states are active in the game, e.g. 'the user is in the menu' 

TODO: Add links concrete files in the section above

## Step 4 - Theory questions
a) For the patterns listing in Step3, which are architectural patterns, and which are design
patterns? What are the relationships and differences of architectural patterns and design
patterns?
Architectural patterns and design patterns are similar, but architectural patterns have a different (broader) scope. They both define solutions for commonly occuring problems when developing software.

Architectural patterns:
- Model View Controller (MVC)
- Pipe and filter

Design patterns:
- Observer
- State
- Template
- Abstract factory

b) How is the pattern you chose realized in your code? (Which class(es) works as the
pattern you chose?)
Implementation details, see above explanation.

c) Is there any advantages in using this pattern in this program? (What are the
advantages/disadvantages?)
TODO: Write
- Singleton: The singleton pattern. Ensure only one instance
- Cleaner code
- May be a bit more confusing? an extra class almost uneccesarry class 'Sprite' (sprite)


