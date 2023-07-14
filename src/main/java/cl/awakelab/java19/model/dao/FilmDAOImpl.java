package cl.awakelab.java19.model.dao;

import cl.awakelab.java19.model.dto.Film;
import cl.awakelab.java19.model.mapper.FilmMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class FilmDAOImpl implements FilmDAO {

  JdbcTemplate template;

  public FilmDAOImpl(DataSource dataSource) {
    this.template = new JdbcTemplate(dataSource);
  }

  @Override
  public Film findById(int id) {
    return template.queryForObject("select film_id, title, description, release_year, language_id, length, rating, " +
            "special_features from film where film_id = ?", new Object[] { id }, new FilmMapper());
  }

  @Override
  public List<Film> findAll() {
    return template.query("select film_id, title, description, release_year, language_id, length, rating, " +
            "special_features from film", new FilmMapper());
  }

  @Override
  public boolean create(Film f) {

    return template.update("insert into film (title, description, release_year, language_id, length, rating," +
            " special_features) values (?, ?, ?, ?, ?, ?, ?)", f.getTitle(), f.getDescription(), f.getReleaseYear(),
            f.getLanguageId(), f.getLength(), f.getRating(), f.getSpecialFeatures()) > 0;
  }

  @Override
  public boolean update(Film f) {
    return template.update("update film set title = ?, description = ?, release_year = ?, language_id = ?, length = " +
            "?, rating = ?, special_features = ? where film_id = ?", f.getTitle(), f.getDescription(),
            f.getReleaseYear(), f.getLanguageId(), f.getLength(), f.getRating(), f.getSpecialFeatures(), f.getId()) > 0;
  }

  @Override
  public boolean delete(int id) {
    return template.update("delete from film where film_id = ?", id) > 0;
  }
}
