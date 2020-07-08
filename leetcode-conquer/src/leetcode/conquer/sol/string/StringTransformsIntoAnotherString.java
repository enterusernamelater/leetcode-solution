package leetcode.conquer.sol.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * basically making sure that one char cannot change to two differ char and the following
 * 想这个例子(ab,ba) a->b 你先变, 你再把b->a 这样前面才变的b也变a了。所以我们需要一个tmp，a->tmp, 最后完成b->a 以后 变 tmp->a. 
 * tmp不会应为b的改变而被影响。所以你只要不把所有char 都变， 有一个可以当tmp这样就可以成立改变 要不然就不能break cycle
 * Time O(n)
 * Space o(N)
 */
public class StringTransformsIntoAnotherString {
	public StringTransformsIntoAnotherString() {}
	
    public boolean canConvert(String str1, String str2) {
        if(str1.equals(str2)) return true;
        Map<Character,Character> map = new HashMap<>();
        for(int i=0;i<str1.length();i++){
            if(map.getOrDefault(str1.charAt(i),str2.charAt(i)) != str2.charAt(i)) return false;
            map.putIfAbsent(str1.charAt(i),str2.charAt(i));
            
        }
        
        return new HashSet<>(map.values()).size()<26;
    }
}
