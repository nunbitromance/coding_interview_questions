/*

 Draw a line on 2D array of boolean. You will be given start point and end point co-ordinates.
 
 */
 
 public void draw(boolean[][] map, int x1, int y1, int x2, int y2) {       
      double m = ((double) y1 - y0) / (x1 - x0);
      double y = y0;
      for(int x = x0 + 1; x <= x1; x++){
        arr[(int) Math.round(y)][x] = true;
        y += m;
      }
 }
