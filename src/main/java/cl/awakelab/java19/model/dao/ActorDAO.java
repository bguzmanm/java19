package cl.awakelab.java19.model.dao;

import cl.awakelab.java19.model.dto.Actor;

import java.util.List;

public interface ActorDAO {
  Actor findById(int id);
  List<Actor> findAll();
  boolean create(Actor a);
  boolean update(Actor a);
  boolean delete(int id);
}
