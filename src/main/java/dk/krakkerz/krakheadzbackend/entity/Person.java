package dk.krakkerz.krakheadzbackend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @OneToMany(mappedBy = "specifiedPerson", fetch = FetchType.EAGER)
    private Set<HobbyInfo> hobbyInfoSet = new HashSet<>();

    @ManyToOne
    private Address address;

    public Person(String email, String firstName, String lastName, String phoneNumber, Address address) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.hobbyInfoSet = hobbyInfoSet;
        this.address = address;
    }
}
