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
import repositorio.Socio;

@Stateless
public class DAOSocio {
    
    //inyeccion del entity manager - de CDI
     @PersistenceContext(unitName = "bieneSoftPU")
    private EntityManager em;
     
     // ---------------- CRUD ----------------
     
     // alta
     @Transactional // annotation de JTA
    public void guardar(Socio socio) {
        if (socio.getIdSocio() == null) em.persist(socio);
        else em.merge(socio);
    }
    
    // baja
    @Transactional
    public void eliminar(int id) {
        Socio i = em.find(Socio.class, id);
        if (i != null) em.remove(i);
    }

    
    // busqueda / lectura
    // no va transactional pq no afecta la bd
    public Socio buscarPorId(int id) {
        return em.find(Socio.class, id);
    }
    
    // listar todas las instalaciones
    public List<Socio> listarTodos() {
        return em.createNamedQuery("Socio.findAll", Socio.class).getResultList();
    }
    
    // CONSULTAS JPQL PERSONALIZADAS - ABAJO
    
}
