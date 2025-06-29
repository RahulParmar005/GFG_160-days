// Serialization is to store a tree in an array so that it can be later restored and deserialization is reading tree back from the array. Complete the functions

// serialize() : stores the tree into an array a and returns the array.
// deSerialize() : deserializes the array to the tree and returns the root of the tree.
// Note: Multiple nodes can have the same data and the node values are always positive integers. Your code will be correct if the tree returned by deSerialize(serialize(input_tree)) is same as the input tree. Driver code will print the in-order traversal of the tree returned by deSerialize(serialize(input_tree)).


class Tree {
    
    static void preorder(Node root, ArrayList<Integer> arr){
        if(root == null){
            arr.add(-1);
            return;
        }
        
        arr.add(root.data);
        preorder(root.left, arr);
        preorder(root.right, arr);
        
    }
    
    // Function to serialize a tree and return a list containing nodes of tree.
    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> arrList = new ArrayList<>();
        preorder(root, arrList);
        
        return arrList;
    }

    static Node deSerializePreorder(int[] i, ArrayList<Integer> arr){
        if(arr.get(i[0]) == -1){
            i[0]++;
            return null;
        }
        
        Node root = new Node(arr.get(i[0]));
        i[0]++;
        
        root.left = deSerializePreorder(i, arr);
        root.right = deSerializePreorder(i, arr);
        
        return root;
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        // code here
        int[] i = {0};
        
        return deSerializePreorder(i, arr);
    }
};