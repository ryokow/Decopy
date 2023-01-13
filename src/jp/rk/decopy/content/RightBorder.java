package jp.rk.decopy.content;

public class RightBorder extends Border {
	private String borderStr;
	public RightBorder(Content content, String str) {
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
		return content.getRowText(row) + this.borderStr;
	}
}
