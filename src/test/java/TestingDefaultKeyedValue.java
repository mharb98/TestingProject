import static org.junit.Assert.*;

import org.jfree.data.DefaultKeyedValue;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.hamcrest.CoreMatchers.*;
import org.jfree.chart.util.Args;

public class TestingDefaultKeyedValue {

	@Test
	public void testHashCode() {
		DefaultKeyedValue d1 = new DefaultKeyedValue("key",100.0);
		DefaultKeyedValue d2 = new DefaultKeyedValue("key",null);
		assertTrue(d1.hashCode() == 1082650819);
		assertTrue(d2.hashCode() == 3076291);
	}

	@Test
	public void testDefaultKeyedValue() {
		//Testing the constructor for initializing keys,values
		Args mockArgs = Mockito.mock(Args.class);
		Object param = null;
		Mockito.doNothing().when(mockArgs).nullNotPermitted("key","key");
		DefaultKeyedValue d1 = new DefaultKeyedValue("key",100);
		assertEquals("key",d1.getKey());
		assertEquals(100,d1.getValue());
		
		DefaultKeyedValue d2 = new DefaultKeyedValue("key",null);
		assertEquals("key",d2.getKey());
		assertEquals(null,d2.getValue());
	}

	@Test
	public void testGetKey() {
		DefaultKeyedValue d = new DefaultKeyedValue("key",3.4);
		String dummy = (String) d.getKey();
		assertEquals("key",dummy);
	}

	@Test
	public void testGetValue() {
		//Value could be Number and could be null
		DefaultKeyedValue d = new DefaultKeyedValue("key",3.4);
		Number n = d.getValue();
		assertEquals(3.4,n);
		
		DefaultKeyedValue d2 = new DefaultKeyedValue("key",null);
		Number n2 = d2.getValue();
		assertEquals(null,n2);
	}

	@Test
	public void testSetValue() {
		//Testing for setting a normal Number Value and null
		DefaultKeyedValue d = new DefaultKeyedValue("key",100);
		d.setValue(50.0);
		Number n = d.getValue();
		assertEquals(n,50.0);
		
		d.setValue(null);
		Number n2 = d.getValue();
		assertEquals(n2,null);
	}

	@Test
	public void testEqualsObject() throws CloneNotSupportedException {
		/*
		 * Testing for two self made equal objects for equality
		 * Using setValue to alter Value of object 2 to test for Value inequality
		 * Using Clone method to check for equality
		 * Using Two different keyed objects to test for ket inequality*/
		DefaultKeyedValue d1 = new DefaultKeyedValue("key",100);
		DefaultKeyedValue d2 = new DefaultKeyedValue("key",100);
		DefaultKeyedValue d4 = new DefaultKeyedValue("key2",100);
		assertTrue(d1.equals(d2));
		
		d1.setValue(150);
		assertFalse(d2.equals(d1));
		
		DefaultKeyedValue d3 = (DefaultKeyedValue) d1.clone();
		assertTrue(d3.equals(d1));
		
		assertFalse(d1.equals(d4));
		
	}

	@Test
	public void testClone() throws CloneNotSupportedException  {
		//Testing for equality of keys and values(including null values)
		DefaultKeyedValue d1 = new DefaultKeyedValue("key",100);
		DefaultKeyedValue d2 = (DefaultKeyedValue) d1.clone();
		assertEquals(d1.getKey(),d2.getKey());
		assertEquals(d1.getValue(),d2.getValue());
		
		DefaultKeyedValue d3 = new DefaultKeyedValue("key",null);
		DefaultKeyedValue d4 = (DefaultKeyedValue) d3.clone();
		assertEquals(d3.getValue(),d4.getValue());
		
	}

	@Test(expected = java.lang.NullPointerException.class)
	public void testToStringException() {
		//Testing for a null value exception for toString method
		//Issue not handled in code,null value can't be converted to string
		DefaultKeyedValue k2 = new DefaultKeyedValue("key",null);
		k2.toString();
	}
	
	@Test
	public void testToString() {
		//Testing for a normal Number value
		DefaultKeyedValue k = new DefaultKeyedValue(10.4,3.5); 
		String dummy = "(10.4, 3.5)";
		assertEquals(dummy,k.toString());		
	}

}
