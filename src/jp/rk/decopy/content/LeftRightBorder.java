package jp.rk.decopy.content;

public class LeftRightBorder extends Border {
    private String borderStr;
    public LeftRightBorder(Content content, String str) {
        super(content);
        this.borderStr = str;
    }

    public int getColumns() {
        return 1 + content.getColumns() + 1;
    }

    public int getRows() {
        return content.getRows();
    }

    public String getRowText(int row) {
        return this.borderStr + content.getRowText(row) + this.borderStr;
    }
}