package cic.examen.examen_parcial.EJ3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/telefono")
public class TelefonoController {

    @Autowired
    private TelefonoService telefonoService;



    @PostMapping("/marcar")
    public void marcarNumero(@RequestParam String numero) {
        telefonoService.marcarNumero(numero);
    }

    @PostMapping("/llamar")
    public void hacerLlamada() {
        telefonoService.hacerLlamada();
    }

    @PostMapping("/colgar")
    public void colgarLlamada() {
        telefonoService.colgarLlamada();
    }

    @PostMapping("/encender")
    public void encenderTelefono() {
        telefonoService.encenderTelefono();
    }

    @PostMapping("/apagar")
    public void apagarTelefono() {
        telefonoService.apagarTelefono();
    }
}
