package Model;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Service;

@Service
public class SqlSessionUtil {
	private static SqlSessionFactory factory;
	
	
	public static SqlSession open() throws Exception {
		if(factory == null) {
			SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
			InputStream is = Resources.getResourceAsStream("mybatis/config.xml");
			factory = builder.build(is);
		}
		return factory.openSession();
	}
	
	public static void main(String[] args) {
		try {
			SqlSession sql = SqlSessionUtil.open();
			
			System.out.println("¿ÀÇÂ ¼º°ø..!"+ sql.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
