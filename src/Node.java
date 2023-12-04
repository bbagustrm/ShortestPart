import java.util.*;

public class Node<T> {
    private T nama;
    private Map<Node<T>, Integer> adjacentNodes = new HashMap<>();

    public Node(T data) {
        this.nama = data;
    }

    public T getData() {
        return nama;
    }

    public void addAdjacentNode(Node<T> node, int weight) {
        adjacentNodes.put(node, weight);
    }

    public Map<Node<T>, Integer> getAdjacentNodes() {
        return adjacentNodes;
    }

}
