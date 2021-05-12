package com.ifmo.jjd.secondexam;

import java.util.*;
import java.util.stream.Collectors;

public class Step {
    private final String description;
    private final List<String> options = new ArrayList<>();

    public Step(String description, String ...options) {
        this.description = description;
        this.options.addAll(Arrays.stream(options).collect(Collectors.toList()));
        this.options.add(Settings.MENU_EXIT);
    }

    public String getDescription() {
        return description;
    }

    public List<String> getOptions() {
        return options;
    }
}
