/*
http://www.geeksforgeeks.org/google-mountain-view-interview/
Design two player battleship game to be played over internet
*/
public class GameService {

        private Player player1;
        private Player player2;
        private Board board;
        private boolean isGameOver = false;
        private int curPlayerId = 1;
        
        public GameService() {
          createPlayers();
          createBoard();
          createShips();
          this.start();
        }
        
        public void start() {
          while (!isGameOver) {
              signalPlayer(curPlayerId);
              updatePlayers(player1, player2);
              changeTurn();
           }
           showWinner();
        }
        
        public Result shoot(int playerId, int x, int y) {
        }
        
        public Result move(int playerId, int shipId, int x, int y) {
        }
        
        private void changeTurn() {
          curPlayerId = curPlayerId == 1 ? 2 : 1;
        }
}

public class Player {
        private Board board;
        private List<Ship> ships;
        private int playerId;
        
        public boolean shoot(int x, int y) {
            for (Ship s : board.getShips()) {
               if (s.isHit(this, x, y)) {
                 s.updateStatus(STATUS.DEAD);
                 return true;
               }
            }
            return false;
        }
        
        public boolean move(int x, int 
}

public class Board {
        private List<Ship> ships;
        private int width;
        private int length;
}

public class Ship {
        private Player player;
        private int x;
        private int y;
        private Direction direction;
        private length;
        private Status status;
        
        public boolean isHit(Player p, int x, int y) {
           if (player != p) {
              switch (this.direction) {
                 case Direction.UP:
                    return (this.x == x && this.y >= y && this.y - length <= y);
                    break;
                    
                 case Direction.RIGHT:
                    return (this.y == y && this.x - length >= x && this.x < x);
                    break;
                    
                 ...
                 
                 default:
                    return false;
              }
           }
           return false;
        }
}

public enum Status {
        ACTIVE = 0,
        DEAD = 1;
}

public enum Direction {
        UP = 0,
        DOWN = 1,
        LEFT = 2,
        RIGHT = 3;
}

public class Result {
        int status;
}
