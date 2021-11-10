package bsu.comp152.webdataonwindowmw;

import java.net.http.HttpClient;
import java.util.ArrayList;

public class DataHandler {
    private HttpClient dataGrabber;
    private String webLocation;
    public DataHandler(String webLocation){
        dataGrabber=HttpClient.newHttpClient();
        this.webLocation=webLocation;
    }

    class UniversityDataTypes{
        String alpha_two_code;
        ArrayList<String> web_pages;
        String name;
        String country;
        ArrayList<String> domains;

        @Override
        public String toString(){
            return name;
        }
    }
}
