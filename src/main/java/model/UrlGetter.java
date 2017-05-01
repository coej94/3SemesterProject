package model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joaci
 */
public class UrlGetter {

    static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        List<String> list = new ArrayList();
        list.add("http://localhost:8084/webto/api/price/Denmark");
        list.add("http://localhost:8084/webto/api/price/Belgium");
        list.add("http://localhost:8084/webto/api/price/Norway");
        list.add("http://localhost:8084/webto/api/price/Sweden");
        list.add("http://localhost:8084/webto/api/price/Netherlands");
        list.add("http://localhost:8084/webto/api/price/Germany");
        list.add("http://localhost:8084/webto/api/price/Aruba");
        new UrlGetter().starter(list);
    }

    public void starter(List<String> list) {
        List<Future> flist = new ArrayList();
        list.forEach((string) -> {
            flist.add(executor.submit(new URLHandler(string, "GET")));
        });
        flist.forEach((future) -> {
            new Thread(() -> {
                try {
                    System.out.println(future.get());
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(UrlGetter.class.getName()).log(Level.SEVERE, null, ex);
                }

            }).start();
        });
        executor.shutdown();
    }

}
