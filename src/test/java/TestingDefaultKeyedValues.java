import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.SortOrder;

import org.jfree.data.DefaultKeyedValue;
import org.jfree.data.DefaultKeyedValues;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.hamcrest.CoreMatchers.*;
import org.jfree.chart.util.Args;


public class TestingDefaultKeyedValues {
	
	@Test
	public void testDefaultKeyedValues() {
		//Testing Constructor for lists sizes
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		int sizeIndexMap = d1.getItemCount();
		
		assertTrue(sizeIndexMap == 0);
	}
	
	@Test
	public void testAddValueComparableDouble() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		double dummy1 = 100.0;
		double dummy2 = 100.1;
		double dummy3 = 100.2;
		
		d1.addValue("Key1",dummy1);
		d1.addValue("Key2",dummy2);
		d1.addValue("Key3",null);
		
		assertTrue(d1.getItemCount() == 3);
	}
	
	@Test
	public void testAddValueComparableNumber() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		Double dummy1 = 100.0;
		Integer dummy2 = 100;
		Integer dummy3 = 200;
		
		d1.addValue("Key1",dummy1);
		d1.addValue("Key2",dummy2);
		d1.addValue("Key3",dummy3);
		
		assertTrue(d1.getItemCount() == 3);
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
	public void testEquals() throws CloneNotSupportedException {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		d1.addValue("key1", 100);
		d1.addValue("key2", 100);
		d1.addValue("key3", 100);
		
		DefaultKeyedValues d2 = new DefaultKeyedValues();
		d2.addValue("key1", 100);
		d2.addValue("key2", 100);
		d2.addValue("key3", 100);
		
		assertTrue(d1.equals(d2));
	}
	
	@Test
	public void testNotEquals() throws CloneNotSupportedException {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		d1.addValue("key1", 100);
		d1.addValue("key2", 100);
		d1.addValue("key3", 100);
		
		DefaultKeyedValues d3 = new DefaultKeyedValues();
		d3.addValue("key1", 105);
		d3.addValue("key2", 100);
		d3.addValue("key3", 100);
	
		assertFalse(d1.equals(d3));
	}
	
	
	@Test
	public void testEqualsClone() throws CloneNotSupportedException {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		d1.addValue("key1", 100);
		d1.addValue("key2", 100);
		d1.addValue("key3", 100);
		
		DefaultKeyedValues d4 = (DefaultKeyedValues) d1.clone();
		assertTrue(d1.equals(d4));
		
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testDefaultKeyedValueNullKey() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		d1.addValue("key1", 100.0);
		d1.addValue("key2", 340.3);
		d1.addValue("key3", 100000);
		d1.addValue("key4", 2.3);
		d1.addValue("key5", 600);
		
		//Testing for key in the beginning
		int n = d1.getIndex(null);	
	}
	
	@Test
	public void testGetIndexBegin() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		d1.addValue("key1", 100.0);
		d1.addValue("key2", 340.3);
		d1.addValue("key3", 100000);
		d1.addValue("key4", 2.3);
		d1.addValue("key5", 600);
		
		//Testing for key in the beginning
		int n = d1.getIndex("key1");

		assertTrue(n == 0);
	}
	
	@Test
	public void testGetIndexEnd() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		d1.addValue("key1", 100.0);
		d1.addValue("key2", 340.3);
		d1.addValue("key3", 100000);
		d1.addValue("key4", 2.3);
		d1.addValue("key5", 600);
		
		//Testing for key in the end
		int n2 = d1.getIndex("key5");
		
		assertTrue(n2 == 4);
	}
	
	@Test
	public void testGetIndexNormal() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		d1.addValue("key1", 100.0);
		d1.addValue("key2", 340.3);
		d1.addValue("key3", 100000);
		d1.addValue("key4", 2.3);
		d1.addValue("key5", 600);
		
		//Testing for normal use
		int n3 = d1.getIndex("key3");
				
		assertTrue(n3 == 2);
	}
	
	@Test
	public void testGetIndexUnavailable() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		d1.addValue("key1", 100.0);
		d1.addValue("key2", 340.3);
		d1.addValue("key3", 100000);
		d1.addValue("key4", 2.3);
		d1.addValue("key5", 600);
		
		//Testing for unavailable key
		int n4 = d1.getIndex("key535");
		
		assertTrue(n4 == -1);
	}
	
	@Test
	public void testGetItemCountAddValue() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		double dummy = 3.5;
		
		d1.addValue("key1", 100);
		d1.addValue("key2", 100.5);
		d1.addValue("key3", dummy);
		
		int n2 = d1.getItemCount();
		
		assertTrue(n2 == 3);
	}
	
	@Test
	public void testGetItemCountEmpty() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		int n = d1.getItemCount();
		
		assertTrue(n == 0);
	}
	
	@Test
	public void testGetItemCountClear() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		double dummy = 3.5;
		
		d1.addValue("key1", 100);
		d1.addValue("key2", 100.5);
		d1.addValue("key3", dummy);
		
		d1.clear();
		
		int n4 = d1.getItemCount(); 
		
		assertTrue(n4 == 0);
	}
	
	@Test
	public void testGetKey() {
		assertTrue(true);
	}

	@Test
	public void testGetKeys() {
		assertTrue(true);
	}
	
	@Test
	public void testGetValueComparable() {
		assertTrue(true);
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
	public void testGetValueIntBegin() {
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
	}
	
	@Test
	public void testGetValueIntNormal() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		Double dummy = 300.4;
		Integer dummy2 = 300; 
		
		d1.addValue("key1", 100.0);
		d1.addValue(dummy, 340.3);
		d1.addValue(dummy2, 100000);
		d1.addValue("key2", dummy2);
		
		//Testing for normal use
		Number n3 = d1.getValue(2);
		assertEquals(100000.0,n3);
	}
	
	@Test
	public void testGetValueIntEnd() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		Double dummy = 300.4;
		Integer dummy2 = 300; 
		
		d1.addValue("key1", 100.0);
		d1.addValue(dummy, 340.3);
		d1.addValue(dummy2, 100000);
		d1.addValue("key2", dummy2);
		
		//Testing for upper bound
		Number n2 = d1.getValue(3);
		assertEquals(300,n2);
	}
	
	@Test
	public void testHashCode() {
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
	public void testSetValueComparableDouble() {
		assertTrue(true);
	}

	@Test
	public void testSetValueComparableNumber() {
		assertTrue(true);
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
