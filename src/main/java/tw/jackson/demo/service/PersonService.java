package tw.jackson.demo.service;

import java.util.List;
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
}
