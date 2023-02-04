package jp.rk.decopy.content;

import java.util.ArrayList;


public class OrderedBorder extends Border {
    private ArrayList<String> borderStrs;
    public OrderedBorder(Content content, String str) {
        super(content);
        borderStrs = new ArrayList<String>();
        char ch = str.charAt(0);
        for (int i = 0; i < content.getRows(); i++) {
            borderStrs.add(i, Character.toString(ch+i)+". ");
        }
    }

    public int getColumns() {
        return 1 + content.getColumns();
    }

    public int getRows() {
        return content.getRows();
    }

    public String getRowText(int row) {
        return borderStrs.get(row) + content.getRowText(row);
    }
}