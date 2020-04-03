package Integration;

import static org.junit.Assert.*;

import org.jfree.data.DefaultKeyedValues;
import org.junit.Test;
import org.mockito.Mockito;

public class IntegrationDeafaultKeyedValues {

	@Test
	public void testGetValueByKey() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		d1.addValue("key1", 100.0);
		Number actual_value = d1.getValue("key1");
		assertEquals(100.0, actual_value);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInsertValue_invalidPosition() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		d1.setValue("key1", 100.0);
		d1.setValue("key3", 300.0);
		
		d1.insertValue(4, "key1", 200.0);
	}
	
	@Test
	public void testInsertValue_ExistingKey() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		d1.setValue("key1", 100.0);
		d1.setValue("key3", 300.0);
		d1.insertValue(0, "key1", 200.0);
		
		assertEquals(d1.getValue("key1"), 200.0);
	}
	
	@Test
	public void testInsertValue_NewKey() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		d1.setValue("key1", 100.0);
		d1.setValue("key2", 200.0);
		d1.setValue("key3", 300.0);
		d1.insertValue(2, "key1", 200.0);
		
		assertEquals(d1.getValue("key1"), 200.0);
	}

	@Test
	public void testRemoveValue_Key() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		d1.setValue("key1", 100.0);
		d1.setValue("key2", 200.0);
		d1.setValue("key3", 300.0);
		d1.removeValue("key2");
		
		assertEquals(d1.getItemCount(), 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemoveValue_UnvalidKey() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		
		d1.setValue("key1", 100.0);
		d1.setValue("key2", 200.0);
		d1.setValue("key3", 300.0);
		
		d1.removeValue("key6");
	}
	
	@Test
	public void testSetValue_Double() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		d1.setValue("key1", 100.0);
		assertEquals(d1.getValue(0), 100.0);
	}

	@Test
	public void testSetValue_Number() {
		DefaultKeyedValues d1 = new DefaultKeyedValues();
		d1.setValue("key1", 100);
		assertEquals(d1.getValue(0), 100.0);
	}
	
	

}
