package bsu.comp152.webdataonwindowmw;

import org.controlsfx.control.tableview2.filter.filtereditor.SouthFilter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import com.google.gson.Gson;

public class DataHandler {
    private HttpClient dataGrabber;
    private String webLocation;
    public DataHandler(String webLocation){
        dataGrabber=HttpClient.newHttpClient();
        this.webLocation=webLocation;
    }

    public UniversityDataTypes[] getData(){
        var httpbuilder= HttpRequest.newBuilder();
        var dataRequest=httpbuilder.uri(URI.create(webLocation)).build();
        HttpResponse<String> response=null;//when assigning null we cannot use var
        try{
            response= dataGrabber.send(dataRequest, HttpResponse.BodyHandlers.ofString());
        }
        catch (IOException exception){
            System.out.println("Error with network");
        }
        catch (InterruptedException e){
            System.out.println("error completing data transfer");
        }
        if (response==null){
            System.out.println("Something went wrong, quitting");
            System.exit(-1);
        }
        var responseBody=response.body();
        var jsonInterpreter=new Gson();
        var universityData=jsonInterpreter.fromJson(responseBody, UniversityDataTypes[].class);
        return universityData;
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
