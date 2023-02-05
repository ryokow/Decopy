package jp.rk.decopy.content;

import jp.rk.decopy.UI.DecopyInput;
import jp.rk.decopy.util.ClipboardController;
import java.util.ArrayList;

public class ContentManager {
    private ContentManager(){};

    public static Content createContent(DecopyInput input){
        Content content;
        switch (input.getPlacement()) {
            case UpDown:
                content = new UpDownBorder(new TextContent(ClipboardController.pull()), input.getDecoStr());
                break;
            case Up:
                content = new UpBorder(new TextContent(ClipboardController.pull()), input.getDecoStr());
                break;
            case LeftRight:
                content = new LeftRightBorder(new TextContent(ClipboardController.pull()), input.getDecoStr());
                break;
            case Brackets:
                content = new BracketsBorder(new TextContent(ClipboardController.pull()), input.getDecoStr());
                break;
            case Full:
                content = new FullBorder(new TextContent(ClipboardController.pull()), input.getDecoStr());
                break;
            case Right:
                content = new RightBorder(new TextContent(ClipboardController.pull()), input.getDecoStr());
                break;
            case Under:
                content = new UnderBorder(new TextContent(ClipboardController.pull()), input.getDecoStr());
                break;
            case Ordered:
                content = new OrderedBorder(new TextContent(ClipboardController.pull()), input.getDecoStr());
                break;
            case Left:
            default:
                content = new LeftBorder(new TextContent(ClipboardController.pull()), input.getDecoStr());
                break;
        }

        return content;
    }

    public static void output(Content content){
        ArrayList<String> str = new ArrayList<String>();
        for (int i = 0; i < content.getRows(); i++) {
            str.add(content.getRowText(i));
        }

        ClipboardController.push(String.join("\n", str));
    }
}
