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
import repositorio.Turno;

@Stateless
public class DAOTurno {
    
    //inyeccion del entity manager - de CDI
     @PersistenceContext(unitName = "bieneSoftPU")
    private EntityManager em;
     
     // ---------------- CRUD ----------------
     
     // alta
     @Transactional // annotation de JTA
    public void guardar(Turno turno) {
        if (turno.getIdTurno() == null) em.persist(turno);
        else em.merge(turno);
    }
    
    // baja
    @Transactional
    public void eliminar(int id) {
        Turno i = em.find(Turno.class, id);
        if (i != null) em.remove(i);
    }

    
    // busqueda / lectura
    // no va transactional pq no afecta la bd
    public Turno buscarPorId(int id) {
        return em.find(Turno.class, id);
    }
    
    // listar todas las instalaciones
    public List<Turno> listarTodos() {
        return em.createNamedQuery("Turno.findAll", Turno.class).getResultList();
    }
    
    // CONSULTAS JPQL PERSONALIZADAS - ABAJO
}
