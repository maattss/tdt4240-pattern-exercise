# TDT4240 Pattern Exercise

This repository is used as the answer for the pattern exercise in the Software Architecture course.
Explanation and dicussion around the steps in the exercise is listed below.

## Step 1 - Which progam is chosen as the base code?
The Pong game (task 4) from the first exercise is chosen for implementing the patterns. Some tweaks which are not directly related to the exercise have also been done.

## Step 2 - Implementation of the Singleton pattern
The game introduces two game states, i.e. [MenuState](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/states/MenuState.kt) and [PongState](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/states/PongState.kt). A game will never include more than one menu and hence only one instance of the MenuState. Additionally, there is a [GameStateManager](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/states/GameStateManager.kt) keeping track of the game state. Similar to MenuState there will only be one instance of GameStateManager. Therefore both the [MenuState](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/states/MenuState.kt) and [GameStateManager](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/states/GameStateManager.kt) implemented as Singletons. In Kotlin the Singleton pattern can easily be implemented by using an [object declaration](https://kotlinlang.org/docs/reference/object-declarations.html#object-declarations). This will ensure that the rules for the Singleton pattern si adhered to.

## Step 3 - Implementing additional patterns
My code from the introduction exercise used many of the same principles and techniques as Brent Aureli in his [Flappy Bird-tutorial](https://www.youtube.com/watch?v=rzBVTPaUUDg). In this series he utilized the [State pattern](https://en.wikipedia.org/wiki/State_pattern) and to some degree the [Template pattern](https://en.wikipedia.org/wiki/Template_method_pattern). Consequently my code from the introduction exercise already had already implemented some of the objectives for this exercise. In this exercise my focus has therefore been to extend the use of these patterns (e.g. by creating new templates) and tweak the implementation from the code base from the first exercise.
The state and template method patterns are used in the following way, in the delivered code:
- **Template method pattern**:
  - State: Both [MenuState](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/states/MenuState.kt) and [PongState](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/states/PongState.kt) are extensions of the abstract [State](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/states/State.kt) class, overriding its abstract methods and inherting variables.
  - Sprites: [Sprite](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/sprites/Sprite.kt) is defined as an abstract class for all drawn objects in the game (includes button, paddle and ball). Includes abstract variables shared by these classes, i.e. texture, position and bounds. All drawn object ([Button](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/sprites/Button.kt), [RightPaddle](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/sprites/RightPaddle.kt), [LeftPaddle](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/sprites/LeftPaddle.kt) and [Ball](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/sprites/Ball.kt)) extends this class.
  - Paddles: The LeftPaddle and the RightPaddle inlcuded a lot of similiar code in exercise 1. This is now gathered in the abstract class [Paddle](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/sprites/Paddle.kt) which is overriden by the concrete implementation of [LeftPaddle](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/sprites/LeftPaddle.kt) and [RightPaddle](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/sprites/RightPaddle.kt).
- **State pattern**:
  - Game states: In order to keep track of the game the state pattern is used to keep track of where the user are in the game. The [GameStateManager](https://github.com/maattss/tdt4240-pattern-exercise/blob/master/core/src/com/maattss/pattern/exercise/states/GameStateManager.kt) holds information about which states are active in the game, e.g. 'the user is in the menu' 

## Step 4 - Theory questions
a) For the patterns listing in Step 3, which are architectural patterns, and which are design
patterns? What are the relationships and differences of architectural patterns and design
patterns?
Architectural patterns and design patterns are similar, but architectural patterns have a different (broader) scope. They both define solutions for commonly occuring problems when developing software.

Architectural patterns:
- Model View Controller
- Pipe and filter

Design patterns:
- Observer
- State
- Template method
- Abstract factory

b) How is the pattern you chose realized in your code? (Which class(es) works as the
pattern you chose?)
Implementation details, see above explanation.

c) Is there any advantages in using this pattern in this program? (What are the
advantages/disadvantages?)
- Template method:
  - Pros: The same code can be shared to multiple classes. Prevents "copy-paste" errors and decreases number of lines of code.
  - Cons: May create unnecessary many classes which may be harder to maintain and understand.
- Singleton: 
  - Pros: Easy to ensure only one instance per class. Easily accessible global access point.
  - Cons: Unit testing may be diffucult because of the global state.
