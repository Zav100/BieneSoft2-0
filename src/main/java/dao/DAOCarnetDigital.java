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
import repositorio.CarnetDigital;

@Stateless
public class DAOCarnetDigital {
    
    //inyeccion del entity manager - de CDI
     @PersistenceContext(unitName = "bieneSoftPU")
    private EntityManager em;
     
     // ---------------- CRUD ----------------
     
     // alta
     @Transactional // annotation de JTA
    public void guardar(CarnetDigital carnetDigital) {
        if (carnetDigital.getIdCarnet() == null) em.persist(carnetDigital);
        else em.merge(carnetDigital);
    }
    
    // baja
    @Transactional
    public void eliminar(int id) {
        CarnetDigital i = em.find(CarnetDigital.class, id);
        if (i != null) em.remove(i);
    }

    
    // busqueda / lectura
    // no va transactional pq no afecta la bd
    public CarnetDigital buscarPorId(int id) {
        return em.find(CarnetDigital.class, id);
    }
    
    // listar todas las instalaciones
    public List<CarnetDigital> listarTodos() {
        return em.createNamedQuery("CarnetDigital.findAll", CarnetDigital.class).getResultList();
    }
    
    // CONSULTAS JPQL PERSONALIZADAS - ABAJO
}
