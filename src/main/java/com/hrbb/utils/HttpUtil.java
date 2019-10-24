package com.hrbb.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtil {
    public static String statuscode = "";

    /**
     * get请求url
     * @param url
     * @return response信息(json格式)
     */
    public static JSONObject get(String url){
        CloseableHttpClient httpClient = null;
        HttpGet httpGet = null;
        JSONObject jsonObject = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
            httpGet = new HttpGet(url);
            httpGet.setConfig(requestConfig);
            CloseableHttpResponse response = httpClient.execute(httpGet);
            String status = response.getStatusLine().toString();
            if(!status.contains("200")){
                System.out.println("请求失败");
                return null;
            }
            HttpEntity httpEntity = response.getEntity();
            jsonObject= JSONObject.parseObject(EntityUtils.toString(httpEntity,"utf-8"));
            EntityUtils.consume(httpEntity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(null!=httpGet){
                    httpGet.releaseConnection();
                }
                if(null!=httpClient){
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;

    }

    /**
     * post请求url
     * @param url
     * @param params 请求参数(json格式)
     * @return response信息(json格式)
     */
    public static JSONObject post(String url, JSONObject params){
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        JSONObject jsonObject = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
            httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            StringEntity entity = new StringEntity(params.toString(),"utf-8");
            httpPost.setEntity(entity);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String status = response.getStatusLine().toString();
            statuscode = status;
            if(!status.contains("200")){
                System.out.println("请求失败");
                return null;
            }
            HttpEntity httpEntity = response.getEntity();
            jsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity(),"UTF-8"));
            EntityUtils.consume(httpEntity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(null!=httpPost){
                    httpPost.releaseConnection();
                }
                if(null!=httpClient){
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }

    /**
     * post请求url
     * @param url
     * @param params 请求参数(string格式)
     * @return response信息(json格式)
     */
    public static JSONObject post(String url, String params){
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        JSONObject jsonObject = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(20000).setConnectTimeout(20000).build();
            httpPost = new HttpPost(url);
            httpPost.setConfig(requestConfig);
            StringEntity entity = new StringEntity(params,"utf-8");
            httpPost.setEntity(entity);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String status = response.getStatusLine().toString();
            statuscode = status;
            if(!status.contains("200")){
                System.out.println("请求失败");
                return null;
            }
            HttpEntity httpEntity = response.getEntity();
            jsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity(),"UTF-8"));
            EntityUtils.consume(httpEntity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(null!=httpPost){
                    httpPost.releaseConnection();
                }
                if(null!=httpClient){
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonObject;
    }

}
