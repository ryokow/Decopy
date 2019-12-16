package jp.rk.decopy.content;

public class UpDownBorder extends Border {
    private String borderStr;
    public UpDownBorder(Content content, String str) {
        super(content);
        this.borderStr = str;
    }

    public int getColumns() {
        return content.getColumns();
    }

    public int getRows() {
        return 1 + content.getRows() + 1;
    }

    public String getRowText(int row) {
        if (row == 0) {
            return makeLine(this.borderStr, content.getColumns());
        } else if (row == content.getRows() + 1) {
            return makeLine(this.borderStr, content.getColumns()); 
        } else {
            return content.getRowText(row - 1);
        }
    }

    private String makeLine(String str, int count) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < count; i++) {
            buf.append(str);
        }
        return buf.toString();
    }
}