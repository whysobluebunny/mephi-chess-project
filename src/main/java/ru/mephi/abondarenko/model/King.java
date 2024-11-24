package ru.mephi.abondarenko.model;

public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)
                || line == toLine && column == toColumn)
            return false;
        int stepLine = Math.abs(line - toLine);
        int stepColumn = Math.abs(column - toColumn);
        return (stepLine <= 1 && stepColumn <= 1) && (chessBoard.board[toLine][toColumn] == null
                || !chessBoard.board[toLine][toColumn].getColor().equals(color));
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board.board[i][j];
                if (piece != null && !piece.getColor().equals(this.color)
                        && piece.canMoveToPosition(board, i, j, line, column))
                    return true;
            }
        }
        return false;
    }
}
