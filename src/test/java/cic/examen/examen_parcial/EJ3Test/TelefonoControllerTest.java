package cic.examen.examen_parcial.EJ3Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import cic.examen.examen_parcial.EJ3.Telefono;
import cic.examen.examen_parcial.EJ3.TelefonoRepository;
import cic.examen.examen_parcial.EJ3.TelefonoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.swing.text.html.parser.Entity;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.http.MediaType;


@SpringBootTest
@AutoConfigureMockMvc
public class TelefonoControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TelefonoService telefonoService;

    @BeforeEach
    public void setup() {
        telefonoService.encenderTelefono(); 
    }

    @AfterEach
	public void tearDown() {
        telefonoService.apagarTelefono();
	}

    @Test
    public void testMarcarNumero() throws Exception {
        mockMvc.perform(post("/api/telefono/marcar")
                .param("numero", "123456789")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Telefono telefono = telefonoService.getTelefono();
        assertEquals("123456789", telefono.getNum());
    }

    @Test
    public void testHacerLlamada() throws Exception {
        telefonoService.marcarNumero("123456789");

        mockMvc.perform(post("/api/telefono/llamar")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        Telefono telefono = telefonoService.getTelefono();
        assertTrue(telefono.isEnLlamada());
    }

    @Test
    public void testColgarLlamada() throws Exception {
        telefonoService.marcarNumero("123456789");
        telefonoService.hacerLlamada();

        mockMvc.perform(post("/api/telefono/colgar")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        Telefono telefono = telefonoService.getTelefono();
        assertFalse(telefono.isEnLlamada());
    }

}



