import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class SetFindAlgo {
    public static void main(String[] args) {
//        SetCard c1 = new SetCard(1, 1, 1, 1);
//        SetCard c2 = new SetCard(1, 2, 1, 1);
//        SetCard c3 = new SetCard(2, 1, 1, 2);
//        SetCard c4 = new SetCard(1, 3, 1, 2);
//        SetCard c5 = new SetCard(2, 2, 2, 2);
//        SetCard c6 = new SetCard(1, 3, 3, 2);
//        SetCard c7 = new SetCard(2, 3, 3, 2);
//        SetCard c8 = new SetCard(1, 3, 2, 2);
        Set<SetCard> cards = new HashSet<SetCard>();
        for (String str : args) {
            try {
                cards.add(SetCard.cardFromString(str));
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage() + str);
                return;
            }
        }
//        cards.add(c4);
//        cards.add(c2);
//        cards.add(c3);
//        cards.add(c1);
//        cards.add(c6);
//        cards.add(c5);
//        cards.add(c7);
//        cards.add(c8);
        findSet(cards);
    }
    static private void findSet(Set<SetCard> board) {
        ArrayList<SetCard> cards = new ArrayList<>(board);
        CardSortingObj cso = new CardSortingObj();
        cards = cso.sort(cards);
        ArrayList<SetCard> cards2 = new ArrayList<>(cards);
        ArrayList<PairSetCards> pairs = new ArrayList<>();
        for (SetCard c1 : cards) {
            cards2.remove(c1);
            for (SetCard c2 : cards2) {
                if (!c1.equals(c2)) {
                    pairs.add(new PairSetCards(c1, c2));
                }
            }
        }
        ArrayList<FullSet> setsFound = new ArrayList<>();
        for (PairSetCards pair : pairs) {
            if(cso.binarySearch(cards, pair.complimentCard(), 0, cards.size())) {
                FullSet set = new FullSet(pair.getC1(), pair.getC2(), pair.complimentCard());
                boolean found = false;
                for (FullSet fs : setsFound) {
                    if (fs.equal(set))
                        found = true;
                }
                if (!found)
                    setsFound.add(set);
            }
        }
        for (FullSet set : setsFound)
            System.out.println(set);
    }
}