package app.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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
@Table(name = "delivery")
public class DeliveryEntity {

	@Id
	Long id;
	@OneToOne
	CustomerEntity custumer;
	@OneToOne
	AddressEntity address;
	LocalDate	dateOfDelivery;
	@OneToOne
	RangeTimeEntity rangeTime;
	@OneToOne
	MoversTeamEntity team;
	String	comment;
	Double	grossWeight;
	
}
