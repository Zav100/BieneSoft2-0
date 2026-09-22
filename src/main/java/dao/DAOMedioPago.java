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
import repositorio.MedioPago;

@Stateless
public class DAOMedioPago {
    
    //inyeccion del entity manager - de CDI
    @PersistenceContext(unitName = "bieneSoftPU")
    private EntityManager em;
     
    // ---------------- CRUD ----------------
     
    // alta
    @Transactional // annotation de JTA
    public void guardar(MedioPago medioPago) {
        if (medioPago.getIdMedioPago() == null) em.persist(medioPago);
        else em.merge(medioPago);
    }
    
    // baja
    @Transactional
    public void eliminar(int id) {
        MedioPago i = em.find(MedioPago.class, id);
        if (i != null) em.remove(i);
    }

    
    // busqueda / lectura
    // no va transactional pq no afecta la bd
    public MedioPago buscarPorId(int id) {
        return em.find(MedioPago.class, id);
    }
    
    // listar todas las instalaciones
    public List<MedioPago> listarTodos() {
        return em.createNamedQuery("MedioPago.findAll", MedioPago.class).getResultList();
    }
    
    // CONSULTAS JPQL PERSONALIZADAS - ABAJO               
}
