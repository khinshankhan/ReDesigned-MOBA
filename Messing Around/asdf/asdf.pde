float linNum, skNum = 150, lrNum = 25, lvNum = 7;
int score = 0, highScore = 0;
int a;
boolean switchIncrement;
int xpos, ypos;
int dx, dy;

void setup() {
  size(300, 168);
  //size(2048, 135);
  background(184, 58, 75 );
  a=9;
  switchIncrement= true;
}
void draw() {
  gui(a);
  if (a==500 || a==0) {
    switchIncrement= !switchIncrement;
  }
  if (switchIncrement) {
    a++;
  } else {
    a--;
  }
}
void gui(int x) {
  //background(184, 58, 75);
  PImage img;
  img = loadImage("map.png");
  //img = loadImage("mario.png");
  background(img);
  fill(255, 255, 255);
  textAlign(CENTER);
  textSize(30);
  text("" + score, width/2, 30);

  textSize(10);
  text("Num rn", 40, 15);
  textSize(15);
  text("" + a, 40, 30);
  fill(184,58,75);
  xpos+=dx;
  ypos+=dy;
  if(xpos<=0 || xpos>=300){
    dx*=-1;
  }
  if(ypos<=0 || ypos>=168){
    dy*=-1;
  }
  ellipse(xpos, ypos, 40, 40);

  //fill(20, 100, 120);
  //ect(0, 430, 500, 70);

  //fill(40, 190, 230);
  //rect(60, 440, 2 * 43, 50, 20);
  //fill(0,0,0);
  //ellipse(30, 465, 40, 40);
  println(mouseX +"," + mouseY);
}
void mouseClicked() {
  /*
  fill(255, 255, 255);
  textAlign(CENTER);
  textSize(2e0);
  text(("CLICKED"), 60, 15);
  */
  dy=dx+=5;
}
void mousePressed() {
  loadPixels();
  for (int i = 0; i < width*height; i++) {
    if (pixels[i] == 0xFF000000) {  // If it is red
      pixels[i] = 0xff00ff00;  // Make it green
      continue;  // Continue to avoid the next statement
    }
    if (pixels[i] == 0xff00ff00) pixels[i] = 0xffff0000; // Make green red
  }
  updatePixels();
}