class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree=new int[n];
        
        // Calculate in-degrees for each node
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                inDegree[leftChild[i]]++;
                if (inDegree[leftChild[i]] > 1) {
                    return false; // More than one incoming edge to a node
                }
            }
            if (rightChild[i] != -1) {
                inDegree[rightChild[i]]++;
                if (inDegree[rightChild[i]] > 1) {
                    return false; // More than one incoming edge to a node
                }
            }
        }
        
        int rootNode = -1;
        // Find the root node (a node with in-degree 0)
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (rootNode != -1) {
                    return false; // More than one root node
                }
                rootNode = i;
            }
        }
        
        if (rootNode == -1) {
            return false; // No root node found
        }
        
        // Perform a depth-first traversal to check if the tree is connected
        boolean[] visited=new boolean[n];
        Stack<Integer> dfs = new Stack<>();
        dfs.push(rootNode);
        
        while (!dfs.empty()) {
            int node = dfs.peek();
            dfs.pop();
            
            if (visited[node]) {
                return false; // Cycle detected
            }
            
            visited[node] = true;
            
            if (leftChild[node] != -1) {
                dfs.push(leftChild[node]);
            }
            if (rightChild[node] != -1) {
                dfs.push(rightChild[node]);
            }
        }
        
        // Check if all nodes are visited
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false; // Some nodes are not reachable
            }
        }
        
        return true;
    }
}