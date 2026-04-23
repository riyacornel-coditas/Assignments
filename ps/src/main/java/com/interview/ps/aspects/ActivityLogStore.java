package com.interview.ps.aspects;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ActivityLogStore {

    private List<String> logs = new ArrayList<>();

    public void addLogs(String message)
    {
        logs.add(message);
    }

    public List<String> getLogs()
    {
        return logs;
    }
}
