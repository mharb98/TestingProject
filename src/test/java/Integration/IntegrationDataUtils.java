package Integration;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;

import org.jfree.data.DataUtils;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.Test;
import org.mockito.Mockito;

public class IntegrationDataUtils {

	private DefaultKeyedValues2D retArr() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
		data.addValue(1.0, "row0", "col0");
		data.addValue(1.0, "row0", "col1");
		data.addValue(1.0, "row0", "col2");
		data.addValue(1.0, "row0", "col3");
		data.addValue(1.0, "row1", "col0");
		data.addValue(1.0, "row1", "col1");
		data.addValue(1.0, "row1", "col2");
		data.addValue(1.0, "row1", "col3");
		data.addValue(1.0, "row2", "col0");
		data.addValue(1.0, "row2", "col1");
		data.addValue(1.0, "row2", "col2");
		data.addValue(1.0, "row2", "col3");
		data.addValue(1.0, "row3", "col0");
		data.addValue(1.0, "row3", "col1");
		data.addValue(1.0, "row3", "col2");
		data.addValue(1.0, "row3", "col3");
		
		return data;
	}
	
	private DefaultKeyedValues retArr2() {
		DefaultKeyedValues data = new DefaultKeyedValues();
		data.addValue("key1", 1.0);
		data.addValue("key2", 1.0);
		data.addValue("key3", 1.0);
		data.addValue("key4", 1.0);
		return data;
	}
	
	@Test
	public void testCalculateColumnTotal() {
		DefaultKeyedValues2D data = retArr();
		
		double n = DataUtils.calculateColumnTotal(data,2);
		
		
		assertTrue(n == 4.0);
	}
	
	@Test
	public void testCalculateColumnTotalLower() {
		DefaultKeyedValues2D data = retArr();
		
		double n = DataUtils.calculateColumnTotal(data,0);
		
		
		assertTrue(n == 4.0);
	}
	
	@Test
	public void testCalculateColumnTotalUpper() {
		DefaultKeyedValues2D data = retArr();

		double n = DataUtils.calculateColumnTotal(data,3);
		
		
		assertTrue(n == 4.0);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCalculateColumnTotalOutOfBound() {
		DefaultKeyedValues2D data = retArr();
		
		double n = DataUtils.calculateColumnTotal(data,-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCalculateColumnTotalOutOfBound2() {
		DefaultKeyedValues2D data = retArr();
		
		double n = DataUtils.calculateColumnTotal(data,4);
	}
	
	@Test
	public void testCalculateColumnTotalArrayColumnRow() {
		DefaultKeyedValues2D data = retArr();

		int ar[]= {1,2};
		
		double n = DataUtils.calculateColumnTotal(data,2,ar);
		
		assertTrue(n == 2.0);
	}
	
	@Test
	public void testCalculateColumnTotalArrayColumnRowUpper() {
		DefaultKeyedValues2D data = retArr();

		int arr[]= {1,3};
		
		double n = DataUtils.calculateColumnTotal(data,2,arr);
		
		assertTrue(n == 2.0);
	}
	
	@Test
	public void testCalculateColumnTotalArrayColumnRowLower() {
		DefaultKeyedValues2D data = retArr();

		int arr[]= {0,2};
		
		double n = DataUtils.calculateColumnTotal(data,2,arr);
		
		assertTrue(n == 2.0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCalculateColumnTotalArrayColumnRowOutOfBound() {
		DefaultKeyedValues2D data = retArr();
		
		int arr[]= {1,2};
		
		double n = DataUtils.calculateColumnTotal(data,4,arr);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCalculateColumnTotalArrayColumnRowOutOfBound2() {
		DefaultKeyedValues2D data = retArr();
		
		int arr[]= {1,2};
		
		double n = DataUtils.calculateColumnTotal(data,-1,arr);
	}

	@Test
	public void testCalculateColumnTotalRowTestUpperInterval() {
		DefaultKeyedValues2D data = retArr();
		
		int arr[]= {1,3};
		
		double n = DataUtils.calculateColumnTotal(data,2,arr);
		
		assertTrue(n == 2.0);
	}
	
	@Test
	public void testCalculateColumnTotalRowTestLowerInterval() {
		DefaultKeyedValues2D data = retArr();

		int arr[]= {0,2};
		
		double n = DataUtils.calculateColumnTotal(data,2,arr);
		
		assertTrue(n == 2.0);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCalculateColumnTotalRowTestLowerIntervalException() {
		DefaultKeyedValues2D data = retArr();

		int arr[]= {-1,3};
		
		double n = DataUtils.calculateColumnTotal(data,2,arr);
	}
	
	@Test
	public void testCalculateRowTotal() {
		DefaultKeyedValues2D data = retArr();
		
		double n = DataUtils.calculateRowTotal(data,2);
		
		
		assertTrue(n == 4.0);
	}
	
	@Test
	public void testCalculateRowTotalUpper() {
		DefaultKeyedValues2D data = retArr();
		
		double n = DataUtils.calculateRowTotal(data,3);
		
		
		assertTrue(n == 4.0);
	}
	
	@Test
	public void testCalculateRowTotalLower() {
		DefaultKeyedValues2D data = retArr();
		
		double n = DataUtils.calculateRowTotal(data,0);
		
		
		assertTrue(n == 4.0);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCalculateRowTotalOutOfBound() {
		DefaultKeyedValues2D data = retArr();
		
		double n = DataUtils.calculateRowTotal(data,-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCalculateRowTotalOutOfBound2() {
		DefaultKeyedValues2D data = retArr();
		
		double n = DataUtils.calculateRowTotal(data,4);
	}
	
	@Test
	public void testCalculateRowTotalArrayColumn() {
		DefaultKeyedValues2D data = retArr();

		int ar[]= {1,2};
		
		double n = DataUtils.calculateRowTotal(data,2,ar);
		
		assertTrue(n == 2.0);
	}
	
	@Test
	public void testCalculateRowTotalArrayColumnRowUpper() {
		DefaultKeyedValues2D data = retArr();

		int arr[]= {1,3};
		
		double n = DataUtils.calculateRowTotal(data,2,arr);
		
		assertTrue(n == 2.0);
	}
	
	@Test
	public void testCalculateRowTotalArrayColumnRowLower() {
		DefaultKeyedValues2D data = retArr();

		int arr[]= {0,2};
		
		double n = DataUtils.calculateRowTotal(data,2,arr);
		
		assertTrue(n == 2.0);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCalculateRowTotalArrayColumnRowOutOfBound() {
		DefaultKeyedValues2D data = retArr();
		
		int arr[]= {1,2};
		
		double n = DataUtils.calculateRowTotal(data,4,arr);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCalculateRowTotalArrayColumnRowOutOfBound2() {
		DefaultKeyedValues2D data = retArr();
		
		int arr[]= {1,2};
		
		double n = DataUtils.calculateRowTotal(data,-1,arr);
	}

	@Test
	public void testCalculateRowTotalRowTestUpperInterval() {
		DefaultKeyedValues2D data = retArr();
		
		int arr[]= {1,3};
		
		double n = DataUtils.calculateRowTotal(data,2,arr);
		
		assertTrue(n == 2.0);
	}
	
	@Test
	public void testCalculateRowTotalRowTestLowerInterval() {
		DefaultKeyedValues2D data = retArr();
		
		int arr[]= {0,2};
		
		double n = DataUtils.calculateRowTotal(data,2,arr);
		
		assertTrue(n == 2.0);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCalculateRowTotalRowTestLowerIntervalException() {
		DefaultKeyedValues2D data = retArr();

		int arr[]= {-1,3};
		
		double n = DataUtils.calculateRowTotal(data,2,arr);
	}
	
	@Test
	public void testgetCumulativePercentagesUpper() {
		DefaultKeyedValues data = retArr2();
		
		DefaultKeyedValues d = new DefaultKeyedValues();
		
		d = (DefaultKeyedValues) DataUtils.getCumulativePercentages(data);
		
		Double n = (Double) d.getValue(3);
		
		assertTrue(n == 1.0);
	}
	
	@Test
	public void testgetCumulativePercentagesNormal() {
		DefaultKeyedValues data = retArr2();

		DefaultKeyedValues d = new DefaultKeyedValues();
		
		d = (DefaultKeyedValues) DataUtils.getCumulativePercentages(data);
		
		Double n = (Double) d.getValue(1);
		
		assertTrue(n == 0.5);
	}
	
	@Test
	public void testgetCumulativePercentagesLower() {
		DefaultKeyedValues data = retArr2();
		
		DefaultKeyedValues d = new DefaultKeyedValues();
		
		d = (DefaultKeyedValues) DataUtils.getCumulativePercentages(data);
		
		Double n = (Double) d.getValue(0);
		
		assertTrue(n == 0.25);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testgetCumulativePercentagesLowerException() {
		DefaultKeyedValues data = retArr2();
		
		DefaultKeyedValues d = new DefaultKeyedValues();
		
		d = (DefaultKeyedValues) DataUtils.getCumulativePercentages(data);
		
		Double n = (Double) d.getValue(-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testgetCumulativePercentagesUpperException() {
		DefaultKeyedValues data = retArr2();
		
		DefaultKeyedValues d = new DefaultKeyedValues();
		
		d = (DefaultKeyedValues) DataUtils.getCumulativePercentages(data);
		
		Double n = (Double) d.getValue(4);
	}

}
