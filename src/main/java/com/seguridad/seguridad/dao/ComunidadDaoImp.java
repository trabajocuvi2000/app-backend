package com.seguridad.seguridad.dao;

import com.seguridad.seguridad.entities.Comunidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ComunidadDaoImp implements ComunidadDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Comunidad getIdComunidadByCodigo(String codigoComunidad) {

        String query = "select c from Comunidad as c where c.codigo = :codigo";
        List<Comunidad> lista = entityManager.createQuery(query).setParameter("codigo", codigoComunidad).getResultList();
//        SI LA LISTA ESTA VACIA NO SE ENCONTRO UNA COMUNIDAD CON ES CODIGO
        if (lista.isEmpty()) {
            return null;
        }
        return lista.get(0);

    }

}
