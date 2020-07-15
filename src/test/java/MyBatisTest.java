import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

  /**
   * 传统方式
   */
  @Test
  public void test1() throws IOException {
    // 1. 变成了流
    InputStream inputStream = Resources.getResourceAsStream("sqllllMapConfig.xml");
    System.out.println("----------------");
    //解析生成configuration，并生成sqlSessionFactory
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    // 生成了defaultSqlSession ，设置了事务不自动提交，完成了executor对象的创建
    SqlSession sqlSession = sqlSessionFactory.openSession();
    //1.根据statementid获取到了Mappedstatemented对象
    //2.将真正的执行委派给了executor
    List<Object> objects = sqlSession.selectList("");


  }

}
