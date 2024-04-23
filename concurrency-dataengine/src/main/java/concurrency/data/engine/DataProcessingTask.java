package concurrency.data.engine;

import java.util.Date;
import java.util.List;

// work on this
public class DataProcessingTask implements Runnable {
	
	private final List<Integer> partition;

	public DataProcessingTask(List<Integer> _partition) {
		this.partition = _partition;
	}

	@Override
	public void run() {
		int sum=0;
		for(int i=0; i<partition.size();i++) {
			sum+=partition.get(i);
		}
		System.out.println(partition+" | sum: "+sum +" | at "+ new Date());
	}

}
