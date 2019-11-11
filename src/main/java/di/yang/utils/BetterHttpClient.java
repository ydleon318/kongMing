package di.yang.utils;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public class BetterHttpClient {
    private CloseableHttpClient httpClient;
    private CloseableHttpResponse response;
    private HttpClientConnectionManager manager;
    public static String responseStr = "";
    public static int codeStuts = 0;


    /**
     * 构造方法
     * @throws URISyntaxException
     */
    public BetterHttpClient() {
        httpClient = HttpClients.custom()
                .setConnectionManager(manager)
                .setConnectionManagerShared(true).build();
    }


    /**
     * get请求
     * @throws Exception
     */
    public void doGet(String url) throws IOException {
        //创建一个GET对象

        HttpGet get =new HttpGet(url);

        //执行请求
        response =httpClient.execute(get);
        System.out.println(getStatusCode());
        printResponse(response);
        //关闭httpclient
        response.close();
        httpClient.close();
    }


    /**
     * post请求，发送json参数
     * @param url 请求url地址
     * @param params 请求的json参数，调用之前需要实例化jsonObject类
     * @throws IOException
     */
    public void doPostWithJson(String url, JSONObject params) throws IOException {
        System.out.printf(url);
        HttpPost post =new HttpPost(url);
        JSONObject jsonObject = null;
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(params.toString(),"utf-8");
        post.setEntity(entity);
        //执行post请求
        response =httpClient.execute(post);
        this.responseStr = EntityUtils.toString(response.getEntity());
        this.codeStuts = getStatusCode();
        System.out.println(codeStuts);
        System.out.println(responseStr);
        response.close();
        httpClient.close();
    }

    /**
     * post请求，发送String参数
     * @param url 请求url地址
     * @param params 请求的json参数，调用之前需要实例化jsonObject类
     * @throws IOException
     */
    public void doPostWithJson(String url, String params) throws IOException {
        System.out.printf(url);
        HttpPost post =new HttpPost(url);
        JSONObject jsonObject = null;
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(params,"utf-8");
        post.setEntity(entity);
        //执行post请求
        response =httpClient.execute(post);
        this.responseStr = EntityUtils.toString(response.getEntity());
        this.codeStuts = getStatusCode();
        System.out.println(codeStuts);
        System.out.println(responseStr);
        response.close();
        httpClient.close();
    }




    /**
     * post请求，发送param类型参数
     * @param url 请求的url地址
     * @param params 请求的param参数，需要用map形式传参
     * @throws Exception
     */
    public void doPostWithParam(String url,Map params)throws Exception{
        HttpPost post =new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (Iterator iter = params.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String value = String.valueOf(params.get(name));
            nvps.add(new BasicNameValuePair(name, value));
        }
        StringEntity entity = new UrlEncodedFormEntity(nvps,"utf-8");
        post.setEntity(entity);
        response =httpClient.execute(post);
        int status = getStatusCode();
        printResponse(response);
        System.out.println(status);
        response.close();
        httpClient.close();
    }



    /**
     * 获取响应状态码
     * @return 状态码
     */
    public int getStatusCode(){
        return response.getStatusLine().getStatusCode();
    }




    /**
     * 打印响应结果
     * @param httpResponse  传入response
     * @throws ParseException
     * @throws IOException
     */
    public static void printResponse(HttpResponse httpResponse)
            throws ParseException, IOException {
        // 获取响应消息实体
        HttpEntity entity = httpResponse.getEntity();
        // 响应状态
        System.out.println("status:" + httpResponse.getStatusLine());
        System.out.println("headers:");
        HeaderIterator iterator = httpResponse.headerIterator();
        while (iterator.hasNext()) {
            System.out.println("\t" + iterator.next());
        }
        // 判断响应实体是否为空
        if (entity != null) {
            String responseString = EntityUtils.toString(entity);
            System.out.println("response length:" + responseString.length());
            System.out.println("response content:"
                    + responseString.replace("\r\n", ""));
        }
    }
}
