import java.util.ArrayDeque;
import java.util.Iterator;

Solver path;
Mnode[][] map;
ArrayDeque<Mnode> moves;
int dx, dy;

void setup() {
  map= new Mnode[24][24];
  moves = new ArrayDeque<Mnode>();
  path = new Solver();
  size(1024, 1024);
  background(loadImage("SmallerMap.jpg"));
  for (int x = 0, dx = 40; x < 24; x ++, dx += 41) {
    for (int y = 0, dy = 50; y < 24; y ++, dy += 41) {
      //if ((x == 23) || (y == 23) || (x == 0) || (y == 0)) {
      //  map[x][y] = new Mnode(x, y, dx, dy, false);
      //} else {
        map[x][y] = new Mnode(x, y, dx, dy, true);
      //}
    }
  }
  //hardcode
  //i messed up the coordinates
  /*map[2][4].walkable = false;
  map[2][5].walkable = false;
  map[2][9].walkable = false;
  map[2][10].walkable = false;
  map[2][11].walkable = false;
  map[2][14].walkable = false;
  map[2][15].walkable = false;
  map[2][18].walkable = false;
  map[2][19].walkable = false;
  map[3][7].walkable = false;
  map[3][10].walkable = false;
  map[3][13].walkable = false;
  map[3][14].walkable = false;
  map[3][17].walkable = false;
  map[3][18].walkable = false;
  map[4][2].walkable = false;
  map[4][7].walkable = false;
  map[4][8].walkable = false;
  map[4][12].walkable = false;
  map[4][13].walkable = false;
  map[4][21].walkable = false;
  map[5][2].walkable = false;
  map[5][3].walkable = false;
  map[5][8].walkable = false;
  map[5][12].walkable = false;
  map[5][15].walkable = false;
  map[5][16].walkable = false;
  map[5][20].walkable = false;
  map[5][21].walkable = false;
  map[6][2].walkable = false;
  map[6][8].walkable = false;
  map[6][10].walkable = false;
  map[6][11].walkable = false;
  map[6][15].walkable = false;
  map[7][4].walkable = false;
  map[7][5].walkable = false;
  map[7][9].walkable = false;
  map[7][10].walkable = false;
  map[7][18].walkable = false;
  map[7][21].walkable = false;
  map[8][4].walkable = false;
  map[8][5].walkable = false;
  map[8][6].walkable = false;
  map[8][10].walkable = false;
  map[8][11].walkable = false;
  map[8][12].walkable = false;
  map[8][13].walkable = false;
  map[8][17].walkable = false;
  map[8][18].walkable = false;
  map[8][20].walkable = false;
  map[8][21].walkable = false;
  map[8][3].walkable = false;
  map[9][2].walkable = false;
  map[9][4].walkable = false;
  map[9][5].walkable = false;
  map[9][7].walkable = false;
  map[9][11].walkable = false;
  map[9][12].walkable = false;
  map[9][19].walkable = false;
  map[9][20].walkable = false;
  map[10][2].walkable = false;
  map[10][3].walkable = false;
  map[10][6].walkable = false;
  map[10][7].walkable = false;
  map[10][8].walkable = false;
  map[10][15].walkable = false;
  map[10][16].walkable = false;
  map[10][18].walkable = false;
  map[10][19].walkable = false;
  map[11][2].walkable = false;
  map[11][3].walkable = false;
  map[11][6].walkable = false;
  map[11][7].walkable = false;
  map[11][8].walkable = false;
  map[11][9].walkable = false;
  map[11][14].walkable = false;
  map[11][15].walkable = false;
  map[11][18].walkable = false;
  map[11][21].walkable = false;
  map[12][2].walkable = false;
  map[12][5].walkable = false;
  map[12][8].walkable = false;
  map[12][9].walkable = false;
  map[12][14].walkable = false;
  map[12][15].walkable = false;
  map[12][20].walkable = false;
  map[12][21].walkable = false;
  map[21][19].walkable = false;
  map[21][18].walkable = false;
  map[21][14].walkable = false;
  map[21][13].walkable = false;
  map[21][12].walkable = false;
  map[21][9].walkable = false;
  map[21][8].walkable = false;
  map[21][5].walkable = false;
  map[21][4].walkable = false;
  map[20][19].walkable = false;
  map[20][18].walkable = false;
  map[20][16].walkable = false;
  map[20][13].walkable = false;
  map[20][10].walkable = false;
  map[20][9].walkable = false;
  map[20][6].walkable = false;
  map[20][5].walkable = false;
  map[19][21].walkable = false;
  map[19][16].walkable = false;
  map[19][15].walkable = false;
  map[19][11].walkable = false;
  map[19][10].walkable = false;
  map[19][2].walkable = false;
  map[18][21].walkable = false;
  map[18][20].walkable = false;
  map[18][16].walkable = false;
  map[18][15].walkable = false;
  map[18][8].walkable = false;
  map[18][7].walkable = false;
  map[18][3].walkable = false;
  map[18][2].walkable = false;
  map[17][21].walkable = false;
  map[17][13].walkable = false;
  map[17][12].walkable = false;
  map[17][8].walkable = false;
  map[16][18].walkable = false;
  map[16][14].walkable = false;
  map[16][13].walkable = false;
  map[16][5].walkable = false;
  map[16][2].walkable = false;
  map[15][19].walkable = false;
  map[15][18].walkable = false;
  map[15][17].walkable = false;
  map[15][13].walkable = false;
  map[15][12].walkable = false;
  map[15][11].walkable = false;
  map[15][10].walkable = false;
  map[15][6].walkable = false;
  map[15][5].walkable = false;
  map[15][3].walkable = false;
  map[15][2].walkable = false;
  map[14][21].walkable = false;
  map[14][18].walkable = false;
  map[14][12].walkable = false;
  map[14][11].walkable = false;
  map[14][4].walkable = false;
  map[14][3].walkable = false;
  map[13][21].walkable = false;
  map[13][20].walkable = false;
  map[13][16].walkable = false;
  map[13][15].walkable = false;
  map[13][8].walkable = false;
  map[13][7].walkable = false;
  map[13][5].walkable = false;
  map[13][4].walkable = false;*/
  /*
  for(int i = 0; i < 24; i++){
   for(int j = 0; j < 24; j++){
   int a = (map[i][j].walkable == true) ? 1 : 0;
   System.out.print(a);
   }
   System.out.println();
   }*/
  for (int i = 0; i < map.length; i++) {
    for (int j = 0; j < map[0].length; j++) {
      System.out.print(map[i][j]+",");
    }
    System.out.println();
  }

  moves.addLast(map[0][23]);
  int dx = 0;
  int dy = 23;
  //System.out.println(map[0][0].row+","+map[0][0].col);
  /*/System.out.println(map[0][0].x+","+map[0][0].y);
   /Solver a = new Solver(moves.peek(), , map);
   System.out.println("Begin:");
   for(Iterator itr = lol.iterator();itr.hasNext();)  {
   System.out.println(itr.next()+",");
   }
   System.out.println("End!");*/
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
//SOMETHING HERE
/*
void mouseClicked() {
 Mnode current = moves.peek();
 //better calcs, might use later. need to discuess
 int x = ((mouseX - 40) / 41);// + (((mouseX - 40) % 41) / 20);
 int y = ((mouseY - 50) / 41);// + (((mouseX - 50) % 41) / 20);
 System.out.println(x+":"+y);
 System.out.println(moves.peek());
 
 //if ( (((current.x - 40) / 41) == x) && (((current.y - 40) / 41) == y) ){
 //  moves = Mnode.calculate(moves.peek(), new Mnode(mouseX, mouseY, true), 4);
 //} else {
 path = new Solver(moves.peek(), map[x][y], map);
 path.locations.addFirst(moves.peek());
 System.out.println("Begin:");
 for (Iterator itr = path.locations.iterator(); itr.hasNext(); ) {
 Mnode temp = (Mnode)itr.next();
 System.out.println(temp+":"+temp.x+","+temp.y);
 }
 System.out.println("End!");
 if (path.locations.size() > 0) {
 moves = Mnode.calculate(moves.peek(), path.locations.remove(), 4);
 }
 //}
 }
 */
void keyPressed()
{
  try {
    if (key == CODED)
    {
      if (keyCode == LEFT)
      {
        if (map[dx][dy-1].walkable == true)    moves = Mnode.calculate(moves.peek(), map[dx][dy-1], 8);
      }
      if (keyCode == RIGHT)
      {
        if (map[dx][dy+1].walkable == true)     moves = Mnode.calculate(moves.peek(), map[dx][dy+1], 8);
      }
      if (keyCode == UP)
      {
        if (map[dx+1][dy].walkable == true)    moves = Mnode.calculate(moves.peek(), map[dx+1][dy], 8);
      }
      if (keyCode == DOWN)
      {
        if (map[dx-1][dy].walkable == true)     moves = Mnode.calculate(moves.peek(), map[dx-1][dy], 8);
      }
    }
  }
  catch(IndexOutOfBoundsException e) {
  }
}