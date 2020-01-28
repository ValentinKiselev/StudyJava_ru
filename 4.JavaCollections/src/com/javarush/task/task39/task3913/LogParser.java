package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;
import com.javarush.task.task39.task3913.query.UserQuery;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery, UserQuery {

    private Path logDir;
    private List<String> linesList;

    public LogParser(Path logDir) {
        this.logDir = logDir;
        String[] files = logDir.toFile().list((dir, name) -> name.endsWith(".log"));
        List<String> lines = new ArrayList<>();
        for (String file : files) {
            try {
                lines.addAll(Files.readAllLines(Paths.get(logDir + File.separator + file), Charset.defaultCharset()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        linesList = lines;
    }


    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> uniqueIPs = new HashSet<>();
        for (String line : linesList)
        {String[] parts = line.split("\\t");
        addStringEntity(after, before, uniqueIPs, parts, 0);
        }
        return uniqueIPs;
    }

    private void addStringEntity(Date after, Date before, Set<String> uniqueIPs, String[] parts, int i) {
        long lineDateTime = getDate(parts[2]).getTime();
        if (isCompatibleDate(lineDateTime, after, before)) uniqueIPs.add(parts[i]);
    }

    private Date getDate(String part) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date date = null;
        try
        {
            date = dateFormat.parse(part);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return date;
    }

    private boolean isCompatibleDate(long lineDateTime, Date after, Date before) {
        if (after == null && before == null)
        {
            return true;
        } else if (after == null)
        {
            if (lineDateTime <= before.getTime())
            {
                return true;
            }
        } else if (before == null)
        {
            if (lineDateTime >= after.getTime())
            {
                return true;
            }
        } else
        {
            if (lineDateTime >= after.getTime() && lineDateTime <= before.getTime())
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<String> uniqueIPs = new HashSet<>();

        for (String line : linesList)
        {String[] parts = line.split("\\t");
        if(user.equals(parts[1])) {
            addStringEntity(after, before, uniqueIPs, parts, 0);
        }
        }
        return uniqueIPs;

    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> uniqueIPs = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (event.toString().equals(parts[3].split(" ")[0])) {
                addStringEntity(after, before, uniqueIPs, parts, 0);
            }
        }
        return uniqueIPs;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {

        Set<String> uniqueIPs = new HashSet<>();

        for (String line : linesList) {
            String[] parts = line.split("\\t");
            if (status.toString().equals(parts[4])) {
                addStringEntity(after, before, uniqueIPs, parts, 0);
            }
        }
        return uniqueIPs;
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> allUsers = new HashSet<>();
        for (String line : linesList)
        {String[] parts = line.split("\\t");
            addUser(allUsers, parts, 1);
        }
        return allUsers;
    }
    private void addUser(Set<String> allUsers, String[] parts, int i) {
        String user = parts[i];
        allUsers.add(parts[i]);
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        return getUniqueUsers(after, before).size();
    }

    public Set<String> getUniqueUsers(Date after, Date before) {
        Set<String> uniqueUsers = new HashSet<>();
        for (String line : linesList)
        {String[] parts = line.split("\\t");
            addUsersEntity(after, before, uniqueUsers, parts, 1);
        }
        return uniqueUsers;
    }
    private void addUsersEntity(Date after, Date before, Set<String> uniqueIPs, String[] parts, int i) {
        long lineDateTime = getDate(parts[2]).getTime();
        if (isCompatibleDate(lineDateTime, after, before)) uniqueIPs.add(parts[i]);
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<String> NumberOfUserEvents = new HashSet<>();

        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if(user.equals(parts[1])) {
                addStringEntity(after, before, NumberOfUserEvents, parts, 3);
            }
        }
        return NumberOfUserEvents.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> UsersForIP = new HashSet<>();

        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if(ip.equals(parts[0])) {
                addStringEntity(after, before, UsersForIP, parts, 1);
            }
        }
        return UsersForIP;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> LoggedUsers = new HashSet<>();

        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if((parts[3].split(" ")[0]).equals("LOGIN")) {
                addStringEntity(after, before, LoggedUsers, parts, 1);
            }
        }
        return LoggedUsers;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> LoggedUsers = new HashSet<>();

        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if((parts[3].split(" ")[0]).equals("DOWNLOAD_PLUGIN")) {
                addStringEntity(after, before, LoggedUsers, parts, 1);
            }
        }
        return LoggedUsers;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> LoggedUsers = new HashSet<>();

        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if((parts[3].split(" ")[0]).equals("WRITE_MESSAGE")) {
                addStringEntity(after, before, LoggedUsers, parts, 1);
            }
        }
        return LoggedUsers;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> LoggedUsers = new HashSet<>();

        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if((parts[3].split(" ")[0]).equals("SOLVE_TASK")) {
                addStringEntity(after, before, LoggedUsers, parts, 1);
            }
        }
        return LoggedUsers;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> LoggedUsers = new HashSet<>();

        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if((parts[3].split(" ")[0]).equals("SOLVE_TASK") && task == Integer.valueOf(parts[3].split(" ")[1])) {
                addStringEntity(after, before, LoggedUsers, parts, 1);
            }
        }
        return LoggedUsers;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> LoggedUsers = new HashSet<>();

        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if((parts[3].split(" ")[0]).equals("DONE_TASK")) {
                addStringEntity(after, before, LoggedUsers, parts, 1);
            }
        }
        return LoggedUsers;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> LoggedUsers = new HashSet<>();

        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if((parts[3].split(" ")[0]).equals("DONE_TASK") && task == Integer.valueOf(parts[3].split(" ")[1])) {
                addStringEntity(after, before, LoggedUsers, parts, 1);
            }
        }
        return LoggedUsers;
    }
}