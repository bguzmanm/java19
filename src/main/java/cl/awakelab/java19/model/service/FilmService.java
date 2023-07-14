package cl.awakelab.java19.model.service;

import cl.awakelab.java19.model.dao.FilmDAO;
import cl.awakelab.java19.model.dto.Film;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
  FilmDAO dao;

  public FilmService(FilmDAO dao) {
    this.dao = dao;
  }

  public List<Film> findAll(){
    return dao.findAll();
  }

  public Film findById(int id) { return dao.findById(id); }

  public boolean update(Film f) {
    return dao.update(f);
  }
  public boolean create(Film f){
    return dao.create(f);
  }

  public boolean delete(int id){
    return dao.delete(id);
  }
}
