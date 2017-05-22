package com.qqh.util;

import java.sql.*;

public class JavaOperationMysql {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		// 一开始必须填一个已经存在的数据库
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8";
		Connection conn = DriverManager.getConnection(url, "root", "root");
		Statement stat = conn.createStatement();

		// 创建数据库hello
		stat.executeUpdate("Create Database If Not Exists javacreate Character Set UTF8");

		// 打开创建的数据库
		stat.close();
		conn.close();
		url = "jdbc:mysql://localhost:3306/javacreate?useUnicode=true&characterEncoding=utf-8";
		conn = DriverManager.getConnection(url, "root", "root");
		stat = conn.createStatement();

		// 创建表test
		stat.executeUpdate("Create Table If Not Exists javacreate.test(id int, name varchar(80))");

		// 添加数据
		stat.executeUpdate("insert into test values(1, '张三')");
		stat.executeUpdate("insert into test values(2, '李四')");

		// 查询数据
		ResultSet result = stat.executeQuery("select * from test");

		ResultSetMetaData data = result.getMetaData();
		for (int i = 1; i <= data.getColumnCount(); i++) {
			// 获得所有列的数目及实际列数
			int columnCount = data.getColumnCount();
			// 获得指定列的列名
			String columnName = data.getColumnName(i);
			// 获得指定列的列值
			int columnType = data.getColumnType(i);
			// 获得指定列的数据类型名
			String columnTypeName = data.getColumnTypeName(i);
			// 所在的Catalog名字
			String catalogName = data.getCatalogName(i);
			// 对应数据类型的类
			String columnClassName = data.getColumnClassName(i);
			// 在数据库中类型的最大字符个数
			int columnDisplaySize = data.getColumnDisplaySize(i);
			// 默认的列的标题
			String columnLabel = data.getColumnLabel(i);
			// 获得列的模式
			String schemaName = data.getSchemaName(i);
			// 某列类型的精确度(类型的长度)
			int precision = data.getPrecision(i);
			// 小数点后的位数
			int scale = data.getScale(i);
			// 获取某列对应的表名
			String tableName = data.getTableName(i);
			// 是否自动递增
			boolean isAutoInctement = data.isAutoIncrement(i);
			// 在数据库中是否为货币型
			boolean isCurrency = data.isCurrency(i);
			// 是否为空
			int isNullable = data.isNullable(i);
			// 是否为只读
			boolean isReadOnly = data.isReadOnly(i);
			// 能否出现在where中
			boolean isSearchable = data.isSearchable(i);
			System.out.println(columnCount);
			System.out.println("获得列" + i + "的字段名称:" + columnName);
			System.out.println("获得列" + i + "的类型,返回SqlType中的编号:" + columnType);
			System.out.println("获得列" + i + "的数据类型名:" + columnTypeName);
			System.out.println("获得列" + i + "所在的Catalog名字:" + catalogName);
			System.out.println("获得列" + i + "对应数据类型的类:" + columnClassName);
			System.out.println("获得列" + i + "在数据库中类型的最大字符个数:" + columnDisplaySize);
			System.out.println("获得列" + i + "的默认的列的标题:" + columnLabel);
			System.out.println("获得列" + i + "的模式:" + schemaName);
			System.out.println("获得列" + i + "类型的精确度(类型的长度):" + precision);
			System.out.println("获得列" + i + "小数点后的位数:" + scale);
			System.out.println("获得列" + i + "对应的表名:" + tableName);
			System.out.println("获得列" + i + "是否自动递增:" + isAutoInctement);
			System.out.println("获得列" + i + "在数据库中是否为货币型:" + isCurrency);
			System.out.println("获得列" + i + "是否为空:" + isNullable);
			System.out.println("获得列" + i + "是否为只读:" + isReadOnly);
			System.out.println("获得列" + i + "能否出现在where中:" + isSearchable);

		}
		while (result.next()) {
			System.out.println(result.getInt("id") + " " + result.getString("name"));
		}

		// 关闭数据库
		result.close();
		stat.close();
		conn.close();
	}
}