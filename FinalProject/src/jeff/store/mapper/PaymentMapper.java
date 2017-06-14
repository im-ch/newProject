package jeff.store.mapper;

import java.util.HashMap;
import java.util.List;

import jeff.domain.Payment;

public interface PaymentMapper {
	
	void createPayment(HashMap<String, Object> map);

	void deletePayment(HashMap<String, Object> map);

	List<Payment> selectAllPayment();

}
