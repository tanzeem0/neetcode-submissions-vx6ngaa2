class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            if(curr.arr[c-'a']==null)
                curr.arr[c-'a'] = new TrieNode();
            curr = curr.arr[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            if(curr!=null && curr.arr[c-'a']!=null)
                curr = curr.arr[c-'a'];
            else
                return false;
        }
        if(curr!=null && curr.isEnd)
            return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c:prefix.toCharArray()){
            if(curr!=null && curr.arr[c-'a']!=null)
                curr = curr.arr[c-'a'];
            else
                return false;
        }
        return true;
    }
}
class TrieNode{
    boolean isEnd;
    TrieNode[] arr;

    public TrieNode(){
        this.isEnd = false;
        this.arr = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */