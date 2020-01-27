package leetcode.conquer.sol.queue.priority;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * add the queue if words not exceed the maxWidth. if exceed the maxWidth we pop all out to form the string
 * when we reach the end we handle the special case 
 * see comments below on the conditions applied.
 */
public class TextJustification {
	public TextJustification() {}
	
    public List<String> fullJustify(String[] words, int maxWidth) {
        int curr = 0;
        Queue<String> queue = new LinkedList<>();
        List<String> res =new ArrayList<>();
        int size = 0;
        int space = 0;
        int extraleft = 0;
        
        for(int i=0; i<words.length; i++){
            size = queue.size();
            //if the current string addition plus the single space in between is still with in the maxWidth
            //the queue size here can be used to represent the single space between each word including the 
            //addition of the words[i]
            if(curr + words[i].length() + size <= maxWidth){
                queue.offer(words[i]);
                curr+=words[i].length();
            }else{
            	//calculating the base space in between 
                space = size == 1? maxWidth-curr : (maxWidth-curr)/(size-1);
                //if not even, I grab the reminder as the space to distribute across the words in queue starting from beginning 
                //one at a time
                //of course special case handle if the current queue has only one word. all spaces added from left to right
                extraleft = size == 1? 0 : (maxWidth-curr)%(size-1);
                StringBuilder sb = new StringBuilder();
                while(!queue.isEmpty()){
                    sb.append(queue.poll());
                    //dont add the spaces to the last word
                    if(sb.length() < maxWidth){ 
                        for(int j=0; j<space; j++) sb.append(" ");
                        //now we add the extra space calculated above one per word from the starting until the extraleft reaches 0
                        if(extraleft-- > 0) sb.append(" ");
                    }
                }
                //adding the builded string and reset curr and queue
                res.add(sb.toString());
                curr = words[i].length();
                queue.offer(words[i]);
            }
            
            //when i reaches the last word we build the last row as the special case
            if(i == words.length-1){
                StringBuilder sb = new StringBuilder();
                while(!queue.isEmpty()){
                    sb.append(queue.poll());
                    if(!queue.isEmpty()) sb.append(" ");
                }
                while(sb.length() < maxWidth){
                    sb.append(" ");
                }
                   res.add(sb.toString());
            }
        }
        
        return res;
    }
}
