package com.imalljoy.insights.data.http;

import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by lijilong on 04/11.
 */

public class FileUtiles {
    public static boolean writeResponseToFile(String dir,String filePath){
        boolean isWriteSuccess = false;
        String fileName = filePath.substring(filePath.lastIndexOf("/"));
        String path = Environment.getExternalStorageDirectory() + "/" + dir + "/" + fileName;
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
        OutputStream out = null;
      /*  try {
//             = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        return isWriteSuccess;
    }
}
