/**
 * 
 */
package board;

import java.util.HashMap;

import pieces.*;
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
		switch(piece.type){
		case PAWN:
			PieceMovement.pawnCheckMove(piece, position, this);
			break;
		case BISHOP:
			PieceMovement.bishopCheckMove(piece, position, this);
			break;
		case KING:
			PieceMovement.kingCheckMove(piece, position, this);
			break;
		case KNIGHT:
			PieceMovement.knightCheckMove(piece, position, this);
			break;
		case QUEEN:
			PieceMovement.queenCheckMove(piece, position, this);
			break;
		case ROOK:
			PieceMovement.rookCheckMove(piece, position, this);
			break;
		default:
			break;
		}
		return false;
	}
	
	public void takeTurn(Player player){
		player.turn(this);
	}
}
