Design a chess game using OO principles | Runhe Tian Coding Practice

http://k2code.blogspot.com/2014/03/design-chess-game-using-oo-principles.html
http://swcodes.blogspot.in/2012/09/chess-game-design.html

public enum PieceType {

    None, Pawn, Knight, Bishop, Rook, Queen, King

}


public enum PieceColor {

    White, Black

}


public struct Piece {

    public PieceType Type { get; set; }

    public PieceColor Color { get; set; }

}

public class Square {

    public int X { get; set; }

    public int Y { get; set; }

}

Finally we have to compose Move, board and finally game : 


public class Board {

    private Square[][] squareSet;


    public Piece[][] pieceSet { get; set; }


    public Board Clone() { ... }

}


public class Move {

    public Square From { get; }

    public Square To { get; }

    public Piece PieceMoved { get; }

    public Piece PieceCaptured { get; }

    public PieceType Promotion { get; }

    public string AlgebraicNotation { get; }

}


public class Game {

    public Board Board { get; }

    public List<Move> Movelist { get; }

    public PieceType Turn { get; set; }

    public Square DoublePawnPush { get; set; } // Used for tracking valid en passant captures

    public int Halfmoves { get; set; }

  

 Player p1,p2;


    public bool CanWhiteCastleA { get; set; }

    public bool CanWhiteCastleH { get; set; }

    public bool CanBlackCastleA { get; set; }

    public bool CanBlackCastleH { get; set; }

  

 //methods

 private void createAndPlacePieces(){

 //generate pieces using a factory method

   //for e.g. config[1][0] = PieceFactory("Pawn",color);

 }

  

 private void setTurn(color) {

  turn = color;

  currentPlayer = (turn==black)?p2 : p1;

 }

  

 private void Play()

 {

  while(CheckStatus!=GameOver)

  {

    changeTurn(); // calls movePiece on the Piece object    


  }

 }

  

}


public interface IGameRules {

    // ....

}
The basic idea is that Game/Board/etc simply store the state of the game. You can manipulate them to e.g. set up a position, if that's what you want. I have a class that implements my IGameRules interface that is responsible for:
Determining what moves are valid, including castling and en passant.
Determining if a specific move is valid.
Determining when players are in check/checkmate/stalemate.
Executing moves.
Separating the rules from the game/board classes also means you can implement variants relatively easily. All methods of the rules interface take a Game object which they can inspect to determine which moves are valid.
Note that I do not store player information on Game. I have a separate class Table that is responsible for storing game metadata such as who was playing, when the game took place, etc.
http://swcodes.blogspot.in/2012/09/chess-game-design.html



Board

A Board class has an attribute of Squares Array (8x8) and PieceSets (black and white).

A Board class also has an attribute of "pieceSetOnTop". The attribute helps to figure the piece moves that are direction-restricted.


PieceSets

A PieceSet class has an attribute of a List<Piece>. The size of the List<Piece> is initially set to 16.

A Piece class has two attributes: color and placeAt (i.e. located at which square).

A Piece class is an abstract class. The extended classes (Pawn, King, Queen, Rook, Knight, Bishop) implements the abstracted operations:
validMoves() - The valid movement for a Piece
attackSquares() - The squares that a Piece can attack
captureFreeMove - The squares that a Piece can move to without being captured. 
toBeCaptured() - The boolean indicates whether a Piece is going to be captured.

The validMoves() operation implements the movement rules. For example, the validMoves of a Pawn class ensures that the Pawn can only move in the direction towards the opponent side. A Pawn class has additional attributes of promoted and promotedTo, which describes the movement/conversion rule of a Pawn at reaching the end of an opponent side and at the conversion about the piece that a Pawn converted to.

Game

A Game class controls the flow of a game. The class has attributes:
playedMoves - Keep a record of moves
turn - Indicate either it is a Black's turn or a White's turn
players - Represent the two players, this can be Human/Human, Computer/Computer or Human/Computer
result - Indicate the result of a game
checkStatus - Indicate which side is being checked or checkmated

Player

A Player class represents a Player. A Player has two attributes:
pieceColor - The color that used by a Player
engine - The engine that makes the moves. This can be a human or a computer
Design a chess game using OO principles | Runhe Tian Coding Practice
Design a chess game using object oriented principles.

public class ChessPieceTurn {

};


public class GameManager {

    void processTurn(PlayerBase player) {

    };


    boolean acceptTurn(ChessPieceTurn turn) {

        return true;

    };


    Position currentPosition;

}


public abstract class PlayerBase {

    public abstract ChessPieceTurn getTurn(Position p);

}


class ComputerPlayer extends PlayerBase {

    @Override

    public ChessPieceTurn getTurn(Position p) {

        return null;

    }


    public void setDifficulty() {

    };


    public PositionEstimator estimater;

    public PositionBackTracker backtracter;

}


public class HumanPlayer extends PlayerBase {

    @Override

    public ChessPieceTurn getTurn(Position p) {

        return null;

    }

}


public abstract class ChessPieceBase {

    abstract boolean canBeChecked();


    abstract boolean isSupportCastle();

}


public class King extends ChessPieceBase {


    @Override

    boolean canBeChecked() {

        // TODO Auto-generated method stub

        return false;

    }


    @Override

    boolean isSupportCastle() {

        // TODO Auto-generated method stub

        return false;

    }

}


public class Queen extends ChessPieceBase {


    @Override

    boolean canBeChecked() {

        // TODO Auto-generated method stub

        return false;

    }


    @Override

    boolean isSupportCastle() {

        // TODO Auto-generated method stub

        return false;

    }

}


public class Position { // represents chess positions in compact form

    ArrayList<ChessPieceBase> black;


    ArrayList<ChessPieceBase> white;

}


public class PositionBackTracker {

    public Position getNext(Position p) {

        return null;

    }

}


public class PositionEstimator {

    public PositionPotentialValue estimate(Position p) {

        return null;

    }

}


public abstract class PositionPotentialValue {

    abstract boolean lessThan(PositionPotentialValue pv);

}

https://xmruibi.gitbooks.io/interview-preparation-notes/content/OOD/DesignExamples/ChessGame.html
Player chooses piece to move through the board.
Piece makes legal move according to its own move rules.
.
If player captures a piece, remove the piece.
If the piece is a pawn reaching the back rank, promote it.
If the move is a castling, set the new position of the rook accordingly. But a king and rook can only castle if they haven't moved, so you need to keep track of that. And if the king moves through a check to castle, that's disallowed, too.
If the move results in a stalemate or checkmate, the game is over.

Basic Object Design
Game:
Contains the Board and 2 Players
Commands List (for history tracking)
Board (Singleton):
Hold spots with 8*8
Initialize the piece when game start
Move Piece
Remove Piece
Spot:
Hold Pieces
Piece (Abstract):
Hold the color to represent the affiliation.
Extended by concreted classes with 8 Pawns, 2 Rooks, 2 Bishops, 2 Knights, 1 Queen, 1 King
Concreted classes define the detail step approach
Player (Abstract):
Has a list of piece reference it owns.
Concreted classes for Human and Computer players
Command
Piece
Destination x, y


Game:
public class Game{
    final static Board board;
    Player p1;
    Player p2;

    public Game() {
        board = new Board();
    }

    public boolean enterPlayer(Player p) {
        if(p1 == null)
            this.p1 = p;
        else if(p2 == null)
            this.p2 = p;
        else
            return false;

        board.initialize(p);
        return true;
    }

    public void processTurn(Player p) {
        // Player make a command and until it is valid
        // System input
        do{
            Command cmd = new Command(input);
            p.addCommand(cmd);
        }while(!board.executeMove(p));
    }

    public startGame(){
        // player enter the game:
        enterPlayer(new ComputerPlayer("Computer"));
        enterPlayer(new HumanPlayer("Bill"));

        while(true) {
            processTurn(p1);
            if(this.board.getWin()) {
                System.out.println("P1 win!");
                break;
            }
            processTurn(p2);
            if(this.board.getWin()) {
                System.out.println("P2 win!");
                break;
            }
        }
    }
}
Board:
public class Board{

    private Spot[][] spots;
    private boolean win; // mark the win or not

    public Board(){
        win = false;
        spots = new Spot[8][8];
    }

    public void initialize(Player p){
        // put the pieces with initial status
        for(int i=0; i<p.getPieces().size(); i++){
            spots[p.getPieces().get(i).getX()][p.getPieces().get(i).getY()].occupySpot(p.getPieces().get(i));
        }
    }

    public boolean executeMove(Player p) {
        Command cmd = p.getCurrentCmd();
        Piece piece = cmd.getPiece();

        // check the move step is valid for piece
        if(!piece.validMove(this, cmd.curX, cmd.curY, cmd.desX, cmd.desY)) {
            // if not valid cmd remove the command and return false
            p.removeCurrentCmd();
            return false;
        }

        // check the two pieces side
        if(spot[cmd.desX][cmd.desY] != null && spot[cmd.desX][cmd.desY].color == piece.color)
            return false;

        // check and change the state on spot
        Piece taken = spot[cmd.desX][cmd.desY].occupySpot(piece);
        if(taken != null &&taken.getClass().getName().equals("King"))
            board.win = true;
        spot[cmd.curX][cmd.curY].releaseSpot;
        return true;
    }

    public boolean getWin() {
        return win;
    }
}
Spot:
public class Spot {
    int x;
    int y;
    Piece piece;

    public Spot(int x, int y) {
        super();
        this.x = x;
        this.y = y;
        piece = null;
    }

    // return original piece
    public void occupySpot(Piece piece){
        Piece origin = this.piece;
        //if piece already here, delete it, i. e. set it dead
        if(this.piece != null) {
            this.piece.setAvailable(false);
        }
        //place piece here
        this.piece = piece;
        return origin;
    }

    public boolean isOccupied() {
        if(piece != null)
            return true;
        return false;
    }

    public Piece releaseSpot() {
        Piece releasedPiece = this.piece;
        this.piece = null;
        return releasedPiece;
    }

    public Piece getPiece() {
        return this.piece;
    }
}
Pieces:
public class Piece {
    private int x;
    private int y;

    private boolean available; // mark the live or dead
    private int color; // mark the owner

    public Piece(boolean available, int x, int y, int color) {
        super();
        this.available = available;
        this.x = x;
        this.y = y;
        this.color = color;
    }


    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY){
        // different by character of piece
    }

}

public class King extends Piece{ 
    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
    }    
}
// ..... for Queen, Rook, Bishop, Pawn
Player:
public class Player {

    public int color;

    private List<Piece> pieces = new ArrayList<>();

    private List<Command> cmds = new ArrayList<>();

    public Player(int color) {
        super();
        this.color = color;
        initializePieces();
    }

    public List<Piece> getPieces() {
        return pieces;
    }


    public void initializePieces(){
        if(this.color == 1){
            for(int i=0; i<8; i++){ // draw pawns
                pieces.add(new Pawn(true,i,2, 1));
            }
            pieces.add(new Rook(true, 0, 0, 1));
            pieces.add(new Rook(true, 7, 0, 1));
            pieces.add(new Bishop(true, 2, 0, 1));
            pieces.add(new Bishop(true, 5, 0, 1));
            pieces.add(new Knight(true, 1, 0, 1));
            pieces.add(new Knight(true, 6, 0, 1));
            pieces.add(new Queen(true, 3, 0, 1));
            pieces.add(new King(true, 4, 0, 1));
        }
        else{
            for(int i=0; i<8; i++){ // draw pawns
                pieces.add(new Pawn(true,i,6, 0));
            }
            pieces.add(new Rook(true, 0, 7, 0));
            pieces.add(new Rook(true, 7, 7, 0));
            pieces.add(new Bishop(true, 2, 7, 0));
            pieces.add(new Bishop(true, 5, 7, 0));
            pieces.add(new Knight(true, 1, 7, 0));
            pieces.add(new Knight(true, 6, 7, 0));
            pieces.add(new Queen(true, 3, 7, 0));
            pieces.add(new King(true, 4, 7, 0));
        }

    }
}
Command
public class Command {
    Piece piece;
    int curX, curY, desX, desY;
    public Commanc(Piece piece, int curX, int curY, int desX, int desY) {
        this.piece = piece; 
        this.curX = curX;
        this.curY = curY;
        this.desX = desX;
        this.desY = desY;
    }
}
https://www.nowtoshare.com/zh/Article/Index/70566

Read full article from Design a chess game using OO principles | Runhe Tian Coding Practice
