package leetcode.conquer.sol.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/*
 * the idea behind this question is making the root key for all given strings meaning for example:
 * xyz the root key is abc. we doing this by first finding the offset meaning how many times the first char
 * has been shifted. 
 * then we bring we remaining chars back to the origin by using the offset. 
 * a special case happens when resetting a char's offset brings the char to before 'a' in ascii, this usually happens
 * when the current char we are resetting has already completed a 26 char loop. Therefore we add 26 to this character
 * so this char becomes the original.
 * 
 * Note: the key to think around this question after finding the shifting offset is this
 * what char after shifting by the offset end up to be the current char.
 * and the 'what char' here is the root key char.
 * Time O(n)
 * Space O(n)
 */
public class GroupShiftedStrings {
	public GroupShiftedStrings() {}
	
    public List<List<String>> groupStrings(String[] strings) {
        if(strings == null || strings.length == 0) return new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        
        for(String s : strings){
            char[] arr = s.toCharArray();
            int offset = arr[0] - 'a';
            for(int i=0;i<arr.length;i++){
                arr[i] -= offset;
                //if is out of range, we add 26 so that the char addition to 26 plus the offset will equal to the original arr[i]
                //think of this ass arr[i] += 26 - offset
                if(arr[i] < 'a') arr[i]+=26;
            }
            String key = new String(arr);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);
            map.putIfAbsent(key,list);
        }
        
        return new ArrayList<>(map.values());
    }
}
