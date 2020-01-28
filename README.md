# TDT4240 Pattern Exercise

This repository is used as the answer for the pattern exercise in the Software Architecture course.
Explanation and dicussion around the steps in the exercise is listed below.

## Step 1 - Which progam is chosen as the base code?
The Pong game (task 4) from the first exercise is chosen to implement patterns. 

## Step 2 - Implementation of the Singleton pattern
The game introduces multiple game states, i.e. 'MenuState' and 'PongState'. Since a game will never include more than one instance of these, the Singleton pattern is used. In Kotlin the Singleton pattern can easily be implemented by using an [object declaration](https://kotlinlang.org/docs/reference/object-declarations.html#object-declarations). This will ensure that the rules for the Singleton pattern si adhered to. Aditionally the 'GameStateManager' is declared as Singleton similarly to the game states.

## Step 3 - Implementing additional patterns
My code from exercise 1 used many of the same principles and techniques as Brent Aureli in his [Flappy Bird-tutorial](https://www.youtube.com/watch?v=rzBVTPaUUDg). In this series he utilized the [State pattern](https://en.wikipedia.org/wiki/State_pattern) and to some degree the template pattern. Consequently my code from the introduction exercise already had already implemented some of the objectives for this exercise. In this exercise my focus has therefore been to extend the use of these patterns (e.g. by creating new templates) and tweak the implementation from the code base from the first exercise.
- (Template pattern)[http://en.wikipedia.org/wiki/Template_method_pattern]
  - State: Both 'MenuState' and 'PongState' are extensions of the state class overriding the abstract methods defined.
  - Buttons: Different buttons have a lot of shared functionality. e.g possibility to press and a texture. A base class 'Button' now includes code that previously was located in all the button classes.
  - Paddles: Similarly to buttons, the paddles include a lot of similiar code. This is now gathered in the abstract class 'Paddle' which is overriden by the concrete implementation of 'LeftPaddle' and 'RightPaddle'.
- (State pattern)[http://en.wikipedia.org/wiki/State_pattern]:
  - Game states

## Step 4 - Theory questions
a) For the patterns listing in Step3, which are architectural patterns, and which are design
patterns? What are the relationships and differences of architectural patterns and design
patterns?
TODO: Write answer
b) How is the pattern you chose realized in your code? (Which class(es) works as the
pattern you chose?)
TODO: Write answer
c) Is there any advantages in using this pattern in this program? (What are the
advantages/disadvantages?)
TODO: Write answer
