package cl.awakelab.java19.model.dao;

import cl.awakelab.java19.model.dto.Film;
import java.util.List;

public interface FilmDAO {
  Film findById(int id);
  List<Film> findAll();
  boolean create(Film f);
  boolean update(Film f);
  boolean delete(int id);
}
