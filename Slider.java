











import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Slider implements ChangeListener{

    JFrame frame;
    JPanel panel;
    JLabel label;
    JSlider slider;

    Slider(){

        frame = new JFrame("Brightness");
        panel = new JPanel();
        label = new JLabel();
        slider = new JSlider(0,19200,800);

        //frame.setFont(new Font("Headliner No. 45",Font.BOLD,30));

        slider.setPreferredSize(new Dimension(400,200));

        //slider.setPaintTicks(true);
        //slider.setMinorTickSpacing(800);
        //slider.setOrientation(SwingConstants.HORIZONTAL);

        slider.setPaintTrack(true);
        //slider.setMajorTickSpacing(1000);

        slider.setPaintLabels(true);
        slider.setFont(new Font("Headliner No. 45",Font.BOLD,15));
        label.setText("Brightness = "+ slider.getValue());

        slider.addChangeListener(this);

        panel.add(slider);
        panel.add(label);
        frame.add(panel);
        frame.setSize(420,420);
        frame.setVisible(true);


}


    @Override
    public void stateChanged(ChangeEvent e) {
        label.setText("Brightness = "+ slider.getValue());
    }


 public static void main(String[] args) throws IOException {
 Slider slider = new Slider();


        
        here:
        for(int i=1;i>=0;i++) {java.io.File file = new java.io.File("/sys/class/backlight/intel_backlight/brightness");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

            pw.println(slider.slider.getValue());
            pw.close();
            continue here;
        }


}
}

