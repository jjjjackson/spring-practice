package tw.jackson.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import tw.jackson.demo.model.Person;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @Override
  public int deletePersonById(UUID targetId) {
    final String sql = "DELETE FROM person WHERE id = ?";
    Object[] arg = new Object[] { targetId };
    jdbcTemplate.update(sql, arg);
    return 0;
  }

  @Override
  public int insertPerson(UUID id, Person person) {
    final String sql = "INSERT INTO person (id, name) VALUES(?, ?)";
    Object[] arg = new Object[] { id, person.getName() };
    jdbcTemplate.update(sql, arg);
    return 0;
  }

  @Override
  public List<Person> selectAllPeople() {
    final String sql = "SELECT id, name FROM person";
    return jdbcTemplate.query(sql, new PersonMapper());
  }

  @Override
  public Optional<Person> selectPersonById(UUID targetId) {
    final String sql = "SELECT id, name FROM person WHERE id = ?";
    Object[] arg = new Object[] { targetId };
    Person person = jdbcTemplate.queryForObject(sql, arg, new PersonMapper());
    return Optional.ofNullable(person);
  }

  @Override
  public int updatePersonById(UUID id, Person person) {
    final String sql = "UPDATE person SET name = ? WHERE id = ?";
    Object[] arg = new Object[] { person.getName(), id };
    jdbcTemplate.update(sql, arg);
    return 0;
  }
}

class PersonMapper implements RowMapper<Person> {

  public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
    UUID id = UUID.fromString(resultSet.getString("id"));
    String name = resultSet.getString("name");
    return new Person(id, name);
  }
}
