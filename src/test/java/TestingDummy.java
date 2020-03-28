import static org.junit.Assert.*;

import org.junit.Test;

public class TestingDummy {

	@Test
	public void testDummyClass() {
		assertTrue(true);
	}

	@Test
	public void testReturnDummy() {
		DummyClass dummy = new DummyClass();
		int b = dummy.returnDummy();
		assertEquals(5,b);
	}

}
