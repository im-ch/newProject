package jeff.service.logic;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jeff.domain.Payment;
import jeff.service.PaymentService;
import jeff.store.PaymentStore;

@Service
public class PaymentServiceLogic implements PaymentService{

	@Autowired
	private PaymentStore store;
	
	@Override
	public void registPayment(HashMap<String, Object> map) {
		store.createPayment(map);
	}

	@Override
	public void removePayment(HashMap<String, Object> map) {
		store.deletePayment(map);
	}

	@Override
	public List<Payment> searchAllPayment() {
		List<Payment> list = store.selectAllPayment();
		return list;
	}
	
}
