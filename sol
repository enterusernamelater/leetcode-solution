class WordDictionary {
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(!node.containsKey(c)) node.put(c,new TrieNode());
            node = node.get(c);
        }
        node.setEnd();
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node = root;
        return searchRecursive(word, node);
    }

    public boolean searchRecursive(String word, TrieNode node){
        if((word == null || word.length() == 0) && node.isEnd()) return true;
        if(word == null || word.length() == 0) return false;

        if(word.charAt(0) == '.'){
            for(int i=0;i<26;i++){
                if(node.getIndex(i) == null) continue;
                TrieNode cur = node.getIndex(i);
                if(searchRecursive(word.substring(1),cur)) return true;
            }
        }
        return node.containsKey(word.charAt(0)) && searchRecursive(word.substring(1), node.get(word.charAt(0)));
    }
}

class TrieNode {
    private TrieNode[] links;
    private final int size = 26;
    private boolean isEnd;

    public TrieNode(){
        this.links=new TrieNode[size];
    }

    public boolean containsKey(char c){
        return links[c-'a'] != null;
    }

    public TrieNode get(char c){
        return links[c-'a'];
    }

    public TrieNode getIndex(int i){
        return links[i];
    }

    public void put(char c, TrieNode node){
        links[c-'a'] = node;
    }

    public void setEnd(){
        this.isEnd = true;
    }

    public boolean isEnd(){
        return this.isEnd;
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
