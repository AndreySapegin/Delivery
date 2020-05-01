package app.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import dto.LicenseCategory;

@Converter(autoApply = true)
public class LicenseCategoryConverter implements AttributeConverter<LicenseCategory, String> {

	@Override
	public String convertToDatabaseColumn(LicenseCategory attribute) {
		if (attribute == null) return null;
		return attribute.getDriverCategory();
	}

	@Override
	public LicenseCategory convertToEntityAttribute(String dbData) {
		return LicenseCategory.of(dbData);
	}

}
