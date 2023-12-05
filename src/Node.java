import java.util.*;

public class Node<T> {
    private T nama;
    private String alamat;
    private Boolean isOpen;
    private Map<Node<T>, Integer> adjacentNodes = new HashMap<>();

    public Node(T data, String alamat, Boolean isOpen) {
        this.nama = data;
        this.alamat = alamat;
        this.isOpen = isOpen;
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
