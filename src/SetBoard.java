import java.util.ArrayList;

public class SetBoard {
    private ArrayList<SetCard> board;

    public SetBoard(ArrayList<SetCard> board) {
        this.board = board;
    }
    public ArrayList<SetCard> getBoard() {
        return new ArrayList<>(board);
    }
}
