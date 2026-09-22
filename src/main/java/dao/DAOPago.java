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
import repositorio.Pago;

@Stateless
public class DAOPago {
    
    //inyeccion del entity manager - de CDI
    @PersistenceContext(unitName = "bieneSoftPU")
    private EntityManager em;
     
    // ---------------- CRUD ----------------
     
    // alta
    @Transactional // annotation de JTA
    public void guardar(Pago pago) {
        if (pago.getIdPago() == null) em.persist(pago);
        else em.merge(pago);
    }
    
    // baja
    @Transactional
    public void eliminar(int id) {
        Pago i = em.find(Pago.class, id);
        if (i != null) em.remove(i);
    }

    
    // busqueda / lectura
    // no va transactional pq no afecta la bd
    public Pago buscarPorId(int id) {
        return em.find(Pago.class, id);
    }
    
    // listar todas las instalaciones
    public List<Pago> listarTodos() {
        return em.createNamedQuery("Pago.findAll", Pago.class).getResultList();
    }
    
    // CONSULTAS JPQL PERSONALIZADAS - ABAJO                   
}
