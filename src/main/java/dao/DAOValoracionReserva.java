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
import repositorio.ValoracionReserva;

@Stateless
public class DAOValoracionReserva {
    
    //inyeccion del entity manager - de CDI
    @PersistenceContext(unitName = "bieneSoftPU")
    private EntityManager em;
     
    // ---------------- CRUD ----------------
     
    // alta
    @Transactional // annotation de JTA
    public void guardar(ValoracionReserva valoracionReserva) {
        if (valoracionReserva.getIdValoracion() == null) em.persist(valoracionReserva);
        else em.merge(valoracionReserva);
    }
    
    // baja
    @Transactional
    public void eliminar(int id) {
        ValoracionReserva i = em.find(ValoracionReserva.class, id);
        if (i != null) em.remove(i);
    }

    
    // busqueda / lectura
    // no va transactional pq no afecta la bd
    public ValoracionReserva buscarPorId(int id) {
        return em.find(ValoracionReserva.class, id);
    }
    
    // listar todas las instalaciones
    public List<ValoracionReserva> listarTodos() {
        return em.createNamedQuery("ValoracionReserva.findAll", ValoracionReserva.class).getResultList();
    }
    
    // CONSULTAS JPQL PERSONALIZADAS - ABAJO    
}
