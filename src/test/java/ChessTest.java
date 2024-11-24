import org.junit.jupiter.api.Test;
import ru.mephi.abondarenko.model.*;

import static org.junit.jupiter.api.Assertions.*;

public class ChessTest {

    // Pawn Tests
    @Test
    public void testPawnMoveOneForward() {
        ChessBoard board = new ChessBoard("White");
        board.board[1][0] = new Pawn("White");
        assertTrue(board.moveToPosition(1, 0, 2, 0));
    }

    @Test
    public void testPawnMoveTwoForwardFromStart() {
        ChessBoard board = new ChessBoard("White");
        board.board[1][0] = new Pawn("White");
        assertTrue(board.moveToPosition(1, 0, 3, 0));
    }

    @Test
    public void testPawnCannotMoveBackward() {
        ChessBoard board = new ChessBoard("White");
        board.board[3][0] = new Pawn("White");
        assertFalse(board.moveToPosition(3, 0, 1, 0));
    }

    // Knight Tests
    @Test
    public void testKnightMoveLShape() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][1] = new Horse("White");
        assertTrue(board.moveToPosition(0, 1, 2, 2));
    }

    @Test
    public void testKnightCannotMoveStraight() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][1] = new Horse("White");
        assertFalse(board.moveToPosition(0, 1, 0, 3));
    }

    // Bishop Tests
    @Test
    public void testBishopMoveDiagonally() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][2] = new Bishop("White");
        assertTrue(board.moveToPosition(0, 2, 2, 4));
    }

    @Test
    public void testBishopCannotMoveStraight() {
        ChessBoard board = new ChessBoard("White");
        board.board[2][4] = new Bishop("White");
        assertFalse(board.moveToPosition(2, 4, 2, 5));
    }

    // Rook Tests
    @Test
    public void testRookMoveStraight() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][0] = new Rook("White");
        assertTrue(board.moveToPosition(0, 0, 0, 5));
    }

    @Test
    public void testRookCannotMoveDiagonally() {
        ChessBoard board = new ChessBoard("White");
        board.board[5][5] = new Rook("White");
        assertFalse(board.moveToPosition(5, 5, 6, 6));
    }

    // Queen Tests
    @Test
    public void testQueenMoveStraight() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][3] = new Queen("White");
        assertTrue(board.moveToPosition(0, 3, 0, 7));
    }

    @Test
    public void testQueenMoveDiagonally() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][3] = new Queen("White");
        assertTrue(board.moveToPosition(0, 3, 4, 7));
    }

    @Test
    public void testQueenCannotJumpOverPieces() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][3] = new Queen("White");
        board.board[2][3] = new Pawn("White");
        assertFalse(board.moveToPosition(0, 3, 4, 3));
    }

    // King Tests
    @Test
    public void testKingMoveOneSquare() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][4] = new King("White");
        assertTrue(board.moveToPosition(0, 4, 1, 4));
    }

    @Test
    public void testKingCannotMoveTwoSquares() {
        ChessBoard board = new ChessBoard("White");
        board.board[1][4] = new King("White");
        assertFalse(board.moveToPosition(1, 4, 3, 4));
    }

    // Castling Tests
    @Test
    public void testCastling0White() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][0] = new Rook("White");
        board.board[0][4] = new King("White");
        assertTrue(board.castling0());
    }

    @Test
    public void testCastling0Black() {
        ChessBoard board = new ChessBoard("Black");
        board.board[7][0] = new Rook("Black");
        board.board[7][4] = new King("Black");
        assertTrue(board.castling0());
    }

    // Capture Tests
    @Test
    public void testPawnCapture() {
        ChessBoard board = new ChessBoard("White");
        board.board[1][0] = new Pawn("White");
        board.board[2][0] = new Pawn("Black");
        assertTrue(board.moveToPosition(1, 0, 2, 0));
    }

    // Knight Capture Test
    @Test
    public void testKnightCapture() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][1] = new Horse("White");
        board.board[2][2] = new Pawn("Black");
        assertTrue(board.moveToPosition(0, 1, 2, 2));
    }

    // Bishop Capture Test
    @Test
    public void testBishopCapture() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][2] = new Bishop("White");
        board.board[2][4] = new Pawn("Black");
        assertTrue(board.moveToPosition(0, 2, 2, 4));
    }

    // Rook Capture Test
    @Test
    public void testRookCapture() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][0] = new Rook("White");
        board.board[0][5] = new Pawn("Black");
        assertTrue(board.moveToPosition(0, 0, 0, 5));
    }

    // Queen Capture Test
    @Test
    public void testQueenCapture() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][3] = new Queen("White");
        board.board[3][3] = new Pawn("Black");
        assertTrue(board.moveToPosition(0, 3, 3, 3));
    }

    // King Capture Test
    @Test
    public void testKingCapture() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][4] = new King("White");
        board.board[1][4] = new Pawn("Black");
        assertTrue(board.moveToPosition(0, 4, 1, 4));
    }

    // Pawn Cannot Capture Own Piece Test
    @Test
    public void testPawnCannotCaptureOwnPiece() {
        ChessBoard board = new ChessBoard("White");
        board.board[1][0] = new Pawn("White");
        board.board[2][1] = new Pawn("White");
        assertFalse(board.moveToPosition(1, 0, 2, 1));
    }

    // Knight Cannot Capture Own Piece Test
    @Test
    public void testKnightCannotCaptureOwnPiece() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][1] = new Horse("White");
        board.board[2][2] = new Pawn("White");
        assertFalse(board.moveToPosition(0, 1, 2, 2));
    }

    // Bishop Cannot Capture Own Piece Test
    @Test
    public void testBishopCannotCaptureOwnPiece() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][2] = new Bishop("White");
        board.board[2][4] = new Pawn("White");
        assertFalse(board.moveToPosition(0, 2, 2, 4));
    }

    // Rook Cannot Capture Own Piece Test
    @Test
    public void testRookCannotCaptureOwnPiece() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][0] = new Rook("White");
        board.board[0][5] = new Pawn("White");
        assertFalse(board.moveToPosition(0, 0, 0, 5));
    }

    // Queen Cannot Capture Own Piece Test
    @Test
    public void testQueenCannotCaptureOwnPiece() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][3] = new Queen("White");
        board.board[3][3] = new Pawn("White");
        assertFalse(board.moveToPosition(0, 3, 3, 3));
    }

    // King Cannot Capture Own Piece Test
    @Test
    public void testKingCannotCaptureOwnPiece() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][4] = new King("White");
        board.board[1][4] = new Pawn("White");
        assertFalse(board.moveToPosition(0, 4, 1, 4));
    }

    // Pawn Cannot Move to Same Position Test
    @Test
    public void testPawnCannotMoveToSamePosition() {
        ChessBoard board = new ChessBoard("White");
        board.board[1][0] = new Pawn("White");
        assertFalse(board.moveToPosition(1, 0, 1, 0));
    }

    // Knight Cannot Move to Same Position Test
    @Test
    public void testKnightCannotMoveToSamePosition() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][1] = new Horse("White");
        assertFalse(board.moveToPosition(0, 1, 0, 1));
    }

    // Bishop Cannot Move to Same Position Test
    @Test
    public void testBishopCannotMoveToSamePosition() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][2] = new Bishop("White");
        assertFalse(board.moveToPosition(0, 2, 0, 2));
    }

    // Rook Cannot Move to Same Position Test
    @Test
    public void testRookCannotMoveToSamePosition() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][0] = new Rook("White");
        assertFalse(board.moveToPosition(0, 0, 0, 0));
    }

    // Queen Cannot Move to Same Position Test
    @Test
    public void testQueenCannotMoveToSamePosition() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][3] = new Queen("White");
        assertFalse(board.moveToPosition(0, 3, 0, 3));
    }

    // King Cannot Move to Same Position Test
    @Test
    public void testKingCannotMoveToSamePosition() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][4] = new King("White");
        assertFalse(board.moveToPosition(0, 4, 0, 4));
    }

    // Bishop Cannot Pass Through Pieces Test
    @Test
    public void testBishopCannotPassThroughPieces() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][2] = new Bishop("White");
        board.board[1][3] = new Pawn("White");
        assertFalse(board.moveToPosition(0, 2, 2, 4));
    }

    // Rook Cannot Pass Through Pieces Test
    @Test
    public void testRookCannotPassThroughPieces() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][0] = new Rook("White");
        board.board[0][1] = new Pawn("White");
        assertFalse(board.moveToPosition(0, 0, 0, 5));
    }

    // Queen Cannot Pass Through Pieces Test
    @Test
    public void testQueenCannotPassThroughPieces() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][3] = new Queen("White");
        board.board[0][4] = new Pawn("White");
        assertFalse(board.moveToPosition(0, 3, 0, 7));
    }

    // King Cannot Pass Through Pieces Test (though it only moves one square)
    @Test
    public void testKingCannotPassThroughPieces() {
        ChessBoard board = new ChessBoard("White");
        board.board[0][4] = new King("White");
        board.board[0][5] = new Pawn("White");
        assertFalse(board.moveToPosition(0, 4, 0, 6));
    }
}