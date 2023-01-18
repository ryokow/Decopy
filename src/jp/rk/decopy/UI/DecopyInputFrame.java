package jp.rk.decopy.UI;

import java.awt.*;
import java.awt.event.*;

import jp.rk.decopy.ButtonID;
import jp.rk.decopy.Placement;


public class DecopyInputFrame extends Frame {	
    private Choice _choice;
    private TextField _textField;
    private Button _OKButton;
    private Button _CancelButton;
    
    public DecopyInputFrame(){
        super();
        this.setLayout(new GridLayout(3,1));
        Label labelOfPlacement = new Label("装飾位置");
        Label labelOfDecoStr = new Label("装飾文字");
        labelOfPlacement.setAlignment(Label.CENTER);
        labelOfDecoStr.setAlignment(Label.CENTER);
       
        _choice = new Choice();
        for(Placement placement : Placement.values()){
            _choice.add(placement.toString());
        }
        _textField = new TextField(4);
        _textField.setSize(50,15);
        
        _OKButton = new Button(ButtonID.OK.toString());
        _OKButton.setSize(50,25);
        _CancelButton = new Button(ButtonID.CANCEL.toString());
        _CancelButton.setSize(50,25);

        Panel p1 = new Panel(new GridLayout(1,2));
        Panel p2 = new Panel(new GridLayout(1,2));
        Panel p3 = new Panel(new GridLayout(1,2));

        p1.add(labelOfPlacement);
        p1.add(_choice);
        p2.add(labelOfDecoStr);
        p2.add(_textField);
        p3.add(_OKButton);
        p3.add(_CancelButton);

        this.add(p1);
        this.add(p2);
        this.add(p3);

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