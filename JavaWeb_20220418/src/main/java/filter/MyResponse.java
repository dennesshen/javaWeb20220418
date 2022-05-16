package filter;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper{
	private CharArrayWriter bufferedWriter;
	private PrintWriter printWriter;
	public MyResponse(HttpServletResponse response) {
		super(response);
		bufferedWriter = new CharArrayWriter();
		printWriter = new PrintWriter(bufferedWriter);
	}
	
	@Override
	public PrintWriter getWriter() throws IOException {
		
		return printWriter;
	}
	
	public String getHTMLSource() {
		return bufferedWriter.toString();
	}

}
