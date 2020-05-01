package dto;

import java.util.HashSet;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Builder
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property ="className")
public class MoversTeam {
	
	@Builder.Default
	private long id = (new Random()).nextLong();
	private HashSet<Employee> team;
	
	public MoversTeam(Long id, HashSet<Employee> team) {
		super();
		this.id = id == null?  (new Random()).nextLong() : id ;
		this.team = team;
	}
	
}
