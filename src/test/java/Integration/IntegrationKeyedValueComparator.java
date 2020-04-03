package Integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jfree.chart.util.SortOrder;
import org.jfree.data.DefaultKeyedValue;
import org.jfree.data.KeyedValue;
import org.jfree.data.KeyedValueComparator;
import org.jfree.data.KeyedValueComparatorType;
import org.junit.Test;

public class IntegrationKeyedValueComparator {

	@Test
	public void testCompare_ByValue_Arg1NullValue() {
		KeyedValue key1 = new DefaultKeyedValue("key1", null);
		KeyedValue key2 = new DefaultKeyedValue("key2", 120.0);
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.ASCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, 1);
	}
	
	@Test
	public void testCompare_ByValue_Arg2NullValue() {
		KeyedValue key1 = new DefaultKeyedValue("key1", 100.0);
		KeyedValue key2 = new DefaultKeyedValue("key2", null);
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.ASCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, -1);
	}
	
	@Test
	public void testCompare_ByValue_ArgsEqual() {
		KeyedValue key1 = new DefaultKeyedValue("key1", 100.0);
		KeyedValue key2 = new DefaultKeyedValue("key2", 100.0);
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.ASCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, 0);
	}
	
	@Test
	public void testCompare_ByValue_ArgsNotEqual1_Ascending() {
		KeyedValue key1 = new DefaultKeyedValue("key1", 100.0);
		KeyedValue key2 = new DefaultKeyedValue("key2", 120.0);
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.ASCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, -1);
	}
	
	@Test
	public void testCompare_ByValue_ArgsNotEqual2_Ascending() {
		KeyedValue key1 = new DefaultKeyedValue("key1", 120.0);
		KeyedValue key2 = new DefaultKeyedValue("key2", 100.0);
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.ASCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, 1);
	}
	
	@Test
	public void testCompare_ByValue_ArgsNotEqual1_Descending() {
		KeyedValue key1 = new DefaultKeyedValue("key1", 100.0);
		KeyedValue key2 = new DefaultKeyedValue("key2", 120.0);
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.DESCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, 1);
	}
	
	@Test
	public void testCompare_ByValue_ArgsNotEqual2_Descending() {
		KeyedValue key1 = new DefaultKeyedValue("key1", 120.0);
		KeyedValue key2 = new DefaultKeyedValue("key2", 100.0);
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_VALUE, SortOrder.DESCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, -1);
	}
	
	@Test
	public void testCompare_ByKey_Ascending() {
		KeyedValue key1 = new DefaultKeyedValue("key1", 100.0);
		KeyedValue key2 = new DefaultKeyedValue("key2", 120.0);
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_KEY, SortOrder.ASCENDING);
		int order = comparator.compare(key1, key2);
		assertEquals(order, -1);
	}
	
	@Test
	public void testCompare_ByKey_Descending() {
		KeyedValue key1 = new DefaultKeyedValue("key1", 100.0);
		KeyedValue key2 = new DefaultKeyedValue("key2", 120.0);
		
		KeyedValueComparator comparator = new KeyedValueComparator(KeyedValueComparatorType.BY_KEY, SortOrder.DESCENDING);
		int order = comparator.compare(key2, key1);
		assertEquals(order, -1);
	}

}
