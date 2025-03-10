import java.util.ArrayList;

public class CardSortingObj {
    public ArrayList<SetCard> sort(ArrayList<SetCard> cards) {
        cards.sort((card1, card2) -> card1.getColor() - card2.getColor());
        cards.sort((card1, card2) -> card1.getFill() - card2.getFill());
        cards.sort((card1, card2) -> card1.getNum() - card2.getNum());
        cards.sort((card1, card2) -> card1.getType() - card2.getType());
        return cards;
    }
    public boolean binarySearch(ArrayList<SetCard> board, SetCard card, int start, int end){
        if (start >= end)
            return false;
        int index = ((start + end) / 2);
        int check = card.compareTo(board.get(index));
        if (check > 0)
            return binarySearch(board, card, index + 1, end);
        if (check < 0)
            return binarySearch(board, card, start, index);
        return true;
    }
}
