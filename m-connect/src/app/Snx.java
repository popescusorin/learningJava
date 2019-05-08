package app;

import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Snx {
    ProcessBuilder processBuilder = null;
    Process p = null;
    //ClassLoader cl = getClass().getClassLoader();
    //File file = new File(cl.getResource("metro_connect.sh").getFile());

    public void open (String server, String user,String password){

        try {
            processBuilder = new ProcessBuilder("src/app/metro_connect.sh", server, user, password);
            Process p = processBuilder.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s = null;
            while((s = br.readLine()) != null) {
                System.out.println(s);
            }
            //p = Runtime.getRuntime().exec("sudo snx -g -s home.metro.info -u sorin.popescu@metrosystems.net");
            //p.waitFor();
            //p.destroy();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void close() {
        try{
            p = Runtime.getRuntime().exec("sudo snx -d");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
