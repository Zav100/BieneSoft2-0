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
import repositorio.Rol;

@Stateless
public class DAORol {

    //inyeccion del entity manager - de CDI
    @PersistenceContext(unitName = "bieneSoftPU")
    private EntityManager em;

    // ---------------- CRUD ----------------
    // alta
    @Transactional // annotation de JTA
    public void guardar(Rol rol) {
        if (rol.getIdRol() == null) {
            em.persist(rol);
        } else {
            em.merge(rol);
        }
    }

    // baja
    @Transactional
    public void eliminar(int id) {
        Rol i = em.find(Rol.class, id);
        if (i != null) {
            em.remove(i);
        }
    }

    // busqueda / lectura
    // no va transactional pq no afecta la bd
    public Rol buscarPorId(int id) {
        return em.find(Rol.class, id);
    }

    // listar todas las instalaciones
    public List<Rol> listarTodos() {
        return em.createNamedQuery("Rol.findAll", Rol.class).getResultList();
    }

    // CONSULTAS JPQL PERSONALIZADAS - ABAJO
}
