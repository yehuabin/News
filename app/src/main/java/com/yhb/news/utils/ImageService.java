package com.yhb.news.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
* Created by smk on 2017/10/13.
*/
public class ImageService extends AsyncTask {
   private ImageView view;
   private static byte[] data;
   /**
    * 获取网络图片的数据
    * @param path
    * @return
    * @throws IOException
    */
   public static byte[] getImage(String path) throws IOException {
//		URL url=new URL(path);
//		HttpURLConnection conn=(HttpURLConnection) url.openConnection();

//得到一个基于http协议的链接对象\
//		conn.setConnectTimeout(5000);
//		conn.setRequestMethod("GET");
//		if(conn.getResponseCode()==200){
//			InputStream in=conn.getInputStream();
//			return StreamTool.read(in);
//		}
//		return null;
       return data;

   }

   public ImageService(ImageView view){
       this.view=view;
   }

   @Override
   public  Object doInBackground(Object... params) {
       try{
           Log.i("inin", "in background");
           URL url=new URL((String) params[0]);
           HttpURLConnection conn=(HttpURLConnection) url.openConnection();//得到一个基于http协议的链接对象\
           conn.setConnectTimeout(5000);
           conn.setRequestMethod("GET");
           if(conn.getResponseCode()==200){
               InputStream in=conn.getInputStream();

               data= StreamTool.readStream(in);
               Bitmap bitmap= BitmapFactory.decodeByteArray(data, 0, data.length);

               return bitmap;
           }
       }catch(Exception e){
           e.printStackTrace();
       }
       return null;
   }

   @Override
   protected void onPostExecute(Object result) {
       Log.i("inin", "in onPostExecute");
       view.setImageBitmap((Bitmap) result);
   }
}
