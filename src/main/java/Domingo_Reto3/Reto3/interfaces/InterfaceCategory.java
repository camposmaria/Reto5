/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domingo_Reto3.Reto3.interfaces;

import Domingo_Reto3.Reto3.Modelo.Category;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Ivonne
 */
public interface InterfaceCategory extends CrudRepository<Category,Integer>
{
    
}
