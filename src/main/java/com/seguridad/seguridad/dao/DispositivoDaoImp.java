package com.seguridad.seguridad.dao;

import com.seguridad.seguridad.entities.Comunidad;
import com.seguridad.seguridad.entities.Dispositivo;
import com.seguridad.seguridad.entities.Emergencia;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DispositivoDaoImp implements DispositivoDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<Dispositivo> actualizarEstadoDispositivo(int emergenciaID, Comunidad comunidad) {
//        select tipo_emergencia_id from emergencia WHERE emergencia_id = 1  
        String query = "select e from Emergencia as e where e.emergencia_id = :emergenciaID";
        List<Emergencia> lista = entityManager.createQuery(query).setParameter("emergenciaID", emergenciaID).getResultList();

//        obtenemos el tipo de emergencia de la comunidad (es decir la amergencia que activo la alarma)
        int tipoEmergencia = lista.get(0).getTipoEmergencia().getTipoEmergenciaValor();
//        System.out.println(tipoEmergencia);
        
//        en la comunidad buscamos los dispositivos 
        for (int i = 0; i < comunidad.getDispositivos().size(); i++) {
            int tipoDispositivo = comunidad.getDispositivos().get(i).getTipoDispositivo().getTipoDispositivoValor();
//            System.out.println(comunidad.getDispositivos().get(i).getTipoDispositivo().getTipoDispositivoValor());
            if (tipoDispositivo == tipoEmergencia) {
                boolean isActive = !comunidad.getDispositivos().get(i).isIsActiva();
                int dispositivoId = comunidad.getDispositivos().get(i).getDispositivo_id();
                System.out.println("Dispositivo ID "+dispositivoId);

                String queryDispositivo = "select d from Dispositivo as d where d.dispositivo_id = :idDispositivo";
                List<Dispositivo> listaDispostivio = entityManager.createQuery(queryDispositivo).setParameter("idDispositivo", dispositivoId).getResultList();

                System.out.println(listaDispostivio.get(0).isIsActiva());
                
                isActive = !listaDispostivio.get(0).isIsActiva();

                Query querySt = null;
                String queryUpdate = "update Dispositivo d set d.isActiva = :activoCambio where d.dispositivo_id = :dispositivoId  ";
                querySt = entityManager.createQuery(queryUpdate).setParameter("activoCambio", isActive).setParameter("dispositivoId", dispositivoId);
                querySt.executeUpdate();
                System.out.println("___________________________");
            }
        }
        if (lista.isEmpty()) {
            return null;
        }
        return null;
    }

}
