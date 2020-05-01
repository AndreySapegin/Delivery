package app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dto.Address;
import dto.Customer;
import dto.Delivery;
import dto.Employee;
import dto.LicenseCategory;
import dto.Person;

@Service
public class DeliveryEngineImpl implements ServiceDeliveryEngine {

	@Override
	public ResponseEntity<Address> getAddress(Long id) {
		Address address = Address.builder().country("USA").city("Dallas").street("N Harwood").building("1717").build();
		return ResponseEntity.ok(address);
	}

	@Override
	public ResponseEntity<Boolean> setAddress(Address address) {
		return ResponseEntity.ok(true);
	}

	@Override
	public ResponseEntity<Boolean> removeAddress(Long id) {
		return  ResponseEntity.ok(true);
	}

	@Override
	public ResponseEntity<List<Address>> getBy(Address address) {
		var list = new ArrayList<Address>();
		list.add(Address.builder().country("USA").city("Dallas").street("N Harwood").building("1717").build());
		return ResponseEntity.ok(list);
	}

	@Override
	public ResponseEntity<Person> getPerson(Long id) {
		var address = Address.builder() //Berolinahaus, Alexanderpl. 1, 10178 Berlin
				.country("Germany").city("Berlin").street("Alexanderpl").building("1").zip("10178")
				.build();
		var person = Person.builder().firstName("Donald").lastName("Duck").address(address).dateBirthday(LocalDate.of(2000, 01, 01)).build();
		return ResponseEntity.ok(person);
	}

	@Override
	public ResponseEntity<Boolean> addPerson(Person person) {
		return ResponseEntity.ok(true);
	}

	@Override
	public ResponseEntity<Boolean> removePerson() {
		return ResponseEntity.ok(true);
	}

	@Override
	public ResponseEntity<List<Person>> findBy(Person person) {
		var address = Address.builder() //Berolinahaus, Alexanderpl. 1, 10178 Berlin
				.country("Germany").city("Berlin").street("Alexanderpl").building("1").zip("10178")
				.build();
		var newPerson = Person.builder().firstName("Donald").lastName("Duck").address(address).dateBirthday(LocalDate.of(2000, 01, 01)).build();
		var list = new ArrayList<Person>();
		list.add(newPerson);
		return ResponseEntity.ok(list);
	}

	@Override
	public ResponseEntity<Customer> getCustomer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Boolean> removeCustomer() {

		return ResponseEntity.ok(true);
	}

	@Override
	public ResponseEntity<Boolean> addCustomer(Customer person) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(true);
	}

	@Override
	public ResponseEntity<List<Customer>> findBy(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Delivery> getDelivery(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Boolean> removeDelivery(Long id) {

		return ResponseEntity.ok(true);
	}

	@Override
	public ResponseEntity<Boolean> setDelivery(Delivery delivery) {

		return ResponseEntity.ok(true);
	}

	@Override
	public ResponseEntity<List<Delivery>> getBy(Delivery delivery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Employee> getEmployee(Long id) {
		var address = Address.builder() //Berolinahaus, Alexanderpl. 1, 10178 Berlin
				.country("Germany").city("Berlin").street("Alexanderpl").building("1").zip("10178")
				.build();
		var employee = Employee.employeeBuilder().address(address).firstName("Jone").lastName("Smith").dateBirthday(LocalDate.of(2000,01,01))
				.dateBeginContract(LocalDate.of(2019, 01, 01)).maried(false).build();
		employee.setDriverLicenseCategory(new HashSet<LicenseCategory>(Arrays.asList(LicenseCategory.B1)));
		return ResponseEntity.ok(employee);
	}

	@Override
	public ResponseEntity<Boolean> removeEmployee() {
		return ResponseEntity.ok(true);
	}

	@Override
	public ResponseEntity<Boolean> addEmployee(Employee employee) {
		return ResponseEntity.ok(true);
	}

	@Override
	public ResponseEntity<List<Employee>> findByEmployee(Employee delivery) {
		return null;
	}

}
