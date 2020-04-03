import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jfree.data.xy.MatrixSeries;
import org.junit.Test;
import org.mockito.Mockito;

public class TestingMatrixSeries {

	@Test
	public void constructor_validArgs() {
		int colCount = 4;
		int rowCount = 3;
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		assertEquals(colCount, matrix.getColumnsCount());
		assertEquals(rowCount, matrix.getRowCount());
		assertTrue(matrix instanceof MatrixSeries);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructor_invalidArgs() {
		int colCount = 4;
		int rowCount = 3;
		MatrixSeries matrix = new MatrixSeries(null, rowCount, colCount);
	}
	
	@Test
	public void getColumnsCount() {
		int colCount = 4;
		int rowCount = 3;
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		assertEquals(colCount, matrix.getColumnsCount());
	}
	
	@Test
	public void getColumnsCount_zeroColumns() {
		int colCount = 0;
		int rowCount = 3;
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		assertEquals(colCount, matrix.getColumnsCount());
	}
	
	@Test
	public void getRowCount() {
		int colCount = 4;
		int rowCount = 3;
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		assertEquals(rowCount, matrix.getRowCount());
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void getRowCount_zeroRows() {
		int colCount = 3;
		int rowCount = 0;
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		int rows = matrix.getRowCount();
	}
	
	@Test
	public void update() {
		int colCount = 3;
		int rowCount = 3;
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		matrix.update(0, 0, 3);
		assertTrue(3 == matrix.get(0, 0));
	}
	
	@Test
	public void get_validIndex() {
		int colCount = 3;
		int rowCount = 3;
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		matrix.update(0, 0, 3);
		assertTrue(3 == matrix.get(0, 0));
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void get_invalidIndex() {
		int colCount = 3;
		int rowCount = 3;
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		double element = matrix.get(5, 5);
	}
	
	@Test
	public void getItemCount()
	{
		int colCount = 3;
		int rowCount = 4;
		MatrixSeries matrix = Mockito.mock(MatrixSeries.class);
		
		Mockito.when(matrix.getRowCount()).thenReturn(rowCount);
		Mockito.when(matrix.getColumnsCount()).thenReturn(colCount);
		Mockito.when(matrix.getItemCount()).thenCallRealMethod();
		
		assertEquals(rowCount*colCount, matrix.getItemCount());
	}
	
	@Test
	public void getItemColumn() {
		int colCount = 3;
		int rowCount = 3;
		
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		MatrixSeries spy = Mockito.spy(matrix);
		
		Mockito.when(spy.getColumnsCount()).thenReturn(colCount);
		
		spy.update(2, 1, 3);
		spy.update(1, 2, 5);
		
		int item1Col = 7 % colCount;
		int item2Col = 5 %colCount;
		
		assertEquals(item1Col, matrix.getItemColumn(7));
		assertEquals(item2Col, matrix.getItemColumn(5));
	}
	
	@Test
	public void getItemRow() {
		int colCount = 3;
		int rowCount = 3;
		
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		MatrixSeries spy = Mockito.spy(matrix);
		
		Mockito.when(spy.getRowCount()).thenReturn(rowCount);
		
		spy.update(2, 1, 3);
		spy.update(1, 2, 5);
		
		int item1Row = 7 / rowCount;
		int item2Row = 5 / rowCount;
		
		assertEquals(item1Row, matrix.getItemRow(7));
		assertEquals(item2Row, matrix.getItemRow(5));
	}
	
	@Test
	public void getItem() {
		int colCount = 3;
		int rowCount = 3;
		
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		MatrixSeries spy = Mockito.spy(matrix);
		
		spy.update(2, 1, 3);
		spy.update(1, 2, 4);
		
		Mockito.when(spy.getItemRow(7)).thenReturn(7 / rowCount);
		Mockito.when(spy.getItemColumn(7)).thenReturn(7 % colCount);
		Mockito.when(spy.getItemRow(5)).thenReturn(5 / rowCount);
		Mockito.when(spy.getItemColumn(5)).thenReturn(5 % colCount);
		
		assertEquals(3.0, spy.getItem(7));
		assertEquals(4.0, spy.getItem(5));
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void getItem_negativeIndex() {
		int colCount = 3;
		int rowCount = 3;
		
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		MatrixSeries spy = Mockito.spy(matrix);
		
		spy.update(2, 1, 3);
		Mockito.when(spy.getItemRow(-1)).thenReturn(-1 / rowCount);
		Mockito.when(spy.getItemColumn(-1)).thenReturn(-1 % colCount);
		
		double item = (Double) spy.getItem(-1);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void getItem_invalidIndex() {
		int colCount = 3;
		int rowCount = 3;
		
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		MatrixSeries spy = Mockito.spy(matrix);
		
		spy.update(2, 1, 3);
		Mockito.when(spy.getItemRow(12)).thenReturn(12 / rowCount);
		Mockito.when(spy.getItemColumn(12)).thenReturn(12 % colCount);
		
		double item = (Double) spy.getItem(12);
	}
	@Test
	public void equals_equalArg() {
		int colCount = 3;
		int rowCount = 3;
		MatrixSeries matrix1 = new MatrixSeries("matrix name", rowCount, colCount);
		MatrixSeries matrix2 = new MatrixSeries("matrix name", rowCount, colCount);
		
		assertTrue(matrix1.equals(matrix2));
	}
	
	@Test
	public void equals_rowCountDifferent() {
		int colCount = 3;
		int rowCount = 3;
		MatrixSeries matrix1 = new MatrixSeries("matrix", rowCount, colCount);
		MatrixSeries matrix1Spy = Mockito.spy(matrix1);
		
		Mockito.when(matrix1Spy.getColumnsCount()).thenReturn(colCount);
		Mockito.when(matrix1Spy.getRowCount()).thenReturn(rowCount);
		
		int rowCount2 = 4;
		MatrixSeries matrix2 = new MatrixSeries("matrix2", rowCount2, colCount);
		MatrixSeries matrix2Spy = Mockito.spy(matrix2);
		
		Mockito.when(matrix2Spy.getColumnsCount()).thenReturn(rowCount2);
		Mockito.when(matrix2Spy.getRowCount()).thenReturn(rowCount);
		
		assertTrue(!matrix1Spy.equals(matrix2Spy));
	}
	
	@Test
	public void equals_colCountDifferent() {
		int colCount = 3;
		int rowCount = 3;
		MatrixSeries matrix1 = new MatrixSeries("matrix", rowCount, colCount);
		MatrixSeries matrix1Spy = Mockito.spy(matrix1);
		
		Mockito.when(matrix1Spy.getColumnsCount()).thenReturn(colCount);
		Mockito.when(matrix1Spy.getRowCount()).thenReturn(rowCount);
		Mockito.doCallRealMethod().when(matrix1Spy).zeroAll();
		
		int colCount2 = 4;
		MatrixSeries matrix2 = new MatrixSeries("matrix2", rowCount, colCount);
		MatrixSeries matrix2Spy = Mockito.spy(matrix2);
		
		Mockito.when(matrix2Spy.getColumnsCount()).thenReturn(colCount2);
		Mockito.when(matrix2Spy.getRowCount()).thenReturn(rowCount);
		Mockito.doCallRealMethod().when(matrix2Spy).zeroAll();
		
		assertTrue(!matrix1Spy.equals(matrix2Spy));
	}
	
	@Test
	public void equals_ArgNotMatrixSeries() {
		int colCount = 3;
		int rowCount = 3;
		MatrixSeries matrix1 = new MatrixSeries("matrix", rowCount, colCount);
		Object invalid_argument = 3;
		assertTrue(!matrix1.equals(invalid_argument));
	}
	
	@Test
	public void zeroAll_regularCase() {
		int colCount = 3;
		int rowCount = 3;
		MatrixSeries matrix1 = new MatrixSeries("matrix", rowCount, colCount);
		MatrixSeries spy = Mockito.spy(matrix1);
		
		spy.update(2, 2, 6);
		spy.update(1, 1, 4);
		
		Mockito.when(spy.getColumnsCount()).thenReturn(colCount);
		Mockito.when(spy.getRowCount()).thenReturn(rowCount);
		spy.zeroAll();

		assertTrue(0 == spy.get(2,2));
		assertTrue(0 == spy.get(1,1));
	}
}
