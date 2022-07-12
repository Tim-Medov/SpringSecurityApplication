
package enterprise.services;

import enterprise.repositories.PersonRepository;
import enterprise.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import enterprise.models.Person;
import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {

    private PersonRepository personRepository;

    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Person> optionalPerson = personRepository.findByUsername(username);

        if (optionalPerson.isEmpty())
            throw new UsernameNotFoundException("User not found");

        return new PersonDetails(optionalPerson.get());
    }
}
