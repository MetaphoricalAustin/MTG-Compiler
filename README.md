# Magic The Gathering Compiler

To run download, make jar file of the following with the command, then run it:

jar cf jar-file compiler.java

java -jar compiler.jar

## Stack (on the backend)

`stack()` | `stack(Object)` | `push` | `pop` | `size` | `printTop`

---

## Commands

### Stack Management

| Command | Description |
|---|---|
| **prepare spell** | Initialize a new stack |
| **cast spell** | Print out the entire stack |
| **planeswalk** | Trash (clear) the stack |
| **cancel** | Remove the top of the stack |

### Viewing the Stack

| Command | Description |
|---|---|
| **display current mana** | See the top of the stack |
| **display numerical mana** | See the top of the stack as a number |

### Tapping (Adding to Stack)

| Command | Description |
|---|---|
| **tap** `(P M I S F C [optional args])` | Push desired letter onto the stack (C = 0) |
| **tap farther** | Add +1 to the top value of the stack |
| **tap less** | Subtract 1 from the top of the stack |
| **tap repeated** | Add a specific mana to the stack x times |

### Input / Output

| Command | Description |
|---|---|
| **telepathy** | Write the next line to the console |
| **write note** | Takes user input, then prints that number of items off the stack to the screen on the same line |
| **write note backwards** | Takes user input and prints it backwards to the screen on the same line |
| **show spell** | Print a file to the console |

### Math Operators

Supported operators: `+` `-` `/` `*` `%`

| Command | Description |
|---|---|
| **do math** | Takes a single operator as input and uses the top two values of the stack, putting the result back on top |

> *The math spell is a favorite — "I cast MATH!"*

### Control Flow

| Command | Description |
|---|---|
| **recast** | Takes two inputs: repeats the first thing the second input number of times. Supports commands; file support not yet implemented |

### Comparison

| Command | Description |
|---|---|
| **compare mana** | Compares sources of mana; takes a number indicating how deep to look |

### File Operations

| Command | Description |
|---|---|
| **commit to memory** | Output the entire stack into a file with the given name |
| **cast prepared spell** | Takes a name and casts a spell from the saved file |

### Other

| Command | Description |
|---|---|
| **helloworld** | *(see write note)* |
| **reverse string** | *(see write note backwards)* |
| **done** | Exit the program |

### Here are some examples of code inputs and outputs:
program always starts within the terminal and needs to be told what to do

Sample command inputs for actions:

---

do commands in file:

  cast prepared spell -> file name

---

see if the value 5 is even:

tap

c

tap farther

tap farther

tap farther

tap farther

tap farther

do math

%

display current mana

done

---

multiply the numbers 5 and 3:

tap

c

tap farther

tap farther

tap farther

tap farther

tap farther

tap

c

tap farther

tap farther

tap farther

do math

*

display current mana

done

---

helloworld:

tap

i

tap less

tap

f

tap less

tap

m

tap less

tap

m

tap less

tap

m

tap farther

tap farther

tap

s

tap farther

tap farther

tap farther

tap farther

tap

m

tap farther

tap farther

tap

s

tap less

tap

m

tap less

tap

f

tap less

tap less

write note

10

done

