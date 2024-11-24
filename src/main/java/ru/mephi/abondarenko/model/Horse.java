package ru.mephi.abondarenko.model;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int stepLine = Math.abs(line - toLine);
        int stepColumn = Math.abs(column - toColumn);
        return ((stepLine == 2 && stepColumn == 1) || (stepLine == 1 && stepColumn == 2))
                && chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)
                && (chessBoard.board[toLine][toColumn] == null
                || !chessBoard.board[toLine][toColumn].getColor().equals(color));
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
