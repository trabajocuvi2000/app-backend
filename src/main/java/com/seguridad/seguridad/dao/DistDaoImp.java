package com.seguridad.seguridad.dao;

import com.seguridad.seguridad.entities.Dis;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DistDaoImp implements DistDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean actualizarEstadoDist(int disId, Dis dist) {

        Query querySt = null;
        String queryUpdate = "update Dis d set d.isActiva = :activoCambio where d.id = :dispositivo_Id  ";
        querySt = entityManager.createQuery(queryUpdate).setParameter("activoCambio", dist.isIsActiva()).setParameter("dispositivo_Id", disId);
//        querySt.executeUpdate();
        System.out.println("___________________");
        System.out.println(querySt);
        System.out.println(querySt.executeUpdate());

        if (querySt.executeUpdate() == 1) {
            return true;
        }

        return false;
    }

}
