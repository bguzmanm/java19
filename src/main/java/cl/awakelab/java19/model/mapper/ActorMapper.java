package cl.awakelab.java19.model.mapper;

import cl.awakelab.java19.model.dto.Actor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActorMapper implements RowMapper<Actor> {
  @Override
  public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Actor(rs.getInt("actor_id"), rs.getString("first_name"), rs.getString("last_name"));
  }
}
