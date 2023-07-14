package cl.awakelab.java19.model.dao;

import cl.awakelab.java19.model.dto.Language;
import cl.awakelab.java19.model.mapper.LanguageMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class LanguageDAOImpl implements LanguageDAO {

  JdbcTemplate template;

  public LanguageDAOImpl(DataSource dataSource) {
    this.template = new JdbcTemplate(dataSource);
  }

  @Override
  public Language findById(int id) {
    return null;
  }

  @Override
  public List<Language> findAll() {
    return template.query("select language_id, name from language", new LanguageMapper());
  }

  @Override
  public boolean create(Language language) {
    return false;
  }

  @Override
  public boolean update(Language language) {
    return false;
  }

  @Override
  public boolean delete(int id) {
    return false;
  }
}
