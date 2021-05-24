package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileClose {
	
	
	public static void close(FileOutputStream fos) {
		if(fos != null) {
			try {
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(ObjectOutputStream oos) {
		if(oos != null) {
			try {
				oos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void close(FileInputStream fis) {
		if(fis != null) {
			try {
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void close(ObjectInputStream ois) {
		if(ois != null) {
			try {
				ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void close(FileOutputStream fos, ObjectOutputStream oos) {
		FileClose.close(fos);
		FileClose.close(oos);
		
	}
	
	public static void close(FileInputStream fis, ObjectInputStream ois) {
		FileClose.close(fis);
		FileClose.close(ois);
		
	}
}
