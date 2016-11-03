package com.mnr.threads.wait.training;

import java.io.File;

/**
 * This class was made for checking computer directories.
 * 
 * 
 * @author gdx
 * @version 1.0
 */
public class FileListMaker implements Runnable{

	Thread t;
	/** variable for directory name */
	private String mainDirName;
	/** variable for number of directories inside current one */
	private static long dirCount;// dir number
	/** variable for size of directories inside current one */
	private static long dirValue;
	/** variable for number of files inside current directory */
	private static long fileCount;
	/** variable for size of files inside current directory */
	private static long fileValue;
	
	/**
	 * Constructor which initialize all class parameters and start
	 * new thread
	 * 
	 * @param dirName - name of main directory for scanning
	 */
	public FileListMaker(String dirName) {
		this.mainDirName = dirName;
		dirCount = 0;
		dirValue = 0;
		fileCount = 0;
		fileValue = 0;
		t = new Thread(this, "filereader");
		t.start();
	}
	
	/**
	 * call methods for chechind all directories and print its result 
	 */
	@Override
	public void run() {
		
		checkDir(mainDirName);
		
		System.out.println("directories inside " + mainDirName + ": " + dirCount
				+ " with total value: " + dirValue
				+ "\nfiles inside: " + fileCount
				+ " with total value: " + fileValue
		);
		
	}
	
	/**
	 * scan current directory for all files and folders, save their size and count to variables
	 * it calls itself recursively until complete.
	 * write names of files with a strange types to console
	 * 
	 * @param dirName - name of directory for scanning
	 */
	public void checkDir(String dirName){
		
		File dir = new File(dirName);
		String[] insideDir = dir.list();// get all inside list
		
		for (int i=0;i<insideDir.length;i++) {
			
			File file = new File(dirName+"/"+insideDir[i]);
			
			if(file.isDirectory()){
				
				dirCount++;
				dirValue += file.length();
				checkDir(file.toString());
				
			}else if(file.isFile()){
			
				fileCount++;
				
				fileValue += file.length();
				
			}else{
				System.out.println("Strange file type: " + file.getName());
			}
			
		}
		
	}
	
}