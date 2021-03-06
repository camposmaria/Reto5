/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domingo_Reto3.Reto3.interfaces;

import Domingo_Reto3.Reto3.Modelo.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ivonne
 */
public interface InterfaceReservation extends CrudRepository<Reservation,Integer>{
    public List<Reservation>findAllByStatus(String status);

    public List<Reservation>findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);
        
    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c GROUP BY c.client order by COUNT(c.client)DESC")

    public List<Object[]> countTotalReservationsByClient();
}
