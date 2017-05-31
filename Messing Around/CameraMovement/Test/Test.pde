import java.awt.image.PixelGrabber;
import java.awt.Toolkit;
import java.awt.Image;


PImage loadImagex(String inFile){
  //http://www.java-tips.org/java-se-tips/java.awt.image/how-to-use-pixelgrabber-class-to-acquire-pixel-data-from-an-image-o.html
  Image image = Toolkit.getDefaultToolkit().getImage(inFile); 
  int [] data= new int [1];
  PImage retval = createImage(1,1,ARGB);
  try {

    PixelGrabber grabber = 
      new PixelGrabber(image, dy, dy, 1366, 768, false);

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

void setup(){
  loadImagex("Rift.png");
}