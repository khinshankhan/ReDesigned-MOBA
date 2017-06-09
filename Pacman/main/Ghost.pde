import java.util.ArrayDeque;
class Ghost {

  PImage img;
  public int x;
  public int y;
  public ArrayDeque<Mnode> moves;
  public boolean edible;
  public String which;
  public int[][] possible = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };

  public Ghost(String shade) {
    img = loadImage(shade+".png"); //(shade+".gif");
  }

  public Ghost(String shade, Mnode start, String name) {
    this(shade);
    //x = start.dx;
    //y = start.dy;
    moves = new ArrayDeque<Mnode>();
    moves.addFirst(start);
    which = name;
  }
  void display() {
    //stroke(0);
    if (!edible) {
      imageMode(CENTER);
      image(img, x, y, img.width * .4, img.height * .4);
    } else {
      scared();
    }
  }
  void update() {
    boolean tried = true;
    for (int[] move : possible) {
      if (tried) {
        try {
          int r = x + move[0];
          int c = y + move[1];
          if (map[r][c].walkable == true) {
            tried = false;
            moves = Mnode.calculate(moves.peek(), map[r][c], 6);
          }
        }
        catch (IndexOutOfBoundsException e) {
          tried = true;
        }
      }
    }
  }

  void scared() {
    edible = false;
    tint(0, 153, 204);  // Tint blue
    image(img, x, y, img.width * .4, img.height * .4);
  }

  // public Mnode nextSpot(){
  //decide where to go for the next spot, so that in the main.pde file, you can be like if [ghost].moves.size() == 1, [ghost].moves = calculate([ghost].moves.peek(), [ghost].next(), 6)
  //}
}