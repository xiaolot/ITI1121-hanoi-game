//Student 1 full name:Weifeng Huang
//Student 2 full name:Weifeng Huang
//==================================================

/**
 * The class <b>HumanPlayer</b> is the class that controls the human's plays.
 * ... some more details here
 * This class provides details information about how the HanoiTowerGame
 * work in the beginning of the game, such as the goal and the rule. 
 * It ask the input source and destination from the player, and run 
 * the play method fromt the class HanoiTowerGame.
 */

import java.util.Scanner;
public class HumanPlayer implements Player {

	// your code here
    private int score;

    /**
     * play is a public method with one input parameter
     * @param g with type of HanoiTowerGame
     * while the gamestate of g is PLAYING, this method would run a loop,
     * and player would input source and destination to play the game until
     * the gamestate of g is not PLAYing.
     * It would mark the score and finally print the different message to winner or loser.
     */
    public void play(HanoiTowerGame g){
        System.out.println(g);
        System.out.println("Your goal is to move "+g.getDisks()+" disks from tower 1 to 3");
        System.out.println("Only one simple rule: no large disk on the top of smaller one");

        while(g.getGameState()==GameState.PLAYING){
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the source and the destination towers each on a single line: ");
            int s=sc.nextInt();
            int d=sc.nextInt();
            g.play(s-1,d-1);
            System.out.println(g);
            System.out.println("Moves played "+g.getLevel()+" Max "+g.maxLevels());
        }
        if (g.getGameState()==GameState.WINNER){
            System.out.println("You did it within the allowed number of moves!");
            score++;
            System.out.println("Your score is "+ score);
        }
        if (g.getGameState()==GameState.LOSER){
            System.out.println("You finished the allowed number of moves");
            System.out.println("Your score is " + score);
        }
    }

    /**
     * getScore is a public method with no input parameter
     * @return score with type of int
     * It return the score that marking the match.
     * This method helps to remember the score of the player.
     */
    public int getScore(){
        return score;
    }

}