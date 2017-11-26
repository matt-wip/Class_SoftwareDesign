import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Contains members to track and update the state of of RotatorView
 * @author Matt Wipfler
 */
public class RotatorControllerModel {

    /** View component of application*/
    private RotatorView gui;
    /** Timer to adjust for rotating image*/
    private Timer timer;

    public RotatorControllerModel(RotatorView gui){
        this.gui = gui;
        this.gui.AddCheckBoxListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JCheckBox temp = (JCheckBox)e.getSource();
                if(temp != null){
                    gui.getjImageContainer().setRotateContinuously(temp.isSelected());
                    if(temp.isSelected()) {
                        timer.restart();
                        timer.start();
                    }
                    else
                        timer.stop();
                }
            }
        });
        this.gui.AddSliderListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider temp = (JSlider)e.getSource();
                if(temp == null) return;
                gui.getjImageContainer().setRotationValue(temp.getValue());
                updateImage();
            }
        });

        this.timer = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateImage();
            }
        });
    }

    /** Small helper method for rendering image*/
    private  void updateImage(){
        this.gui.getjImageContainer().repaint();
    }
}
