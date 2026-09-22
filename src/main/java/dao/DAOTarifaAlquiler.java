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
import repositorio.TarifaAlquiler;

@Stateless
public class DAOTarifaAlquiler {
    
    //inyeccion del entity manager - de CDI
    @PersistenceContext(unitName = "bieneSoftPU")
    private EntityManager em;
     
    // ---------------- CRUD ----------------
     
    // alta
    @Transactional // annotation de JTA
    public void guardar(TarifaAlquiler tarifaAlquiler) {
        if (tarifaAlquiler.getIdTarifa() == null) em.persist(tarifaAlquiler);
        else em.merge(tarifaAlquiler);
    }
    
    // baja
    @Transactional
    public void eliminar(int id) {
        TarifaAlquiler i = em.find(TarifaAlquiler.class, id);
        if (i != null) em.remove(i);
    }

    
    // busqueda / lectura
    // no va transactional pq no afecta la bd
    public TarifaAlquiler buscarPorId(int id) {
        return em.find(TarifaAlquiler.class, id);
    }
    
    // listar todas las instalaciones
    public List<TarifaAlquiler> listarTodos() {
        return em.createNamedQuery("TarifaAlquiler.findAll", TarifaAlquiler.class).getResultList();
    }
    
    // CONSULTAS JPQL PERSONALIZADAS - ABAJO        
}
