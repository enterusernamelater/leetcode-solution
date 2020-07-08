package leetcode.conquer.sol.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/*
 * this is a trie but using treemap
 * Time O(nlogN)
 * space constant
 * 
 */
public class DesignInMemoryFileSystem {
	public DesignInMemoryFileSystem() {}
	
    private Node root = new Node("");
    
    public List<String> ls(String path) {
        String[] token = path.split("/");
        Node current = root;
        for(int i=0;i<token.length;i++){
           if(token[i].isBlank()) continue;
           current = current.map.get(token[i]);
        }
        if(!current.file.toString().isEmpty()) return Arrays.asList(current.dir);
        return new ArrayList<>(current.map.keySet());
    }
    
    public void mkdir(String path) {
        String[] token = path.split("/");
        Node current = root;
        for(int i=0;i<token.length;i++){
           if(token[i].isBlank()) continue;
           Node newNode = current.map.getOrDefault(token[i], new Node(token[i]));
           current.map.putIfAbsent(token[i],newNode);
           current = newNode;
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] token = filePath.split("/");
        Node current = root;
        for(int i=0;i<token.length;i++){
           if(token[i].isBlank()) continue;
           Node newNode = current.map.getOrDefault(token[i], new Node(token[i]));
           current.map.putIfAbsent(token[i],newNode);
           current = newNode;
        }
        current.file.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        String[] token = filePath.split("/");
        Node current = root;
        for(int i=0;i<token.length;i++){
            if(token[i].isBlank()) continue;
            current = current.map.get(token[i]);
        }
       return current.file.toString(); 
    }
    
    class Node{
        public TreeMap<String,Node> map = new TreeMap<>();
        public StringBuilder file = new StringBuilder();
        public String dir;
        public Node(String dir){this.dir = dir;}
    }
}
