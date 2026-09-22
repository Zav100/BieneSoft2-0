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
import repositorio.Reserva;

@Stateless
public class DAOReserva {
        
    //inyeccion del entity manager - de CDI
     @PersistenceContext(unitName = "bieneSoftPU")
    private EntityManager em;
     
     // ---------------- CRUD ----------------
     
     // alta
     @Transactional // annotation de JTA
    public void guardar(Reserva reserva) {
        if (reserva.getIdReserva() == null) {
            em.persist(reserva);
        } else {
            em.merge(reserva);
        }
    }
    
    // baja
    @Transactional
    public void eliminar(int id) {
        Reserva i = em.find(Reserva.class, id);
        if (i != null) em.remove(i);
    }

    
    // busqueda / lectura
    // no va transactional pq no afecta la bd
    public Reserva buscarPorId(int id) {
        return em.find(Reserva.class, id);
    }
    
    // listar todas las instalaciones
    public List<Reserva> listarTodos() {
        return em.createNamedQuery("Reserva.findAll", Reserva.class).getResultList();
    }
    
    // CONSULTAS JPQL PERSONALIZADAS - ABAJO
}
