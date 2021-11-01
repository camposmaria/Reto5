/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domingo_Reto3.Reto3.servicios;


import Domingo_Reto3.Reto3.Modelo.Admin;
import Domingo_Reto3.Reto3.Repositorio.RepositorioAdmin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ivonne
 */
@Service
public class ServiciosAdmin {
    @Autowired
    private RepositorioAdmin metodosCrud;

    public List<Admin> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Admin> getAdmin(int IdAdmin) {
        return metodosCrud.getAdmin(IdAdmin);
    }

    public Admin save(Admin admin) {
        if (admin.getIdAdmin()== null) {
            return metodosCrud.save(admin);
        } else {
            Optional<Admin> admin1 = metodosCrud.getAdmin(admin.getIdAdmin());
            if (admin1.isEmpty()) {
                return metodosCrud.save(admin);
            } else {
                return admin;
            }
        }
    }

    public Admin update(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin>g=metodosCrud.getAdmin(admin.getIdAdmin());
            if(!g.isEmpty()){
                if(admin.getEmail()!=null){
                    g.get().setEmail(admin.getEmail());
                }
                if(admin.getName()!=null){
                    g.get().setName(admin.getName());
                }
                if(admin.getPassword()!=null){
                    g.get().setPassword(admin.getPassword());
                }   
                return metodosCrud.save(g.get());
            }
        }
        return admin;
    }
    public boolean deleteAdmin(int IdAdmin){
        Boolean dato=getAdmin(IdAdmin).map(admin -> {
            metodosCrud.delete(admin);
            return true;
        }).orElse(false);
        return dato;
    }
}
