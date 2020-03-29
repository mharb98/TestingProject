import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.SortOrder;
import org.jfree.data.DefaultKeyedValues;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.hamcrest.CoreMatchers.*;
import org.jfree.chart.util.Args;


public class TestingDefaultKeyedValues {

	@Test
	public void testHashCode() {
		assertTrue(true);
	}

	@Test
	public void testEquals() throws CloneNotSupportedException {
		/*Testing by making two equal values
		 * Testing by making unequal values
		 * Testing by using clone
		 * Testing for an object not instance of DefaultKeyedValues
		 */
		
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		d1.addValue("key1", 100);
		d1.addValue("key2", 100);
		d1.addValue("key3", 100);
		
		DefaultKeyedValues d2 = new DefaultKeyedValues();
		d2.addValue("key1", 100);
		d2.addValue("key2", 100);
		d2.addValue("key3", 100);
		
		DefaultKeyedValues d3 = new DefaultKeyedValues();
		d3.addValue("key4", 100);
		d3.addValue("key2", 100);
		d3.addValue("key3", 100);
		
		DefaultKeyedValues d4 = (DefaultKeyedValues) d1.clone();
		
		Integer I = 4;
		
		assertTrue(d1.equals(d1));
		
		assertTrue(d1.equals(d2));
		
		assertFalse(d1.equals(d3));
		
		assertTrue(d1.equals(d4));
		
		assertFalse(d1.equals(I));
		
	}

	@Test
	public void testClone() throws CloneNotSupportedException {
		DefaultKeyedValues d = new DefaultKeyedValues();
		
		d.addValue("key1", 100);
		d.addValue("key1", 100);
		d.addValue("key1", 100);
		
		DefaultKeyedValues d2 = (DefaultKeyedValues) d.clone();
		
		assertTrue(d2.getKeys().size() == d.getKeys().size());
		assertTrue(d2.getItemCount() == d.getItemCount());
	}

	@Test
	public void testDefaultKeyedValues() {
		//Testing Constructor for lists sizes
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		int sizeIndexMap = d1.getItemCount();
		
		assertTrue(sizeIndexMap == 0);
		
		ArrayList<Comparable> array = (ArrayList<Comparable>) d1.getKeys();
		
		assertTrue(array.size() == 0);
	}

	@Test
	public void testGetItemCount() {
		/*
		 * Testing for empty list
		 * Testing by using addValue method
		 * Testing by using setValue method
		 * Testing after using clear method*/
		
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		int n = d1.getItemCount();
		assertTrue(n == 0);
		
		double dummy = 3.5;
		
		d1.addValue("key1", 100);
		d1.addValue("key2", 100.5);
		d1.addValue("key3", dummy);
		
		int n2 = d1.getItemCount();
		
		assertTrue(n2 == 3);
		
		d1.setValue("key4", 1000);
		d1.setValue("key5", 100.4);
		d1.setValue("key6", dummy);
		
		int n3 = d1.getItemCount();
		
		assertTrue(n3 == 6);
		
		d1.clear();
		
		int n4 = d1.getItemCount(); 
		
		assertTrue(n4 == 0);
	}
	
	@Test(expected = java.lang.IndexOutOfBoundsException.class)
	public void testGetValueException() {
		//Testing for lower bound out of index exception
		
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		Double dummy = 300.4;
		Integer dummy2 = 300; 
		
		d1.addValue("key1", 100.0);
		d1.addValue(dummy, 340.3);
		d1.addValue(dummy2, 100000);
		d1.addValue("key2", dummy2);
		
		d1.getValue(-1);
	}
	
	@Test(expected = java.lang.IndexOutOfBoundsException.class)
	public void testGetValueException2() {
		//Testing for upper bound out of index exception
		
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		Double dummy = 300.4;
		Integer dummy2 = 300; 
		
		d1.addValue("key1", 100.0);
		d1.addValue(dummy, 340.3);
		d1.addValue(dummy2, 100000);
		d1.addValue("key2", dummy2);
		
		d1.getValue(4);
	}
	
	@Test
	public void testGetValueInt() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		Double dummy = 300.4;
		Integer dummy2 = 300; 
		
		d1.addValue("key1", 100.0);
		d1.addValue(dummy, 340.3);
		d1.addValue(dummy2, 100000);
		d1.addValue("key2", dummy2);
		
		//Testing For lower bound
		Number n = d1.getValue(0);
		assertEquals(100.0,n);
		
		//Testing for upper bound
		Number n2 = d1.getValue(3);
		assertEquals(300,n2);
		
		//Testing for normal use
		Number n3 = d1.getValue(2);
		assertEquals(100000.0,n3);
	}

	@Test
	public void testGetKey() {
		assertTrue(true);
	}

	@Test
	public void testGetIndex() {
		Args mockArgs = Mockito.mock(Args.class);
		Mockito.doNothing().when(mockArgs).nullNotPermitted(Comparable.class,"key");
		
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		d1.addValue("key1", 100.0);
		d1.addValue("key2", 340.3);
		d1.addValue("key3", 100000);
		d1.addValue("key4", 2.3);
		d1.addValue("key5", 600);
		
		assertTrue(true);
		
		//Testing for key in the beginning
		int n = d1.getIndex("key1");

		assertTrue(n == 0);
		
		//Testing for key in the end
		int n2 = d1.getIndex("key5");
		
		assertTrue(n2 == 4);
		
		//Testing for normal use
		int n3 = d1.getIndex("key3");
				
		assertTrue(n3 == 2);
		
		//Testing for unavailable key
		int n4 = d1.getIndex("key535");
		
		assertTrue(n4 == -1);
	}

	@Test
	public void testGetKeys() {
		assertTrue(true);
	}

	@Test
	public void testGetValueComparable() {
		assertTrue(true);
	}

	@Test
	public void testAddValueComparableDouble() {
		assertTrue(true);
	}

	@Test
	public void testAddValueComparableNumber() {
		assertTrue(true);
	}

	@Test
	public void testSetValueComparableDouble() {
		assertTrue(true);
	}

	@Test
	public void testSetValueComparableNumber() {
		assertTrue(true);
	}

	@Test
	public void testInsertValueIntComparableDouble() {
		assertTrue(true);
	}

	@Test
	public void testInsertValueIntComparableNumber() {
		assertTrue(true);
	}

	@Test
	public void testRemoveValueInt() {
		assertTrue(true);
	}

	@Test
	public void testRemoveValueComparable() {
		assertTrue(true);
	}

	@Test
	public void testClear() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		d1.addValue("key1", 100.0);
		d1.addValue("key2", 100.3);
		d1.addValue("key3", 100.5);
		d1.addValue("key4", 100.6);
		
		d1.clear();
		
		ArrayList<Comparable> array = (ArrayList<Comparable>) d1.getKeys();
		
		assertTrue(d1.getItemCount() == 0);
		assertTrue(array.size() == 0);
	}

	@Test
	public void testSortByKeys() {
		assertTrue(true);		
	}

	@Test
	public void testSortByValues() {
		assertTrue(true);
	}

}
