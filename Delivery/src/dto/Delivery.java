package dto;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Random;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Builder

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property ="className")
public class Delivery implements Comparable<Delivery>{
	
	public static Comparator<Delivery> byCustormer = Comparator.comparing(Delivery::getCustomer);
	public static Comparator<Delivery> byAddress = Comparator.comparing(Delivery::getAddressOfDelivery);
	public static Comparator<Delivery> byDateOfDelivery = Comparator.comparing(Delivery::getDateOfDelivery);

	public static Comparator<Delivery> commonComparator = byCustormer.thenComparing(byAddress).thenComparing(byDateOfDelivery);
	
	
	@Builder.Default
	private long					id = (new Random()).nextLong();
	@NotNull
	private @Valid Customer			customer;
	@NotNull
	private @Valid Address			addressOfDelivery;
	@NotNull
	@FutureOrPresent
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate				dateOfDelivery;
	private @Valid RangeTime		timeRange;
	private MoversTeam				moversTeam;
	private String					comment;
	private double					grossWeight;

	public Delivery(Long id, @NotNull @Valid Customer customer, @NotNull @Valid Address addressOfDelivery,
			@NotNull LocalDate dateOfDelivery, @Valid RangeTime timeRange, MoversTeam moversTeam, String comment,
			double grossWeight) {
		super();
		this.id = id == null ? (new Random()).nextLong(): id;
		this.customer = customer;
		this.addressOfDelivery = addressOfDelivery;
		this.dateOfDelivery = dateOfDelivery;
		this.timeRange = timeRange;
		this.moversTeam = moversTeam;
		this.comment = comment;
		this.grossWeight = grossWeight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((dateOfDelivery == null) ? 0 : dateOfDelivery.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Delivery other = (Delivery) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (dateOfDelivery == null) {
			if (other.dateOfDelivery != null)
				return false;
		} else if (!dateOfDelivery.equals(other.dateOfDelivery))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	public void setAddressOfDelivery(Address addressOfDelivery) {
		this.addressOfDelivery = addressOfDelivery;
	}

	public void setTimeRange(RangeTime timeRange) {
		this.timeRange = timeRange;
	}

	public void setMoversTeam(MoversTeam moversTeam) {
		this.moversTeam = moversTeam;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setGrossWeight(double grossWeight) {
		this.grossWeight = grossWeight;
	}

	@Override
	public int compareTo(Delivery o) {
		return commonComparator.compare(this, o);
	}
	
}
