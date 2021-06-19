package graphs.breadthFrstSearch;

public class VertexImpl {

    private char label;
    private Boolean visited;

    public VertexImpl(char label) {
        this.label = label;
        this.setVisited(false);
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    public void display() {
        System.out.print(this.label+"-");
    }
}
