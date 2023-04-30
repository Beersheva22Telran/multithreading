package telran.multithreading.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
class ParallelStreamTest {
private static final long N_NUMBERS = 10_000_000;
Integer[] array = {100, -10, 20, -90, 50, 40, 60, 100, -10};
int[] bigArray = ThreadLocalRandom.current().ints(N_NUMBERS).toArray();
	@BeforeEach
	void setUp() throws Exception {
	}
int index = 0;
	//@Test
	void test() {
		Integer[] expected = {-90, -10, -10, 20, 40, 50,  60, 100,  100, };
		HashSet<String> threadNames = new HashSet<>();
		Integer[] actual = new Integer[expected.length];
//		final int[] index = {0};
		
		Arrays.stream(array).parallel().sorted((a, b) -> {
			threadNames.add(Thread.currentThread().getName());
			return a - b;
		}).forEachOrdered((num) -> {actual[index++] = num;
		threadNames.add(Thread.currentThread().getName());
		});
		System.out.println(threadNames);
		assertArrayEquals(expected, actual);
	}
	@Test
	void bigArrayTest() {
		
		HashSet<String> threadNames = new HashSet<>();
		
//		final int[] index = {0};
		
		Arrays.stream(bigArray).boxed().sorted((a, b) -> {
			threadNames.add(Thread.currentThread().getName());
			return Integer.compare(a, b);
		}).toArray();
		System.out.println(threadNames);
	}

}
