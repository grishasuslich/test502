public class CowNode {
    int id;
    String name;
    boolean isDeleted;
    CowNode parent;
    CowNode left;
    CowNode right;

    CowNode(int value, String name, CowNode parent) {
        this.id = value;
        this.name = name;
        this.isDeleted = false;
        this.right = null;
        this.left = null;
        this.parent = parent;
    }
}
