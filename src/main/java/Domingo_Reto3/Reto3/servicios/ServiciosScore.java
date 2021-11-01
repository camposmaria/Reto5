/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domingo_Reto3.Reto3.servicios;


import Domingo_Reto3.Reto3.Modelo.Score;
import Domingo_Reto3.Reto3.Repositorio.RepositorioScore;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ivonne
 */
@Service
public class ServiciosScore {
    @Autowired
    private RepositorioScore metodosCrud;

    public List<Score> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Score> getScore(int IdScore) {
        return metodosCrud.getScore(IdScore);
    }

    public Score save(Score score) {
        if (score.getIdScore()== null) {
            return metodosCrud.save(score);
        } else {
            Optional<Score> score1 = metodosCrud.getScore(score.getIdScore());
            if (score1.isEmpty()) {
                return metodosCrud.save(score);
            } else {
                return score;
            }
        }
    }

    public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score>g=metodosCrud.getScore(score.getIdScore());
            if(!g.isEmpty()){
                if(score.getMessageText()!=null){
                    g.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!=null){
                    g.get().setStars(score.getStars());
                }
                return metodosCrud.save(g.get());
            }
        }
        return score;
    }
    public boolean deleteScore(int IdScore){
        Boolean d=getScore(IdScore).map(score -> {
            metodosCrud.delete(score);
            return true;
        }).orElse(false);
        return d;
    }
    
}
