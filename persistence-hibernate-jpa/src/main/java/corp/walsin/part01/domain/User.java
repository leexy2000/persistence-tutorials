package corp.walsin.part01.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 1368460747892823647L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private String unid;
	
	@Column
	private String name;
	
	@Column
	private String gender;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date birthday;

}
