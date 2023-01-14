package jp.rk.decopy.content;

public class UnderBorder extends Border {
    private String borderStr;
    public UnderBorder(Content content, String str) {
        super(content);
        this.borderStr = str;
    }

    public int getColumns() {
        return content.getColumns();
    }

    public int getRows() {
        return content.getRows() + 1;
    }

    public String getRowText(int row) {
        if (row == content.getRows()) {
            return makeLine(this.borderStr, content.getColumns());
        } else {
            return content.getRowText(row);
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