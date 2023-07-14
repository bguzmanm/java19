package cl.awakelab.java19.model.mapper;

import cl.awakelab.java19.model.dto.Language;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LanguageMapper implements RowMapper<Language> {
  @Override
  public Language mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Language(rs.getInt("language_id"), rs.getString("name"));
  }
}
