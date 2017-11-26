import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/** Custom class for creating a label with an image within it
 * @author Matt Wipfler
 */
public class ImageLabel extends JLabel{

    // Private members
    /** Image instance of label*/
    private BufferedImage image = null;
    /** Field to track behavior of label.*/
    private boolean rotateContinuously;
    /** Field to track current value between 0 and 100.*/
    private int rotationValue;
    /** Past rotation value. in radians*/
    private double pastRotation;

    //Accessors
    /**Accessor to set rotate continuously
     * @param rotateContinuously Boolean for rotating. True to rotate continuously*/
    public void setRotateContinuously(boolean rotateContinuously) {
        this.rotateContinuously = rotateContinuously;
    }
    /**Accessor to set rotationValue
     * @param rotationValue Value to base rotation amount and speed off of*/
    public void setRotationValue(int rotationValue){
        this.rotationValue = rotationValue;
    }
    //Base framework: https://stackoverflow.com/questions/4918482/rotating-bufferedimage-instances
    /** Constructor of class
     * @param image Icon for label
     */
    public ImageLabel(BufferedImage image){
        super(new ImageIcon(image));
        this.image = image;
        this.rotateContinuously = false;
        this.rotationValue = 0;
        this.pastRotation = 0;
    }

    /**
     * Override to render image on screen. Can rotate continuously or separately
     * @param graphics standard graphics
     */
    @Override
    public void paintComponent(Graphics graphics){
        //super.paintComponent(graphics);
        if(image == null) return;

        Graphics2D graphics2D = (Graphics2D)graphics;
        AffineTransform transform = graphics2D.getTransform();
        transform.translate(getWidth()/2,getHeight()/2);
        // Rotate continuously
        double rotation;
        if(rotateContinuously){
            this.pastRotation += this.rotationValue*0.005;
            if(this.pastRotation > 7.0){
                this.pastRotation -= 2.0*Math.PI;
            }
            transform.rotate(this.pastRotation);
        }
        else { //rotate a little
            this.pastRotation = Math.PI*(this.rotationValue*0.02);
            transform.rotate(this.pastRotation);
        }

        // source of inspiration: https://stackoverflow.com/questions/4918482/rotating-bufferedimage-instances
        transform.scale(0.6,0.6);
        transform.translate(-image.getWidth()/2,-image.getHeight()/2);

        graphics2D.drawImage(image,transform,null);
    }
}
