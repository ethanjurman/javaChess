package pieces;

import board.*;

public class PieceMovement {
	public boolean pawnCheckMove(Piece piece, BoardPosition newPosition, Board board){
		int row = newPosition.row - piece.pos.row;
		int col = newPosition.col - piece.pos.col;
		if ((row == 1) && ((col == 1) || (col == -1)))
			return board.getBoardState().containsKey(newPosition);
		if ((row == 2) || (row == 1) && (col == 0) && (piece.positionHistory.size() == 1)){
			return !board.getBoardState().containsKey(newPosition);
		}
		return false;
	}
	public boolean knightCheckMove(Piece piece, BoardPosition newPosition, Board board){
		int row = newPosition.row - piece.pos.row;
		int col = newPosition.col - piece.pos.col;
		int rowSign = row < 0 ? -1 : 1;
		int colSign = col < 0 ? -1 : 1;
		if (((row * rowSign) == 2) && ((col * colSign) == 1))
			return true;
		if (((row * rowSign) == 1) && ((col * colSign) == 2))
			return true;
		return false;
	}
	public boolean kingCheckMove(Piece piece, BoardPosition newPosition, Board board){
		int row = newPosition.row - piece.pos.row;
		int col = newPosition.col - piece.pos.col;
		int rowSign = row < 0 ? -1 : 1;
		int colSign = col < 0 ? -1 : 1;
		return ((row * rowSign) <= 1)  && ((col * colSign) <= 1);
	}
	public boolean bishopCheckMove(Piece piece, BoardPosition newPosition, Board board){
		int row = newPosition.row - piece.pos.row;
		int col = newPosition.col - piece.pos.col;
		int rowSign = row < 0 ? -1 : 1;
		int colSign = col < 0 ? -1 : 1;
		if ((row * rowSign) == (col * colSign)){
			for (int i = 0; i < (row * rowSign); ++i){
				if (!board.getBoardState().containsKey(new BoardPosition(rowSign * i, colSign * i)))
					return false;
			}
			return true;
		}
		return false;
	}
	public boolean rookCheckMove(Piece piece, BoardPosition newPosition, Board board){
		int row = newPosition.row - piece.pos.row;
		int col = newPosition.col - piece.pos.col;
		int rowSign = row < 0 ? -1 : 1;
		int colSign = col < 0 ? -1 : 1;
		int max = (row * rowSign) > (col * colSign) ? row * rowSign : col * colSign;
		if ((row == 0) || (col == 0)){
			for (int i = 0; i < max; ++i){ 
				if (!board.getBoardState().containsKey(new BoardPosition(
						i * (row == 0 ? row : rowSign), 
						i * (col == 0 ? col : colSign)
						)))
					return false;
			}
			return true;
		}
		return false;
	}
	public boolean queenCheckMove(Piece piece, BoardPosition newPosition, Board board){
		int row = newPosition.row - piece.pos.row;
		int col = newPosition.col - piece.pos.col;
		int rowSign = row < 0 ? -1 : 1;
		int colSign = col < 0 ? -1 : 1;
		if ((row * rowSign) == (col * colSign))
			return bishopCheckMove(piece, newPosition, board);
		if ((row == 0) || (col == 0))
			return rookCheckMove(piece, newPosition, board);
		return false;
	}
}
