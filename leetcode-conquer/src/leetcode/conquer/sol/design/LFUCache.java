package leetcode.conquer.sol.design;

import java.util.HashMap;
import java.util.Map;

/*
 * in LRU cache design we need only one double link list and a map to keep track of the key nodes
 * however in LFU we will need a map to store frequencies as key and each frequency points to a double linkedlist
 * the doublelinklist will handle the case we frequencies are the same and LRU principle applies thats why we will need the double linked list
 * once the min freq is determined and the max capacity is reach we remove the min frequency's double link list's LRU 
 * we keep a min count. increment the min if after get key the current min double link list is empty. reset the min to 1 when add.
 * the double linked list has a len when add we +1 and remove we -1. if the list is empty we remove from the dlinkmap
 * Time O(1)
 * Space O(n)
 */
class LFUCache {
    int min = 0;
    Map<Integer, Node> nodeMap = new HashMap<>();
    Map<Integer,Dlink> dlinkMap = new HashMap<>();
    int capacity = 0;
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node node = nodeMap.get(key);
        if(node == null) return -1;
        
        Dlink dlink = dlinkMap.get(node.count);
        dlink.removeNode(node);
        if(dlink.len == 0){
            dlinkMap.remove(node.count);
            if(node.count == min) min++;
        }
        node.count++;
        dlink = dlinkMap.getOrDefault(node.count, new Dlink());
        dlink.addNode(node);
        dlinkMap.putIfAbsent(node.count,dlink);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.value = value;
            get(key);
            return;
        }
        
        if(nodeMap.size() == capacity){
           Dlink dlink = dlinkMap.get(min);
           Node node = dlink.removeLeast();
           nodeMap.remove(node.key);
           if(dlink.len == 0) dlinkMap.remove(min);
        }
        
        Node newNode = new Node(value,1,key);
        min=1;
        nodeMap.put(key,newNode);
        Dlink dlink = dlinkMap.getOrDefault(1,new Dlink());
        dlink.addNode(newNode);
        dlinkMap.putIfAbsent(1,dlink);
    }
}

class Node{
    public int value;
    public int count;
    public int key;
    public Node prev;
    public Node next;
    
    public Node(int value, int count, int key){
        this.value = value;
        this.count = count;
        this.key = key;
    }
}

class Dlink{
    public Node head = new Node(0,0,0);
    public Node tail = new Node(0,0,0);
    public int len = 0;
    
    public Dlink(){
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public void addNode(Node node){
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        len++;
    }
    
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        len--;
    }
    
    public Node removeLeast(){
        Node node = head.next;
        removeNode(node);
        return node;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
