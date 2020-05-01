package dto;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Builder
@ToString
@JsonInclude(Include.NON_NULL)
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property ="className")
@JsonSubTypes ({@Type (value = dto.Employee.class, name = "employee")})
public class Person implements Comparable<Person>{

	public static Comparator<Person> byFirstName = Comparator.comparing(Person::getFirstName);
	public static Comparator<Person> bySecondName = Comparator.comparing(Person::getLastName);
	public static Comparator<Person> byBirhday = Comparator.comparing(Person::getDateBirthday);
	
	public static Comparator<Person> commonComporator = bySecondName.thenComparing(byFirstName);
	
	@Builder.Default
	private final Long		id = (new Random()).nextLong();
	@NotEmpty(message = "Field \"first name\" cant will be empty")
	@Size(min=2, max=20)
	@Pattern(regexp = "[^\\d]*")
	private String		firstName;
	@NotEmpty(message = "Field \"last name\" cant will be empty")
	@Size(min=2, max=40)
	@Pattern(regexp = "[^\\d]*")
	private String		lastName;
	@Past
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate		dateBirthday;
	@Size(max=5)
	private HashSet<PhoneNumber>	phone;
	@Email
	private String		email;
	private @Valid Address address;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@JsonCreator
	public Person(@JsonProperty("id") Long id,
			@JsonProperty("firstName") @NotEmpty(message = "Field \"first name\" cant will be empty") @Size(min = 2, max = 20) String firstName,
			@JsonProperty("lastName") @NotEmpty(message = "Field \"last name\" cant will be empty") @Size(min = 2, max = 40) String lastName,
			@JsonProperty("dateBirthday") @Past LocalDate dateBirthday, 
			@JsonProperty("phone") HashSet<PhoneNumber> phone, 
			@JsonProperty("email") @Email String email, 
			@JsonProperty("address")Address address) {
		super();
		this.id = id == null ? (new Random()).nextLong(): id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateBirthday = dateBirthday;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	public void setPhone(HashSet<PhoneNumber> phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public boolean addPhone(PhoneNumber newPhone) {
		if (phone == null) phone = new HashSet<PhoneNumber>();
		return phone.add(newPhone);
	}
	
	@Override
	public int compareTo(Person o) {
		return commonComporator.compare(this, o);
	}
	
}
