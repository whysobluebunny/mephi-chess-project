package ru.mephi.abondarenko.model;

public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)
                || line == toLine && column == toColumn)
            return false;
        if (Math.abs(line - toLine) == Math.abs(column - toColumn)) {
            int stepLine = (toLine - line) / Math.abs(toLine - line);
            int stepColumn = (toColumn - column) / Math.abs(toColumn - column);
            int currentLine = line + stepLine;
            int currentColumn = column + stepColumn;
            while (currentLine != toLine && currentColumn != toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null)
                    return false;
                currentLine += stepLine;
                currentColumn += stepColumn;
            }
            return (chessBoard.board[toLine][toColumn] == null
                    || !chessBoard.board[toLine][toColumn].getColor().equals(color));
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}