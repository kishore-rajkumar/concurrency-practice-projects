package concurrency.data.engine;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelDataProcessor {
	
	private ExecutorService executor; //??
	private List<List<Integer>> partitions;
	
	public ParallelDataProcessor(int numThreads,List<List<Integer>> partitions) {
		this.executor = Executors.newFixedThreadPool(numThreads);
		this.partitions=partitions;
	}
	
	// process method
	public int process() throws InterruptedException, ExecutionException {
		int sum = 0;
		for(List<Integer> partition:partitions) {
			Future<Integer> future = executor.submit(new DataProcessingTaskCallable(partition));
			sum+=future.get();
		}
		return sum;
	}
	
	// thread pool shutdown method
	public void shutdown() {
		executor.shutdown();
	}
}
