package concurrency.data.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataSetTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		
		int oneMillionDataPoints=1000000;
		int actual = DataSet.create(oneMillionDataPoints).size();
		
		assertEquals(oneMillionDataPoints, actual);
		
	}
	
	@Test
	void emptyDataset() {
		int zeroDataPoints=0;
		
		Exception exception = assertThrows(IllegalArgumentException.class,
				()-> DataSet.create(zeroDataPoints));
		
		assertEquals("Empty dataset: size cannot be 0", exception.getMessage());
	}

}
