package jp.rk.decopy.content;

public class TextContent extends Content {
    private String[] _text;

    public TextContent(String text){
        _text = text.split("\n");
    }

    public int getColumns() {
        return getMaxColumns(_text);
    }

    public int getRows() {
        return _text.length;
    }

    public String getRowText(int row) {
        return _text[row];
    }

    private int getMaxColumns(String[] strs) {
        int max = 0;
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].length() > max) {
                max = strs[i].length();
            }
        }
        return max;
    }

}