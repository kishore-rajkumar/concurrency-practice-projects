package concurrency.data.engine;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataProcessingTaskCallable implements Callable<Integer> {
	
	private final List<Integer> partition;
	
	private Lock lock = new ReentrantLock(); //why reentrant??
	
	public DataProcessingTaskCallable(List<Integer> partition) {
		this.partition = partition;
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
// ensure locking
		try {
			lock.lock();
			for(int i=0;i<partition.size();i++) {
				sum+=partition.get(i);
			}
		}finally {
			lock.unlock();
		}
		
		return sum;
	}


}
