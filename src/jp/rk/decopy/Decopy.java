package jp.rk.decopy;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import jp.rk.decopy.util.ClipboardController;
import jp.rk.decopy.UI.*;
import jp.rk.decopy.content.*;

class Decopy implements ActionListener{
    static DecopyInputFrame _frame;
    static DecopyInput _decopyInput;

    public static void main(String[] args) {
        // String decoStr = ">";
        // Placement placement = Placement.Left;
	    _decopyInput = new DecopyInput();

        if (args.length == 0) {
            //GUIから情報を取得しdecopyInputにset
            _frame = new DecopyInputFrame();
            _frame.setSize(400, 500);
            _frame.setTitle("Decopy");
            _frame.setVisible(true);
        }
        else if (args.length != 0) {

            for (String string : args) {
                String[] param = string.split(":");
                if (param[0].equals("-p")) {
                    if (isPlacement(param[1])) {
                        _decopyInput.setPlacement(Placement.valueOf(param[1]));
                    }
                } else if (param[0].equals("-c")) {
                    _decopyInput.setDecoStr(param[1]);
                } else {
                    System.out.println("An argument is not valid.");
                    usage();
                    return;
                }
            }
        }

        // output(creatContent(decopyInput));
    }

    private static boolean isPlacement(String str) {
        Placement[] placements = Placement.values();
        for (Placement placement : placements) {
            if (str.equals(placement.name())) {
                return true;
            }
        }

        return false;
    }

    private static Content creatContent(DecopyInput decopyInput) {
        Content content;
        switch (decopyInput.getPlacement()) {
            case UpDown:
                content = new UpDownBorder(new TextContent(ClipboardController.pull()), decopyInput.getDecoStr());
                break;
            case Up:
                content = new UpBorder(new TextContent(ClipboardController.pull()), decopyInput.getDecoStr());
                break;
            case LeftRight:
                content = new LeftRightBorder(new TextContent(ClipboardController.pull()), decopyInput.getDecoStr());
                break;
            case Brackets:
                content = new BracketsBorder(new TextContent(ClipboardController.pull()), decopyInput.getDecoStr());
                break;
            case Full:
                content = new FullBorder(new TextContent(ClipboardController.pull()), decopyInput.getDecoStr());
                break;
            case Right:
                content = new RightBorder(new TextContent(ClipboardController.pull()), decopyInput.getDecoStr());
                break;
            case Under:
                content = new UnderBorder(new TextContent(ClipboardController.pull()), decopyInput.getDecoStr());
                break;
            case Left:
            default:
                content = new LeftBorder(new TextContent(ClipboardController.pull()), decopyInput.getDecoStr());
                break;
        }

        return content;
    }

    private static void output(Content content) {
        ArrayList<String> str = new ArrayList<String>();
        for (int i = 0; i < content.getRows(); i++) {
            str.add(content.getRowText(i));
        }

        ClipboardController.push(String.join("\n", str));
    }

    public void actionPerformed(ActionEvent e) {
            Button btn = (Button)e.getSource();
            if (btn.getLabel().equals(ButtonID.OK.toString())) {
                _decopyInput.setPlacement(_frame.getPlacement());
                _decopyInput.setDecoStr(_frame.getDecoStr());
                output(creatContent(_decopyInput));
            } else {
                System.exit(0);
            }
    }

    private static void usage() {
        System.out.println("Usage: java Decopy");
        System.out.println("Usage: java Decopy -p:UpDown -c:-");
        System.out.println("Usage: java Decopy -p:Brackets -c:\\(");
    }

}