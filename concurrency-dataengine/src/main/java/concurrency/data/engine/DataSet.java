package concurrency.data.engine;

import java.util.ArrayList;
import java.util.List;

public class DataSet {
	
	public static List<Integer> create(int size){
		
		if(size==0)
			throw new IllegalArgumentException("Empty dataset: size cannot be 0");
		
		List<Integer> dataset=new ArrayList<>();
		
		for(int i=0; i <size; i++) {
			dataset.add(i);
		}
		
		return dataset;
	}

}
