package game.piece;

import game.board.Board;
import game.position.Position;

public class Knight extends Piece{

	public Knight(boolean white, Position position, Board board) {
		super(white, position, board);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Object deepCopy() {
		Knight knight = new Knight(this.isWhite(),this.getPosition(),this.getBoard());
		if(this.hadMoved())knight.hadMoved();
		return knight;
	}

}
