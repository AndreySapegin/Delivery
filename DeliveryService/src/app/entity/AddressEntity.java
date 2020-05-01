package app.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "address")
public class AddressEntity {

	@Id
	Long id;
	String country;
	String city;
	String street;
	String building;
	String apartment;
	String zip;
	int floor;
	boolean lift;

}
