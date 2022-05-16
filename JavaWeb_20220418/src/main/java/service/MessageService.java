package service;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MessageService {
	private String MyselflineToken ="41iIMuIkarutCDCaoy3ZdEkbVXxkTzgqUAOgfRVWzAM";
	private String groupLineToken = "C5GkumipTloU4tQcJSfFj6TfzgnUtBKdkVhrZ032YUt";
	private String lineNotify = "https://notify-api.line.me/api/notify";
	private int httpCode = 0;

	//圖形怎麼上傳
	public int pushMessageAndSticker(String content, String stickerPackageId, String stickerId) {
		try {
			//將訊息轉成byte陣列 編碼
			byte[] postData = ("message="+content+"&stickerPackageId="+stickerPackageId+"&stickerId="+stickerId).getBytes("UTF-8");
			
			//建立URL 物件
			URL url = new URL(lineNotify);
			
			//建立HttpURLConection 物件
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			//設定conn 相關屬性
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			
			//設定LineNotify 相關的授權Header
			conn.setRequestProperty("Authorization", "Bearer " + groupLineToken);
			
			//發送postData訊息過去
			try(DataOutputStream dataOutputStream = new DataOutputStream(conn.getOutputStream())) {
				
				dataOutputStream.write(postData);
				dataOutputStream.flush();
			}
			
			//取得回應訊息
			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				httpCode = conn.getResponseCode();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return httpCode;
	}
	
	
	public int pushMessage(String content) {
		
		try {
			//將訊息轉成byte陣列 編碼
			byte[] postData = ("message="+content).getBytes("UTF-8");
			
			//建立URL 物件
			URL url = new URL(lineNotify);
			
			//建立HttpURLConection 物件
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			//設定conn 相關屬性
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setUseCaches(false);
			
			//設定LineNotify 相關的授權Header
			conn.setRequestProperty("Authorization", "Bearer " + groupLineToken);
			
			//發送postData訊息過去
			try(DataOutputStream dataOutputStream = new DataOutputStream(conn.getOutputStream())) {
				
				dataOutputStream.write(postData);
				dataOutputStream.flush();
			}
			
			//取得回應訊息
			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				httpCode = conn.getResponseCode();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return httpCode;
	}
}
