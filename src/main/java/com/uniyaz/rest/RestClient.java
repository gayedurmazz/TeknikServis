package com.uniyaz.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.uniyaz.rest.dto.ComplaintDto;
import com.uniyaz.rest.dto.UserDto;
import com.uniyaz.ui.views.ListComplaintView;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

public class RestClient {

    public void callLoginService(String usernameField, String passwordField) {

        Gson gson = new GsonBuilder().create();
        HttpPost post = new HttpPost("http://localhost:8080/rest/user/login");
        HttpEntity httpEntity = new StringEntity("userName=" + usernameField + "&password="+ passwordField, Charset.forName("utf-8"));
        post.setEntity(httpEntity);
        post.addHeader("content-type", "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            HttpEntity entity = response.getEntity();
            String dataAsJsonStr = EntityUtils.toString(entity);

            UserDto loggedUser = gson.fromJson(dataAsJsonStr, UserDto.class);
            System.out.println(loggedUser.getUserName()+ " " + loggedUser.getPassword());

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void callSaveComplaintService(ComplaintDto complaintDto){

        Gson gson = new GsonBuilder().create();
        String categoryDtoJson = gson.toJson(complaintDto);

        HttpPost post = new HttpPost("http://localhost:8080/rest/complaint/saveComplaint");
        HttpEntity httpEntity = new StringEntity(categoryDtoJson, Charset.forName("utf-8"));
        post.setEntity(httpEntity);
        post.addHeader("content-type", "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            HttpEntity entity = response.getEntity();
            String dataAsJsonStr = EntityUtils.toString(entity);

            ComplaintDto savedComplaintDto = gson.fromJson(dataAsJsonStr, ComplaintDto.class);
            System.out.println("KAYIT YAPILDI");

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<ComplaintDto> callListComplaintByClientNameService(String clientNameField){
        Gson gson = new GsonBuilder().create();
        HttpPost post = new HttpPost("http://localhost:8080/rest/complaint/findAllComplaintsByName");
        HttpEntity httpEntity = new StringEntity("clientNameSurname=" + clientNameField, Charset.forName("utf-8"));
        post.setEntity(httpEntity);
        post.addHeader("content-type", "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            HttpEntity entity = response.getEntity();
            String dataAsJsonStr = EntityUtils.toString(entity);

            List<ComplaintDto> complaintDtoList = null;
            ComplaintDto choosenComplaint = gson.fromJson(dataAsJsonStr, ComplaintDto.class);
            complaintDtoList.add(choosenComplaint);
            return complaintDtoList;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}

