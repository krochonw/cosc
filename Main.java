package P4;

/* This file includes:
 * 	1. Solution to P3
 *  2. Questions for P4. Comments starting with REQ represent the questions.
 *  
 * Features:
 * 	- We have from 1 to 3 players
 *  - We have many questions. Each player may be asked more than one question.
 *  - User can play many rounds of the game. 
 * 
 * Focus: 
 * 	- Arrays and Methods
 * 
 * Aim:
 * 	- Organize code and avoid code redundancy by the use of methods
 */
import java.util.*;
public class Main {				
	static Game game;			
	
	//Two arrays for questions and answers (both are global, i.e., accessible by all code in the class).
	//REQ1:	Replace array values with real questions/answers
	static String[] questions = {"What is the Capital of BC?", "What IDE was this created in?", "What programming language was this made with?", "What is the Capital of Canada", "What is the course number for this class?", "What country borders ours? ", "Largest Province area wise? ", "Largest Province population wise", "The song \"Hotline Bling\" is by what artist?"};
	static String[] answers = 	{"Victoria",   "Eclipse",   "Java",   "Ottawa",   "111",   "USA",   "Quebec",   "Ontario",   "Drake"};
	
	public static void main(String[] args) {
		String ans;
		do{								
			//Reset the game
			game = new Game();			
			
			
			
			//Get number of players (from 1 to 3)
			int numPlayers = game.askForInt("How many players", 1, 3);

			//Add up to 3 players to the game
			for (int i = 0; i < numPlayers; i++) {
				String name = game.askForText("What is player " + i + " name?");
				game.addPlayer(name);				
			}
			
			//REQ2:	Call a method to shuffle questions and answers. For that, you need to create a method with the header: void shuffleQuestions();
			shuffleQuestions();
			//REQ3:	- Calculate the maximum number of questions each player could be asked (equals to the number of available questions divided by numPlayers). Store this value in a variable maxQuestions
			//	- Ask the user how many questions should be given to each player. The value read from the user should not exceed MaxQuestion. Store this value in a variable numQuestions.
			int maxQuestions = questions.length/numPlayers;
			int numQuestions = game.askForInt("How many questions per player?", 1, maxQuestions);
			
			//		- Ask each player the next unanswered question (e.g., player 0 gets the first question. If it is answered correctly, then player1 gets the next question in the array, otherwise player1 gets the same question again, and so on). 
			for(int n = 0; n < numQuestions; n++){
			// 		  Assume that an incorrectly answered question will keep popping up until it is correctly answered.
			//		  Hint: you need to create a for loop that repeats the below code block numQuestions times.
			//		  Hint: you need to have a variable that keeps track of the next question to be offered. 
			for (int i = 0; i < numPlayers; i++) {
				game.setCurrentPlayer(i);//draw rectangle around player 0, and currentPlayer = player0
				String answer = game.askForText(questions[i]);
				if(answers[i].equals(answer))
					game.correct();		//display "Correct", increment score, change frame color to green
				else
					game.incorrect();	//display "incorrect", change frame color of player to red
			}	
			
			}
			//Do you want to play again? make sure you get valid input
			ans = game.askForText("Play again? (Y/N)"); 
			while(ans != null && !ans.toUpperCase().equals("Y") && !ans.toUpperCase().equals("N"))
				ans = game.askForText("Invalid input. Play again? (Y/N)");
		}while(ans.toUpperCase().equals("Y"));	//play again if the user answers "Y" or "y"

		System.exit(1); 	//This statement terminates the program
		
	}
	public static void shuffleQuestions()
	{
	    int index;
	    String temp;
	    String temp1;
	    Random random = new Random();
	    for (int i = questions.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = questions[index];
	        temp1 = answers[index];
	        questions[index] = questions[i];
	        answers[index] = answers[i];
	        questions[i] = temp;
	        answers[i]= temp1;
	    }
	}
		
		
		
	}
	

