/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domingo_Reto3.Reto3.Repositorio;

import Domingo_Reto3.Reto3.Modelo.Client;
import Domingo_Reto3.Reto3.Modelo.ContadorClientes;
import Domingo_Reto3.Reto3.Modelo.Reservation;
import Domingo_Reto3.Reto3.interfaces.InterfaceReservation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservation {
    @Autowired
    private InterfaceReservation crud4;

    public List<Reservation> getAll(){
        return (List<Reservation>) crud4.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservation save(Reservation reservation){
        return crud4.save(reservation);
    }
    public void delete(Reservation reservation){
        crud4.delete(reservation);
    }

    public List<Reservation>ReservationStatus(String status){
        return crud4.findAllByStatus(status);

    }

    public List<Reservation> ReservationTiempoRepositorio(Date a, Date b){
        return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<ContadorClientes> getClientesRepositorio(){
        List<ContadorClientes> res =new ArrayList<>();
        List<Object[]> report = crud4.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){

            res.add(new ContadorClientes((long)report.get(i)[1],(Client) report.get(i)[0]));
            
        }

        return res;
        
    }

    
}
