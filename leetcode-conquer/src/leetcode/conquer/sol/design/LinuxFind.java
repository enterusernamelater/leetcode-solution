package leetcode.conquer.sol.design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * 
Implemnet linux find command as an api ,
the api willl support finding files that has given size requirements and a file with a certain format like
find all file >5mb
find all xml
create a library flexible that is flexible
Design clases,interfaces.
 */
public class LinuxFind {
	public List<File> findFileByFilters(Directory dirct, Filter filter){
			if(filter == null) return new ArrayList<>();
			findFileBFS(dirct, filter);
			return findFileDfs(dirct,filter);
			
	}
	
	private List<File> findFileDfs(Directory directory, Filter filter) {
		
		List<File> list = new ArrayList<>();
		for(Directory dict : directory.dictories) {
			List<File> files = findFileDfs(dict,filter);
			list.addAll(files);
		}
		
		for(File file : directory.files) {
			if(filter.applyFilter(file)) list.add(file);
		}
		return list;
	}
	
	private List<File> findFileBFS(Directory directory, Filter filter){
		Queue<Directory> q = new LinkedList<>();
		q.offer(directory);
		List<File> result = new ArrayList<>();
		
		while(!q.isEmpty()){
			for(int k=q.size();k>0;k--) {
				Directory dic = q.poll();
				for(File file : dic.files) {
					if(filter.applyFilter(file)) result.add(file);
				}
				for(Directory nextDic : dic.dictories) q.offer(nextDic);
			}
		}
		return result;
	}
}

class Directory{
	public List<File> files = new ArrayList<>();
	public List<Directory> dictories = new ArrayList<>();
	public Directory() {}
	
}

interface Filter{
	public boolean applyFilter(File file);
}

class notFilter implements Filter{
	List<Filter> filters;

	public notFilter(List<Filter> filters) {
		this.filters = filters;
	}
	
	public boolean applyFilter(File file) {
		for(Filter filter : filters) {
			if(filter.applyFilter(file)) return false;
		}
		return true;
	}
}

class andFilter implements Filter{
	List<Filter> filters;

	public andFilter(List<Filter> filters) {
		this.filters = filters;
	}
	public boolean applyFilter(File file) {
		for(Filter filter : filters) {
			if(!filter.applyFilter(file)) return false;
		}
		return true;
	}
}

class orFilter implements Filter{
	List<Filter> filters;

	public orFilter(List<Filter> filters) {
		this.filters = filters;
	}
	public boolean applyFilter(File file) {
		for(Filter filter : filters) {
			if(filter.applyFilter(file)) return true;
		}
		return false;
	}
}

class minSizeFilter implements Filter{
	public Integer minSize;
	public minSizeFilter(int minSize) {
		this.minSize = minSize;
	}
	
	public boolean applyFilter(File file) {
		return file.size > minSize;
	}
}

class typeFilter implements Filter{
	public String type;
	
	public typeFilter(String type) {
		this.type = type;
	}
	
	public boolean applyFilter(File file) {
		return file.type.equals(type);
	}
}

class nameFilter implements Filter{
	public String name;
	public nameFilter(String name) {
		this.name = name;
	}
	
	public boolean applyFilter(File file) {
		return file.name.equals(this.name);
	}
}

class File{
	public int size;
	public String name;
	public String type;
	public File() {};
}
