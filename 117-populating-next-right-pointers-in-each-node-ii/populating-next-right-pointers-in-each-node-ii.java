class Solution {
    Map<Integer, Node> map = new HashMap<>();

    public Node connect(Node root) {
        dfs(root, 0);
        return root;
    }

    void dfs(Node curr, int level) {
        if (curr == null) return;

        if (map.containsKey(level) && map.get(level) != curr) {
            map.get(level).next = curr;
        }

        map.put(level, curr);
        curr.next = null;

        dfs(curr.left, level + 1);
        dfs(curr.right, level + 1);
    }
}

// dfs + hashmap. for every level we must mantain a node. whenever we reach that level we must see if the current node is not equal to the saved node at that level we must do saved.next = curr and map.put(level, curr) and curr.next = null. like this we can solve it