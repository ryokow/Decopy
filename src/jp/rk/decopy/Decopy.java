package jp.rk.decopy;

import jp.rk.decopy.UI.*;
import jp.rk.decopy.content.Content;
import jp.rk.decopy.content.ContentManager;

class Decopy {

    public static void main(String[] args) {
        // String decoStr = ">";
        // Placement placement = Placement.Left;
	    DecopyInput decopyInput = new DecopyInput();

        if (args.length == 0) {

            DecopyInputController controller = new DecopyInputController();
            controller.displayDecopyInputFrame();
        
        }
        else if (args.length != 0) {

            for (String string : args) {
                String[] param = string.split(":");
                if (param[0].equals("-p")) {
                    if (isPlacement(param[1])) {
                        decopyInput.setPlacement(Placement.valueOf(param[1]));
                    }
                } else if (param[0].equals("-c")) {
                    decopyInput.setDecoStr(param[1]);
                } else {
                    System.out.println("An argument is not valid.");
                    usage();
                    return;
                }
            }
        }
   
        ContentManager.output(ContentManager.createContent(decopyInput));
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

    private static void usage() {
        System.out.println("Usage: java Decopy");
        System.out.println("Usage: java Decopy -p:UpDown -c:-");
        System.out.println("Usage: java Decopy -p:Brackets -c:\\(");
    }

}