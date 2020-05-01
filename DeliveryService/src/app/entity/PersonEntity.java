package app.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonEntity {

	@Id
	long id;
	String firstName;
	String lastName;
	@ManyToMany(cascade = CascadeType.ALL)
	Set<AddressEntity> address;
	@ManyToMany(cascade = CascadeType.ALL)
	Set<PhoneNumberEntity> phone;
	String email;
	LocalDate dateBirthday;
	
}
