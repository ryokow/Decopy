package jp.rk.decopy.content;

import java.util.ArrayList;


public class OrderedBorder extends Border {
    private ArrayList<String> borderStrs;
    public OrderedBorder(Content content, String str) {
        super(content);
        borderStrs = new ArrayList<String>();
        int chint = str.codePointAt(0); 
        String s = ".";
        if (chint == "①".codePointAt(0)) {
            s = "";            //①が指定された場合は.（ピリオド）をつけない
        }
        char ch = 0;
        for (int i = 0; i < content.getRows(); i++) {
            ch = (char)(chint+i);
            borderStrs.add(i, Character.toString(ch) + s + " ");
        }
    }

    public int getColumns() {
        return 3 + content.getColumns();
    }

    public int getRows() {
        return content.getRows();
    }

    public String getRowText(int row) {
        return borderStrs.get(row) + content.getRowText(row);
    }
}