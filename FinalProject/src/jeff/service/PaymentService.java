package jeff.service;

import java.util.HashMap;
import java.util.List;

import jeff.domain.Payment;

public interface PaymentService {
	
	void registPayment(HashMap<String, Object> map);

	void removePayment(HashMap<String, Object> map);

	List<Payment> searchAllPayment();

}
