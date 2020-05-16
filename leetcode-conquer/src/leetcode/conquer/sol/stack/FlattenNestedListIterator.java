package leetcode.conquer.sol.stack;
import java.util.*;
import leetcode.conquer.sol.recursion.util.NestedInteger;

/*
 * use queue and recursion to store the nodes.
 * then pop
 * Time O(n)
 * Space constant
 */
public class FlattenNestedListIterator implements Iterator<Integer> {
    private Queue<NestedInteger> q = new LinkedList<>();
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        helper(nestedList);
    }
    
    private void helper(List<NestedInteger> nestedList){
        for(NestedInteger node : nestedList){
            if(node.getInteger() == null){
                helper(node.getList());
            }else{
                q.offer(node);
            }
        }
    }

    @Override
    public Integer next() {
        return q.poll().getInteger();
    }

    @Override
    public boolean hasNext() {
        return !q.isEmpty();
    }
}

