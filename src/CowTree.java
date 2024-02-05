public class CowTree {
    private CowNode root;

    public CowNode find(int id) {
        CowNode current = root;
        while (current != null) {
            if (current.id == id) {
                break;
            }
            current = current.id < id ? current.right : current.left;
        }
        return current;
    }

    public CowNode giveBirth(int id, String name) {
        root = giveBirth(root, id, name, null);
        return root;
    }

    public CowNode giveBirth(int parentId, int id, String name) {
        CowNode parent = find(parentId);
        root = giveBirth(root, id, name, parent);
        return root;
    }

    public void endLifeSpan(int id) {
        root = endLifeSpan(root, id);
    }

    private CowNode giveBirth(CowNode root, int id, String name, CowNode parent) {
        if (root == null) {
            return new CowNode(id, name, parent);
        } else if (root.id > id) {
            root.left = giveBirth(root.left, id, name, parent);
        } else if (root.id < id) {
            root.right = giveBirth(root.right, id, name, parent);
        } else {
            throw new RuntimeException(String.format("duplicate id - [%s]", id));
        }
        return root;
    }

    private CowNode endLifeSpan(CowNode node, int id) {
        if (node == null) {
            return node;
        } else if (node.id > id) {
            node.left = endLifeSpan(node.left, id);
        } else if (node.id < id) {
            node.right = endLifeSpan(node.right, id);
        } else {
            node.isDeleted = true;
        }
        return node;
    }

    public void printFarmData(CowNode node) {
        if (node != null) {
            printFarmData(node.left);
            print(node);
            printFarmData(node.right);
        }
    }

    private void print(CowNode cowNode) {
        if (cowNode.isDeleted) return;
        System.out.println();
        printCow(cowNode);
        if (cowNode.parent == null || cowNode.parent.isDeleted) return;
        System.out.print(" -> [PARENT] ");
        printCow(cowNode.parent);
    }

    private static void printCow(CowNode cowNode) {
        System.out.print(String.format("id=%s, name=%s", cowNode.id, cowNode.name));
    }
}
