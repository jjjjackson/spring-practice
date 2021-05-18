package tw.jackson.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import tw.jackson.demo.dao.PersonDao;
import tw.jackson.demo.model.Person;

@Service
public class PersonService {

  private final PersonDao personDao;

  public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
    this.personDao = personDao;
  }

  public int addPerson(Person person) {
    return personDao.insertPerson(person);
  }

  public List<Person> getAllPeople() {
    return personDao.selectAllPeople();
  }

  public Optional<Person> getPersonById(UUID id) {
    return personDao.selectPersonById(id);
  }

  public int deletePersonById(UUID id) {
    return personDao.deletePersonById(id);
  }

  public int updatePersonById(UUID id, Person person) {
    return personDao.updatePersonById(id, person);
  }
}
