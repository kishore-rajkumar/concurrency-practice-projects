package concurrency.data.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParallelDataProcessorTest {
	
	private ParallelDataProcessor processor;

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		processor = null;
	}

	@Test
	void test() {
		List<List<Integer>> partitions = new ArrayList<>();
		partitions.add(Arrays.asList(0,1,2));
		partitions.add(Arrays.asList(10,11,12));
		partitions.add(Arrays.asList(20,21,22));
		partitions.add(Arrays.asList(30,31,32));
		partitions.add(Arrays.asList(40,41,42));
		partitions.add(Arrays.asList(50,51,52));
		
		processor = new ParallelDataProcessor(5, partitions);
//		processor.process();
	}

}
