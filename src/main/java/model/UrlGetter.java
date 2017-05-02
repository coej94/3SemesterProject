package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

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
        List<Future> flist = new ArrayList();
        list.forEach((string) -> {
            flist.add(executor.submit(new URLHandler(string, requestMethod)));
        });

        List<String> resultList = new ArrayList();
        List<Thread> tList = new ArrayList();
        flist.forEach((future) -> {
            tList.add(new Thread(() -> {
                try {
                    resultList.add((String) future.get());
                } catch (InterruptedException | ExecutionException ex) {
                    ex.printStackTrace();
                }
            }));
        });

        tList.forEach((t) -> {
            t.start();
        });

        tList.forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        String result = "";
        for (String string : resultList) {
            if(string.equals(resultList.get(resultList.size()-1))){
                result += string;
            } else {
                result += string+",\n";
            }
        }
        return result;
    }

}
