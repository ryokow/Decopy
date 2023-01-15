package jp.rk.decopy;

import jp.rk.decopy.util.ClipboardController;
import jp.rk.decopy.content.*;

class Decopy {
    public static void main(String[] args) {
        // String decoStr = ">";
        // Placement placement = Placement.Left;
        DecoInfo decoInfo = new DecoInfo();

        if (args.length == 0) {
            //GUIから情報を取得しdecoInfoにset
        }
        else if (args.length != 0) {

            for (String string : args) {
                String[] param = string.split(":");
                if (param[0].equals("-p")) {
                    if (isPlacement(param[1])) {
                        decoInfo.setPlacement(Placement.valueOf(param[1]));
                    }
                } else if (param[0].equals("-c")) {
                    decoInfo.setDecoStr(param[1]);
                } else {
                    System.out.println("An argument is not valid.");
                    usage();
                    return;
                }
            }
        }

        creatContent(decoInfo).output();
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

    private static Content creatContent(DecoInfo decoInfo) {
        Content content;
        switch (decoInfo.getPlacement()) {
            case UpDown:
                content = new UpDownBorder(new TextContent(ClipboardController.pull()), decoInfo.getDecoStr());
                break;
            case Up:
                content = new UpBorder(new TextContent(ClipboardController.pull()), decoInfo.getDecoStr());
                break;
            case LeftRight:
                content = new LeftRightBorder(new TextContent(ClipboardController.pull()), decoInfo.getDecoStr());
                break;
            case Brackets:
                content = new BracketsBorder(new TextContent(ClipboardController.pull()), decoInfo.getDecoStr());
                break;
            case Full:
                content = new FullBorder(new TextContent(ClipboardController.pull()), decoInfo.getDecoStr());
                break;
            case Right:
                content = new RightBorder(new TextContent(ClipboardController.pull()), decoInfo.getDecoStr());
                break;
            case Under:
                content = new UnderBorder(new TextContent(ClipboardController.pull()), decoInfo.getDecoStr());
                break;
            case Left:
            default:
                content = new LeftBorder(new TextContent(ClipboardController.pull()), decoInfo.getDecoStr());
                break;
        }

        return content;
    }

    private static void usage() {
        System.out.println("Usage: java Decopy");
        System.out.println("Usage: java Decopy -p:UpDown -c:-");
        System.out.println("Usage: java Decopy -p:Brackets -c:\\(");
    }

}