package app.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "range_time")
public class RangeTimeEntity {

	@Id
	@Column(name = "range_time_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	long id;
	@Column(name = "begin_time")
	LocalTime from;
	@Column(name = "end_time")
	LocalTime to;
}
