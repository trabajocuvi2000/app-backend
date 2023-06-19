/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seguridad.seguridad.dao;

import com.seguridad.seguridad.entities.Comunidad;
import com.seguridad.seguridad.entities.DispositivoComunidad;
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
public class DispositivoComunidadDaoImp implements DispositivoComunidadDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<DispositivoComunidad> dispositivosComunidad(int comunidaddId) {
        String query = "select d from DispositivoComunidad as d where d.comunidad.comunidad_id = :comunidadId";
        List<DispositivoComunidad> lista = entityManager.createQuery(query).setParameter("comunidadId", comunidaddId).getResultList();
//        SI LA LISTA ESTA VACIA NO SE ENCONTRO UNA COMUNIDAD CON ES CODIGO
        if (lista.isEmpty()) {
            return null;
        }
        return lista;
    }

    @Override
    public Optional<DispositivoComunidad> actualizarEstadoDispositivo(int comunidadId, Emergencia emergencia) {
        int nivel_emergencia = emergencia.getNivel_emergencia();// obtenego el nivel de emergencia

        String query = "select d from DispositivoComunidad as d where d.comunidad.comunidad_id = :comunidadId";
        List<DispositivoComunidad> listaDispositivosComunidad = entityManager.createQuery(query).setParameter("comunidadId", comunidadId).getResultList();
//        SI LA LISTA ESTA VACIA NO SE ENCONTRO DISPOSITIVOS DE ESA COMUNIDAD
        if (listaDispositivosComunidad.isEmpty()) {
            return null;
        }
        for (int i = 0; i < listaDispositivosComunidad.size(); i++) {
            if (listaDispositivosComunidad.get(i).getNivel_emergencia() == nivel_emergencia) {
                // obtenemos el id del dispositivo
                int dispositivoId = listaDispositivosComunidad.get(i).getDispositivoComunidad_Id();
                // cambio el estado del dispositivo de activo a no activo o viserversa
                boolean isActive = !listaDispositivosComunidad.get(i).isIsActive();
                
                Query querySt = null;
                String queryUpdate = "update DispositivoComunidad d set d.isActive = :activoCambio where d.dispositivoComunidad_Id = :dispositivoComunidad_Id  ";
                querySt = entityManager.createQuery(queryUpdate).setParameter("activoCambio", isActive).setParameter("dispositivoComunidad_Id", dispositivoId);
                querySt.executeUpdate();
                 
                
                System.out.println("_____________________________ IS WROKIn");

            } else {
                return null;
            }
        }
return null;
    }

}
