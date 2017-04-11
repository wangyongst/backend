package com.myweb.service.impl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpRequest implements Runnable{

	public static void httpUrlConnection(String data){
		try {
			String pathUrl = "http://61.178.15.39:8081/GSCreditManage/randomCode.dos";
			URL url = new URL(pathUrl);
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			httpConn.setUseCaches(false);
			httpConn.setRequestMethod("GET");
			String requestString = data;

			byte[] requestStringBytes = requestString.getBytes("UTF-8");
			httpConn.setRequestProperty("Content-length", ""+ requestStringBytes.length);
			httpConn.setRequestProperty("Content-Type",
					"application/octet-stream");
			httpConn.setRequestProperty("Connection", "Keep-Alive");
			httpConn.setRequestProperty("Charset", "UTF-8");

			OutputStream outputStream = httpConn.getOutputStream();
			outputStream.write(requestStringBytes);
			outputStream.close();
			int responseCode = httpConn.getResponseCode();

			if (HttpURLConnection.HTTP_OK == responseCode) {
				StringBuffer sb = new StringBuffer();
				String readLine;
				BufferedReader responseReader;
				responseReader = new BufferedReader(new InputStreamReader(
						httpConn.getInputStream(), "UTF-8"));
				while ((readLine = responseReader.readLine()) != null) {
					sb.append(readLine).append("\n");
				}
				responseReader.close();
				System.out.println(sb.toString());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static String str2HexStr(String str) {
		char[] chars = "0123456789ABCDEF".toCharArray();
		StringBuilder sb = new StringBuilder("");
		byte[] bs = str.getBytes();
		int bit;

		for (int i = 0; i < bs.length; i++) {
			bit = (bs[i] & 0x0f0) >> 4;
			sb.append(chars[bit]);
			bit = bs[i] & 0x0f;
			sb.append(chars[bit]);
			sb.append(' ');
		}
		return sb.toString().trim();
	}

	public static String hexStr2Str(String hexStr) {
		String str = "0123456789ABCDEF";
		char[] hexs = hexStr.toCharArray();
		byte[] bytes = new byte[hexStr.length() / 2];
		int n;
		for (int i = 0; i < bytes.length; i++) {
			n = str.indexOf(hexs[2 * i]) * 16;
			n += str.indexOf(hexs[2 * i + 1]);
			bytes[i] = (byte) (n & 0xff);
		}
		return new String(bytes);
	}

	/**
	 * String的字符串转换成unicode的String
	 */
	public static String str2Unicode(String strText) throws Exception {
		char c;
		String strRet = "";
		int intAsc;
		String strHex;
		for (int i = 0; i < strText.length(); i++) {
			c = strText.charAt(i);
			intAsc = (int) c;
			strHex = Integer.toHexString(intAsc);
			if (intAsc > 128) {
				strRet += "//u" + strHex;
			} else {
				// 低位在前面补00
				strRet += "//u00" + strHex;
			}
		}
		return strRet;
	}


	public static void main(String[] args) throws Exception {
//		String oril = new String(
//				"7E005418853225057FFFFF1031110000000000000000000000000000000064FFFF300046000F21422FFF21637FFF7A7062FFFF21637FFF7838983FFF21637FFF7765253FFF21637FFF7621423FFF21637FFF76FF397E");
//		String data = oril.substring(28, 74);
//		System.out.println(data);
//		System.out.println("时间：" + data.substring(0, 6));
//		System.out.println("纬度：" + data.substring(6, 14));
//		System.out.println("经度：" + data.substring(14, 22));
//		System.out.println("速度：" + data.substring(22, 24));
//		System.out.println("方向：" + data.substring(24, 26));
//		System.out.println("日期：" + data.substring(26, 28));
//		System.out.println("状态和告警：" + data.substring(28, 32));
//		System.out.println("电量：" + data.substring(32, 34));
//		System.out.println("步数：" + data.substring(34, 38));
//		System.out.println("GSM 信号强度：" + data.substring(38, 40));
//		System.out.println("GPS 有效卫星数：" + data.substring(40, 42));
//		System.out.println("基站/wifi 状态位：" + data.substring(42, 46));
//		String status = "0100011000000000";
//		System.out.println(status + "--------" + data.substring(42, 46));
//		System.out.println("网络接入方式: " + status.substring(6, 8));
//		System.out.println("WIFI 接入标识: " + status.substring(8, 9));
//		System.out.println("CDMA: " + status.substring(9, 10));
//		System.out.println("无线网络类型: " + status.substring(10, 14));
//		System.out.println("移动网关IP版本: " + status.substring(14, 16));
//
//		String other = oril.substring(74);
//		System.out.println(other);
//		System.out.println("移动网关IP: " + other.substring(0, 8));
//		System.out.println("Mcc: " + other.substring(8, 12));
//		System.out.println("Mnc: " + other.substring(12, 16));
//		System.out.println("Lac: " + other.substring(16, 20));
//		System.out.println("Cellid: " + other.substring(20, 26));
//		System.out.println("Signal：" + other.substring(26, 30));
		
//		
//		URL u=new URL("http://route.showapi.com/142-1?showapi_appid=myappid&showapi_timestamp=20150814180305&mcc=&mnc=&lac=&ci=&gcs=&showapi_sign=mysecret");
//        InputStream in=u.openStream();
//        ByteArrayOutputStream out=new ByteArrayOutputStream();
//        try {
//            byte buf[]=new byte[1024];
//            int read = 0;
//            while ((read = in.read(buf)) > 0) {
//                out.write(buf, 0, read);
//            }
//        }  finally {
//            if (in != null) {
//                in.close();
//            }
//        }
//        byte b[]=out.toByteArray( );
//        System.out.println(new String(b,"utf-8"));
		HttpRequest httpRequest = new HttpRequest();
		for(int i = 0 ; i < 500000 ; i ++){
			Thread thread = new Thread(httpRequest);
			thread.start();
			System.out.println("-------------------------------------"+i+"-------------------------------------------------------------");
			if(i == 200) Thread.sleep(10);
		}
		
	}

	@Override
	public void run() {
		//HttpRequest httpRequest = new HttpRequest();
		HttpRequest.httpUrlConnection("");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
	}
}