package cl.awakelab.java19.model.dao;

import cl.awakelab.java19.model.dto.Actor;

import java.util.List;

public interface ActorDAO {
  public Actor findById(int id);
  public List<Actor> findAll();
  public boolean create(Actor a);
  public boolean update(Actor a);
  public boolean delete(int id);
}
