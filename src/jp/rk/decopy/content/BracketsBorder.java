package jp.rk.decopy.content;

public class BracketsBorder extends Border {
    private String borderStr;
    public BracketsBorder(Content content, String str) {
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
        String rightsideBorderStr = getRightsideBorderStr(this.borderStr); //default

        if (content.getRows() <= 1) {
            return this.borderStr + content.getRowText(0) + rightsideBorderStr;
        }

        if (row == 0) {
            return this.borderStr + content.getRowText(row);
        } else if (row == content.getRows() - 1) {
            return " " + content.getRowText(row) + rightsideBorderStr;
        } else {
            return " " + content.getRowText(row);
        }
    }

    private String getRightsideBorderStr(String leftsideBorderStr){
        Brackets brackets = getBrackets(leftsideBorderStr);
        if (brackets != null) {
            return getRightsideBracket(brackets);
        }
        return leftsideBorderStr;
    }

    private String getRightsideBracket(Brackets brackets){

        String rightsideBracket = ")"; //default
        
        switch (brackets) {
            case FullWidthParentheses:
                rightsideBracket = "）";
                break;
            case Brackets:
                rightsideBracket = "]";
                break;
            case Braces:
                rightsideBracket = "}";
                break;
            case AngleBrackets:
                rightsideBracket = ">";
                break;
            case DoubleAB:
                rightsideBracket = ">>";
                break;
            case Angles:
                rightsideBracket = "」";
                break;
            case BoldAngles:
                rightsideBracket = "】";
                break;
            case DoubleAngles:
                rightsideBracket = "』";
                break;
            case Parentheses:
            default:
                break;
        }

        return rightsideBracket;
    }

    private Brackets getBrackets(String bracketStr){
        Brackets[] values = Brackets.values();
        for (Brackets brackets : values) {
            if (bracketStr.equals(brackets.getBracketStr())) {
                return brackets;
            }
        }
        return null;
    }

    private enum Brackets {
        Parentheses("("),
        FullWidthParentheses("（"),
        Brackets("["),
        Braces("{"),
        AngleBrackets("<"),
        DoubleAB("<<"),
        Angles("「"),
        BoldAngles("【"),
        DoubleAngles("『");

        private final String bracketStr;
        private Brackets(final String bracketStr){
            this.bracketStr = bracketStr;
        }

        String getBracketStr(){
            return this.bracketStr;
        }
    }
}
