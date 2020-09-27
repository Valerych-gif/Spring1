import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class flatListToTree {
    static class Node {
        private Integer nodeNumber;

        private List<Node> childNodes;

        private Integer parentNodeNumber;

        public Node(Integer nodeNumber, Integer parentNodeNumber) {
            this.nodeNumber = nodeNumber;
            this.parentNodeNumber = parentNodeNumber;
            this.childNodes = new ArrayList<>();
        }

        public void printChildren() {
            if (childNodes.size() > 0) {
                System.out.println("\nChildren of node #" + nodeNumber);
                System.out.print("\t");
                for (Node childNode : childNodes) {
                    System.out.print(childNode.nodeNumber + " ");
                }
            }
        }

        public void addChild(Node node) {
            childNodes.add(node);
        }

        public Integer getNodeNumber() {
            return nodeNumber;
        }

        public List<Node> getChildNodes() {
            return childNodes;
        }

        public Integer getParentNodeNumber() {
            return parentNodeNumber;
        }
    }

    static List<Node> flatList;

    public static void main(String[] args) {
        flatList = new ArrayList<>();
        flatList.add(new Node(1, null));
        flatList.add(new Node(2, null));
        flatList.add(new Node(3, 1));
        flatList.add(new Node(4, 3));
        flatList.add(new Node(5, null));
        flatList.add(new Node(6, 3));
        flatList.add(new Node(7, 2));
        flatList.add(new Node(8, 5));

        List<Node> tree = new ArrayList<>(flatList);

        List<Integer> toRemove = new ArrayList<>();
        for (Node flatNode : flatList) {
            Integer nodeParentNumber = flatNode.getParentNodeNumber();
            for (Node treeNode : tree) {
                if (treeNode.getNodeNumber().equals(nodeParentNumber)) {
                    treeNode.addChild(flatNode);
                    toRemove.add(tree.indexOf(flatNode));
                }
            }
        }

        for (Integer index : toRemove) {
            tree.set(index, null);
        }
        tree.removeIf(Objects::isNull);
    }
}
