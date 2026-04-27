functions the Magic The Gathering Compiler has:
stack: stack(), stack(Object), push, pop, size, printTop
math operators: + - / * %

				prepare spell: initalize a new stack
				cast spell: print out the entire stack, do I need this?
repeater		recast: takes two inputs and will do the first thing, the second input number of times, commands - yes, files - not yet
				display current mana: see the top of the stack
				display numberical mana: see the top of the stack as a number
helloworld		write note: takes user input and then prints that number of items off the stack to the screen on the same line
reverse string	write note backwards: takes user input and then prints it backwards to the screen on the same line
cat				telepathy: write next line to console
				tap (P M I S F C optional arguments): will desired letter onto the stack (C is 0)
				tap farther:  add +1 to the top value of the stack
				tap less: subtract 1 from the top of the stack
				tap repeated: add a specific mana to the stack (and print it out) x times
				cancel: remove the top of the stack
				commit to memory: output entire stack into file with name given
				planeswalk: trash the stack
multiply/even	do math: takes a single input for the operator and will use the top two values of the stack putting the result back on top
					(the math spell is a favorite, "I cast MATH!")
palindrome		compare mana: compares sources of mana, given a number for how deep to look
				show spell: print a file to the console
				
				cast prepared spell: takes a name and will cast a spell from such saved file
		
				done: exit the program
