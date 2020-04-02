package leetcode.conquer.sol.graph;

public class FindTheCelebrity extends Relation{
	
	public FindTheCelebrity() {}
	
    public int findCelebrity(int n) {
        int celeb = 0;
        
        //trace the graph finding the node that has no pointer
        //due to the question criteria there should be only one celeb 
        //and all other nodes should be pointing to the celeb
        //its possible to have a circler graph, therefore when need to check the celeb
        //after the candidate picked.
        for(int i=0;i<n;i++){
            if(knows(celeb,i)) celeb = i;
        }
        
        //checking if someone doesn't know the celeb, and if the celeb is in a circler graph
        //meaning the celeb knows someone 
        for(int i=0;i<n;i++){
            if(i == celeb) continue;
            if(!knows(i,celeb) || knows(celeb,i)) return -1;
        }
        return celeb;
    }
	
	// assuming all are celebrity until one found. if no one found return -1;
	// a naive solution
    public int findCelebrityMySol(int n) {
        int res = -1;
        for(int i=0;i<n;i++){
            boolean found = true;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(knows(i,j) || !knows(j,i)){
                    found = false;
                    break;
                }
            }
            if(found){
                if(res != -1) return -1;
                res = i;
            }
        }
        
        return res;
    }
}
