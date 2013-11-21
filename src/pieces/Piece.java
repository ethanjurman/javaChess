/**
 * 
 */
package pieces;

import java.util.ArrayList;
import java.util.HashMap;

import board.Board;
import board.BoardPosition;

/**
 * @author Ethan
 *
 */
public class Piece {
	public ChessPieceType type;
	public ChessColor color;
	public BoardPosition pos;
	public ArrayList<BoardPosition> positionHistory = new ArrayList<BoardPosition>();
	
	public Piece(ChessPieceType type, ChessColor color, BoardPosition pos, Board board) {
		this.type = type;
		this.color = color;
		this.setNewPosition(pos);
	}
	
	public void setNewPosition(BoardPosition newPosition){
		this.pos = newPosition;
		this.positionHistory.add(newPosition);
	}
}
