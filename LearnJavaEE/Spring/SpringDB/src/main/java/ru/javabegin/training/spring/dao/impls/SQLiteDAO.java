package ru.javabegin.training.spring.dao.impls;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import ru.javabegin.training.spring.dao.interfaces.MP3Dao;
import ru.javabegin.training.spring.dao.objects.Author;
import ru.javabegin.training.spring.dao.objects.MP3;

@Component("sqliteDAO")
public class SQLiteDAO implements MP3Dao {
	
	private static final String mp3Table = "mp3";
	private static final String mp3View = "mp3_view";

	private SimpleJdbcInsert insertMP3;
	//private DataSource dataSource;
	
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);// позволяет вставлять значения по имени
		//this.insertMP3 = new SimpleJdbcInsert(dataSource).withTableName("mp3").usingColumns("name", "author");// в таблицу mp3 в колонки name,author
		//this.dataSource = dataSource;
	}
	
	@Override
	//@Transactional(propagation = Propagation.REQUIRED)
	public int insertMP3(MP3 mp3) {

		//System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		int author_id = insertAuthor(mp3.getAuthor());

		String sqlInsertMP3 = "insert into mp3 (author_id2, name) VALUES (:authorId, :mp3Name)";

		MapSqlParameterSource params = new MapSqlParameterSource();

		params = new MapSqlParameterSource();
		params.addValue("mp3Name", mp3.getName());
		params.addValue("authorId", author_id);

		return jdbcTemplate.update(sqlInsertMP3, params);

	}

	@Override
	//@Transactional(propagation = Propagation.MANDATORY)//все нормально, т.к. этот метод вызывается в другом(insertMP3), где уже открыта транзакция
	public int insertAuthor(Author author) {
		//System.out.println(TransactionSynchronizationManager.isActualTransactionActive());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sqlInsertAuthor = "insert into author (name) VALUES (:authorName)";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("authorName", author.getName());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(sqlInsertAuthor, params, keyHolder);

		return keyHolder.getKey().intValue();

	}


	/*@Override
	public void insert(MP3 mp3) {
		String sql = "insert into mp3 (name, author) VALUES (:name, :author)";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", mp3.getName());//можно дописывать тип параметра Type....
		params.addValue("author", mp3.getAuthor());

		jdbcTemplate.update(sql, params);
	}*/
	/*@Override
	public int insert(MP3 mp3) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		//объявляем параметы
		params.addValue("name", mp3.getName());
		params.addValue("author", mp3.getAuthor());
		//выполняем
		return insertMP3.execute(params);

	}*/
	@Override
	//@Transactional// выполнить данный метод через транзакцию(так что если одна из наших вставок не сработает, то и вторая откатится)
	public int insert(MP3 mp3) {

		String sqlInsertAuthor = "insert into author (name) VALUES (:authorName)";

		Author author = mp3.getAuthor();

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("authorName", author.getName());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(sqlInsertAuthor, params, keyHolder);//выполняем апдейт

		int author_id = keyHolder.getKey().intValue();

		String sqlInsertMP3 = "insert into mp3 (author_id, name) VALUES (:authorId, :mp3Name)";

		params = new MapSqlParameterSource();
		params.addValue("mp3Name", mp3.getName());
		params.addValue("authorId", author_id);

		return jdbcTemplate.update(sqlInsertMP3, params);

	}

	// массовая вставка
	@Override
	public int[] batchInsert(List<MP3> listMP3){
		String sql = "INSERT INTO mp3(name,author) VALUES(:name, :author";
		SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(listMP3.toArray());
		int[] updateCounts = jdbcTemplate.batchUpdate(sql, batch);
		return updateCounts;
	}
	// разница между методами в том, что в варианте ниже при изменении мест автора и имени(в строке sql), их поставит обратно(в какое поле какой параметр вставить)
	/*@Override
	public int insertList(List<MP3> listMP3) {
		String sql = "insert into mp3 (name, author) VALUES (:author, :name)";

		SqlParameterSource[] params = new SqlParameterSource[listMP3.size()];

		int i = 0;

		for (MP3 mp3 : listMP3) {
			MapSqlParameterSource p = new MapSqlParameterSource();
			p.addValue("name", mp3.getName());
			p.addValue("author", mp3.getAuthor());

			params[i] = p;
			i++;
		}

		// SqlParameterSource[] batch =
		// SqlParameterSourceUtils.createBatch(listMP3.toArray());
		int[] updateCounts = jdbcTemplate.batchUpdate(sql, params);
		return updateCounts.length;
	}*/
	@Override
	public int insertList(List<MP3> listMP3) {
		int i = 0;

		for (MP3 mp3 : listMP3) {
			insert(mp3);
			i++;
		}

		return i;

	}

	
	
	/*@Override
	public Map<String, Integer> getStat() {
		String sql = "select author, count(*) as count from mp3 group by author";

		// в отличии от RowMapper нужно самим обработать ResultSet
		return jdbcTemplate.query(sql, new ResultSetExtractor<Map<String, Integer>>() {

			public Map<String, Integer> extractData(ResultSet rs) throws SQLException {
				Map<String, Integer> map = new TreeMap<>();
				while (rs.next()) {
					String author = rs.getString("author");
					int count = rs.getInt("count");
					map.put(author, count);
				}
				return map;
			};

		});

	}*/
	@Override
	public Map<String, Integer> getStat() {
		String sql = "select author_name, count(*) as count from " + mp3View + " group by author_name";

		return jdbcTemplate.query(sql, new ResultSetExtractor<Map<String, Integer>>() {

			public Map<String, Integer> extractData(ResultSet rs) throws SQLException {
				Map<String, Integer> map = new TreeMap<>();
				while (rs.next()) {
					String author = rs.getString("author_name");
					int count = rs.getInt("count");
					map.put(author, count);
				}
				return map;
			};

		});

	}


	@Override
	public void delete(int id) {
		String sql = "delete from mp3 where id=:id";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		jdbcTemplate.update(sql, params);
	}

	@Override
	public void delete(MP3 mp3) {
		delete(mp3.getId());
	}

	@Override
	public MP3 getMP3ByID(int id) {
		String sql = "select * from mp3 where id=:id";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbcTemplate.queryForObject(sql, params, new MP3RowMapper());
	}

	@Override
	public List<MP3> getMP3ListByName(String name) {
		String sql = "select * from mp3 where upper(name) like :name";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", "%" + name.toUpperCase() + "%");

		return jdbcTemplate.query(sql, params, new MP3RowMapper());
	}

	/*@Override
	public List<MP3> getMP3ListByAuthor(String author) {
		String sql = "select * from mp3 where upper(author) like :author";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("author", "%" + author.toUpperCase() + "%");

		return jdbcTemplate.query(sql, params, new MP3RowMapper());
	}*/

	@Override
	public int getMP3Count() {
		String sql = "select count(*) from mp3";
		return jdbcTemplate.getJdbcOperations().queryForObject(sql, Integer.class);
	}

	/*private static final class MP3RowMapper implements RowMapper<MP3> {

		@Override
		public MP3 mapRow(ResultSet rs, int rowNum) throws SQLException {
			MP3 mp3 = new MP3();
			mp3.setId(rs.getInt("id"));
			mp3.setName(rs.getString("name"));
			mp3.setAuthor(rs.getString("author"));
			return mp3;
		}

	}*/
	
	/*public void insertWithJDBC(MP3 mp3) {

		Connection conn = null;

		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:db/SpringDB.db";
			conn = DriverManager.getConnection(url, "", "");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "insert into mp3 (name, author) VALUES (?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, mp3.getName());
			ps.setString(2, mp3.getAuthor());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}*/
	
	@Override
	public List<MP3> getMP3ListByAuthor(String author) {
		String sql = "select * from " + mp3View + " where upper(author_name) like :author_name";

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("author_name", "%" + author.toUpperCase() + "%");

		return jdbcTemplate.query(sql, params, new MP3RowMapper());
	}

	private static final class MP3RowMapper implements RowMapper<MP3> {

		@Override
		public MP3 mapRow(ResultSet rs, int rowNum) throws SQLException {
			Author author = new Author();
			author.setId(rs.getInt("author_id"));
			author.setName("author_name");

			MP3 mp3 = new MP3();
			mp3.setId(rs.getInt("mp3_id"));
			mp3.setName(rs.getString("mp3_name"));
			mp3.setAuthor(author);
			return mp3;
		}

	}
	
	
	
	
}