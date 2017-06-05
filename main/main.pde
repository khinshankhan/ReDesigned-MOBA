Mnode[][] map;
void setup(){
  map= new Mnode[24][12];
  size(1024, 1024);
  background(loadImage("SmallerMap.jpg"));
  for (int x = 0, dx = 1004; x < 24; x ++, dx -= 41){
    for (int y = 0, dy = 1004 - (40 * (x % 2)) ; y < 12; y ++, dy -= 80){
      if ((x == 0) || ((y == 0) && (x % 2 == 0))){
        map[x][y] = new Mnode(dx, dy, false);
      } else {
        map[x][y] = new Mnode(dx, dy, true);
      }
    }
  }
  for (int x = 0; x < 24; x ++){
    for (int y = 0; y < 12; y ++){
      Mnode current = map[x][y];
      if (current.walkable){
        fill(255,0,0);
      } else {
        fill(0,255,0);
      }
      rect(current.x - 5, current.y - 5, 10, 10);
    }
  }
}

//void draw(){
  
//}