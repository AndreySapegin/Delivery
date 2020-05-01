package app.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name ="customer")
public class CustomerEntity {

	@Id
	Long id;
	String unicalNumber;
	String customerName;
	@ManyToMany(cascade = CascadeType.ALL)
	Set<AddressEntity> address;
	@ManyToMany(cascade = CascadeType.ALL)
	Set<PersonEntity> contact;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	Set<PhoneNumberEntity> commonPhone;
	String	comment;
}
