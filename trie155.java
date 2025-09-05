// Implement Trie class and complete insert(), search() and isPrefix() function for the following queries :

// Type 1 : (1, word), calls insert(word) function and insert word in the Trie
// Type 2 : (2, word), calls search(word) function and check whether word exists in Trie or not.
// Type 3 : (3, word), calls isPrefix(word) function and check whether word exists as a prefix of any string in Trie or not.


// User function Template for Java
class Node {
    Node[] child;
    boolean isLeaf;
    
    Node() {
        child = new Node[26];
        isLeaf = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        // Implement Trie
        root = new Node();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        Node curr = root;
        for(char c : word.toCharArray()) {
            if(curr.child[c - 'a'] == null) {
                curr.child[c - 'a'] = new Node();
            }
            curr = curr.child[c - 'a'];
        }
        curr.isLeaf = true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        Node curr = root;
        for(char c : word.toCharArray()) {
            if(curr.child[c - 'a'] == null) {
                return false;
            }
            curr = curr.child[c - 'a'];
        }
        
        return curr.isLeaf;
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        Node curr = root;
        for(char c : word.toCharArray()) {
            if(curr.child[c - 'a'] == null) {
                return false;
            }
            curr = curr.child[c - 'a'];
        }
        
        return true;
    }
}