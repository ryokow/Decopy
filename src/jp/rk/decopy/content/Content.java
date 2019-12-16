package jp.rk.decopy.content;

import java.util.ArrayList;
import jp.rk.decopy.util.ClipboardController;

public abstract class Content {
    public abstract int getColumns();
    public abstract int getRows();
    public abstract String getRowText(int row);

    public final void output() {
        ArrayList<String> str = new ArrayList<String>();
        for (int i = 0; i < getRows(); i++) {
            str.add(getRowText(i));
        }

        ClipboardController.push(String.join("\n", str));
    }
}