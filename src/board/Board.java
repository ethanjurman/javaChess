/**
 * 
 */
package board;

import java.util.HashMap;

import pieces.Piece;
import player.Player;

/**
 * @author Ethan
 *
 */
public class Board {
	public HashMap<BoardPosition, Piece> pieces;
	
	public Board(){
		this.pieces = new HashMap<BoardPosition, Piece>();
	}
	
	public HashMap<BoardPosition, Piece> getBoardState(){
		return pieces;
	}
	
	public void setBoardState(HashMap<BoardPosition, Piece> newBoard){
		this.pieces = newBoard;
	}
	
	public boolean move(Piece piece, BoardPosition position){
		return false;
	}
	
	public void takeTurn(Player player1){
		player1.turn(this);
	}
}
