import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jfree.chart.util.SortOrder;
import org.jfree.data.DefaultKeyedValue;
import org.jfree.data.KeyedValue;
import org.jfree.data.KeyedValueComparator;
import org.jfree.data.KeyedValueComparatorType;
import org.junit.Test;
import org.mockito.Mockito;

public class TestingKeyedValuedComparator {

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNullOrder() {
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNullType() {
		KeyedValueComparator comparator = new KeyedValueComparator(null, SortOrder.ASCENDING);
	}
	
	@Test
	public void testConstructorProperArgs() {
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.ASCENDING);
		assertTrue(comparator instanceof KeyedValueComparator);
	}
	
	@Test
	public void testGetType() {
		KeyedValueComparatorType currentType = KeyedValueComparatorType.BY_VALUE;
		KeyedValueComparator comparator = new KeyedValueComparator(currentType, SortOrder.ASCENDING);
		KeyedValueComparatorType type = comparator.getType();
		assertEquals(type, currentType);
	}
	
	@Test
	public void testGetOrder() {
		SortOrder currentOrder = SortOrder.ASCENDING;
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, currentOrder);
		SortOrder order = comparator.getOrder();
		assertEquals(order, currentOrder);
	}
	
	@Test
	public void testCompareArg1NullObj() {
		KeyedValue key1 = null;
		KeyedValue key2 = new DefaultKeyedValue("key2", 120.0);
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.ASCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, 1);
	}
	
	@Test
	public void testCompareArg2NullObj() {
		KeyedValue key1 = new DefaultKeyedValue("key1", 100.0);
		KeyedValue key2 = null;
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.ASCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, -1);
	}
	
	@Test
	public void testCompare_ByValue_Arg1NullValue() {
		KeyedValue key1 = Mockito.mock(KeyedValue.class);
		KeyedValue key2 = Mockito.mock(KeyedValue.class);
		
		Mockito.when(key1.getValue()).thenReturn(null);
		Mockito.when(key2.getValue()).thenReturn(120.0);
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.ASCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, 1);
	}
	
	@Test
	public void testCompare_ByValue_Arg2NullValue() {
		KeyedValue key1 = Mockito.mock(KeyedValue.class);
		KeyedValue key2 = Mockito.mock(KeyedValue.class);
		
		Mockito.when(key1.getValue()).thenReturn(100.0);
		Mockito.when(key2.getValue()).thenReturn(null);
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.ASCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, -1);
	}
	
	@Test
	public void testCompare_ByValue_ArgsEqual() {
		KeyedValue key1 = Mockito.mock(KeyedValue.class);
		KeyedValue key2 = Mockito.mock(KeyedValue.class);
		
		Mockito.when(key1.getValue()).thenReturn(100.0);
		Mockito.when(key2.getValue()).thenReturn(100.0);
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.ASCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, 0);
	}
	
	@Test
	public void testCompare_ByValue_ArgsNotEqual1_Ascending() {
		KeyedValue key1 = Mockito.mock(KeyedValue.class);
		KeyedValue key2 = Mockito.mock(KeyedValue.class);
		
		Mockito.when(key1.getValue()).thenReturn(100.0);
		Mockito.when(key2.getValue()).thenReturn(120.0);
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.ASCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, -1);
	}
	
	@Test
	public void testCompare_ByValue_ArgsNotEqual2_Ascending() {
		KeyedValue key1 = Mockito.mock(KeyedValue.class);
		KeyedValue key2 = Mockito.mock(KeyedValue.class);
		
		Mockito.when(key1.getValue()).thenReturn(120.0);
		Mockito.when(key2.getValue()).thenReturn(100.0);
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.ASCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, 1);
	}
	
	@Test
	public void testCompare_ByValue_ArgsNotEqual1_Descending() {
		KeyedValue key1 = Mockito.mock(KeyedValue.class);
		KeyedValue key2 = Mockito.mock(KeyedValue.class);
		
		Mockito.when(key1.getValue()).thenReturn(100.0);
		Mockito.when(key2.getValue()).thenReturn(120.0);
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.DESCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, 1);
	}
	
	@Test
	public void testCompare_ByValue_ArgsNotEqual2_Descending() {
		KeyedValue key1 = Mockito.mock(KeyedValue.class);
		KeyedValue key2 = Mockito.mock(KeyedValue.class);
		
		Mockito.when(key1.getValue()).thenReturn(120.0);
		Mockito.when(key2.getValue()).thenReturn(100.0);
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.DESCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, -1);
	}
	
	@Test
	public void testCompare_ByKey_Ascending() {
		KeyedValue key1 = Mockito.mock(KeyedValue.class);
		KeyedValue key2 = Mockito.mock(KeyedValue.class);
		
		Mockito.when(key1.getKey()).thenReturn("key1");
		Mockito.when(key2.getKey()).thenReturn("key2");
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_KEY, SortOrder.ASCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, -1);
	}
	
	@Test
	public void testCompare_ByKey_Descending() {
		KeyedValue key1 = Mockito.mock(KeyedValue.class);
		KeyedValue key2 = Mockito.mock(KeyedValue.class);
		
		Mockito.when(key1.getKey()).thenReturn("key1");
		Mockito.when(key2.getKey()).thenReturn("key2");
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_KEY, SortOrder.DESCENDING);
		int order = comparator.compare(key2, key1);
		assertEquals(order, -1);
	}
	
	
}
