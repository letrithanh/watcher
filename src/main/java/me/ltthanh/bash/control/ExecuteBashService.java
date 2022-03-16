package me.ltthanh.bash.control;

import java.io.IOException;
import java.text.MessageFormat;

public class ExecuteBashService {

    public void execute(String path) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", MessageFormat.format("sh {0}", path));
        try {
            Process process = processBuilder.start();
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Executed script!");
            } else {
                System.err.println("Couldn't execute the script: " + path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
