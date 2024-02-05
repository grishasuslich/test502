public class Main {
    public static void main(String[] args) {
        CowTree farmTree = new CowTree();
        CowNode root = farmTree.giveBirth(1, "Burenka1");

        farmTree.giveBirth(1, 2, "child1-Burenka1");
        farmTree.giveBirth(1, 3, "child2-Burenka1");
        farmTree.giveBirth(1, 4, "child3-Burenka1");
        farmTree.giveBirth(4, 23, "TEST");

        farmTree.giveBirth(5, "Burenka2");
        farmTree.giveBirth(5, 6, "child1-Burenka2");

        farmTree.giveBirth(7, "Burenka3");

        farmTree.endLifeSpan(4);

        farmTree.giveBirth(4, 24, "TEST");

        farmTree.printFarmData(root);
    }
}
