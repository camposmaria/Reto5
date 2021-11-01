/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domingo_Reto3.Reto3.Repositorio;

import Domingo_Reto3.Reto3.Modelo.Score;
import Domingo_Reto3.Reto3.interfaces.InterfaceScore;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ivonne
 */
@Repository
public class RepositorioScore {
    @Autowired
    private InterfaceScore crud;
    public List<Score> getAll(){
        return (List<Score>) crud.findAll();
    }
    public Optional<Score> getScore(int id){
        return crud.findById(id);
    }

    public Score save(Score score){
        return crud.save(score);
    }
    public void delete(Score score){
       crud.delete(score);
    }
}
