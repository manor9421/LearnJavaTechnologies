package com.mnr.ionio;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		
		/* read all inside directory
		String dirname = "/d";
		File f1 = new File(dirname);
		if( f1.isDirectory() ){
			System.out.println( "directory detected"
					+ "\nit include:" );
			
			// read all files/directories to String array
			String s[] = f1.list();
			
			for( int i=0; i < s.length; i++ ){
				
				File fBuf = new File( dirname + "/" + s[i] );
				if( fBuf.isDirectory() ){
					System.out.println( s[i] + " is a directory" );
				}else{
					System.out.println( s[i] + " is a file" );
				}
				
			}// end of for cycle
			
		}else{
			System.out.println( dirname + " is not a directory!" );
		}
		*/
		
		/*
		String dirname = "/d";
		File f2 = new File(dirname);
		FFilter fnf = new FFilter("txt");//filter for searched files(with .txt ending)
		String s[] = f2.list(fnf);//list with filter
		
		for( int i=0;i<s.length;i++ ){
			System.out.println( "File: " + s[i] );
		}
		
		File[] filesArray = f2.listFiles();// return array of files
		File[] filesFilteredArray = f2.listFiles(fnf);// return array of files with filter
		File[] filesFilteredArray2 = f2.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {// true if filepath is OK for us
				return false;
			}
		});// return array of files
		*/
		
		/*
		File file = new File("/d/newdir");
		file.mkdir();// return true on succesfully directory created. false if path is not created yet
		//file.mkdirs();// create directory and ALL needed directories if they are not created yet
		*/
		
		/* File reading
		int size;
		try(
			FileInputStream f0 = new FileInputStream("/d/file.txt");
			//File file = new File("/d/file.txt");
			//FileInputStream f1 = new FileInputStream(file);
		){
			System.out.println( "byte length: " + (size = f0.available()) );
			int n = size/10;
			
			System.out.println("first " + n + " bytes:");
			
			for(int i=0; i<n;i++){
				System.out.print( (char) f0.read() );
			}
			
			System.out.println("\nstill available: " + f0.available());
			
			System.out.println("next " + n + " bytes: with read(b[])");
			
			byte b[] = new byte[n];
			if( f0.read(b) != n ){
				System.err.println("Can't read " + n + " bytes");
			}
			System.out.println(new String(b,0,n));
			
			System.out.println("stille available: " + f0.available());
			
			System.out.println(new String(b,0,b.length));
			
		}catch(IOException e){
			System.out.println("File reading error!");
		}
		*/
		
		/* Writing to file
		String s = "Hello from eclipse\n";
		byte buf[] = s.getBytes();
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream("/d/file.txt",true);// (path, boolean add);(File),(File, boolean add);
			
			for(int i=0;i<buf.length;i++){
				fos.write(buf[i]);
			}
			
			fos.write(buf);
			
			
		}catch (IOException e) {
			System.out.println("file io error");
		}finally {
				try {
					if(fos != null)
						fos.close();
				} catch (IOException e) {
					System.out.println("file closing error");
				}
		}
		*/
		
		
		/*
		String tmp = "hello from Eclipse";
		byte b[] = tmp.getBytes();
		
		ByteArrayInputStream input = new ByteArrayInputStream(b);// close() methods isn't needed
		//ByteArrayInputStream input = new ByteArrayInputStream(b,0,3);// start,length
		
		for(int i=0;i<2;i++){
			int c;
			while((c = input.read()) != -1){
				if(i==0){// 1st simbol will have lower case
					System.out.println((char) c );
				}else {
					System.out.println(Character.toUpperCase((char) c));
				}
			}
			System.out.println();
			input.reset();// reset cursor to the 1st position(mark() method - change cursor)
			
		}
		*/
		//
		/*
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		String string = "--Hello From Eclipse--";
		byte buf[] = string.getBytes();
		
		try {
			baos.write(buf);
		} catch (IOException e) {
			System.out.println("buffer write error");
		}
		
		System.out.println(baos.toString());
		
		byte b[] = baos.toByteArray();
		
		for(int i=0; i<b.length;i++) System.out.println((char) b[i]);
		
		System.out.println("\nTo OutputStream()");
		
		try(FileOutputStream fos = new FileOutputStream("/d/file.txt",true)){
			
			try {
				baos.writeTo(fos);// write ByteArrayOutputStream to file
			} catch (IOException e) {
				e.printStackTrace();
			}
		}catch(IOException e){
			System.out.println("IO Exception " + e);
			return;
		}
		baos.reset();
		
		baos.write('X');// rewrite ByteArrayOutputStream
		System.out.println(baos);
		*/
		
		
		/* BufferedInputStream
		String s = "This is &copy; sign";
		
		byte buf[] = s.getBytes();
		ByteArrayInputStream in = new ByteArrayInputStream(buf);
		
		int c;
		boolean marked = false;
		
		try(
				BufferedInputStream f = new BufferedInputStream(in)
				//BufferedInputStream f = new BufferedInputStream(in,8192)// with buffer size
			){
			while( (c=f.read()) != -1 ){
				switch(c){
				case '&':
					if(!marked){
						f.mark(32);// make mark for reading next 32 bytes
						marked = true;
					}else{
						marked = false;
					}
					break;
				case ';':
					if(marked){
						marked = false;
						System.out.print("(c)");
					}else{
						System.out.print( (char) c );
					}
					break;
				case ' ':
					if(marked){
						marked = false;
						f.reset();
						System.out.print("&");
					}else {
						System.out.print( (char) c );
					}
					break;
				default:
					if(!marked){
						System.out.print( (char) c );
					}
					break;
				}
				
			}
		}catch (IOException e) {
			System.out.println("IO Exception");
		}
		*/
		
		
		////////// --------------------------------- //////////////////////////
		/*
		File f = new File("/d/file.txt");
		
		try(
				FileInputStream fis = new FileInputStream(f);
		){
			int fileSize = fis.available();
			StringBuilder inFile = new StringBuilder();
			System.out.println( "file size is " + fileSize );
			
			for(int i=0;i<fileSize;i++){
				inFile.append( (char) fis.read() );
			}
			
			System.out.println(inFile);
			
		}catch(IOException e){
			System.out.println("file reading error");
		}
		*/
		
		/* BufferedReader
		try(
			BufferedReader br = new BufferedReader(new FileReader("/d/file.txt"),8192);
		){
			String inFile;
			
			while( (inFile = br.readLine()) != null ){
				System.out.println(inFile);
			}
			
		}catch( IOException e ){
			e.printStackTrace();
		}
		*/
		
		/* BufferedWriter
		try(
			BufferedWriter bw = new BufferedWriter(new FileWriter("/d/file.txt",true),8192)
		){
			String s = "abcde123456789";
			
			bw.write(s);
			
		}catch(IOException e){
			
		}
		*/
		
		
		/* Write Serializable
		 * If we need to serialize object which was inherited, his parent must have empty constructor
		try(
			FileOutputStream fos = new FileOutputStream("/d/file.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		){
			
		SerClass ob = new SerClass(35, "John");
		
		oos.writeObject(ob);
//		oos.flush();
//		oos.close();

		}catch (IOException e) {
			System.out.println("unable to write object");
		}
		*/
		
		/* Read Serializable from file
		try(
			FileInputStream fis = new FileInputStream("/d/file.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
		){
			SerClass fileOb = (SerClass) ois.readObject();
			System.out.println("object info: " + fileOb.length + "/" + fileOb.name);
			
		}catch (IOException e) {
			System.out.println("unable to read object");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		*/
		
		/*String path = "/d";
		String name = "qq.t";
		
		File aFile = new File(path,name);
		
		aFile.mkdir();
		
		try {
			aFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		/*
		File forList = new File("/d/file.array");
		try {
			forList.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// write
		LinkedList<String> ll = new LinkedList<>();
		for(int i=0;i<100000;i++){
			ll.add("e"+i);
		}
		String path = "/d/file.txt";
		try(
			FileOutputStream fos = new FileOutputStream("/d/w.w");// will create file if not exist
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		){
			oos.writeObject(ll);
		}catch (IOException e) {
			e.printStackTrace();
		}*/
		// read
		/*try(
			FileInputStream fis = new FileInputStream("/d/w.w");
			ObjectInputStream ois = new ObjectInputStream(fis);
		){
			LinkedList<String> rLL = (LinkedList<String>) ois.readObject();
			System.out.println(rLL.get(rLL.size()-1));
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}*/
		
		
		/*try(
			BufferedReader br = new BufferedReader(new FileReader("/d/w.w"),8192);
		){
			int max = 0;
			int c;
			while( (c=br.read()) != -1 ){
				if(c>max) max=c;
			}
			System.out.println((char) max);
		}catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		
		
		
		
		
	}

}
