public class SetCard {
    private int type, num, color, fill;

    public SetCard(int type, int num, int color, int fill) {
        this.type = type;
        this.num = num;
        this.color = color;
        this.fill = fill;
    }
    public static SetCard cardFromString(String str) throws NumberFormatException {
        int key = Integer.parseInt(str);
        int[] parameters = new int[4];
        for (int i = 0; i < parameters.length; i++) {
            int p = key%10;
            key /= 10;
            if (p < 1 || p > 3) throw new NumberFormatException("number out of range at ");
            parameters[i] = p;
        }
        if (key > 0)
            throw new NumberFormatException("too many numbers at ");
        return new SetCard(parameters[0], parameters[1], parameters[2], parameters[3]);
    }

    public int getType() {
        return type;
    }
    public int getNum() {
        return num;
    }
    public int getColor() {
        return color;
    }
    public int getFill() {
        return fill;
    }
    @Override
    public String toString() {
        return "{" + typeString() + ", " + num + ", " + colorString() + ", " + fillString() + "}";
    }
    private String typeString() {
        return switch (type) {
            case 1 -> "Rhombus";
            case 2 -> "Ellipse";
            case 3 -> "Reel";
            default -> null;
        };
    }
    private String colorString() {
        return switch (color) {
            case 1 -> "Red";
            case 2 -> "Green";
            case 3 -> "Purple";
            default -> null;
        };
    }
    private String fillString() {
        return switch (fill) {
            case 1 -> "Empty";
            case 2 -> "Blank";
            case 3 -> "Striped";
            default -> null;
        };
    }
    public boolean equal(Object obj) {
        if (obj instanceof SetCard other) {
            return other.num == this.num && other.color == this.color &&
                    other.fill == this.fill;
        }
        return false;
    }
    public int compareTo(SetCard other) {
        int delta = type - other.type;
        if(delta != 0) return delta;
        delta = num - other.num;
        if(delta != 0) return delta;
        delta = color - other.color;
        if (delta != 0) return delta;
        delta = fill - other.fill;
        return delta;
    }
}
