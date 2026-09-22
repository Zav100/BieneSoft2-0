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
import repositorio.CategoriaSocio;

@Stateless
public class DAOCategoriaSocio {
     
    //inyeccion del entity manager - de CDI
     @PersistenceContext(unitName = "bieneSoftPU")
    private EntityManager em;
     
     // ---------------- CRUD ----------------
     
     // alta
     @Transactional // annotation de JTA
    public void guardar(CategoriaSocio categoriaSocio) {
        if (categoriaSocio.getIdCategoriaSocio() == null) em.persist(categoriaSocio);
        else em.merge(categoriaSocio);
    }
    
    // baja
    @Transactional
    public void eliminar(int id) {
        CategoriaSocio categoriaSocio = em.find(CategoriaSocio.class, id);
        if (categoriaSocio != null) em.remove(categoriaSocio);
    }

    
    // busqueda / lectura
    // no va transactional pq no afecta la bd
    public CategoriaSocio buscarPorId(int id) {
        return em.find(CategoriaSocio.class, id);
    }
    
    // listar todas las instalaciones
    public List<CategoriaSocio> listarTodos() {
        return em.createNamedQuery("CategoriaSocio.findAll", CategoriaSocio.class).getResultList();
    }
    
    // CONSULTAS JPQL PERSONALIZADAS - ABAJO
}
