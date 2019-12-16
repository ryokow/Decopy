package jp.rk.decopy.content;

public class FullBorder extends Border {
    private String borderStr;
    public FullBorder(Content content, String str) {
        super(content);
        this.borderStr = str;
    }

    public int getColumns() {
        return 1 + content.getColumns() + 1;
    }

    public int getRows() {
        return 1 + content.getRows() + 1;
    }

    public String getRowText(int row) {
        if (row == 0) {
            return makeLine(this.borderStr, 1 + content.getColumns() + 1);
        } else if (row == content.getRows() + 1) {
            return makeLine(this.borderStr, 1 + content.getColumns() + 1); 
        } else {
            return this.borderStr + content.getRowText(row - 1) + this.borderStr;
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