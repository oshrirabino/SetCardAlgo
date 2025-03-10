public class PairSetCards {
    private final SetCard c1;
    private final SetCard c2;
    public PairSetCards(SetCard c1, SetCard c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public SetCard complimentCard() {
        int type = c1.getType() == c2.getType() ? c1.getType() : 6 - (c1.getType() + c2.getType());
        int num = c1.getNum() == c2.getNum() ? c1.getNum() : 6 - (c1.getNum() + c2.getNum());
        int color = c1.getColor() == c2.getColor() ? c1.getColor() : 6 - (c1.getColor() + c2.getColor());
        int fill = c1.getFill() == c2.getFill() ? c1.getFill() : 6 - (c1.getFill() + c2.getFill());
        return new SetCard(type, num, color, fill);
    }
    @Override
    public String toString() {
        return c1.toString() + " " + c2.toString();
    }
    public SetCard getC1() {
        return this.c1;
    }
    public SetCard getC2() {
        return this.c2;
    }
}
