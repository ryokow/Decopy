package jp.rk.decopy.content;

public abstract class Border extends Content {
    protected Content content;
    protected Border(Content content) {
        this.content = content;
    }
}