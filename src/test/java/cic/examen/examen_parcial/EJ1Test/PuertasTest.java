package cic.examen.examen_parcial.EJ1Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import cic.examen.examen_parcial.EJ1.Armario;
import cic.examen.examen_parcial.EJ1.Cama;

@SpringBootTest
class PuertasTest {


	@Test
    public void testArmarioConPuertas() {
        Armario armario = new Armario(3);
        armario.setNombre("Armario");

        assertEquals("Armario", armario.getNombre());
        assertEquals(3, armario.getPuertas());
        assertTrue(armario.tienePuertas(), "El armario no tiene puertas.");
    }



    @Test
    public void testCamaConPuertas() {
        Cama cama = new Cama(0);
        cama.setNombre("Cama Ikea");

        assertEquals("Cama Ikea", cama.getNombre());
        assertEquals(0, cama.getPuertas());
        assertFalse(cama.tienePuertas(), "La cama tiene puertas.");
    }


}