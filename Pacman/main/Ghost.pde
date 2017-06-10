import java.util.ArrayDeque;
import java.util.Random;
class Ghost {

  PImage img;
  public int x;
  public int y;
  public ArrayDeque<Mnode> moves;
  public boolean edible;
  public String which;
  public int[][] possible = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
  public int time;
  public int speed;
  Mnode pos;

  public Ghost(String shade) {
    img = loadImage(shade+".png"); //(shade+".gif");
    shade = which;
    moves = new ArrayDeque<Mnode>();
    time = 0;
    speed = 2;
    edible = true;
  }

  public Ghost(String shade, Mnode start) {
    this(shade);
    moves = new ArrayDeque<Mnode>();
    moves.addFirst(start);
    //which = name;
  }

  void start(Mnode first) {
    moves.add(first);
  }

  void display() {
    if (moves.size() > 1) {
      pos = moves.removeFirst();
    } 
    x = moves.peek().row;
    y = moves.peek().col;
    if (edible) {
      imageMode(CENTER);
      image(img, moves.peek().x, moves.peek().y, (img.width * .4)/2, (img.height * .4)/2);
    } else {
      tint(0, 153, 204);  // Tint blue
      image(img, moves.peek().x, moves.peek().y, (img.width * .4)/2, (img.height * .4)/2);
      noTint();
    }
    if (time%10 == 0) {
      update();
    }
    time++;
  }

  void update() {
    ArrayList<int[]> list = new ArrayList<int[]>();
    boolean tried = true;
    Random rnd = new Random();
    int randomNumberFromArray = rnd.nextInt(4);
    while (tried) {
      int rand = rnd.nextInt(4);
      int [] move = new int[2];
      move = possible[rand];
      try {
        //System.out.println(moves.peek().row+":"+moves.peek().col);
        int r = moves.peek().row + move[0];
        int c = moves.peek().col + move[1];
        if (map[r][c].walkable == true) {
          tried = false;
          moves = Mnode.calculate(moves.peek(), map[r][c], speed);
        } else {
          throw new IndexOutOfBoundsException();
        }
      }
      catch (IndexOutOfBoundsException e) {
        tried = true;
      }
    }
  }

  // public Mnode nextSpot(){
  //decide where to go for the next spot, so that in the main.pde file, you can be like if [ghost].moves.size() == 1, [ghost].moves = calculate([ghost].moves.peek(), [ghost].next(), 6)
  //}
}