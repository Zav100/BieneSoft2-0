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
import repositorio.ConceptoPago;

@Stateless
public class DAOConceptoPago {
    
    //inyeccion del entity manager - de CDI
    @PersistenceContext(unitName = "bieneSoftPU")
    private EntityManager em;
     
    // ---------------- CRUD ----------------
     
    // alta
    @Transactional // annotation de JTA
    public void guardar(ConceptoPago conceptoPago) {
        if (conceptoPago.getIdConcepto() == null) em.persist(conceptoPago);
        else em.merge(conceptoPago);
    }
    
    // baja
    @Transactional
    public void eliminar(int id) {
        ConceptoPago i = em.find(ConceptoPago.class, id);
        if (i != null) em.remove(i);
    }

    
    // busqueda / lectura
    // no va transactional pq no afecta la bd
    public ConceptoPago buscarPorId(int id) {
        return em.find(ConceptoPago.class, id);
    }
    
    // listar todas las instalaciones
    public List<ConceptoPago> listarTodos() {
        return em.createNamedQuery("ConceptoPago.findAll", ConceptoPago.class).getResultList();
    }
    
    // CONSULTAS JPQL PERSONALIZADAS - ABAJO           
}
