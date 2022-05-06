package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

public class InputStreamPrintService {
	public void print(InputStream inputStream) throws IOException {
//		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//		String line;
//		while((line = bufferedReader.readLine()) != null) {
//			System.out.println(line);
//		}
		
		String content = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
		System.out.println(content);
	}

}
