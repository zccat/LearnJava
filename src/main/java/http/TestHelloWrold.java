package http;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.io.IOUtils;

public class TestHelloWrold {
    public static void main(String[] args) throws Exception {
        String wsdl = "http://192.168.31.66:8899/ConnectByJavaDemo.asmx";
        int timeout = 10000;
        StringBuffer sb = new StringBuffer("");
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<soap:Envelope " +
                "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
                "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " +
                "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n");
        sb.append("<soap:Body>");
        sb.append("<Add xmlns=\"http://tempuri.org/\">" +
                "<student>" +
                "<ID>666</ID>" +
                "<Name>测试用8899</Name>" +
                "<Age>88</Age>" +
                "</student>" +
                "</Add>");
        sb.append("</soap:Body>");
        sb.append("</soap:Envelope>");

        // HttpClient发送SOAP请求
        System.out.println("HttpClient 发送SOAP请求");
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod(wsdl);
        // 设置连接超时
        client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);
        // 设置读取时间超时
        client.getHttpConnectionManager().getParams().setSoTimeout(timeout);
        // 然后把Soap请求数据添加到PostMethod中
        RequestEntity requestEntity = new StringRequestEntity(sb.toString(), "text/xml", "UTF-8");
        //设置请求头部，否则可能会报 “no SOAPAction header” 的错误
        postMethod.setRequestHeader("SOAPAction","http://tempuri.org/Add");
        // 设置请求体
        postMethod.setRequestEntity(requestEntity);
        int status = client.executeMethod(postMethod);
        // 打印请求状态码
        System.out.println("status:" + status);
        // 获取响应体输入流
        InputStream is = postMethod.getResponseBodyAsStream();
        // 获取请求结果字符串
        String result = IOUtils.toString(is);
        System.out.println("result: " + result);


        // HttpURLConnection 发送SOAP请求
        System.out.println("HttpURLConnection 发送SOAP请求");
        URL url = new URL(wsdl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        conn.setRequestMethod("POST");
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setConnectTimeout(timeout);
        conn.setReadTimeout(timeout);

        DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
        dos.write(sb.toString().getBytes("utf-8"));
        dos.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        String line = null;
        StringBuffer strBuf = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            strBuf.append(line);
        }
        dos.close();
        reader.close();
        System.out.println(strBuf.toString());
    }

}