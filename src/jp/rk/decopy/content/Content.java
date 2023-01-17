package jp.rk.decopy.content;

public abstract class Content {
    public abstract int getColumns();
    public abstract int getRows();
    public abstract String getRowText(int row);
    
    // *** Decopy.javaに移行 ***
    // public final void output() {
    //     ArrayList<String> str = new ArrayList<String>();
    //     for (int i = 0; i < getRows(); i++) {
    //         str.add(getRowText(i));
    //     }
    //     ClipboardController.push(String.join("\n", str));
    // }

}