package ru.mephi.abondarenko.model;

public abstract class ChessPiece {
    protected String color;
    protected boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int stepLine = line == toLine ? 0 : (toLine - line) / Math.abs(toLine - line);
        int stepColumn = column == toColumn ? 0 : (toColumn - column) / Math.abs(toColumn - column);
        int currentLine = line + stepLine;
        int currentColumn = column + stepColumn;
        while (currentLine != toLine || currentColumn != toColumn) {
            if (chessBoard.board[currentLine][currentColumn] != null)
                return false;
            currentLine += stepLine;
            currentColumn += stepColumn;
        }
        return chessBoard.board[toLine][toColumn] == null
                || !chessBoard.board[toLine][toColumn].getColor().equals(color);
    }

    public abstract String getSymbol();
}
