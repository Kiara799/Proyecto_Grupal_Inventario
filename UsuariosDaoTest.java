import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import inventarioapp.dao.UsuariosDao;

class UsuariosDaoTest {
	private UsuariosDao dao = new UsuariosDao();
	
	@Test
	void testAdmin() {
		boolean resultado = dao.login("admin", "admin");
		assertTrue(resultado);
	}
}
