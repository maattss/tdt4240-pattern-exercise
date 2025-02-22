# TDT4240 Pattern Exercise

This repository is used as the answer for the pattern exercise in the Software Architecture course.
Explanation and dicussion around the steps in the exercise is listed below.

## Step 1 - Which progam is chosen as the base code?
The Pong game (task 4) from the [first exercise](https://github.com/maattss/tdt4240-intro-exercise) is chosen for implementing the patterns. The game is still a 2-player game, where the left player use the W/S key-combo and the right player uses UP/DOWN arrow-keys for playing. First player to 21 points win the game! Run [this JAR-file](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/pong.jar) to play the game (requires Java installed on your computer).

## Step 2 - Implementation of the Singleton pattern
The game introduces two game states, i.e. [MenuState](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/states/MenuState.kt) and [PongState](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/states/PongState.kt). A game will never include more than one menu and hence only one instance of the MenuState. This class is therefore implemented as Singleton. Additionally, there is a [GameStateManager](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/states/GameStateManager.kt) keeping track of the game state. Similar to MenuState there will only be one instance of GameStateManager. Therefore, also this class MenuState and has been implemented as Singleton. In Kotlin the Singleton pattern can easily be implemented by using an [object declaration](https://kotlinlang.org/docs/reference/object-declarations.html#object-declarations). This will ensure that the rules for the Singleton pattern is adhered to.

## Step 3 - Implementing additional patterns
My code from the introduction exercise used many of the same principles and techniques as Brent Aureli in his [Flappy Bird-tutorial](https://www.youtube.com/watch?v=rzBVTPaUUDg). In this series he utilized the [State pattern](https://en.wikipedia.org/wiki/State_pattern) and to some degree the [Template pattern](https://en.wikipedia.org/wiki/Template_method_pattern). Consequently my code from the introduction exercise already had already implemented some of the objectives for this exercise. In this exercise my focus has therefore been to extend the use of these patterns (e.g. by creating new templates) and tweak the implementation from the code base from the first exercise.
The state and template method patterns are used in the following way:
- **Template method pattern**:
  - State: Both [MenuState](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/states/MenuState.kt) and [PongState](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/states/PongState.kt) are extensions of the abstract [State](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/states/State.kt) class, overriding its abstract methods and inherting variables.
  - Sprites: [Sprite](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/sprites/Sprite.kt) is defined as an abstract class for all drawn objects in the game and includes abstract variables shared by these classes, i.e. texture, position and bounds. All drawn object ([Button](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/sprites/Button.kt), [RightPaddle](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/sprites/RightPaddle.kt), [LeftPaddle](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/sprites/LeftPaddle.kt) and [Ball](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/sprites/Ball.kt)) extends this class.
  - Paddles: The LeftPaddle and the RightPaddle included a lot of similiar code in exercise 1. This is now gathered in the abstract class [Paddle](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/sprites/Paddle.kt) which is overriden by the concrete implementation of LeftPaddle and RightPaddle.
- **State pattern**:
  - Game states: In order to keep track of the game, the state pattern is used to keep track of where the user are in the game. The [GameStateManager](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/states/GameStateManager.kt) holds information about which states are active in the game, e.g. 'the user is in the menu'.

## Step 4 - Theory questions
_a) For the patterns listed in Step 3, which are architectural patterns, and which are design
patterns? What are the relationships and differences of architectural patterns and design
patterns?_

Architectural patterns:
- Model View Controller
- Pipe and filter
- Entity Component System

Design patterns:
- Observer
- State
- Template method
- Abstract factory

Architectural patterns and design patterns are similar, but architectural patterns have a different (broader) scope. They both define solutions for commonly occuring problems when developing software.

_b) How is the pattern you chose realized in your code? (Which class(es) works as the
pattern you chose?)_

Implementation details, see above explanation.

_c) Is there any advantages in using this pattern in this program? (What are the
advantages/disadvantages?)_
- Template method:
  - Pros: The same code can be shared by multiple classes. Prevents "copy-paste" errors and decreases number of lines of code.
  - Cons: May create unnecessary many classes which may be harder to maintain and understand.
- Singleton: 
  - Pros: Easy to ensure only one instance per class. Easily accessible global access point.
  - Cons: Unit testing may be diffucult because of the global state.
