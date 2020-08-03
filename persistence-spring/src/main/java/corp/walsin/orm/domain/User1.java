package corp.walsin.orm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Calendar;
import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User1 implements Serializable {
	private static final long serialVersionUID = 5663396988341628904L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;
	private String unid;
	private String name;
	private String gender;
	private Date birthday;

	public Integer getAge() {
		if (birthday == null)
			return -1;
		Calendar now = Calendar.getInstance();
		now.setTime(new Date());
		Calendar birth = Calendar.getInstance();
		birth.setTime(birthday);
		int yearBirth = birth.get(Calendar.YEAR);
		int monthBirth = birth.get(Calendar.MONTH);
		int dayBirth = birth.get(Calendar.DAY_OF_MONTH);
		int yearNow = now.get(Calendar.YEAR);
		int monthNow = now.get(Calendar.MONTH);
		int dayNow = now.get(Calendar.DAY_OF_MONTH);

		if (now.before(birth)) {
			return 0;
		} else {
			int age = yearNow - yearBirth;
			if (monthNow > monthBirth) {
				return age;
			} else if (monthNow == monthBirth) {
				return (dayNow < dayBirth) ? age - 1 : age;
			} else {
				return age - 1;
			}
		}
	}
}
