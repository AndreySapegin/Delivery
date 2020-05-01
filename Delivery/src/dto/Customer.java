package dto;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Builder

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property ="className")
public class Customer implements Comparable<Customer>{
	
	public static Comparator<Customer> byUnicalNumber = Comparator.comparing(Customer::getUnicalNumber);
	public static Comparator<Customer> byCustomerName = Comparator.comparing(Customer::getCustomerName);
	
	public static Comparator<Customer> commonCustomer = byUnicalNumber.thenComparing(byCustomerName);
	
	
	@Builder.Default
	private Long		id = (new Random()).nextLong();
	@NotEmpty
	private String		unicalNumber;
	@NotEmpty
	private String		customerName;
	private HashSet<Address>	address;
	private HashSet<Person>		contact;
	private HashSet<PhoneNumber>		commonPhone;
	private String		comment;
	
	@JsonCreator
	public Customer(Long id, String unicalNumber, String customerName, HashSet<Address> address,
			HashSet<Person> contact, HashSet<PhoneNumber> commonPhone, String comment) {
		super();
		this.id = id == null ? (new Random()).nextLong(): id;
		this.unicalNumber = unicalNumber;
		this.customerName = customerName;
		this.address = address;
		this.contact = contact;
		this.commonPhone = commonPhone;
		this.comment = comment;
	}


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
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public void setAddress(HashSet<Address> address) {
		this.address = address;
	}


	public void setContact(HashSet<Person> contact) {
		this.contact = contact;
	}


	public void setCommonPhone(HashSet<PhoneNumber> commonPhone) {
		this.commonPhone = commonPhone;
	}



	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public boolean addPhone(PhoneNumber phone) {
		if (commonPhone == null) commonPhone = new HashSet<PhoneNumber>();
		return commonPhone.add(phone);
	}
	public boolean addPerson(Person person) {
		if (contact == null) contact = new HashSet<Person>();
		return contact.add(person);
	}
	public boolean addAddress(Address addr) {
		if (address == null) address = new HashSet<Address>();
		return address.add(addr);
	}
	
	public boolean removePhone(PhoneNumber phone) {
		return commonPhone != null ? commonPhone.remove(phone) : false;
	}
	public boolean removePerson(Person person) {
		return contact != null ? contact.remove(person) : false;
	}
	public boolean removeAddress(Address addr) {
		return address != null ? address.remove(addr) : false;
	}


	@Override
	public int compareTo(Customer o) {
		return commonCustomer.compare(this, o);
	}	
}
