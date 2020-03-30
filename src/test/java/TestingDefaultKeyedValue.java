import static org.junit.Assert.*;
import org.jfree.data.DefaultKeyedValue;
import org.junit.Test;
import org.mockito.Mockito;
import org.jfree.chart.util.Args;

public class TestingDefaultKeyedValue {

	@Test
	public void testHashCodeNull() {
		DefaultKeyedValue d2 = new DefaultKeyedValue("key",null);
		assertTrue(d2.hashCode() == 3076291);
	}

	@Test
	public void testHashCodeNumber() {
		DefaultKeyedValue d1 = new DefaultKeyedValue("key",100.0);
		assertTrue(d1.hashCode() == 1082650819);
	}
	
	@Test
	public void testDefaultKeyedValueNull() {
		Args mockArgs = Mockito.mock(Args.class);
		//Mockito.doNothing().when(mockArgs).nullNotPermitted("key","key");
		
		DefaultKeyedValue d1 = new DefaultKeyedValue("key",null);
		assertEquals("key",d1.getKey());
		assertEquals(null,d1.getValue());
	}
	
	@Test
	public void testDefaultKeyedValueNumber() {
		Args mockArgs = Mockito.mock(Args.class);
		Mockito.doNothing().when(mockArgs).nullNotPermitted("key","key");
		
		int k = 100;
		
		DefaultKeyedValue d1 = new DefaultKeyedValue("key",k);
		assertEquals("key",d1.getKey());
		assertEquals(100,d1.getValue());
	}

	
	@Test
	public void testGetKey() {
		DefaultKeyedValue d = new DefaultKeyedValue("key",3.4);
		String dummy = (String) d.getKey();
		assertEquals("key",dummy);
	}

	@Test
	public void testGetValueNull() {
		DefaultKeyedValue d2 = new DefaultKeyedValue("key",null);
		Number n2 = d2.getValue();
		assertEquals(null,n2);
	}

	@Test
	public void testGetValueNumber() {
		DefaultKeyedValue d = new DefaultKeyedValue("key",3.4);
		Number n = d.getValue();
		assertEquals(3.4,n);
	}
	
	@Test
	public void testSetValueNull() {
		//Testing for setting a normal Number Value and null
		DefaultKeyedValue d = new DefaultKeyedValue("key",100);
		d.setValue(null);
		Number n2 = d.getValue();
		assertEquals(null,n2);
	}

	@Test
	public void testSetValueNumber() {
		//Testing for setting a normal Number Value and null
		DefaultKeyedValue d = new DefaultKeyedValue("key",100);
		d.setValue(50.0);
		Number n = d.getValue();
		assertEquals(50.0,n);
	}
	
	@Test
	public void testEqualsObjectEqual() throws CloneNotSupportedException {
		DefaultKeyedValue d1 = new DefaultKeyedValue("key",100);
		DefaultKeyedValue d2 = new DefaultKeyedValue("key",100);
		
		assertTrue(d1.equals(d2));
		assertTrue(d1.equals(d1));
		
	}

	@Test
	public void testEqualsObjectNotEqual() throws CloneNotSupportedException {
		DefaultKeyedValue d1 = new DefaultKeyedValue("key",100);
		DefaultKeyedValue d4 = new DefaultKeyedValue("key",100);
		
		d4.setValue(50.0);
		
		assertFalse(d1.equals(d4));
	}
	
	@Test
	public void testEqualsObjectClone() throws CloneNotSupportedException {
		DefaultKeyedValue d1 = new DefaultKeyedValue("key",100);
		DefaultKeyedValue d3 = (DefaultKeyedValue) d1.clone();
		assertTrue(d3.equals(d1));
	}
	
	@Test
	public void testCloneNull() throws CloneNotSupportedException  {
		DefaultKeyedValue d3 = new DefaultKeyedValue("key",null);
		DefaultKeyedValue d4 = (DefaultKeyedValue) d3.clone();
		assertEquals(d3.getValue(),d4.getValue());
		
	}

	@Test
	public void testCloneNumber() throws CloneNotSupportedException  {
		DefaultKeyedValue d1 = new DefaultKeyedValue("key",100);
		DefaultKeyedValue d2 = (DefaultKeyedValue) d1.clone();
		assertEquals(d1.getKey(),d2.getKey());
		assertEquals(d1.getValue(),d2.getValue());
	}

	
	@Test(expected = java.lang.NullPointerException.class)
	public void testToStringException() {
		//Issue not handled in code,null value can't be converted to string
		DefaultKeyedValue k2 = new DefaultKeyedValue("key",null);
		k2.toString();
	}
	
	@Test
	public void testToString() {
		DefaultKeyedValue k = new DefaultKeyedValue(10.4,3.5); 
		String dummy = "(10.4, 3.5)";
		assertEquals(dummy,k.toString());		
	}

}
