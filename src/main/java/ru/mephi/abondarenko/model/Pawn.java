package ru.mephi.abondarenko.model;

public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn))
            return false;
        int direction = color.equals("White") ? 1 : -1;
        if (column == toColumn) {
            if (line + direction == toLine) {
                return chessBoard.board[toLine][toColumn] == null
                        || !chessBoard.board[toLine][toColumn].getColor().equals(color);
            }
            if ((line == 1 && color.equals("White")) || (line == 6 && color.equals("Black"))) {
                return line + 2 * direction == toLine && (chessBoard.board[toLine][toColumn] == null
                        || !chessBoard.board[toLine][toColumn].getColor().equals(color));
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
