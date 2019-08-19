package leetcode.conquer.sol.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * using merge sort to solve this problem, a detailed explanation can be found in here:
 * https://www.youtube.com/watch?v=Cv0ft2dFz80
 * rules for the merge sort are in the vid
 * Time complexity O(nlog(n)) Space O(n)
 */
public class TheSkylineProblem {
	public TheSkylineProblem () {}

    public List<List<Integer>> getSkyline(int[][] buildings) {
        if(buildings == null || buildings.length == 0) return new ArrayList<>();
        
        return mergeSort(0, buildings.length-1, buildings);
    }
    
    private List<List<Integer>> mergeSort(int l, int r, int[][] buildings){
        if(l>r) return new ArrayList<>();
        
        if(l==r){
            int[] building = buildings[l];
            List<List<Integer>> merge = new ArrayList<>();
            int x1 = building[0];
            int x2 = building[1];
            int y = building[2];
            merge.add(new ArrayList<>(Arrays.asList(x2,0)));
            merge.add(0, new ArrayList<>(Arrays.asList(x1,y)));
            return merge;
        }else{
            int mid = (l+r) >> 1;
            
            List<List<Integer>> mergel = mergeSort(l,mid,buildings);
            List<List<Integer>> merger = mergeSort(mid+1,r,buildings);
            
            return mergeBuilding(mergel,merger);
        }
    }
    
    private List<List<Integer>> mergeBuilding(List<List<Integer>> mergel, List<List<Integer>>merger){
        if(mergel == null || mergel.isEmpty() || merger == null || merger.isEmpty()) return new ArrayList<>();
        
        int hl = 0 , hr = 0;
        
        List<List<Integer>> mergeList = new ArrayList<>();
        while(!mergel.isEmpty() && !merger.isEmpty()){
            List<Integer> arrl = mergel.get(0);
            List<Integer> arrr = merger.get(0);
            List<Integer> mergeArr = new ArrayList<>();
            
            if(arrl.get(0) < arrr.get(0)){
                if(arrl.get(1)<hr){
                    mergeArr.add(hr);
                }else{
                    mergeArr.add(arrl.get(1));
                }
                
                hl = arrl.get(1);
                
                mergeArr.add(0,arrl.get(0));
                mergel.remove(0);
            }else if(arrl.get(0) > arrr.get(0)){
                if(arrr.get(1)<hl){
                    mergeArr.add(hl);
                }else{
                    mergeArr.add(arrr.get(1));
                }
                
                hr = arrr.get(1);
                
                mergeArr.add(0,arrr.get(0));
                merger.remove(0);
            }else{
                mergeArr.add(Math.max(arrr.get(1),arrl.get(1)));

                mergeArr.add(0,arrr.get(0));
                hl = arrl.get(1);
                hr = arrr.get(1);
                merger.remove(0);
                mergel.remove(0);
            }
            
            mergeList.add(mergeArr);
        }
        
        while(!mergel.isEmpty()) mergeList.add(mergel.remove(0));
        while(!merger.isEmpty()) mergeList.add(merger.remove(0));
        
        removeDup(mergeList);
        return mergeList;
    }
    
    private void removeDup(List<List<Integer>> mergeList){
        if(mergeList == null || mergeList.isEmpty()) return;
        
        int curr = 0;
        while(curr < mergeList.size()){
            boolean found = true;
            int i = curr + 1;
            while(i<mergeList.size() && found){
                if(mergeList.get(curr).get(1).equals(mergeList.get(i).get(1))){
                    found = true;
                    mergeList.remove(i);
                }else{
                    found = false;
                }
            }
            curr++;
        }
    }
}
