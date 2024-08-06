package cic.examen.examen_parcial.EJ3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TelefonoService {

    @Autowired
    private TelefonoRepository telefonoRepository;

    public Telefono getTelefono() {
        return telefonoRepository.findById(1L).orElseGet(() -> {
            Telefono telefono = new Telefono();
            telefono.setId(1L); 
            return telefono;
        });
    }

    @Transactional
    public void marcarNumero(String num) {
        Telefono telefono = getTelefono();
        telefono.marcar(num);
        telefonoRepository.save(telefono);
    }

    @Transactional
    public void hacerLlamada() {
        Telefono telefono = getTelefono();
        telefono.llamar();
        telefonoRepository.save(telefono);
    }

    @Transactional
    public void colgarLlamada() {
        Telefono telefono = getTelefono();
        telefono.colgar();
        telefonoRepository.save(telefono);
    }

    @Transactional
    public void encenderTelefono() {
        Telefono telefono = getTelefono();
        telefono.encender();
        telefonoRepository.save(telefono);
    }

    @Transactional
    public void apagarTelefono() {
        Telefono telefono = getTelefono();
        telefono.apagar();
        telefonoRepository.save(telefono);
    }
}
