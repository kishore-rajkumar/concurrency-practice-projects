package concurrency.data.engine;

import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataProcessingTaskRunnable implements Runnable {
	
	private int sum;
	private final List<Integer> partition;
	
	private Lock lock = new ReentrantLock(); // why reentrant used ??

	public DataProcessingTaskRunnable(List<Integer> _partition) {
		this.partition = _partition;
	}

	@Override
	public void run() {
		if(partition.isEmpty())
			throw new IllegalArgumentException("empty partition");
		
		try{
			lock.lock();
			
			for(int i=0; i<partition.size();i++) {
				sum+=partition.get(i);
			}
			
			System.out.println(partition+" | sum: "+sum +" | at "+ new Date());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public int getSum() {
		return sum;
	}

}
