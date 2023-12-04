import java.util.*;

class Dijkstra<T> {
    private List<Node<T>> nodes;

    public Dijkstra(List<Node<T>> nodes) {
        this.nodes = nodes;
    }
    public void calculateShortestPath(Node<T> source) {
        Map<Node<T>, Integer> distances = new HashMap<>();
        Map<Node<T>, Node<T>> previousNodes = new HashMap<>();
        PriorityQueue<Node<T>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        distances.put(source, 0);
        priorityQueue.add(source);

        while (!priorityQueue.isEmpty()) {
            Node<T> current = priorityQueue.poll();

            for (Map.Entry<Node<T>, Integer> entry : current.getAdjacentNodes().entrySet()) {
                Node<T> neighbor = entry.getKey();
                int newDistance = distances.get(current) + entry.getValue();

                if (newDistance < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distances.put(neighbor, newDistance);
                    previousNodes.put(neighbor, current);
                    priorityQueue.add(neighbor);
                }
            }
        }
    }

    public void printPaths() {
        for (Node<T> node : nodes) {
            List<T> path = getPath(node);
            int totalWeight = calculateTotalWeight(path);
            System.out.println(path + " | Total Weight: " + totalWeight);
        }
    }

    private int calculateTotalWeight(List<T> path) {
        int totalWeight = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            Node<T> currentNode = findNode(path.get(i));
            Node<T> nextNode = findNode(path.get(i + 1));
            totalWeight += currentNode.getAdjacentNodes().get(nextNode);
        }
        return totalWeight;
    }
    private Node<T> findNode(T data) {
        for (Node<T> node : nodes) {
            if (node.getData().equals(data)) {
                return node;
            }
        }
        return null;
    }

    private List<T> getPath(Node<T> destination) {
        List<T> path = new ArrayList<>();
        for (Node<T> node = destination; node != null; node = previousNodes.get(node)) {
            path.add(node.getData());
        }
        Collections.reverse(path);
        return path;
    }

    private Map<Node<T>, Node<T>> previousNodes;

    public void setPreviousNodes(Map<Node<T>, Node<T>> previousNodes) {
        this.previousNodes = previousNodes;
    }

    public Map<Node<T>, Node<T>> calculatePreviousNodes(Node<T> source) {
        Map<Node<T>, Integer> distances = new HashMap<>();
        Map<Node<T>, Node<T>> previousNodes = new HashMap<>();
        PriorityQueue<Node<T>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        distances.put(source, 0);
        priorityQueue.add(source);

        while (!priorityQueue.isEmpty()) {
            Node<T> current = priorityQueue.poll();

            for (Map.Entry<Node<T>, Integer> entry : current.getAdjacentNodes().entrySet()) {
                Node<T> neighbor = entry.getKey();
                int newDistance = distances.get(current) + entry.getValue();

                if (newDistance < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distances.put(neighbor, newDistance);
                    previousNodes.put(neighbor, current);
                    priorityQueue.add(neighbor);
                }
            }
        }

        return previousNodes;
    }
}
