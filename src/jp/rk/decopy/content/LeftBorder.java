package jp.rk.decopy.content;

public class LeftBorder extends Border {
    private String borderStr;
    public LeftBorder(Content content, String str) {
        super(content);
        this.borderStr = str;
    }

    public int getColumns() {
        return 1 + content.getColumns();
    }

    public int getRows() {
        return content.getRows();
    }

    public String getRowText(int row) {
        return this.borderStr + content.getRowText(row);
    }
}