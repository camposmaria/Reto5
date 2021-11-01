/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domingo_Reto3.Reto3.servicios;

import Domingo_Reto3.Reto3.Modelo.Client;
import Domingo_Reto3.Reto3.Repositorio.RepositorioClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosClient {
    @Autowired
     private RepositorioClient metodosCrud;
     
     public List<Client> getAll(){
        return metodosCrud.getAll();
    }
     
      public Optional<Client> getClient(int clientId) {
        return metodosCrud.getClient(clientId);
    }

    public Client save(Client client){
        if(client.getIdClient()==null){
            return metodosCrud.save(client);
        }else{
            Optional<Client> e= metodosCrud.getClient(client.getIdClient());
            if(e.isEmpty()){
                return metodosCrud.save(client);
            }else{
                return client;
            }
        }
    }

    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= metodosCrud.getClient(client.getIdClient());
            if(!e.isEmpty()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}


