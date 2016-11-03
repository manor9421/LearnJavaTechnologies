package ru.javabegin.training.spring.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.javabegin.training.spring.dao.impls.SQLiteDAO;
import ru.javabegin.training.spring.dao.interfaces.MP3Dao;
import ru.javabegin.training.spring.dao.objects.Author;
import ru.javabegin.training.spring.dao.objects.MP3;

public class Start {

	public static void main(String[] args) {
//		MP3 mp3 = new MP3();
//		mp3.setName("Song name");
//		mp3.setAuthor("Song author");
//
//		// new SQLiteDAO().insertWithJDBC(mp3);
//
//		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//		MP3Dao sqLiteDAO = (MP3Dao) context.getBean("sqliteDAO");
//
//		//sqLiteDAO.insert(mp3);
//		System.out.println(sqLiteDAO.getMP3ListByAuthor("John").size());

		/*MP3 firstMP3 = new MP3();
		firstMP3.setName("Song name");
		firstMP3.setAuthor("Song author");

		MP3 secondMP3 = new MP3();
		secondMP3.setName("Song name2");
		secondMP3.setAuthor("Song author2");

		List<MP3> list = new ArrayList<>();

		list.add(firstMP3);
		list.add(secondMP3);

		// new SQLiteDAO().insertWithJDBC(mp3);

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		SQLiteDAO sqLiteDAO = (SQLiteDAO) context.getBean("sqliteDAO");

		System.out.println(sqLiteDAO.batchInsert(list));*/
		
		MP3 firstMP3 = new MP3();
		firstMP3.setName("Song N55");

		Author author = new Author();
		author.setName("Justin");

		firstMP3.setAuthor(author);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		SQLiteDAO sqLiteDAO = (SQLiteDAO) context.getBean("sqliteDAO");

		System.out.println(sqLiteDAO.insertMP3(firstMP3));
		
	}

}