package com.seguridad.seguridad.dao;

import com.seguridad.seguridad.entities.EmergenciaReportada;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmergenciaReportadaDaoImp implements EmergenciaReportadaDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public EmergenciaReportada obtenerUltimaEmergenciaReportada() {
        String query = "SELECT e FROM EmergenciaReportada e  WHERE e.emergenciaReportada_id =(SELECT max(e.emergenciaReportada_id ) FROM EmergenciaReportada)";
        List<EmergenciaReportada> lastEmergency = entityManager.createQuery(query).getResultList();
        System.out.println(lastEmergency.size()-1);

        if (lastEmergency.isEmpty()) {
            return null;
        }

        return lastEmergency.get(lastEmergency.size()-1);
    }

}
