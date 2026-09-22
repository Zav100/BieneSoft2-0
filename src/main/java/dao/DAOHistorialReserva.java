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
import repositorio.HistorialReserva;

@Stateless
public class DAOHistorialReserva {
    
    //inyeccion del entity manager - de CDI
    @PersistenceContext(unitName = "bieneSoftPU")
    private EntityManager em;
     
    // ---------------- CRUD ----------------
     
    // alta
    @Transactional // annotation de JTA
    public void guardar(HistorialReserva historialReserva) {
        if (historialReserva.getIdHistorial() == null) em.persist(historialReserva);
        else em.merge(historialReserva);
    }
    
    // baja
    @Transactional
    public void eliminar(int id) {
        HistorialReserva i = em.find(HistorialReserva.class, id);
        if (i != null) em.remove(i);
    }

    
    // busqueda / lectura
    // no va transactional pq no afecta la bd
    public HistorialReserva buscarPorId(int id) {
        return em.find(HistorialReserva.class, id);
    }
    
    // listar todas las instalaciones
    public List<HistorialReserva> listarTodos() {
        return em.createNamedQuery("HistorialReserva.findAll", HistorialReserva.class).getResultList();
    }
    
    // CONSULTAS JPQL PERSONALIZADAS - ABAJO
}
