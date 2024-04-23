package concurrency.data.engine;

import java.util.ArrayList;
import java.util.List;

public class DataPartitioner {
	
	public static List<List<Integer>> partition(List<Integer> dataset,
			int numPartitions) {
		List<List<Integer>> partitions = new ArrayList<>();
		
		//calculate partitin size
		int partitionSize = dataset.size()/numPartitions;
		
		//create partitions
		for(int i=0;i<numPartitions;i++) {
			int start=i*partitionSize;
			int end= (i==(numPartitions-1))? dataset.size(): start+partitionSize;
			partitions.add(dataset.subList(start, end));
		}
		
		return partitions;
	}

}
