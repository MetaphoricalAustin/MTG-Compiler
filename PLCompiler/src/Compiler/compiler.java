package Compiler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class compiler 
{
	@SuppressWarnings("rawtypes")
	public static <E> void main(String[] args)
	{

		String line = null;
		ArrayList history = new ArrayList<String>();
		
		Scanner scanner = new Scanner(System.in);
		
		Compiler.stack stack = new stack(); //despite the warning I need this line or it will error with uninitialized 
		
		System.out.println("Spell Builder Ready:");
		line = scanner.nextLine();
		
		doCommand(line, scanner, history, true); //boolean will tell the while loop to continue or not (so another function can call this function)
		
		System.out.println("exiting");

		scanner.close();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void doCommand(String command, Scanner scanner, ArrayList history, boolean fromMain)//actual command processor for doing a saved file
	{
		String line = command;
		do
		{
			boolean worked = false; //need this to reset each loop
			//System.out.println(command);
			if(line.equals("Display Current Mana") || line.equals("display current mana"))
			{
				displayMana();
				worked = true;
			}
			else if(line.equals("Display Numberical Mana") || line.equals("display numerical mana"))
			{
				displayNumericalMana();
				worked = true;
			}
			else if(line.equals("tap farther") || line.equals("Tap Further"))
			{
				tapFarther();
				worked = true;
			}
			else if(line.equals("tap less") || line.equals("Tap Less"))
			{
				tapLess();
				worked = true;
			}
			else if(line.equals("tap repeated") || line.equals("Tap Repeated"))
			{
				tapRepeated(scanner, history);
				worked = true;
			}
			else if(line.equals("recast") || line.equals("Recast"))
			{
				recast(scanner, history);
				worked = true;
			}
			else if(line.equals("Planeswalk") || line.equals("planeswalk"))
			{
				planeswalk();
				worked = true;
			}
			else if(line.equals("Cancel") || line.equals("cancel"))
			{
				cancel();
				worked = true;
			}
			else if(line.equals("Cast Spell") || line.equals("cast spell"))
			{
				castSpell();
				worked = true;
			}
			else if(line.equals("write note") || line.equals("Write Note"))
			{
				writeNote(scanner, history);
				worked = true;
			}
			else if(line.equals("write note backwards") || line.equals("Write Note Backwards"))
			{
				writeNoteBackwards(scanner, history);
				worked = true;
			}
			else if(line.equals("commit to memory") || line.equals("Commit To Memory"))
			{
				commitToMemory(scanner, history);
				worked = true;
			}
			else if(line.equals("do math") || line.equals("Do Math"))
			{
				doMath(scanner, history);
				worked = true;
			}
			else if(line.equals("compare mana") || line.equals("Compare Mana"))
			{
				compareMana(scanner, history);
				worked = true;
			}
			else if(line.equals("show spell") || line.equals("Show Spell"))
			{
				outputFile(scanner, history);
				worked = true;
			}
			else if(line.equals("read from file") || line.equals("Read From File"))
			{
				readFromFile(scanner, history);
				worked = true;
			}
			else if(line.equals("cast prepared spell") || line.equals("Cast Prepared Spell"))
			{
				recallMemory(scanner, history);
				worked = true;
			}
			else if(line.equals("telepathy") || line.equals("Telepathy"))
			{
				telepathy(scanner, history);
				worked = true;
			}
			else if(line.equals("Tap") || line.equals("tap"))
			{
				System.out.println("What mana are you using?");
				String input = scanner.nextLine();
				
				if(input.equals("Island") || input.equals("I"))
				{
					tap('I');
					worked = true;
				}
				else if(input.equals("island") || input.equals("i"))
				{
					tap('i');
					worked = true;
				}
				else if(input.equals("Mountain") || input.equals("M"))
				{
					tap('M');
					worked = true;
				}
				else if(input.equals("mountain") || input.equals("m"))
				{
					tap('m');
					worked = true;
				}
				else if(input.equals("Plains") || input.equals("P"))
				{
					tap('P');
					worked = true;
				}
				else if(input.equals("plains") || input.equals("p"))
				{
					tap('p');
					worked = true;
				}
				else if(input.equals("Forest") || input.equals("F"))
				{
					tap('F');
					worked = true;
				}
				else if(input.equals("forest") || input.equals("f"))
				{
					tap('f');
					worked = true;
				}
				else if(input.equals("Swamp") || input.equals("S"))
				{
					tap('s');
					worked = true;
				}
				else if(input.equals("swamp") || input.equals("s"))
				{
					tap('s');
					worked = true;
				}
				else if(input.equals("C") || input.equals("c") || input.equals("Colorless") || input.equals("colorless"))
				{
					tap();//just puts 0 on the stack
					worked = true;
				}
				else if(line.equals("done"))//just so the error is not printed when done
				{
					
				}
				else
				{
					System.out.println("Mana type not found");
				}
				if(worked)//need to save the secondary input
				{
					history.addLast(input);
				}
			}
			else
			{
				System.out.println("Command not found");
			}
			//could output something here to let the user know to do the next thing
			if(worked)
			{
				history.addLast(line);//put all the good commands into the array (last so everything is still in order)
			}
			if(fromMain)//only get the next input if the loop is going
			{
				line = scanner.nextLine();
			}
		} while(!line.equals("done") && fromMain);
	}
	
	private static void telepathy(Scanner scanner, ArrayList history)
	{
		String input = scanner.nextLine();
		System.out.println(input);
	}
	
	private static void compareMana(Scanner scanner, ArrayList history) //palindrome checker
	{
	    System.out.println("How much mana do you want to compare");
	    int number = Integer.parseInt(scanner.nextLine());
	    if(number > stack.getSize())
	    {
	        System.out.println("false");
	    }
	    else
	    {
	        String word1 = "";
	        String word2 = "";
	        for(int x = 0; x < number; x++)
	        {
	            if(x < number / 2) // integer division naturally floors, skipping the middle character
	            {
	                word1 += stack.pop();
	            }
	            else if(x == number / 2 && number % 2 != 0) // skip the middle character for odd lengths
	            {
	                stack.pop();
	            }
	            else
	            {
	                word2 += stack.pop();
	            }
	        }
	        String word3 = "";
	        for(int x = word2.length(); x != 0; x--)
	        {
	            word3 += word2.substring(x - 1, x);
	        }
	        System.out.println(word1.equals(word3));
	    }
	}
	
	private static void displayNumericalMana() //print the top of the stack as a number
	{
		System.out.println((int) stack.pop().toString().charAt(0));
	}
	
	private static void doMath(Scanner scanner, ArrayList history)
	{
		System.out.println("What operator is going to be used?");
		String operation = scanner.nextLine();
		if(!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/") && !operation.equals("%"))
		{
			System.out.println("Operator not found: " + operation);
		}
		else if(operation.equals("%"))
		{
			history.addLast(operation);
			int operator1 = Integer.parseInt(stack.pop().toString());;
			System.out.println(operator1);
			int result = operator1 % 2;
			if(result != 0)
			{
				stack.push(0);
			}
			else
			{
				stack.push(1);
			}
		}
		else
		{
			history.addLast(operation);
			int operator1 = Integer.parseInt(stack.pop().toString());;
			System.out.println(operator1);
			
			int operator2 = Integer.parseInt(stack.pop().toString());;
			System.out.println(operator2);
			if(operation.equals("+"))
			{
				int result = operator1 + operator2;
				stack.push(result);
			}
			else if(operation.equals("-"))
			{
				int result = operator1 - operator2;
				stack.push(result);
			}
			else if(operation.equals("*"))
			{
				int result = operator1 * operator2;
				stack.push(result);
			}
			else if(operation.equals("/"))
			{
				int result = operator1 / operator2;
				stack.push(result);
			}
			else if(operation.equals("%"))//modulo operator, not needed anymore?
			{
				int result = operator1 % operator2;
				stack.push(result);
			}
		}
	}
	
	private static void commitToMemory(Scanner scanner, ArrayList history)//make a file and put the users command history into it
	{
		System.out.println("What should the file be named?");
		String input = scanner.nextLine();
		// FIX: wrap in try-with-resources so the writer is always closed and flushed
		try (BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(input)))
		{
			for(Object cmd : history)
			{
				bufferWriter.write(cmd.toString());
				bufferWriter.newLine();
			}
			history.clear(); // drain history after writing, matching original removeFirst() intent
		}
		catch(IOException e)
		{
			System.out.println("Something went wrong: " + e);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void writeNote(Scanner scanner, ArrayList history)
	{
		System.out.println("Give the length of the characters to print");
		int input = Integer.parseInt(scanner.nextLine());
		history.addLast(input);
		recursivePop(input);
		System.out.println();
	}
	
	@SuppressWarnings("unchecked")
	private static void writeNoteBackwards(Scanner scanner, ArrayList history) //print the top of the stack as a letter
	{
		System.out.println("Give the length of the characters to print");
		int input = Integer.parseInt(scanner.nextLine());
		history.addLast(input);
		while(input != 0)
		{
			input--;
			System.out.print(stack.pop());
		}
		System.out.println();
	}
	
	private static void recursivePop(int number)
	{
		if(number == 1)
		{
			System.out.print(stack.pop());
		}
		else
		{
			String word = (String) stack.pop();
			recursivePop(--number);
			System.out.print(word);
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void recast(Scanner scanner, ArrayList history) //puts a certain number of something on the stack, while printing it out
	{
		System.out.println("What is getting cast?");
		String spell = scanner.nextLine();
		history.addLast(spell);
		System.out.println("How many times?");
		String number = scanner.nextLine();
		history.addLast(number);
		System.out.println("Casting " + spell + " " + number + "of times");
		for(int x = 0; x < Integer.parseInt(number); x++)
		{
			doCommand(spell, scanner, history, false);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void tapRepeated(Scanner scanner, ArrayList history)
	{
		System.out.println("What is mana getting added to the spell?");
		String object = scanner.nextLine();
		history.addLast(object);
		System.out.println("How many times?");
		String number = scanner.nextLine();
		history.addLast(number);
		System.out.println("Adding " + object + " mana to spell " + number + " times");
		for(int x = 0; x < Integer.parseInt(number); x++)
		{
			stack.push(object);
			System.out.println(object);
		}
	}
	
	private static void recallMemory(Scanner scanner, ArrayList history)//needed?
	{
		System.out.println("What spell would you like to cast?");
		String fileName = scanner.nextLine();
		
		if(!checkIfFileName(fileName))
		{
			System.out.println("File not found: " + fileName);
			return;
		}
		
		try
		{
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			StringBuilder fileContents = new StringBuilder();
			String fileLine;
			while((fileLine = bufferedReader.readLine()) != null)
			{
				fileContents.append(fileLine).append("\n");
			}
			bufferedReader.close();
			fileReader.close();
			
			Scanner fileScanner = new Scanner(fileContents.toString());
			
			if(fileScanner.hasNextLine())
			{
				String firstCommand = fileScanner.nextLine();
				doCommand(firstCommand, fileScanner, history, true);
			}
			
			fileScanner.close();
		}
		catch(IOException e)
		{
			System.out.println("Something went wrong reading the file: " + e);
		}
	}
	
	private static void readFromFile(Scanner scanner, ArrayList history)//try the file and if it exists do the commands inside of it
	{
		System.out.println("What is the file to output");
		String name = scanner.nextLine();
		if(checkIfFileName(name))
		{
			history.addLast(name);
			try 
			{
				FileReader fileReader = new FileReader(name);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				StringBuilder fileContents = new StringBuilder();
				String fileLine;
				while((fileLine = bufferedReader.readLine()) != null)
				{
					fileContents.append(fileLine).append("\n");
				}
				bufferedReader.close();
				fileReader.close();
				
				Scanner fileScanner = new Scanner(fileContents.toString());
				ArrayList<String> replayHistory = new ArrayList<>();
				if(fileScanner.hasNextLine())
				{
					String firstCommand = fileScanner.nextLine();
					doCommand(firstCommand, fileScanner, replayHistory, true);
				}
				fileScanner.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	private static boolean outputFile(Scanner scanner, ArrayList history)//try the file and if it exists output each line inside of it to console
	{
		System.out.println("What is the file to output");
		String name = scanner.nextLine();
		if(checkIfFileName(name))
		{
			history.addLast(name);
			 try 
			 {
				 FileReader fileReader = new FileReader(name);
		    	 BufferedReader bufferedReader = new BufferedReader(fileReader);

		    	 while((name = bufferedReader.readLine()) != null) 
		    	 {
		    		 System.out.println(name);
		    	 }
		    	 
		    	 bufferedReader.close();
		    	 fileReader.close();
			 } 
			 catch (IOException e) 
			 {
				e.printStackTrace();
			 }
			 return true;
		}
		return false;
	}
	
	private static void castSpell()
	{
		while(stack.getSize() > 0)
		{
			System.out.print(stack.pop());
			System.out.println();
		}
	}
	
	private static void planeswalk()
	{
		while(stack.getSize() > 0)
		{
			stack.pop();
		}
	}
	
	private static void cancel() //remove the top of the stack
	{
		stack.pop();
	}
	
	private static void tapLess() //subtract one from the top of stack, negatives?
	{
		String number = (String) stack.pop().toString();
		//System.out.println(number);
		int extraNumberyNumber = (int) number.charAt(0);
		//System.out.println(extraNumberyNumber);
		extraNumberyNumber--;
		//System.out.println((char) extraNumberyNumber);
		tap((char) extraNumberyNumber);
	}
	
	private static void tap(char letter) //push object onto the stack
	{
		stack.push(letter);
	}
	
	private static void tap() //overload push with default value of 0
	{
		stack.push(0);
	}
	
	private static void tapFarther()
	{
		String number = (String) stack.pop().toString();
		//System.out.println(number);
		int extraNumberyNumber = (int) number.charAt(0);
		//System.out.println(extraNumberyNumber);
		extraNumberyNumber++;
		//System.out.println((char) extraNumberyNumber);
		tap((char) extraNumberyNumber);
	}
	
	private static void displayMana() //print the top of the stack
	{
		//int extraNumberyNumber = Integer.parseInt(number); //I am proud of this line despite not using it anymore
		if(stack.getSize() > 0)
		{
			stack.printTop();
		}
		else
		{
			System.out.println("No mana present");
		}
	}
	
	private static boolean checkIfFileName(String fileName) //return if the given filename is a found file
	{
		try 
		{
	    	 FileReader fileReader = new FileReader(fileName);
	    	 fileReader.close();
	    	 return true;
		}
		catch(FileNotFoundException e) 
	    {
	    	System.out.println( "Unable to open file '" +  fileName + "'" + e);                
			return false;
	    } 
		catch (IOException e) 
		{
	    	System.out.println( "Unable to open file '" +  fileName + "'" + e);
			return false;
		}
	}
}