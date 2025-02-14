package game.piece;

import java.util.Set;
import game.board.Board;
import game.position.Position;
import game.util.Movement;
import game.position.*;

public class Piece {
	protected boolean white;
	protected boolean moved;
	protected Position position;
	protected Board board;
	
	public Piece(boolean white, Position position, Board board) {
		super();
		this.white = white;
		//this.moved = moved;
		this.position = position;
		this.board = board;
		
		board.placePiece(this, position);
	}
	
	public Set<Position> getLegalMove(){
		Movement movement = new Movement(this.getPosition(), this.getBoard());
		movement.getMovePositions(this);
		
		return movement.getMoves();
	}
	
	public Object deepCopy(); 
//	{	return new Object(new Piece(this.isWhite(),this.getPosition(),this.getBoard()));}
	
	public String toString() {
		return this.getClass().getSimpleName()+"("+this.getPosition()+")";
	}
	
	public void moveHandle(Position to) {
		this.setPosition(to);
		this.setMoved(true);
		this.hadMoved();
	}
	
	public boolean equals(Object o) {
		if(this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Piece piece = (Piece) o;
		return this.isWhite()==piece.isWhite()&&this.getPosition()==piece.getPosition();
	}
	
	public boolean hadMoved() {
		this.setMoved(true);
		return true;
	}
	
	public boolean isWhite() {
		return white;
	}
	public void setWhite(boolean white) {
		this.white = white;
	}
	public boolean isMoved() {
		return moved;
	}
	public void setMoved(boolean moved) {
		this.moved = moved;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	
}
