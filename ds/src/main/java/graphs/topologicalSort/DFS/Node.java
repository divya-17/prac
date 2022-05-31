package graphs.topologicalSort.DFS;

public class Node {

    private int value;
    private Color color;

    public Node(int value){
        this.value = value;
        this.color = Color.WHITE;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", color=" + color +
                '}';
    }


}
