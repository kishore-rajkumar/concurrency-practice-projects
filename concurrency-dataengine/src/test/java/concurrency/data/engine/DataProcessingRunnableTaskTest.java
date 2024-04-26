package concurrency.data.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataProcessingRunnableTaskTest {
	
	private DataProcessingTaskRunnable task;
	private List<Integer> partition;

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		task=null;
		partition=null;
	}

	@Test
	void test_sum_of_partition() {
		partition=Arrays.asList(0,1,2);
		task=new DataProcessingTaskRunnable(partition);
		
		task.run();

		int expected=3;
		assertEquals(expected,task.getSum());
	}
	
	@Test
	void test_empty_partition_throws_illegal_agruments_exception() {
		partition=Arrays.asList();
		task=new DataProcessingTaskRunnable(partition);

		Exception ex = assertThrows(IllegalArgumentException.class, ()-> task.run());
		assertEquals("empty partition", ex.getMessage());
	}

}
