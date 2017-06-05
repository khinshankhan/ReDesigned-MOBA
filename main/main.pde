import java.util.ArrayDeque;

Mnode[][] map;
ArrayDeque<Mnode> moves;

void setup() {
  map= new Mnode[24][24];
  moves = new ArrayDeque<Mnode>();
  size(1024, 1024);
  background(loadImage("SmallerMap.jpg"));
  for (int x = 0, dx = 40; x < 24; x ++, dx += 41) {
    for (int y = 0, dy = 50; y < 24; y ++, dy += 41) {
      if ((x == 23) || (y == 23) || (x == 0) || (y == 0)) {
        map[x][y] = new Mnode(dx, dy, false);
      } else {
        map[x][y] = new Mnode(dx, dy, true);
      }
    }
  }
  moves.addLast(map[0][23]);
  /*for (int x = 0; x < 24; x ++){
   for (int y = 0; y < 24; y ++){
   Mnode current = map[x][y];
   if (current.walkable){
   fill(255,0,0);
   } else {
   fill(0,255,0);
   }
   rect(current.x - 5, current.y - 5, 10, 10);
   }
   }
   fill(0,0,255)*/
}

void draw() {
  background(loadImage("SmallerMap.jpg"));
  for (int x = 0; x < 24; x ++) {
    for (int y = 0; y < 24; y ++) {
      Mnode current = map[x][y];
      if (current.walkable) {
        fill(255, 0, 0);
      } else {
        fill(0, 255, 0);
      }
      rect(current.x - 5, current.y - 5, 10, 10);
    }
  }
  fill(0, 0, 255);
  if (moves.size() > 1) {
    moves.removeFirst();
  }
  fill(0, 0, 255);
  rect(moves.peek().x - 5, moves.peek().y - 5, 10, 10);
}

void mouseClicked() {
  Mnode current = moves.peek();
  int x = ((mouseX - 40) / 41);// + (((mouseX - 40) % 41) / 20);
  int y = ((mouseY - 50) / 41);// + (((mouseX - 50) % 41) / 20);
  if ( (((current.x - 40) / 41) == x) && (((current.y - 40) / 41) == y) ){
    moves = Mnode.calculate(moves.peek(), new Mnode(mouseX, mouseY, true), 4);
  } else {
    moves = Mnode.calculate(moves.peek(), map[x][y], 4);
  }
}