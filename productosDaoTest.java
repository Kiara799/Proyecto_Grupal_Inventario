import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import inventarioapp.dao.ProductosDao;

class productosDaoTest {
	ProductosDao dao = new ProductosDao();
	
	@Test
	void testGetProductos() {
		dao = new ProductosDao();
		int total = dao.getProductos().size();
		assertTrue(total > 0);
	}
}
