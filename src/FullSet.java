import java.util.ArrayList;

public class FullSet {
    private final SetCard first, second, third;
    public FullSet(SetCard c1, SetCard c2, SetCard c3) {
        CardSortingObj co = new CardSortingObj();
        ArrayList<SetCard> arr = new ArrayList<>();
        arr.add(c1);
        arr.add(c2);
        arr.add(c3);
        arr = co.sort(arr);
        this.first = arr.get(0);
        this.second = arr.get(1);
        this.third = arr.get(2);
    }
    @Override
    public String toString() {
        return "SET: [" + first + ", " + second + ", " + third + "]";
    }

    public boolean equal(Object other) {
        if (other instanceof FullSet otherSet) {
            return foundInSet(otherSet.first) && foundInSet(otherSet.second);
        }
        return false;
    }
    private boolean foundInSet(SetCard card) {
        return card.equal(first) || card.equal(second) || card.equal(third);
    }
}


