package sdj.projection;

import org.springframework.beans.factory.annotation.Value;

public interface GuideNameSalary {
	
	String getName();
	Integer getSalary();
	
	@Value(" #{target.name} \t #{target.salary} ")
	String getInfo();
}
