import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.jfree.chart.util.SortOrder;
import org.jfree.data.DefaultKeyedValues;
import org.junit.Test;
import org.mockito.Mockito;


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
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		d1.addValue("key1", 100);
		assertEquals("key1", d1.getKey(0));
	}
	
	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testGetNullKey() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		d1.addValue(null, 100);
		d1.getKey(0);
	}
	
	@Test
	public void testGetKeys() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		d1.addValue("key1", 100);
		d1.addValue("key2", 101);
		d1.addValue("key3", 102);
		
		ArrayList<String> expected_list= new ArrayList<String>();
		expected_list.add("key1");
		expected_list.add("key2");
		expected_list.add("key3");
		
		assertEquals(d1.getKeys(), expected_list);
	}
	
	@Test
	public void testGetValueByKey() {
		DefaultKeyedValues d1 = Mockito.spy(DefaultKeyedValues.class);
		
		d1.addValue("key1", 100.0);
		Mockito.when(d1.getIndex("key1")).thenReturn(0);
		
		Number actual_value = d1.getValue("key1");
		assertEquals(100.0, actual_value);
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
	public void testHashCode_OneKey() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		d1.addValue("key1", 100);
		assertEquals(d1.hashCode(), 3288529);
	}
	
	@Test
	public void testHashCode_MultipleKeys() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		d1.addValue("key1", 100);
		d1.addValue("key2", 200);
		assertEquals(d1.hashCode(), 105232898);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInsertValue_invalidPosition() {
		DefaultKeyedValues d1 = Mockito.spy(DefaultKeyedValues.class);
		
		d1.setValue("key1", 100.0);
		d1.setValue("key3", 300.0);
		
		d1.insertValue(4, "key1", 200.0);
	}
	
	@Test
	public void testInsertValue_ExistingKey() {
		DefaultKeyedValues d1 = Mockito.spy(DefaultKeyedValues.class);
		
		d1.setValue("key1", 100.0);
		d1.setValue("key3", 300.0);
		
		Mockito.when(d1.getItemCount()).thenReturn(2);
		Mockito.when(d1.getIndex("key1")).thenReturn(0);
		
		d1.insertValue(0, "key1", 200.0);
		assertEquals(d1.getValue("key1"), 200.0);
	}
	
	@Test
	public void testInsertValue_NewKey() {
		DefaultKeyedValues d1 = Mockito.spy(DefaultKeyedValues.class);
		
		d1.setValue("key1", 100.0);
		d1.setValue("key2", 200.0);
		d1.setValue("key3", 300.0);
		
		Mockito.when(d1.getItemCount()).thenReturn(2);
		Mockito.when(d1.getIndex("key1")).thenReturn(0);
		
		d1.insertValue(2, "key1", 200.0);
		assertEquals(d1.getValue("key1"), 200.0);
	}
	
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemoveValue_UnvalidIndex() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		d1.setValue("key1", 100.0);
		d1.setValue("key2", 200.0);
		d1.setValue("key3", 300.0);
		
		d1.removeValue(4);
	}
	
	@Test
	public void testRemoveValue_Index() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		d1.setValue("key1", 100.0);
		d1.setValue("key2", 200.0);
		d1.setValue("key3", 300.0);
		
		d1.removeValue(2);
		assertEquals(d1.getItemCount(), 2);
	}

	@Test
	public void testRemoveValue_Key() {
		DefaultKeyedValues d1 = Mockito.spy(DefaultKeyedValues.class);
		
		d1.setValue("key1", 100.0);
		d1.setValue("key2", 200.0);
		d1.setValue("key3", 300.0);
		
		Mockito.when(d1.getIndex("key2")).thenReturn(1);
		
		d1.removeValue("key2");
		assertEquals(d1.getItemCount(), 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveValue_UnvalidKey() {
		DefaultKeyedValues d1 = Mockito.spy(DefaultKeyedValues.class);
		
		d1.setValue("key1", 100.0);
		d1.setValue("key2", 200.0);
		d1.setValue("key3", 300.0);
		
		d1.removeValue("key6");
	}
	
	@Test
	public void testSetValue_Double() {
		DefaultKeyedValues d1 = Mockito.mock(DefaultKeyedValues.class);
		Mockito.when(d1.getIndex("key1")).thenReturn(0);
		Mockito.doCallRealMethod().when(d1).setValue("key1", 100.0);
		Mockito.when(d1.getValue(0)).thenReturn(100.0);
		d1.setValue("key1", 100.0);
		assertEquals(d1.getValue(0), 100.0);
	}

	@Test
	public void testSetValue_Number() {
		DefaultKeyedValues d1 = Mockito.mock(DefaultKeyedValues.class);
		Mockito.when(d1.getIndex("key1")).thenReturn(0);
		Mockito.doCallRealMethod().when(d1).setValue("key1", 100);
		Mockito.when(d1.getValue(0)).thenReturn(100);
		d1.setValue("key1", 100);
		assertEquals(d1.getValue(0), 100);
	}

	@Test
	public void testSortByKeys() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		d1.addValue("key2", 100);
		d1.addValue("key3", 200);
		d1.addValue("key1", 300);
		
		DefaultKeyedValues expected = new DefaultKeyedValues();
		expected.addValue("key1", 300);
		expected.addValue("key2", 100);
		expected.addValue("key3", 200);
		
		d1.sortByKeys(SortOrder.ASCENDING);
		
		assertEquals(d1.getKeys(),  expected.getKeys());
	}

	@Test
	public void testSortByValues() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		d1.addValue("key1", 200);
		d1.addValue("key2", 400);
		d1.addValue("key3", 100);
		
		DefaultKeyedValues expected = new DefaultKeyedValues();
		expected.addValue("key3", 100);
		expected.addValue("key1", 200);
		expected.addValue("key2", 400);
		
		d1.sortByValues(SortOrder.ASCENDING);
		
		assertEquals(d1.getKeys(),  expected.getKeys());
	}

}
