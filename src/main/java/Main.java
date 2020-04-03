import org.jfree.data.xy.MatrixSeries;
import org.mockito.Mockito;

public class Main {

	public static void main(String[] args) {
		MatrixSeries m = new MatrixSeries("matrix", 3, 3);
		m.update(0, 0, 4);
		m.update(0, 1, 5);
		m.update(1, 2, 8);
		System.out.println(m.getItem(-1));
		
	}

}
