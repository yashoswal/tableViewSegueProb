package com.intel.newTableView.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by ymoswal on 7/6/15.
 */
public class CourseData {


    HashMap<Integer,ArrayList<String>> courseMap = new HashMap<Integer,ArrayList<String>>();

    InputStream inputStream;

    public CourseData(InputStream is) {

        inputStream = is;
        setCourseMap();
    }

    public void setCourseMap()
    {
            int i = 0;

        try{

            InputStreamReader input = new InputStreamReader(inputStream,"UTF-8");
            BufferedReader in = new BufferedReader(input);

            String c;
            while((c = in.readLine())!=null){

                ArrayList<String> str = new ArrayList<String>();
                String[] split = c.split("\t");
                for(String s : split) {
                    str.add(s);
                }
                courseMap.put(i, str);

                i++;
            }
               inputStream.close();
            input.close();
            in.close();
        }catch(IOException e){
            System.out.println(e);
        }

    }

    public String getCourse(int index){

        ArrayList<String> temp = courseMap.get(index);
        return temp.get(0);
    }

    public String getAuthor(int index){
        ArrayList<String> temp = courseMap.get(index);
        return temp.get(1);
    }

    public String getDescription(int index){
        ArrayList<String> temp = courseMap.get(index);
        if(temp.size()==3) {
            return temp.get(2);
        }
        else{
            return "";
        }
    }

    public int getSize(){
       return courseMap.size();
    }

}
