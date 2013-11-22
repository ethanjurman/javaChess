/**
 * 
 */
package board;

import java.util.ArrayList;
import java.util.HashMap;

import pieces.*;
import player.Player;

/**
 * @author Ethan
 *
 */
public class Board {
	public HashMap<BoardPosition, Piece> pieces;
	public ArrayList<Piece> history = new ArrayList<Piece>();
	
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
		boolean moveSuccess = false; 
		switch(piece.type){
		case PAWN:
			moveSuccess = PieceMovement.pawnCheckMove(piece, position, this);
			break;
		case BISHOP:
			moveSuccess = PieceMovement.bishopCheckMove(piece, position, this);
			break;
		case KING:
			moveSuccess = PieceMovement.kingCheckMove(piece, position, this);
			break;
		case KNIGHT:
			moveSuccess = PieceMovement.knightCheckMove(piece, position, this);
			break;
		case QUEEN:
			moveSuccess = PieceMovement.queenCheckMove(piece, position, this);
			break;
		case ROOK:
			moveSuccess = PieceMovement.rookCheckMove(piece, position, this);
			break;
		default:
			break;
		}
		if (moveSuccess)
			history.add(piece);
		return moveSuccess;
	}
	
	public void takeTurn(Player player){
		player.turn(this);
	}
}
