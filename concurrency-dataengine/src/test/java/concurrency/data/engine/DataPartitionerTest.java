package concurrency.data.engine;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataPartitionerTest {
	
	private List<Integer> dataset;

	@BeforeEach
	void setUp() throws Exception {
		dataset = DataSet.create(20);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {//test if the list of partitions returned contains the number of number of partitions required
		int numPartitions = 10;
		List<List<Integer>> partitions = DataPartitioner.partition(dataset,numPartitions);
		
		int actualSize = partitions.size();
		assertEquals(numPartitions,actualSize);
	}
	
	@Test
	void test_subDataset_of_given_dataset() {
		int numPartitions =4;
		List<List<Integer>> partitions = DataPartitioner.partition(dataset,numPartitions);
		
		List<Integer> expected=DataSet.create(5);
		List<Integer> actual = partitions.get(0);
		
		assertEquals(expected,actual);
	}

}
