package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns <1) {
			throw new BoardException("E nescessario que haja ao menos uma linha e uma coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		if (!positionExistis(row, column)) {
			throw new BoardException("Posicao nao existe no tabuleiro");
		}
		return pieces[row][column];
	}
	
	public Piece piece(Position position) {
		if(!positionExistis(position)) {
			throw new BoardException("Posicao nao inexistente no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Ja ha uma pessa na posicao " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if(!positionExistis(position)) {
			throw new BoardException("Esta peca nao esta em nenhuma posicao deste tabuleiro");
		}
		if(piece(position)== null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux; 	
	}
	
	public boolean positionExistis(int row, int column) {
		return row >=0 && row < rows && column >=0 && column < columns;
	}
	
	public boolean positionExistis(Position position) {
		return positionExistis(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if (!positionExistis(position)) {
			throw new BoardException("Posicao nao inexistente no tabuleiro");
		}
		return piece(position) != null;
	}
}
