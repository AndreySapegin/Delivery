package app.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import dto.Address;
import dto.Customer;
import dto.Delivery;
import dto.Employee;
import dto.Person;

public interface ServiceDeliveryEngine {

	// Address CRUD
	public ResponseEntity<Address> getAddress(Long id);

	public ResponseEntity<Boolean> setAddress(Address address);

	public ResponseEntity<Boolean> removeAddress(Long id);
	
	public ResponseEntity<List<Address>> getBy(Address address);

	// Person CRUD
	public ResponseEntity<Person> getPerson(Long id);

	public ResponseEntity<Boolean> addPerson(Person person);

	public ResponseEntity<Boolean> removePerson();

	public ResponseEntity<List<Person>> findBy(Person person);

	// Custom CRUD
	public ResponseEntity<Customer> getCustomer(Long id);

	public ResponseEntity<Boolean> removeCustomer();

	public ResponseEntity<Boolean> addCustomer(Customer person);

	public ResponseEntity<List<Customer>> findBy(Customer customer);

	// Delivery CRUD
	
	public ResponseEntity<Delivery> getDelivery(Long id);

	public ResponseEntity<Boolean> removeDelivery(Long id);

	public ResponseEntity<Boolean> setDelivery(@Valid Delivery delivery);

	public ResponseEntity<List<Delivery>> getBy(Delivery delivery);
	
	// Employee CRUD

	public ResponseEntity<Employee> getEmployee(Long id);

	public ResponseEntity<Boolean> removeEmployee();

	public ResponseEntity<Boolean> addEmployee(@Valid Employee employee);
	
	public ResponseEntity<List<Employee>> findByEmployee(Employee delivery);
		
}
