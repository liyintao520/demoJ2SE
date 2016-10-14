package com.lyt.apache;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

/**
 * @Title: CommonsDbutils.java
 * @Package com.lyt.apache
 * @Description: TODO
 * @date 2016年10月14号 下午4:57
 * @version V1.0
 * @author liyintao
 * 测试数据库链接，并把数据分别放到list和 map中
 * 在本地新建数据库 demo 建表
 */
public class CommonsDbutils {
	public static void main(String[] args) {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/demo";
		String jdbcDriver = "com.mysql.jdbc.Driver";
		String username = "root";
		String password = "root";
		DbUtils.loadDriver(jdbcDriver);//加载驱动
		String sql = "select id,name from person";
		//****************************转换成list  ************************************
		try {
			conn = DriverManager.getConnection(url,username, password);
			QueryRunner qr = new QueryRunner();
			@SuppressWarnings({ "rawtypes", "unchecked" })
			List results = qr.query(conn, sql, new BeanListHandler(Person.class));
			for (int i = 0; i < results.size(); i++) {
				Person p = (Person) results.get(i);
				System.out.println("age: " + p.getAge() + ",name:" + p.getName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		//****************************转换成map  ************************************
		try {
			conn = DriverManager.getConnection(url, username, password);
			QueryRunner qr = new QueryRunner();
			@SuppressWarnings("rawtypes")
            List results = (List) qr.query(conn, sql, new MapListHandler());
			for (int i = 0; i < results.size(); i++) {
				@SuppressWarnings("unchecked")
                Map<String,Object> map = (Map<String,Object>) results.get(i);
				System.out.println("age:" + map.get("age") + ",name:"+ map.get("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
	}
}
