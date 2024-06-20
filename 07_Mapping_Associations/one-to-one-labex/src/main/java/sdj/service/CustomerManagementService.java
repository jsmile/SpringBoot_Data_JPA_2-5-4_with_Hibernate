package sdj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sdj.entity.Customer;
import sdj.entity.Passport;
import sdj.repository.CustomerRepository;
import sdj.repository.PassportRepository;

@Service
public class CustomerManagementService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PassportRepository passportRepository;

	@Transactional
	public void persistingACustomerAlongWithItsPassport() {
		Passport passport = new Passport("925076473", "GBR");
		Customer customer = new Customer("Nicole Scott", "ns27@sumwhr.com", passport);

		customerRepository.save(customer);    
	}
	
	@Transactional(readOnly = true)
	public void findingAPassport() {
		Passport passport = passportRepository.findById(1L).get(); 
		System.out.println(passport);
	}

}
