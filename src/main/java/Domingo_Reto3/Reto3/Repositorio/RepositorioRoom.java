/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domingo_Reto3.Reto3.Repositorio;

import Domingo_Reto3.Reto3.Modelo.Room;
import Domingo_Reto3.Reto3.interfaces.InterfaceRoom;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioRoom {
    @Autowired
    private InterfaceRoom crud;

    public List<Room> getAll(){
        return (List<Room>) crud.findAll();
    }

    public Optional<Room> getRoom(int id){
        return crud.findById(id);
    }

    public Room save(Room room){
        return crud.save(room);
    }
    public void delete(Room room){
        crud.delete(room);
    }
  

}
