package concurrency.data.engine;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ParallelDataProcessorApp {
	
	public static void main(String[] args) {
		//create dataset
		int oneMillionDataSet=100000;
		List<Integer> dataset = DataSet.create(oneMillionDataSet);
		
		LocalDateTime from = LocalDateTime.now();
		System.out.println("START >>> "+from);
		//process
		processDataset(dataset);
		LocalDateTime to = LocalDateTime.now();
		System.out.println("END >>> "+to);
		System.out.println("Time Taken >>> "+Duration.between(from, to));
	}

	private static void processDataset(List<Integer> dataset) {
		//partition dataset
		int numPartitions = 2000;
		List<List<Integer>> partitions = DataPartitioner.partition(
				dataset, numPartitions);
		
		// call multiple processor threads
		int numThreads = 3;
		System.out.println("THREADS: " + numThreads);
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
