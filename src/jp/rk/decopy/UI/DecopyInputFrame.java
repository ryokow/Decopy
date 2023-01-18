package jp.rk.decopy.UI;

import java.awt.*;
import java.awt.event.*;

import jp.rk.decopy.ButtonID;
import jp.rk.decopy.Placement;


public class DecopyInputFrame extends Frame {	
    Choice _choice;
    TextField _textField;
    Button _OKButton;
    Button _CancelButton;

    public DecopyInputFrame(){
        super();
        Label labelOfPlacement = new Label();
        Label labelOfDecoStr = new Label();
        labelOfPlacement.setText("装飾位置");
        labelOfDecoStr.setText("装飾文字");

        _choice = new Choice();
        for(Placement placement : Placement.values()){
            _choice.add(placement.toString());
        }
        _textField = new TextField(4);
        

        _OKButton = new Button(ButtonID.OK.toString());

        _CancelButton = new Button(ButtonID.CANCEL.toString());

        this.add(labelOfPlacement, BorderLayout.NORTH);
        this.add(_choice, BorderLayout.NORTH);
        this.add(labelOfDecoStr, BorderLayout.CENTER);
        this.add(_textField, BorderLayout.CENTER);
        this.add(_OKButton, BorderLayout.SOUTH);
        this.add(_CancelButton, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }

    public Placement getPlacement(){
        return Placement.valueOf(_choice.getSelectedItem());
    }

    public String getDecoStr(){
        return _textField.getText();
    }

    public void setActionListener(ActionListener listener){
        _OKButton.addActionListener(listener);
        _CancelButton.addActionListener(listener);
    }
    
}