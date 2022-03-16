package me.ltthanh;

import me.ltthanh.watcher.control.WatcherRegister;

public class App {

    /**
     * args[0] json config path
     * @param args
     */
    public static void main(String[] args) {
        try {
            String configPath = "./watcher-config.json";
            if (args.length > 0 && !args[0].isBlank()) {
                configPath = args[0];
            }
            System.out.println("Watcher was started with config at " + configPath);


            WatcherRegister watcherRegister = new WatcherRegister();
            watcherRegister.register(configPath);
        } catch (Exception e) {
            System.err.println("Interupt by unexpected behavior T.T");
            e.printStackTrace();
        }
    }
}
