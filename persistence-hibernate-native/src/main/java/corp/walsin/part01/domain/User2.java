package corp.walsin.part01.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name = "USER")
@Data
public class User2 implements Serializable {

	private static final long serialVersionUID = 1368460747892823647L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	private String unid;
	private String name;
	private String gender;
	private Date birthday;	
}
