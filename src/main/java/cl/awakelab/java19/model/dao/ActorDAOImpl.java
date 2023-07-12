package cl.awakelab.java19.model.dao;

import cl.awakelab.java19.model.dto.Actor;
import cl.awakelab.java19.model.mapper.ActorMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
@Component
public class ActorDAOImpl implements ActorDAO {

  JdbcTemplate jdbcTemplate;

  public ActorDAOImpl(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public Actor findById(int id) {
    return jdbcTemplate.queryForObject("select actor_id, first_name, last_name from actor where actor_id = ?",
            new Object[] { id }, new ActorMapper());
  }

  @Override
  public List<Actor> findAll() {
    return jdbcTemplate.query("select actor_id, first_name, last_name from actor", new ActorMapper());
  }

  @Override
  public boolean create(Actor a) {
    return jdbcTemplate.update("insert into actor (first_name, last_name) values (?, ?)",
            a.getFirstName(), a.getLastName()) > 0;

  }

  @Override
  public boolean update(Actor a) {
    return jdbcTemplate.update("update actor set first_name = ?, last_name = ? where actor_id = ?", a.getFirstName(),
            a.getLastName(), a.getId()) > 0;
  }

  @Override
  public boolean delete(int id) {
    return jdbcTemplate.update("delete from actor where actor_id = ?", id) > 0;
  }
}
