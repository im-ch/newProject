package jeff.store.logic;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class JeffSessionFactory {
	

	private static JeffSessionFactory instance;
	private static SqlSessionFactory sqlSessionFactory;

	private final String resource = "jeff/store/config.xml";

	private JeffSessionFactory() {
	}

	public static JeffSessionFactory getInstance() {
		if (instance == null) {
			instance = new JeffSessionFactory();
		}
		return instance;
	}

	public SqlSession getSession() {
		if (sqlSessionFactory == null) {
			Reader reader = null;

			try {
				reader = Resources.getResourceAsReader(resource);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("MyBatis 설정파일 로드 중 오류 발생");
			}
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}

//		Autocommit 설정
		return sqlSessionFactory.openSession(true);
	}


}
