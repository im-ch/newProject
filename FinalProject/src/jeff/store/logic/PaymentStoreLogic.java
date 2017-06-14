package jeff.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import jeff.domain.Payment;
import jeff.store.PaymentStore;
import jeff.store.mapper.PaymentMapper;

@Repository
public class PaymentStoreLogic implements PaymentStore{

	@Override
	public void createPayment(HashMap<String, Object> map) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		PaymentMapper mapper = session.getMapper(PaymentMapper.class);
		mapper.createPayment(map);
		session.close();
	}

	@Override
	public void deletePayment(HashMap<String, Object> map) {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		PaymentMapper mapper = session.getMapper(PaymentMapper.class);
		mapper.deletePayment(map);
		session.close();
	}

	@Override
	public List<Payment> selectAllPayment() {
		SqlSession session = JeffSessionFactory.getInstance().getSession();
		PaymentMapper mapper = session.getMapper(PaymentMapper.class);
		List<Payment> list = mapper.selectAllPayment();
		session.close();
		return list;
	}
	
	

}
