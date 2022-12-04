package cashnamu.cashnamu_v2.www.common.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.Map;

/**
 * 
* @packageName    : cashnamu.cashnamu_v2.www.common.http
* @fileName        : HttpsTransferUtil.java
* @author        : rhkdg
* @description : https 접근 유틸 
* =======================================
* DATE			AUTHOR			NOTE
* ---------------------------------------
* 2022.12.01	고광혁			최초생성
 */
public class HttpsTransferUtil {

	/**
	 * get 방식 요청
	 * @param apiUrl
	 * @param requestHeader
	 * @return
	 * @throws Exception
	 */
	public static String get(String apiUrl , Map<String,String> requestHeader) throws Exception {
		HttpURLConnection con = null;
		try {
			con = urlConnect(apiUrl);
			for(Map.Entry<String, String> header : requestHeader.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				return readBody(con.getInputStream());
			}else {
				return readBody(con.getErrorStream());
			}
		}catch (MalformedInputException e) {
			throw new Exception("API URL이 잘못되었습니다. :"+ apiUrl ,e);
		}catch (IOException  e) {
			throw new Exception("연결에 실패하였습니다 :"+ apiUrl ,e);
		}finally {
			con.disconnect();
		}
	}
	
	/**
	 * post 방식 요청
	 * @param apiUrl
	 * @param parameter
	 * @return
	 * @throws Exception
	 */
	public static String post(String apiUrl, String parameter) throws Exception {
		HttpURLConnection con = null;
		try {
			con = urlConnect(apiUrl);
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(parameter);
			wr.flush();
			wr.close();
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				return readBody(con.getInputStream());
			}else {
				return readBody(con.getErrorStream());
			}
		}catch (IOException e) {
			throw new Exception("API 응답 실패",e);
		}finally {
			con.disconnect();
		}
	}
	
	/**
	 * url 연결 초기설정
	 * @param apiUrl
	 * @return
	 * @throws IOException
	 * @throws MalformedInputException
	 */
	public static HttpURLConnection urlConnect(String apiUrl) throws IOException , MalformedInputException{
		URL url = new URL(apiUrl);
		return (HttpURLConnection)url.openConnection(); 
	}
	
	/**
	 * 응답값 일기
	 * @param body
	 * @return
	 * @throws Exception
	 */
	public static String readBody(InputStream body) throws Exception {
		InputStreamReader streamReader = new InputStreamReader(body);
		try(BufferedReader lineReader = new BufferedReader(streamReader)){
			StringBuilder responseBody = new StringBuilder();
			
			String line;
			while((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}
			
			return responseBody.toString();
		}catch (IOException e) {
			throw new Exception("API 응답을 읽는데 실패하였습니다.");
		}
	}
}
