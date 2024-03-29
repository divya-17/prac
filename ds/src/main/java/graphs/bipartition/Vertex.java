package graphs.bipartition;

public class Vertex {


    private Integer num;
    private Color color;


    public Vertex(Integer num){
        this.num = num;
        color = Color.NOCOLOR;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "num=" + num +
                ", color=" + color +
                '}';
    }
}
