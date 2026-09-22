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
import repositorio.Instalacion;

@Stateless
public class DAOInstalacion {
    
    //inyeccion del entity manager - de CDI
     @PersistenceContext(unitName = "bieneSoftPU")
    private EntityManager em;
     
     // ---------------- CRUD ----------------
     
     // alta
     @Transactional // annotation de JTA
    public void guardar(Instalacion instalacion) {
        if (instalacion.getIdInstalacion() == null) em.persist(instalacion);
        else em.merge(instalacion);
    }
    
    // baja
    @Transactional
    public void eliminar(int id) {
        Instalacion i = em.find(Instalacion.class, id);
        if (i != null) em.remove(i);
    }

    
    // busqueda / lectura
    // no va transactional pq no afecta la bd
    public Instalacion buscarPorId(int id) {
        return em.find(Instalacion.class, id);
    }
    
    // listar todas las instalaciones
    public List<Instalacion> listarTodos() {
        return em.createNamedQuery("Instalacion.findAll", Instalacion.class).getResultList();
    }
    
    // CONSULTAS JPQL PERSONALIZADAS - ABAJO
    
}
