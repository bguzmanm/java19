package cl.awakelab.java19.model.service;

import cl.awakelab.java19.model.dao.ActorDAO;
import cl.awakelab.java19.model.dto.Actor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

  ActorDAO actorDAO;

  public ActorService(ActorDAO actorDAO) {
    this.actorDAO = actorDAO;
  }

  public List<Actor> findAll(){
    List<Actor> actorDTOList = actorDAO.findAll();
    return actorDTOList;
  }

  public Actor findOne(int id){
    return actorDAO.findById(id);
  }

  public boolean create(Actor a){
    return actorDAO.create(a);
  }

  public boolean update(Actor a){
    return actorDAO.update(a);
  }
  public boolean delete(int id){
    return actorDAO.delete(id);
  }
}
