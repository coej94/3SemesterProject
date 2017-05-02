package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author joaci
 */
public class UrlGetter {

    static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    public String getData(String requestMethod,String dest,String date,String passengers ) {
        List<String> list = new ArrayList();
        list.add("http://airline-plaul.rhcloud.com/api/flightinfo/"+dest+"/"+date+"/"+passengers);
        list.add("http://airline-plaul.rhcloud.com/api/flightinfo/CPH/2017-05-06T00:00:00.000Z/1"); // Andre flyselskaber
        list.add("http://airline-plaul.rhcloud.com/api/flightinfo/CPH/2017-05-07T00:00:00.000Z/1");
        list.add("http://airline-plaul.rhcloud.com/api/flightinfo/CPH/2017-05-08T00:00:00.000Z/1");
        list.add("http://airline-plaul.rhcloud.com/api/flightinfo/CPH/2017-05-09T00:00:00.000Z/1");
        
        List<Future<String>> fList = new ArrayList();
                
        list.forEach((url) -> {
            fList.add(executor.submit(new URLHandler(url, requestMethod)));
        });

        List<String> newList = list.stream()
                .map(url -> executor.submit(new URLHandler(url, requestMethod)))
                .map(future -> {
            try {
                return future.get();
            } catch (InterruptedException ex) {
                return null;
            } catch (ExecutionException ex) {
                return null;
            }
            }).parallel()
                .collect(Collectors.toList());
        
        
        String asger = "";
        for (String string : newList) {
            asger += string;
        }
        return asger;
        
    }

  

}
