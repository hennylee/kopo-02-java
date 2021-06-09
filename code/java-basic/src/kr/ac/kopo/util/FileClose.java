package kr.ac.kopo.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class FileClose {
	
	// InputStream
	public static void close(InputStream is) { // 명시적 형변환을 쓰면 형변환은 필요 없다~!
		if(is != null) {
			
			try {
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	// OutputStream 오버로딩
	public static void close(OutputStream os) { // 명시적 형변환을 쓰면 형변환은 필요 없다~!
		if(os != null) {
			
			try {
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// Reader 오버로딩
	public static void close(Reader r) {
		if(r != null) {
			try {
				r.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	// Writer 오버로딩
	public static void close(Writer w) {
		if(w != null) {
			try {
				w.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void close(InputStream bis, InputStream is) {
		FileClose.close(bis);
		FileClose.close(is);
	}
	
	public static void close(OutputStream bos, OutputStream os) {
		FileClose.close(bos);
		FileClose.close(os);
	}
	
	public static void close(Reader r, Writer w) {
		close(r);
		close(w);
	}
}