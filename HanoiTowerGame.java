//Student 1 full name:Weifeng Huang
//Student 2 full name:Weifeng Huang
//==================================================



/**
 * Your documentation for this class ....
 * This class implement a tower game.
 * Initially there would be three tower, tower 2 and 3 would be empty,
 * tower 1 would have 3 disks(if no particular disk input variable).
 * 3 disks must be stacking from small to big.
 * player need to move the 3 disks from tower 1 to tower 3
 * with a precondtion "It it not allow to put a larger disk into a small one"
 * There is also max move as a limitation, player need to use less move.
 */

import java.lang.Math;

public class HanoiTowerGame {

	//This will point to the array of three towers (type of towers LinkedStack)
	private Stack[] towerValues;  
	private int disks;
	private int level;
	private int maxLevels;
	private GameState gameState;

    /**
	 * A constructor for class HanoiTowerGame with no input parameter.
	 * It initializes the amount of disks as 3, gameState as playing,
	 * level(move) is 0, maxlevel as forumla 2*((2^disks)-1), three tower is implemented by
	 * linkedStack. And it would push disks into first tower.
	 */ 
	public HanoiTowerGame(){
		this.disks=3;
		gameState=GameState.PLAYING;
		level=0;
		maxLevels=2*((int)Math.pow(2,disks)-1);
		towerValues=new Stack[3];
		for (int a=0; a<3;a++){
			towerValues[a]=new LinkedStack();
		}
		
		for (int i=3; i>0;i--){
			String temp="";
			for(int n=0; n<i;n++){
				temp=temp+"-";
			}
			towerValues[0].push(temp);
		}
	}

	//your code here
	/**
	 * A constructor for class HanoiTowerGame with a input parameter.
	 * It initializes the amount of disks for particular input disks, gameState as playing,
	 * level(move) is 0, maxlevel as forumla 2*((2^disks)-1), three tower is implemented by
	 * linkedStack. And it would push disks into first tower.
	 */ 
	public HanoiTowerGame(int disks){
		this.disks=disks;
		gameState=GameState.PLAYING;
		level=0;
		maxLevels=2*((int)Math.pow(2,disks)-1);
		towerValues=new Stack[3];
		for (int a=0; a<3;a++){
			towerValues[a]=new LinkedStack();
		}
		
		for (int i=disks; i>0;i--){
			String temp="";
			for(int n=0; n<i;n++){
				temp=temp+"-";
			}
			towerValues[0].push(temp);
		}
	}

	/**
	 * getDisks is a public method with no input parameter.
	 * @return disks with type of int
	 * It return the amount of disks
	 * It would be used while printing the 
	 * information in the beginning of the game
	 */
	public int getDisks(){
		return disks;
	}

	/**
	 * getLevel is a public method with no input parameter.
	 * @return level with type of int
	 * It return the total move of the player
	 * This method would return the count of player 
	 * move, and compare with the maxlevels.
	 */
	public int getLevel(){
		return level;
	}

	/**
	 * maxLevels is a public method with no input parameter.
	 * @return maxLevels with type int
	 * It return the max move that the player is allow to play
	 * This method would be use on limiting the the total move of player.
	 */
	public int maxLevels(){
		return maxLevels;
	}

	/**
	 * getGameState is a public method with no input parameter.
	 * @return gameState with type GameState
	 * it return the state(winner, loser, or playing) of the game
	 * This method would be use to update the game state.
	 */
	public GameState getGameState(){
		return gameState;
	}

	/**
	 * getLevel is a public method with a input parameter.
	 * @param i with type of int
	 * i=={0,1,2} in this case, 0 is first tower,
	 * 1 is second tower, 2 is third tower.
	 * @return towerValue[i].size() with type of int
	 * it return the total disk on the i tower.
	 * This method may compare with the disks, 
	 * which detected the winner.
	 */
	public int getDisksAtTower(int i){
		return towerValues[i].size();
	}

	/**
	 * The public method play has two input parameter, 
	 * @param ct,dt with type of int
	 * ct represent current tower,
	 * dt represent destination tower.
	 * This method transfer the top value on ct to dt, if pass the condition blew:
	 * 1. the top of ct is not null.
	 * 2. the top of ct is smaller than the top of dt(if dt is not null).
	 * 3. the top of ct is not null, and the top of dt is null.
	 */ 
	public void play(int ct, int dt){
		if (!towerValues[ct].isEmpty()){
			if (towerValues[dt].isEmpty()){
				towerValues[dt].push(towerValues[ct].pop());
				level++;
			}else{
				if (towerValues[ct].peek().toString().compareTo(towerValues[dt].peek().toString())<0){
					towerValues[dt].push(towerValues[ct].pop());
					level++;
			    }else{
			    	System.out.println("Invalid move!!!");
			    }
		    }
		}else{
			System.out.println("There is/are no disk/'s at tower"+ct);
	    }
		checkWinner();
	}

	/**
	 * The public method checkWinner do not have a input parameter.
	 * Checking the player win or lost is the main purpose.
	 * Once it detects the winner or loser, the gamestate would be changed.
	 * checkWinner would be used on the method play in order to update 
	 * the gamestate after a move.
	 */
	public void checkWinner(){
		if (gameState==GameState.PLAYING){
			if (getDisksAtTower(2)==disks){
				gameState=GameState.WINNER;
			}
		}
		if (gameState==GameState.PLAYING){
			if (getLevel()>=maxLevels()){
				gameState=GameState.LOSER;
			}
		}
	}

	/**
	 * toString is a public method with no input parameter.
	 * @return s with type of String
	 * It return a string representation of this game.
	 * This method could display the current information of 3 tower
	 * After the move of the player, it shows
	 * a clear picture to the player.
	 */
	public String toString(){
		String s="";
		for (int i=1; i<4;i++){
			s=s+"Tower "+i+Utils.NEW_LINE;
			s=s+towerValues[i-1].ttb(disks)+Utils.NEW_LINE;
		}
		return s;
	}



	// all methods should be documented: purpose of the method, input, and output
	// and where it is used in the assignment

}
