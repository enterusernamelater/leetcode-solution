package leetcode.conquer.sol.recursion;
import java.util.*;


/*
 * first build graph with email as the node and connecting all possible email on associated accounts.
 * meanwhile keeping an emailToName (this will be later used to retrieve email with duplicate accounts)
 * dfs on a given email node and store all its path node in the end add to the result sorted with the emailToname value 
 * https://www.youtube.com/watch?v=J5YnIxbG3hw
 * O(nlog(n)) due to the sort
 * Space O(n) n being the number of emails + names
 */
public class AccountsMerge {
	public AccountsMerge() {}
	
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if(accounts == null || accounts.isEmpty()) return new ArrayList<>();
        Map<String, Set<String>> g = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        buildGraph(g,emailToName,accounts);
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        
        for(String email : emailToName.keySet()){
            if(visited.add(email)){
                LinkedList<String> list = new LinkedList<>();
                dfs(g,list,visited,email);
                Collections.sort(list);
                list.add(0,emailToName.get(email));
                res.add(list);
            }
        }
        return res;
    }
    
    private void dfs(Map<String, Set<String>> g, LinkedList<String> list, Set<String> visited, String email){
        for(String currentEmail : g.get(email)){
            if(visited.add(currentEmail)){
                dfs(g,list,visited,currentEmail);
            }
        }
        
        list.add(email);
    }
    
    private void buildGraph(Map<String, Set<String>> g, Map<String,String> emailToName, List<List<String>> accounts){
        for(List<String> account : accounts){
            String name = account.get(0); //the first one is the name;
            for(int i=1;i<account.size();i++){
                emailToName.put(account.get(i),name);
                g.putIfAbsent(account.get(i),new HashSet<>());
                if(i==1) continue;
                
                g.get(account.get(i-1)).add(account.get(i));
                g.get(account.get(i)).add(account.get(i-1));     
            }
        }
    }
}
