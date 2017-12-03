package com.example.n_son.roombookingsupport.ConnectInternet;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by N-SON on 07/04/17.
 */

public class DownloadJSon extends AsyncTask<String, Void, String> {
    String duongDan;
    List<HashMap<String,String>> attrs;
    Boolean method=true;
    public DownloadJSon(String duongDan){
        this.duongDan= duongDan;
        method= true;
    }
    public DownloadJSon(String duongDan, List<HashMap<String, String>> attrs){
        this.duongDan= duongDan;
        this.attrs= attrs;
        method= false;
    }
    @Override
    protected String doInBackground(String... params) {
        String data="";
        try {
            URL url= new URL(duongDan);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();

            if(!method){
                data= methodPost(httpURLConnection);
            }
            else{
                data= methodGet(httpURLConnection);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    public String methodGet(HttpURLConnection httpURLConnection){
        String data="";
        InputStream inputStream= null;
        try {
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader= new InputStreamReader(inputStream);
            BufferedReader bufferedReader= new BufferedReader(inputStreamReader);

            StringBuilder duLieu = new StringBuilder();
            String line="";
            while ((line=bufferedReader.readLine())!= null){
                duLieu.append(line);
            }
            data= duLieu.toString();
            bufferedReader.close();
            inputStreamReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    public String methodPost(HttpURLConnection httpURLConnection){
        String data="";
        String key="";
        String value="";
        try {
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            Uri.Builder builder= new Uri.Builder();
            int count= attrs.size();
            for(int i=0; i<count; i++){
                for(Map.Entry<String,String> values: attrs.get(i).entrySet()){
                    key= values.getKey();
                    value= values.getValue();
                }
                builder.appendQueryParameter(key, value);
            }
            String query = builder.build().getEncodedQuery();

            OutputStream outputStream= httpURLConnection.getOutputStream();
            OutputStreamWriter outputStreamWriter= new OutputStreamWriter(outputStream);
            BufferedWriter bufferedReader= new BufferedWriter(outputStreamWriter);
            bufferedReader.write(query);
            bufferedReader.flush();

            bufferedReader.close();
            outputStream.close();
            outputStream.close();
            data= methodGet(httpURLConnection);
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
