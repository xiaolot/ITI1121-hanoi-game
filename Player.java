//Student 1 full name:Weifeng Huang
//Student 2 full name:Weifeng Huang
//==================================================



/**
 * Your documentation for this interface ....
 * An interface Player contains 2 method.
 * The method play revecive a input parameter G with type HanoiTowerGame, and play on this game.
 * The method getScore return the Score of current player.
 */

public interface Player {
	public abstract void play(HanoiTowerGame G);
    public abstract int getScore();
}