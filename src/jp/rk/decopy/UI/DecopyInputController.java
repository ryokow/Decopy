package jp.rk.decopy.UI;

import jp.rk.decopy.ButtonID;
import jp.rk.decopy.content.ContentManager;
import java.awt.*;
import java.awt.event.*;

public class DecopyInputController implements ActionListener {

    public DecopyInputController(){}

    public void displayDecopyInputFrame(){
        DecopyInputFrame frame = new DecopyInputFrame();
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Decopy");
        frame.setActionListener(this);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        
        Button btn = (Button)e.getSource();
        if (btn.getLabel().equals(ButtonID.OK.toString())) {
            DecopyInputFrame frame;
            frame = (DecopyInputFrame)btn.getParent().getParent();
            ContentManager.output(ContentManager.createContent(frame.getDecopyInput()));
        }

        System.exit(0);
    }
}