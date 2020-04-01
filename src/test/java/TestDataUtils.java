import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Matchers.anyInt;
import org.jfree.data.DataUtils;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.Test;

public class TestDataUtils {

	@Test
	public void testEqual() {
		
	}

	
	@Test
	public void testClone() {
		double[][] arr1 = {{1.2,3.4,5.6},{5.6,3.5,4.3},{3.4,7.5,7.3}};
		double[][] arr2 = DataUtils.clone(arr1);
		 
		assertTrue(DataUtils.equal(arr1,arr2));
 	}
	
	@Test
	public void testCalculateColumnTotal() {
		Values2D data = Mockito.mock(Values2D.class);
		Mockito.when(data.getRowCount()).thenReturn(10);
		Mockito.when(data.getValue(anyInt(),anyInt())).thenReturn(1.0);

		double n = DataUtils.calculateColumnTotal(data,10);
		
		assertTrue(n == 10.0);
	}
	
	@Test
	public void testCalculateColumnTotalLower() {
		Values2D data = Mockito.mock(Values2D.class);
		Mockito.when(data.getRowCount()).thenReturn(10);
		Mockito.when(data.getValue(anyInt(),anyInt())).thenReturn(1.0);

		double n = DataUtils.calculateColumnTotal(data,0);
		
		assertTrue(n == 10.0);
	}
	
	@Test
	public void testCalculateColumnTotalUpper() {
		Values2D data = Mockito.mock(Values2D.class);
		Mockito.when(data.getRowCount()).thenReturn(10);
		Mockito.when(data.getColumnCount()).thenReturn(10);
		Mockito.when(data.getValue(anyInt(),anyInt())).thenReturn(1.0);

		double n = DataUtils.calculateColumnTotal(data,data.getColumnCount()-1);
		
		assertTrue(n == 10.0);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCalculateColumnTotalOutOfBound() {
		Values2D data = Mockito.mock(Values2D.class);
		Mockito.when(data.getRowCount()).thenReturn(10);
		Mockito.doThrow(ArrayIndexOutOfBoundsException.class).when(data).getValue(0,-1);

		double n = DataUtils.calculateColumnTotal(data,-1);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCalculateColumnTotalOutOfBound2() {
		Values2D data = Mockito.mock(Values2D.class);
		Mockito.when(data.getRowCount()).thenReturn(10);
		Mockito.doThrow(ArrayIndexOutOfBoundsException.class).when(data).getValue(0,10);

		double n = DataUtils.calculateColumnTotal(data,10);
	}
	
	@Test
	public void testCalculateRowTotal() {
		Values2D data = Mockito.mock(Values2D.class);
		Mockito.when(data.getColumnCount()).thenReturn(10);
		Mockito.when(data.getValue(anyInt(),anyInt())).thenReturn(1.0);

		double n = DataUtils.calculateRowTotal(data,10);
		
		assertTrue(n == 10.0);
	}
	
	@Test
	public void testCalculateRowTotalUpper() {
		Values2D data = Mockito.mock(Values2D.class);
		Mockito.when(data.getColumnCount()).thenReturn(10);
		Mockito.when(data.getRowCount()).thenReturn(10);
		Mockito.when(data.getValue(anyInt(),anyInt())).thenReturn(1.0);

		double n = DataUtils.calculateRowTotal(data,data.getRowCount()-1);
		
		assertTrue(n == 10.0);
	}
	
	@Test
	public void testCalculateRowTotalLower() {
		Values2D data = Mockito.mock(Values2D.class);
		Mockito.when(data.getColumnCount()).thenReturn(10);
		Mockito.when(data.getValue(anyInt(),anyInt())).thenReturn(1.0);

		double n = DataUtils.calculateRowTotal(data,0);
		
		assertTrue(n == 10.0);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCalculateRowTotalOutOfBound() {
		Values2D data = Mockito.mock(Values2D.class);
		Mockito.when(data.getColumnCount()).thenReturn(10);
		Mockito.doThrow(ArrayIndexOutOfBoundsException.class).when(data).getValue(-1,0);

		double n = DataUtils.calculateRowTotal(data,-1);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCalculateRowTotalOutOfBound2() {
		Values2D data = Mockito.mock(Values2D.class);
		Mockito.when(data.getColumnCount()).thenReturn(10);
		Mockito.doThrow(ArrayIndexOutOfBoundsException.class).when(data).getValue(10,0);

		double n = DataUtils.calculateRowTotal(data,10);
	}
	
	@Test
	public void testCreateNumberArray() {
		double[] arr = {23.4,26.4,2.0,4.5,34.4};
		Number[] arr2 = DataUtils.createNumberArray(arr);
		
		assertTrue(arr2.length == arr.length);
	}
	
	@Test
	public void testCreateNumberArray2D() {
		double[][] arr = {{1.2,3.4,5.6},{5.6,3.5,4.3},{3.4,7.5,7.3}};
		Number[][] arr2 = DataUtils.createNumberArray2D(arr);
		
		assertTrue(arr2.length == 3);
	}
	
	@Test
	public void testCreateNumberArray2DUpper() {
		double[][] arr = {{1.2,3.4,5.6},{5.6,3.5,4.3},{3.4,7.5,7.3}};
		Number[][] arr2 = DataUtils.createNumberArray2D(arr);
		
		assertTrue(arr2[2].length == 3);
	}
	
	@Test
	public void testCreateNumberArray2DLower() {
		double[][] arr = {{1.2,3.4,5.6},{5.6,3.5,4.3},{3.4,7.5,7.3}};
		Number[][] arr2 = DataUtils.createNumberArray2D(arr);
		
		assertTrue(arr2[0].length == 3);
	}
	
	@Test
	public void testgetCumulativePercentagesUpper() {
		KeyedValues data = Mockito.mock(KeyedValues.class);
		Mockito.when(data.getItemCount()).thenReturn(4);
		Mockito.when(data.getValue(anyInt())).thenReturn(1.0);
		Mockito.when(data.getKey(anyInt())).thenReturn("key1").thenReturn("key2").thenReturn("key3")
		.thenReturn("key4");
		
		DefaultKeyedValues d = new DefaultKeyedValues();
		
		d = (DefaultKeyedValues) DataUtils.getCumulativePercentages(data);
		
		Double n = (Double) d.getValue(3);
		
		assertTrue(n == 1.0);
	}
	
	@Test
	public void testgetCumulativePercentagesNormal() {
		KeyedValues data = Mockito.mock(KeyedValues.class);
		Mockito.when(data.getItemCount()).thenReturn(4);
		Mockito.when(data.getValue(anyInt())).thenReturn(1.0);
		Mockito.when(data.getKey(anyInt())).thenReturn("key1").thenReturn("key2").thenReturn("key3")
		.thenReturn("key4");
		
		DefaultKeyedValues d = new DefaultKeyedValues();
		
		d = (DefaultKeyedValues) DataUtils.getCumulativePercentages(data);
		
		Double n = (Double) d.getValue(1);
		
		assertTrue(n == 0.5);
	}
	
	@Test
	public void testgetCumulativePercentagesLower() {
		KeyedValues data = Mockito.mock(KeyedValues.class);
		Mockito.when(data.getItemCount()).thenReturn(4);
		Mockito.when(data.getValue(anyInt())).thenReturn(1.0);
		Mockito.when(data.getKey(anyInt())).thenReturn("key1").thenReturn("key2").thenReturn("key3")
		.thenReturn("key4");
		
		DefaultKeyedValues d = new DefaultKeyedValues();
		
		d = (DefaultKeyedValues) DataUtils.getCumulativePercentages(data);
		
		Double n = (Double) d.getValue(0);
		
		assertTrue(n == 0.25);
	}
}
