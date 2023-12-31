import java.util.List;

public class Main {
    public static void main(String[] args) {

        Node<String> nodeA = new Node<>("JNE1", "Jl.Mangkudipuro No 41", true);
        Node<String> nodeB = new Node<>("JNE2", "Jl.Mulawarman No 23", true);
        Node<String> nodeC = new Node<>("JNE3", "Jl.Messi No 7", true);
        Node<String> nodeD = new Node<>("JNE4", "Jl.Diponegoro No 69", true);
        Node<String> nodeE = new Node<>("JNE5", "Jl.Tirto Agung No 45", true);
        Node<String> nodeF = new Node<>("JNE6", "Jl.Sudirman No 82", true);

        nodeA.addAdjacentNode(nodeB, 2);
        nodeA.addAdjacentNode(nodeC, 4);

        nodeB.addAdjacentNode(nodeC, 3);
        nodeB.addAdjacentNode(nodeD, 1);
        nodeB.addAdjacentNode(nodeE, 5);

        nodeC.addAdjacentNode(nodeD, 2);

        nodeD.addAdjacentNode(nodeE, 1);
        nodeD.addAdjacentNode(nodeF, 4);

        nodeE.addAdjacentNode(nodeF, 2);

        List<Node<String>> nodeList = List.of(nodeA, nodeB, nodeC, nodeD, nodeE, nodeF);
        Dijkstra<String> dijkstra = new Dijkstra<>(nodeList);
        dijkstra.calculateShortestPath(nodeA);
        dijkstra.setPreviousNodes(dijkstra.calculatePreviousNodes(nodeA));
        dijkstra.printPaths();
    }
}