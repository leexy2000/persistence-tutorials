package corp.walsin.part01.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class User1 implements Serializable {

	private static final long serialVersionUID = 1368460747892823647L;

	private Integer id;
	private String unid;
	private String name;
	private String gender;
	private Date birthday;

}
