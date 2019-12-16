package jp.rk.decopy.content;

public class UpBorder extends Border {
    private String borderStr;
    public UpBorder(Content content, String str) {
        super(content);
        this.borderStr = str;
    }

    public int getColumns() {
        return content.getColumns();
    }

    public int getRows() {
        return 1 + content.getRows();
    }

    public String getRowText(int row) {
        if (row == 0) {
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