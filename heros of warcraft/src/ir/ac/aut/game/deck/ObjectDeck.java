package ir.ac.aut.game.deck;

public abstract class ObjectDeck {
    private Object[] obj;
    private int cnt;

    public ObjectDeck(Object[] obj) {
        this.obj = obj;
        cnt = this.obj.length - 1;
    }

    public Object deal() throws ArrayIndexOutOfBoundsException {
        Object temp;
        temp = this.obj[cnt];
        cnt--;
        if (cnt < 0) {
            return null;
        } else {
            return temp;
        }
    }

    public int size() {
        return cnt;
    }

    public boolean isEmpty() {
        return deal() == null;
    }
}