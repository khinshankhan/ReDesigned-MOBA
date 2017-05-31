import java.awt.image.PixelGrabber;
import java.awt.Toolkit;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

int dx, dy, screenwidth, screenheight;
BufferedImage Rift;


//StackOverFlow taught how to input stream

void setup() {
  //try{
    //System.out.println(new File("Rift.jpg").getPath());
    //File RiftFile = new File("Rifts/Rift.png");
    //Rift = ImageIO.read(RiftFile);
    //InputStream in = getClass().getResourceAsStream("Rift.png");
    //Rift = ImageIO.read(in);
//} catch (IOException e){
    //System.err.println(e);
    //System.out.println("Error during reading Rift.");
    //System.exit(0);
  //}
  dx = 683;
  dy = 384;
  screenwidth = 1366;
  screenheight = 768;
  size(1366, 768);
  //background(loadImagex("Rift.png"));
  background(loadImage(makeBackground()));
  //background(image(makeBackground(),0,0));
}

void draw() {
  background(loadImage(makeBackground()));
  //background(image(makeBackground(),0,0));
  //background(loadImagex("Rift.png"));
  System.out.println(dx + "," + dy);
  System.out.println(mouseX + "," + mouseY);
}

/*PImage makeBackground(){
  BufferedImage sub = Rift.getSubimage(dx - 683, dy - 384, 1366, 768);
  PImage img = new PImage(sub);
  return img;
}*/

String makeBackground(){
  File temp = new File("temp.png");
  BufferedImage sub = Rift.getSubimage(dx - 683, dy - 384, 1366, 768);
  try{
    ImageIO.write(sub, "png", temp);
  } catch (IOException e){
    System.err.println(e);
    System.out.println("Can't make Rift.");
    System.exit(0);
  }
  return "temp.png";
}


//dx uses picture |width - 683|
//dy uses picture |height - 384|
//2402 - 683 = 1719
//2363 - 384 = 1979
//4096 - 683 = 3413
//4096 - 384 = 3712
void mouseMoved() {
  if (dx > 384 && mouseX < 50){
    dx -= 10;
    if (dx < 384){
      dx = 384;
    }
  }
  if (dx < 3413 && mouseX > 1316){
    dx += 10;
    if (dx > 3413){
      dx = 3413;
    }
  }
  if (dy > 683 && mouseY < 50){
    dy -= 10;
    if (dy < 683){
      dy = 683;
    }
  }
  if (dy < 3712 && mouseY > 718){
    dy += 10;
    if (dy > 3712){
      dy = 3712;
    }
  }
}

//from https://forum.processing.org/one/topic/snippet-crazy-fast-image-loading.html
PImage loadImagex(String inFile){
  //http://www.java-tips.org/java-se-tips/java.awt.image/how-to-use-pixelgrabber-class-to-acquire-pixel-data-from-an-image-o.html
  Image image = Toolkit.getDefaultToolkit().getImage(inFile); 
  int [] data= new int [1];
  PImage retval = createImage(1,1,ARGB);
  try {
    PixelGrabber grabber = new PixelGrabber(image, dy, dy, 1366, 768, false);
    if (grabber.grabPixels()) {
      int w = grabber.getWidth();
      int h = grabber.getHeight();
      retval = createImage(w,h,ARGB);
      if (isGreyscaleImage(grabber)) {
        byte[] datax = (byte[]) grabber.getPixels();
          arraycopy(datax,retval.pixels);
        // Process greyscale image ...
      }
      else {
        data = (int[]) grabber.getPixels();
        arraycopy(data,retval.pixels);
        //arraycopy(data,pixels);
        // Process Color image
      }
    }
  }
  catch (InterruptedException e1) {
    e1.printStackTrace();
  }
  return retval; 
}

public static final boolean isGreyscaleImage(PixelGrabber pg) {
  return pg.getPixels() instanceof byte[];
}