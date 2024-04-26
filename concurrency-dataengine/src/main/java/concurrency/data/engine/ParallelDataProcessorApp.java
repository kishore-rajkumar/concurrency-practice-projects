package concurrency.data.engine;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ParallelDataProcessorApp {
	
	public static void main(String[] args) {
		//create dataset
		int oneMillionDataSet=100000;
		List<Integer> dataset = DataSet.create(oneMillionDataSet);
		
		//partition dataset
		int numPartitions = 2000000;
		List<List<Integer>> partitions = DataPartitioner.partition(
				dataset, numPartitions);
		
		//process dataset
		int numThreads = 3;
		ParallelDataProcessor processor = new ParallelDataProcessor(
				numThreads, partitions);
		try {
			
			int total = processor.process();
			System.out.println("Sum Total : " + total);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}finally {
			processor.shutdown();
		}
	}

}
