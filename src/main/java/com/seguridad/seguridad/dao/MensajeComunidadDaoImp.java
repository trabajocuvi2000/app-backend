package com.seguridad.seguridad.dao;

import com.seguridad.seguridad.entities.MensajeComunidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MensajeComunidadDaoImp implements MensajeComunidadDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<MensajeComunidad> getMesnajesComunidad(int comunidadId) {
//ASC, DESC
        String query = "select mc from MensajeComunidad as mc where mc.comunidad.comunidad_id = :comunidadId ORDER BY mc.mensajes_comunidad_id ASC";
        List<MensajeComunidad> listaMensajes = entityManager.createQuery(query).setParameter("comunidadId", comunidadId).getResultList();
//        SI LA LISTA ESTA VACIA NO SE ENCONTRO UNA COMUNIDAD CON ES CODIGO
        if (listaMensajes.isEmpty()) {
            return null;
        }

        return listaMensajes;
    }

}
