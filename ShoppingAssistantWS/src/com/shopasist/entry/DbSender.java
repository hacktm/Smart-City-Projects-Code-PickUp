
package com.shopasist.entry;

import java.io.Reader;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sa.beans.Item;

public class DbSender {

  private SqlSessionFactory factory;

  public DbSender(String configFIleLocation) {
    Reader reader = null;
    try {
      reader = Resources.getResourceAsReader(configFIleLocation);
    } catch (Exception e) {
    	System.out.println(e);
      throw new RuntimeException(e.getMessage());
    }
    factory = new SqlSessionFactoryBuilder().build(reader);
  }

  public Item doATest() throws PersistenceException {

    SqlSession session = factory.openSession();
    Item obj = null;
    try {
      String query = "com.mybatis.mappers.TestMapper.getItem";

      int id = 2;
      obj = (Item) session.selectOne(query, id);
    } finally {
      session.close();
    }
    return obj;
  }
}