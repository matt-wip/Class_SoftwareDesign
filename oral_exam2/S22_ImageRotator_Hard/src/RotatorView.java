import com.sun.javafx.iio.ImageStorage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Graphical interface for application
 * @author Matt Wipfler
 */
public class RotatorView extends JFrame{

    // Private members
    /** Slider to adjust rotation or speed of rotation*/
    private final JSlider jSliderSpeed;
    /** Check box to adjust behavior of slider*/
    private final JCheckBox jCheckBoxSpinConst;
    /** Container for image*/
    private ImageLabel jImageContainer;
    //https://docs.oracle.com/javase/7/docs/api/java/awt/image/BufferedImage.html

    // Accessors

    /**
     * Accessor
     * @return Reference to ImageLabel field
     */
    public ImageLabel getjImageContainer() {
        return jImageContainer;
    }

    /** Constructor*/
    public RotatorView(){
        // Set main window options
        super("Rotate Image");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null);

        // Initialize members
        jCheckBoxSpinConst = new JCheckBox("Spin constantly");
        jCheckBoxSpinConst.setSize(50,20);
        jCheckBoxSpinConst.setSelected(false);

        BufferedImage jImage = null;
        try{
            jImage = ImageIO.read(getClass().getResource("matrix_in.jpg"));
        }
        catch (IOException e){
            System.out.println("Error finding image: " + e.getMessage());
        }
        jImageContainer = new ImageLabel(jImage);
        jImageContainer.setSize(50,50);

        jSliderSpeed = new JSlider();
        jSliderSpeed.setMinimum(0);
        jSliderSpeed.setMaximum(100);
        jSliderSpeed.setValue(0);

        // Add members to frames
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(jImageContainer);
        mainPanel.add(jSliderSpeed);
        mainPanel.add(jCheckBoxSpinConst);

        this.getContentPane().add(mainPanel);
        this.setVisible(true);
    }

    /** Method to add listener to slider
     * @param list Listener to add to slide*/
    public void AddSliderListener(ChangeListener list){
        jSliderSpeed.addChangeListener(list);
    }
    /** Method to add listener to checkbox
     * @param list Listener to add to checkbox*/
    public void AddCheckBoxListener(ActionListener list){
        jCheckBoxSpinConst.addActionListener(list);
    }

}
