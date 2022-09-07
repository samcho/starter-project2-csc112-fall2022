import java.io.*;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Flipped_Grayscale_Cats {
    public static void main(String[] args) {
        String filename = "CAT_00/00000001_000.jpg";
        File myFile = null;

        // image parameters
        BufferedImage  image;
        int width;
        int height;

        try {
            // open file
            myFile = new File(filename);

            // read in image data
            image = ImageIO.read(myFile);
            width = image.getWidth();
            height = image.getHeight();

            // sanity check to make sure it works
            System.out.println("width: " + image.getWidth());
            System.out.println("height: " + image.getHeight());

            for(int i=0; i<width; i++) {
                for(int j=0; j<height; j++) {

                    // get the individual RGB pixel data
                    Color c = new Color(image.getRGB(i, j));
                    // convert pixel into grayscale
                    int red = (int)(c.getRed() * 0.299);
                    int green = (int)(c.getGreen() * 0.587);
                    int blue = (int)(c.getBlue() *0.114);

                    // set the new image colors
                    Color newColor = new Color(red+green+blue, red+green+blue, red+green+blue);
                    image.setRGB(i,j,newColor.getRGB());
                }
            }

            // write out grayscale image
            File output = new File("grayscale.jpg");
            ImageIO.write(image, "jpg", output);
        } catch (Exception e) {
            System.err.println("Could not open input file.");
        }
    }
}
