package graphs.courseSchedule;

import graphs.bipartition.Color;

public class Vertex {

 private Integer num;
 private Color vertexColor;

 public Vertex(Integer num){
     this.num = num;
     vertexColor = Color.NOCOLOR;
 }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Color getVertexColor() {
        return vertexColor;
    }

    public void setVertexColor(Color vertexColor) {
        this.vertexColor = vertexColor;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "num=" + num +
                ", vertexColor=" + vertexColor +
                '}';
    }
}
