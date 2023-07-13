package cl.awakelab.java19.model.mapper;

import cl.awakelab.java19.model.dto.Film;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmMapper implements RowMapper<Film> {
  @Override
  public Film mapRow(ResultSet rs, int rowNum) throws SQLException {
    Film film = new Film();
    film.setId(rs.getInt("film_id"));
    film.setTitle(rs.getString("title"));
    film.setDescription(rs.getString("description"));
    film.setReleaseYear(rs.getInt("release_year"));
    film.setLanguageId(rs.getInt("language_id"));
    film.setLength(rs.getInt("length"));
    film.setRating(rs.getString("rating"));
    film.setSpecialFeatures(rs.getString("special_features"));
    return film;

  }
}
