package leetcode.conquer.sol.recursion.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * using trie store the products and then for each prefix searchword 0 to word.length-1 find all words under the prefix(when reach the isEnd) 
 * and add to the result
 * Time O(nlog(n))
 * Space O(n)
 */
public class SearchSuggestionsSystem {
	public SearchSuggestionsSystem() {}
		
    private List<List<String>> res = new ArrayList<>();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        if(products == null || products.length == 0) return res;
        Trie root = new Trie();
        
        for(String word : products){
            addTrie(word,root);
        }
        
        for(int i=1;i<=searchWord.length();i++){
            String subword = searchWord.substring(0,i);
            List<String> list = new ArrayList<>();
            search(subword,subword,root,list);
            res.add(list);
        }
        return res;
    }
    
    private void search(String s, String curr, Trie root, List<String> list){
        if(root == null) return;
        if(curr.length() == 0){
            addSearch(s,root,list);
        }else{
            search(s,curr.substring(1),root.get(curr.charAt(0)-'a'),list);
        }
    }
    
    private void addSearch(String s, Trie root, List<String> list){
        if(list.size() == 3 || root == null) return;
        if(root.isEnd){
            list.add(s);
        }
        
        for(int i=0;i<26;i++){
            if(root.get(i) == null) continue;
            char c = (char)('a'+i);
            addSearch(s+c, root.get(i), list);
        }
    }
    
    private void addTrie(String word, Trie node){
        if(word.length() == 0){
            node.isEnd = true;
            return;
        }
        int index = word.charAt(0)-'a';
        if(node.get(index) == null) node.put(word.charAt(0));
        addTrie(word.substring(1),node.get(index));
    }
    
    /*
     * sort the list and use bst to determin the correct start index for each prefix on searchword
     * Time O(nlogn(m)) n being the length of searchword m being the number of product words.
     * Space constant besides the result
     */
    public List<List<String>> suggestedProductsBST(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        for(int i=0;i<searchWord.length();i++) res.add(new ArrayList<>());
        
        Arrays.sort(products);
        for(int i=1;i<=searchWord.length();i++){
            String subword = searchWord.substring(0,i);
            int l=0;
            int r=products.length-1;
            
            while(l<r){
                int mid = l + (r-l)/2;
                String midString = products[mid];
                
                if(midString.startsWith(subword)){
                    r=mid;
                }else{
                    int val = subword.compareTo(midString);
                    if(val < 0) r = mid;
                    else l = mid+1;
                }
            }
            
            for(int j=r;j<products.length && res.get(i-1).size()<3;j++){
                if(products[j].startsWith(subword)) res.get(i-1).add(products[j]);
                else break;
            }
        }
        
        return res;
    }
}

class Trie{
    Trie[] trie = new Trie[26];
    boolean isEnd = false;
    
    public Trie(){}
    
    public void put(char c){
        this.trie[c-'a'] = new Trie();
    }
    
    public Trie get(int i){
        return trie[i];
    }
}
