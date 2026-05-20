class WordDictionary {
    Trie root;
    public WordDictionary() {
        this.root = new Trie();
    }
    // O(1) time to add the word to the trie as length of the word can be max 25
    public void addWord(String word) {
         Trie curr = root;
        for(char c:word.toCharArray()){
            if(curr.arr[c-'a']==null)
                curr.arr[c-'a'] = new Trie();
            curr = curr.arr[c-'a'];
        }
        curr.endWord = true;
    }
    // Rather than going for all possible combinations we can start from bottom up dfs approach it reduces time complexity to O(N) rather than O(26^2 x N)
    public boolean dfs(Trie root,int index,String word){
        Trie curr = root;
        for(int i=index;i<word.length();i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(Trie t:curr.arr){
                    if(t!=null && dfs(t,i+1,word))
                        return true;
                }
                return false;
            }else{
                if(curr.arr[c-'a'] == null)
                    return false;
                curr = curr.arr[c-'a'];
            }
        }
        return curr.endWord;
    }
    public boolean search(String word) {
        return dfs(root,0,word);
    }
}
class Trie{
    boolean endWord;
    Trie[] arr;
    public Trie(){
        this.endWord = false;
        this.arr = new Trie[26];
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */