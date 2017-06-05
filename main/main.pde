Mnode[][] map;
void setup(){
  map= new Mnode[24][24];
  size(1024, 1024);
  background(loadImage("SmallerMap.jpg"));
  for (int x = 0, dx = 40; x < 24; x ++, dx += 41){
    for (int y = 0, dy = 40; y < 24; y ++, dy += 41){
      if ((x == 23) || (y == 23) || (x == 0) || (y == 0)){
        map[x][y] = new Mnode(dx, dy, false);
      } else {
        map[x][y] = new Mnode(dx, dy, true);
      }
    }
  }
  for (int x = 0; x < 24; x ++){
    for (int y = 0; y < 24; y ++){
      Mnode current = map[x][y];
      if (current.walkable){
        fill(255,0,0);
      } else {
        fill(0,255,0);
      }
      rect(current.x - 5, current.y - 5, 10, 10);
      System.out.print(current);
    }
    System.out.println();
  }
}

//void draw(){
  
//}