package me.ltthanh.config.control;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import me.ltthanh.config.entity.WatcherConfig;

public class ConfigReader {

    public WatcherConfig load(String jsonConfigPath) {
        try {
            JsonReader reader = new JsonReader(new FileReader(jsonConfigPath));
            Gson gson = new Gson();
            return gson.fromJson(reader, WatcherConfig.class);
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Couldn't find config file");
        }
    }

}
