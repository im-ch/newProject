package jeff.store;

import java.util.HashMap;
import java.util.List;

import jeff.domain.Payment;

public interface PaymentStore {
	
	void createPayment(HashMap<String, Object> map);

	void deletePayment(HashMap<String, Object> map);

	List<Payment> selectAllPayment();
	
}
