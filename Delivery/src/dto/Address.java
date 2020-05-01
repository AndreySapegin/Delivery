package dto;

import java.util.Comparator;
import java.util.Random;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property ="className")
public class Address implements Comparable<Address> {
	
	public static Comparator<Address> byCountry = Comparator.comparing(Address::getCountry);
	public static Comparator<Address> byCity = Comparator.comparing(Address::getCity);
	public static Comparator<Address> byStreet = Comparator.comparing(Address::getStreet);
	
	public static Comparator<Address> commonComparator = byCountry.thenComparing(byCity).thenComparing(byStreet);
	
	@Builder.Default
	private Long		id = (new Random()).nextLong();
	@NotEmpty(message = "Field \"country\" cant will be empty")
	private String		country;
	@NotEmpty(message = "Field \"city/town\" cant will be empty")
	private String		city;
	@NotEmpty(message = "Field \"street\" cant will be empty")
	private String		street;
	private String		building;
	private String		apartment;
	@Pattern(regexp = "\\d*", message = "In zipcode should have consistens digits only")
	private String		zip;
	private Integer		floor;
	private Boolean 	lift;

	@Override
	public int compareTo(Address o) {
		return commonComparator.compare(this, o);
	}

}
