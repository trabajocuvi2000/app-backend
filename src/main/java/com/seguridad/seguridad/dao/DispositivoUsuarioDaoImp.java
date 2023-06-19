package com.seguridad.seguridad.dao;

import com.seguridad.seguridad.entities.DispositivoUsuario;
import com.seguridad.seguridad.model.ConfirmChange;
import com.seguridad.seguridad.model.DispositivoUsuaioActualizado;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DispositivoUsuarioDaoImp implements DispositivoUsuarioDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<DispositivoUsuario> dispositivosUsuario(int usuarioId) {
        String query = "select d from DispositivoUsuario as d where d.usuario.usuario_id = :usuarioId";
        List<DispositivoUsuario> lista = entityManager.createQuery(query).setParameter("usuarioId", usuarioId).getResultList();

        if (lista.isEmpty()) {
            return null;
        }

        return lista;
    }

    @Override
    public ConfirmChange actualizarEstadoDispositivoUsuario(int dispositivoUsuarioId) {
        ConfirmChange confirmChange = new ConfirmChange();

        String query = "select d from DispositivoUsuario as d where d.dispositivoUsuario_id = :dispositivoUsuarioID";
        List<DispositivoUsuario> lista = entityManager.createQuery(query).setParameter("dispositivoUsuarioID", dispositivoUsuarioId).getResultList();

        if (lista.isEmpty()) {
            confirmChange.setIsChange(false);
            return confirmChange;
        }

        // obtenemos el id del dispositivo
        int dispositivoId = lista.get(0).getDispositivoUsuario_id();
        // cambio el estado del dispositivo de activo a no activo o viserversa
        boolean isActive = !lista.get(0).isIsActive();
        Query querySt = null;
        String queryUpdate = "update DispositivoUsuario d set d.isActive = :activoCambio where d.dispositivoUsuario_id = :dispositivoUsuario_Id";
        querySt = entityManager.createQuery(queryUpdate).setParameter("activoCambio", isActive).setParameter("dispositivoUsuario_Id", dispositivoId);
        querySt.executeUpdate();

        confirmChange.setIsChange(true);
        return confirmChange;
    }

    @Override
    public DispositivoUsuaioActualizado actualizarEstadoDispositivoUsuarioByDevice(int dispositivoUsuarioId, DispositivoUsuario dispositivoUsuario) {

        DispositivoUsuaioActualizado dispositivoActualizado = new DispositivoUsuaioActualizado();
        int dispositivoId = dispositivoUsuarioId;
        // cambio el estado del dispositivo de activo a no activo o viserversa
        boolean isActive = dispositivoUsuario.isIsActive();

        Query querySt = null;
        String queryUpdate = "update DispositivoUsuario d set d.isActive = :activoCambio where d.dispositivoUsuario_id = :dispositivoUsuario_Id";
        querySt = entityManager.createQuery(queryUpdate).setParameter("activoCambio", isActive).setParameter("dispositivoUsuario_Id", dispositivoId);
      
        int isUpdate = querySt.executeUpdate(); // en caso de que el dispositivo no se aya actualizado regresa 0

        // objeto a regresar
        dispositivoActualizado.setNombre(dispositivoUsuario.getNombre());
        dispositivoActualizado.setDispositivoId(dispositivoId);
        if (isUpdate == 0) {//en caso de que sea cero el dispositivo no se actualiza
            dispositivoActualizado.setMensaje("Dispositivo no actualizado");
            dispositivoActualizado.setIsUpdate(false);
            return dispositivoActualizado;
        }
        dispositivoActualizado.setIsUpdate(true);
        dispositivoActualizado.setIsActive(isActive);
        dispositivoActualizado.setMensaje("Dispositivo actualizado correctamente");
        return dispositivoActualizado;
    }

}
