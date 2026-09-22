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
import repositorio.Usuario;

@Stateless
public class DAOUsuario {
    
        //inyeccion del entity manager - de CDI
     @PersistenceContext(unitName = "bieneSoftPU")
    private EntityManager em;
     
     // ---------------- CRUD ----------------
     
     // alta
     @Transactional // annotation de JTA
    public void guardar(Usuario usuario) {
        if (usuario.getIdUsuario() == null) em.persist(usuario);
        else em.merge(usuario);
    }
    
    // baja
    @Transactional
    public void eliminar(int id) {
        Usuario i = em.find(Usuario.class, id);
        if (i != null) em.remove(i);
    }

    
    // busqueda / lectura
    // no va transactional pq no afecta la bd
    public Usuario buscarPorId(int id) {
        return em.find(Usuario.class, id);
    }
    
    // listar todas las instalaciones
    public List<Usuario> listarTodos() {
        return em.createNamedQuery("Usuario.findAll", Usuario.class).getResultList();
    }
    
    // CONSULTAS JPQL PERSONALIZADAS - ABAJO
}
