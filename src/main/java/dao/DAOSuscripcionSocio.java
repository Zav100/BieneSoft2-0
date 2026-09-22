/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import repositorio.SuscripcionSocio;

@Stateless
public class DAOSuscripcionSocio {
    
        //inyeccion del entity manager - de CDI
     @PersistenceContext(unitName = "bieneSoftPU")
    private EntityManager em;
     
     // ---------------- CRUD ----------------
     
     // alta
     @Transactional // annotation de JTA
    public void guardar(SuscripcionSocio suscripcionSocio) {
        if (suscripcionSocio.getIdSuscripcion() == null) em.persist(suscripcionSocio);
        else em.merge(suscripcionSocio);
    }
    
    // baja
    @Transactional
    public void eliminar(int id) {
        SuscripcionSocio i = em.find(SuscripcionSocio.class, id);
        if (i != null) em.remove(i);
    }

    
    // busqueda / lectura
    // no va transactional pq no afecta la bd
    public SuscripcionSocio buscarPorId(int id) {
        return em.find(SuscripcionSocio.class, id);
    }
    
    // listar todas las instalaciones
    public List<SuscripcionSocio> listarTodos() {
        return em.createNamedQuery("SuscripcionSocio.findAll", SuscripcionSocio.class).getResultList();
    }
    
    // ---------------------------------- CONSULTAS JPQL PERSONALIZADAS  ----------------------------------
    
    // CONSULTA  PARA BUSCAR LA ULTIMA SUSCRP. DE UN SOCIO
    public SuscripcionSocio buscarUltimaPorSocio(int idSocio) {
        List<SuscripcionSocio> resultado = em.createQuery(
                "SELECT s FROM SuscripcionSocio s WHERE s.idSocio.idSocio = :idSocio ORDER BY s.fechaVencimiento DESC",
                SuscripcionSocio.class)
                .setParameter("idSocio", idSocio)
                .setMaxResults(1)
                .getResultList();
        return resultado.isEmpty() ? null : resultado.get(0);
    }
}
