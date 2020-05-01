package dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public enum LicenseCategory {
	AM(1,"Cat AM",16),
	A(2,"Cat A",20),
	A1(3,"Cat A1",16),
	A2(4,"Cat A2",18),
	B(10,"Cat B",18),
	BE(11,"Cat BE",18),
	B1(12,"Cat B1",16),
	C1(20,"Cat C1",18),
	C1E(21,"Cat C1E",18),
	C(22,"Cat C",21),
	CE(23,"Cat CE",21),
	D1(30,"Cat D1",21),
	D1E(31,"Cat D1E",21),
	D(32,"Cat D",24),
	DE(34,"Cat DE",24)
	;
	
	
	private int id;
	private String driverCategory;
	private int minAge;
	
	@JsonCreator
	public LicenseCategory init(@JsonProperty("licenseCategory") String str) {
		for (LicenseCategory lc: LicenseCategory.values())
			if (lc.getDriverCategory().equals(str)) return lc;
		return LicenseCategory.A;
	}
	
	@JsonValue
	public String getDriverCategory() {
		return driverCategory;
	}
	public int getMinAge() {
		return minAge;
	}
	
	public int getId() {
		return id;
	}
	
	public static LicenseCategory of(String driverCategory) {
		return driverCategory == null ? null :
			Stream.of(LicenseCategory.values())
			.filter(lc -> lc.getDriverCategory().equals(driverCategory))
			.findFirst().orElseThrow(IllegalArgumentException::new);
	}
	
}
