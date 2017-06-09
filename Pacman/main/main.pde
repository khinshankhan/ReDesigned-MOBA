import java.util.ArrayDeque;

Mnode[][] map;
ArrayDeque<Mnode> moves;
int dx, dy, d, animer, way, left;
int score;
Ghost red;
Ghost yellow;
Ghost blue;
Ghost pink;
PImage img;

//THIS IS THE "BOOLEAN" FOR BEING POWERED UP!!!
//I made it
int reallyobvious;
// totally feel free to change it

void setup() {
  left = 0;
  map= new Mnode[24][24];
  moves = new ArrayDeque<Mnode>();
  //size(1024, 1024);
  //background(loadImage("SmallerMap.jpg"));
  size(1200, 1024);
  img = loadImage("Map.jpg");
  background(img);
  for (int x = 0, dx = 40; x < 24; x ++, dx += 41) {
    for (int y = 0, dy = 50; y < 24; y ++, dy += 41) {
      map[x][y] = new Mnode(x, y, dx, dy, true);
      left += 1;
    }
  }
  map[1][1].walkable = false;
  map[1][2].walkable = false;
  map[1][3].walkable = false;
  map[1][4].walkable = false;
  map[1][6].walkable = false;
  map[1][7].walkable = false;
  map[1][8].walkable = false;
  map[1][9].walkable = false;
  map[1][10].walkable = false;
  map[1][13].walkable = false;
  map[1][14].walkable = false;
  map[1][15].walkable = false;
  map[1][16].walkable = false;
  map[1][17].walkable = false;
  map[1][19].walkable = false;
  map[1][20].walkable = false;
  map[1][21].walkable = false;
  map[1][22].walkable = false;
  map[2][1].walkable = false;
  map[2][22].walkable = false;
  map[3][1].walkable = false;
  map[3][3].walkable = false;
  map[3][4].walkable = false;
  map[3][5].walkable = false;
  map[3][6].walkable = false;
  map[3][7].walkable = false;
  map[3][8].walkable = false;
  map[3][9].walkable = false;
  map[3][10].walkable = false;
  map[3][13].walkable = false;
  map[3][14].walkable = false;
  map[3][15].walkable = false;
  map[3][16].walkable = false;
  map[3][17].walkable = false;
  map[3][18].walkable = false;
  map[3][19].walkable = false;
  map[3][20].walkable = false;
  map[3][22].walkable = false;
  map[4][1].walkable = false;
  map[4][3].walkable = false;
  map[4][20].walkable = false;
  map[4][22].walkable = false;
  map[5][3].walkable = false;
  map[5][5].walkable = false;
  map[5][6].walkable = false;
  map[5][7].walkable = false;
  map[5][8].walkable = false;
  map[5][10].walkable = false;
  map[5][11].walkable = false;
  map[5][12].walkable = false;
  map[5][13].walkable = false;
  map[5][15].walkable = false;
  map[5][16].walkable = false;
  map[5][17].walkable = false;
  map[5][18].walkable = false;
  map[5][20].walkable = false;
  map[6][1].walkable = false;
  map[6][3].walkable = false;
  map[6][5].walkable = false;
  map[6][18].walkable = false;
  map[6][20].walkable = false;
  map[6][22].walkable = false;
  map[7][1].walkable = false;
  map[7][3].walkable = false;
  map[7][5].walkable = false;
  map[7][7].walkable = false;
  map[7][8].walkable = false;
  map[7][9].walkable = false;
  map[7][10].walkable = false;
  map[7][13].walkable = false;
  map[7][14].walkable = false;
  map[7][15].walkable = false;
  map[7][16].walkable = false;
  map[7][18].walkable = false;
  map[7][20].walkable = false;
  map[7][22].walkable = false;
  map[8][1].walkable = false;
  map[8][3].walkable = false;
  map[8][5].walkable = false;
  map[8][7].walkable = false;
  map[8][16].walkable = false;
  map[8][18].walkable = false;
  map[8][20].walkable = false;
  map[8][22].walkable = false;
  map[9][1].walkable = false;
  map[9][3].walkable = false;
  map[9][7].walkable = false;
  map[9][10].walkable = false;
  map[9][11].walkable = false;
  map[9][12].walkable = false;
  map[9][13].walkable = false;
  map[9][16].walkable = false;
  map[9][20].walkable = false;
  map[9][22].walkable = false;
  map[10][1].walkable = false;
  map[10][3].walkable = false;
  map[10][5].walkable = false;
  map[10][7].walkable = false;
  map[10][10].walkable = false;
  map[10][13].walkable = false;
  map[10][16].walkable = false;
  map[10][18].walkable = false;
  map[10][20].walkable = false;
  map[10][22].walkable = false;
  map[11][5].walkable = false;
  map[11][13].walkable = false;
  map[11][18].walkable = false;
  map[22][1].walkable = false;
  map[22][2].walkable = false;
  map[22][3].walkable = false;
  map[22][4].walkable = false;
  map[22][6].walkable = false;
  map[22][7].walkable = false;
  map[22][8].walkable = false;
  map[22][9].walkable = false;
  map[22][10].walkable = false;
  map[22][13].walkable = false;
  map[22][14].walkable = false;
  map[22][15].walkable = false;
  map[22][16].walkable = false;
  map[22][17].walkable = false;
  map[22][19].walkable = false;
  map[22][20].walkable = false;
  map[22][21].walkable = false;
  map[22][22].walkable = false;
  map[21][1].walkable = false;
  map[21][22].walkable = false;
  map[20][1].walkable = false;
  map[20][3].walkable = false;
  map[20][4].walkable = false;
  map[20][5].walkable = false;
  map[20][6].walkable = false;
  map[20][7].walkable = false;
  map[20][8].walkable = false;
  map[20][9].walkable = false;
  map[20][10].walkable = false;
  map[20][13].walkable = false;
  map[20][14].walkable = false;
  map[20][15].walkable = false;
  map[20][16].walkable = false;
  map[20][17].walkable = false;
  map[20][18].walkable = false;
  map[20][19].walkable = false;
  map[20][20].walkable = false;
  map[20][22].walkable = false;
  map[19][1].walkable = false;
  map[19][3].walkable = false;
  map[19][20].walkable = false;
  map[19][22].walkable = false;
  map[18][3].walkable = false;
  map[18][5].walkable = false;
  map[18][6].walkable = false;
  map[18][7].walkable = false;
  map[18][8].walkable = false;
  map[18][10].walkable = false;
  map[18][11].walkable = false;
  map[18][12].walkable = false;
  map[18][13].walkable = false;
  map[18][15].walkable = false;
  map[18][16].walkable = false;
  map[18][17].walkable = false;
  map[18][18].walkable = false;
  map[18][20].walkable = false;
  map[17][1].walkable = false;
  map[17][3].walkable = false;
  map[17][5].walkable = false;
  map[17][18].walkable = false;
  map[17][20].walkable = false;
  map[17][22].walkable = false;
  map[16][1].walkable = false;
  map[16][3].walkable = false;
  map[16][5].walkable = false;
  map[16][7].walkable = false;
  map[16][8].walkable = false;
  map[16][9].walkable = false;
  map[16][10].walkable = false;
  map[16][13].walkable = false;
  map[16][14].walkable = false;
  map[16][15].walkable = false;
  map[16][16].walkable = false;
  map[16][18].walkable = false;
  map[16][20].walkable = false;
  map[16][22].walkable = false;
  map[15][1].walkable = false;
  map[15][3].walkable = false;
  map[15][5].walkable = false;
  map[15][7].walkable = false;
  map[15][16].walkable = false;
  map[15][18].walkable = false;
  map[15][20].walkable = false;
  map[15][22].walkable = false;
  map[14][1].walkable = false;
  map[14][3].walkable = false;
  map[14][7].walkable = false;
  map[14][10].walkable = false;
  map[14][11].walkable = false;
  map[14][12].walkable = false;
  map[14][13].walkable = false;
  map[14][16].walkable = false;
  map[14][20].walkable = false;
  map[14][22].walkable = false;
  map[13][1].walkable = false;
  map[13][3].walkable = false;
  map[13][5].walkable = false;
  map[13][7].walkable = false;
  map[13][10].walkable = false;
  map[13][13].walkable = false;
  map[13][16].walkable = false;
  map[13][18].walkable = false;
  map[13][20].walkable = false;
  map[13][22].walkable = false;
  map[12][5].walkable = false;
  map[12][13].walkable = false;
  map[12][18].walkable = false;
  for (int dax = 0; dax < 24; dax++) {
    for (int dyx = 0; dyx < 24; dyx++) {
      if (!(map[dax][dyx].walkable)) {
        map[dax][dyx].stepped = map[dax][dyx].occupado = true;
        left -= 1;
      }
    }
  }
  moves.addLast(map[0][0]);
  dx = 0;
  dy = 0;
  d = 0;
  animer = 0;
  way = 1;
  fill(255,255,255);
  map[0][23].has = new PowerUp(map[0][23], 0, 23);
  fill(255, 255, 0);
  red = new Ghost("red");
  red.start(map[10][12]);
  yellow = new Ghost("yellow");
  yellow.start(map[11][12]);
  blue = new Ghost("blue");
  blue.start(map[12][12]);
  pink = new Ghost("pink");
  pink.start(map[13][12]);
}

void draw() {
  if ((int)(Math.random() * 2000) == 42){
    int sax = (int)(24 * Math.random());
    int say = (int)(24 * Math.random());
    map[sax][say].has = new PowerUp(map[sax][say], sax, say);
  }
  //background(loadImage("SmallerMap.jpg"));
  background(loadImage("Map.jpg"));
  fill(255, 255, 255);
  textAlign(CENTER);
  textSize(30);
  text("" + score, 1100, 40);
  
  if(reallyobvious != 0){
    red.scared();
    yellow.scared();
    blue.scared();
    pink.scared();
  }
  if(reallyobvious != 0){
    red.unscared();
    yellow.unscared();
    blue.unscared();
    pink.unscared();
  }
  red.display();
  yellow.display();
  blue.display();
  pink.display();
  if (moves.size() > 1) {
    moves.removeFirst();
  } else {
    if (d != 0) {
      try {
        if (d == 1) {
          if (map[dx][dy - 1].walkable) {
            moves = Mnode.calculate(moves.peek(), map[dx][dy - 1], 6);
            dy -= 1;
          } else {
            d = 0;
          }
        }
        if (d == 2) {
          if (map[dx + 1][dy].walkable) {
            moves = Mnode.calculate(moves.peek(), map[dx + 1][dy], 6);
            dx += 1;
          } else {
            d = 0;
          }
        }
        if (d == 3) {
          if (map[dx][dy + 1].walkable) {
            moves = Mnode.calculate(moves.peek(), map[dx][dy + 1], 6);
            dy += 1;
          } else {
            d = 0;
          }
        }
        if (d == 4) {
          if (map[dx - 1][dy].walkable) {
            moves = Mnode.calculate(moves.peek(), map[dx - 1][dy], 6);
            dx -= 1;
          } else {
            d = 0;
          }
        }
      }
      catch (IndexOutOfBoundsException e) {
        d = 0;
      }
    }
    if (!(map[(moves.peek().x - 40) / 41][(moves.peek().y - 50) / 41].stepped)) {
      map[(moves.peek().x - 40) / 41][(moves.peek().y - 50) / 41].stepped = true;
      left -= 1;
    }
    if (null != map[(moves.peek().x - 40) / 41][(moves.peek().y - 50) / 41].has) {
      reallyobvious = 101;
      map[(moves.peek().x - 40) / 41][(moves.peek().y - 50) / 41].has = null;
    }
    if (reallyobvious > 0){
      reallyobvious -= 1;
      System.out.println(reallyobvious);
    }
    if (animer == 0) {
      imageMode(CENTER);
      ellipse(moves.peek().x, moves.peek().y, 40, 40);
    } else {
      if ( d == 0) {
        PImage pac = loadImage(animer + ".png");
        image(pac, moves.peek().x, moves.peek().y);
        //image(pac, moves.peek().x - 20, moves.peek().y - 20);
      } else {
        PImage pac = loadImage(animer + (12 * (d - 1)) + ".png");
        image(pac, moves.peek().x, moves.peek().y);
        //image(pac, moves.peek().x - 20, moves.peek().y - 20);
      }
    }
    if (animer == 0) {
      animer = 2;
      way = 2;
    } else {
      if (animer == 12) {
        animer = 10;
        way = -2;
      } else {
        animer += way;
      }
    }
  }
  for (int x = 0; x < 24; x ++) {
    for (int y = 0; y < 24; y ++) {
      Mnode cur = map[x][y];
      fill(255, 255, 255);
      if (cur.stepped) {
      } else {
        rect(cur.x - 5, cur.y - 5, 10, 10);
      }
      if (null != cur.has){
        ellipse(cur.x, cur.y, 21, 21);
      }
      fill(255, 255, 0);
    }
  }
  if (left == 0) {
    clear();
  }
}

void keyPressed() {
  println(mouseX +"," + mouseY);
  if (key == CODED) {
    if (keyCode == LEFT) {
      d = 4;
    }
    if (keyCode == RIGHT) {
      d = 2;
    }
    if (keyCode == UP) {
      d = 1;
    }
    if (keyCode == DOWN) {
      d = 3;
    }
  }
}