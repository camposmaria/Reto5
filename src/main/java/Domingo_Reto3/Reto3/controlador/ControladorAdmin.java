/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domingo_Reto3.Reto3.controlador;

import Domingo_Reto3.Reto3.Modelo.Admin;
import Domingo_Reto3.Reto3.Modelo.Category;
import Domingo_Reto3.Reto3.servicios.ServiciosAdmin;
import Domingo_Reto3.Reto3.servicios.ServiciosCategory;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ivonne
 */
@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorAdmin {
    @Autowired
    private ServiciosAdmin servicio;
    @GetMapping("/all")
    public List<Admin> getAdmin(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int IdAdmin) {
        return servicio.getAdmin(IdAdmin);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin) {
        return servicio.save(admin);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin) {
        return servicio.update(admin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int IdAdmin) {
        return servicio.deleteAdmin(IdAdmin);
    }

}
