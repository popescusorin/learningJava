import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Snx {
    ProcessBuilder processBuilder = null;
    Process p = null;

    public void open (String server, String user,String password){
        try {
            processBuilder = new ProcessBuilder("/bin/bash","-c","/home/sorin/learningJava/metro_connect.sh", server, user, password);
            Process p = processBuilder.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s = null;
            while((s = br.readLine()) != null) {
                System.out.println(s);
            }
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
    
    public static void main (String[] args) {
        Snx snx = new Snx();
        System.out.println("Following arguments are processed: ");
        System.out.println("SERVER: "   + args[0]);
        System.out.println("USER: "     + args[1]);
        System.out.println("PASSWORD: " + args[2]);

        snx.open(args[0],args[1],args[2]);
        

        System.out.println("job finished!");

    }
}
