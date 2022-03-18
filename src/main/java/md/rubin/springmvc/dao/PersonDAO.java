package md.rubin.springmvc.dao;

import md.rubin.springmvc.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Tom","tom@mail.ru",21));
        people.add(new Person(++PEOPLE_COUNT,"Ana","ana@mail.ru",18));
        people.add(new Person(++PEOPLE_COUNT,"Dina","dina@mail.ru",16));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return (Person) people.stream().filter(people -> people.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
