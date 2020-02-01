package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

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

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {

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

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if(user.equals(parts[1]) && event.toString().equals(parts[3].split(" ")[0])) addDateEntity(after, before, parts, set);
        }
        return set;
    }

    private void addDateEntity(Date after, Date before, String[] parts, Set<Date> set) {
        Date date = getDate(parts[2]);
        long time = getDate(parts[2]).getTime();
        if (isCompatibleDate(time, after, before)) set.add(date);
        }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if(Status.FAILED.toString().equals(parts[4])) addDateEntity(after, before, parts, set);
        }
        return set;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if(Status.ERROR.toString().equals(parts[4])) addDateEntity(after, before, parts, set);
        }
        return set;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Set<Date> set = new TreeSet<>(dateUniversal(after, before, 2, user, Event.LOGIN.toString(), Status.OK.toString()));
        if (set.size() == 0)
            return null;
        return set.iterator().next();
    }

    private Set<Date> dateUniversal(Date after, Date before, int position, String... strings) {
        Set<String> stringDates = userUniversal(after, before, position, strings);
        Set<Date> result = new HashSet<>();
        for (String string : stringDates)
            result.add(getDate(string));
        return result;
    }
    private Set<String> userUniversal(Date after, Date before, int position, String... strings) {
        Set<String> result = new HashSet<>();
        for (String line : linesList) {
            if (contains(line, strings)) {
                String[] parts = line.split("\t");
                addStringEntity(after, before, result, parts, position);
            }
        }
        return result;
    }
    private boolean contains(String string, String... strings) {
        for (String reg : strings) {
            if (!string.contains(reg))
                return false;
        }
        return true;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Set<Date> set = new TreeSet<>(dateUniversal(after, before, 2, user, Event.SOLVE_TASK.toString() + " " + task));
        if (set.size() == 0)
            return null;
        return set.iterator().next();
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Set<Date> set = new TreeSet<>(dateUniversal(after, before, 2, user, Event.DONE_TASK.toString() + " " + task));
        if (set.size() == 0)
            return null;
        return set.iterator().next();
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if(user.equals(parts[1]) && Event.WRITE_MESSAGE.toString().equals(parts[3])) addDateEntity(after, before, parts, set);
        }
        return set;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> set = new HashSet<>();
        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if(user.equals(parts[1]) && Event.DOWNLOAD_PLUGIN.toString().equals(parts[3])) addDateEntity(after, before, parts, set);
        }
        return set;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();

        for (String line : linesList)
        {String[] parts = line.split("\\t");
         addEventEntity(after, before, events, parts);
        }
        return events;
    }

    private void addEventEntity(Date after, Date before, Set<Event> enteties, String[] parts)
    {
        Event lineEvent = Event.valueOf(parts[3].split(" ")[0]);
        long lineDateTime = getDate(parts[2]).getTime();

        if (isCompatibleDate(lineDateTime, after, before))
        {
            enteties.add(lineEvent);
        }
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> events = new HashSet<>();

        for (String line : linesList)
        {String[] parts = line.split("\\t");
        if(parts[0].equals(ip)) addEventEntity(after, before, events, parts);
        }
        return events;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> events = new HashSet<>();

        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if(parts[1].equals(user)) addEventEntity(after, before, events, parts);
        }
        return events;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();

        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if(Status.FAILED.toString().equals(parts[4])) addEventEntity(after, before, events, parts);
        }
        return events;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();

        for (String line : linesList)
        {String[] parts = line.split("\\t");
            if(Status.ERROR.toString().equals(parts[4])) addEventEntity(after, before, events, parts);
        }
        return events;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int numberOfAttemptToSolve = 0;

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (Event.SOLVE_TASK.toString().equals(parts[3].split(" ")[0])
                    && task == Integer.valueOf(parts[3].split(" ")[1]))
            {
                long lineDateTime = getDate(parts[2]).getTime();
                if (isCompatibleDate(lineDateTime, after, before))
                {
                    numberOfAttemptToSolve++;
                }
            }
        }
        return numberOfAttemptToSolve;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int numberOfSucAttemptToSolve = 0;

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (Event.DONE_TASK.toString().equals(parts[3].split(" ")[0])
                    && task == Integer.valueOf(parts[3].split(" ")[1]))
            {
                long lineDateTime = getDate(parts[2]).getTime();
                if (isCompatibleDate(lineDateTime, after, before)) {
                    numberOfSucAttemptToSolve++;
                }
                }
        }
        return numberOfSucAttemptToSolve;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (Event.SOLVE_TASK.toString().equals(parts[3].split(" ")[0]) )
            {
                long lineDateTime = getDate(parts[2]).getTime();
                if (isCompatibleDate(lineDateTime, after, before))
                {
                    int task = Integer.valueOf(parts[3].split(" ")[1]);
                    map.put(task, getNumberOfAttemptToSolveTask(task,after, before));
                }
            }
        }
        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();

        for (String line : linesList)
        {
            String[] parts = line.split("\\t");
            if (Event.DONE_TASK.toString().equals(parts[3].split(" ")[0]) )
            {
                long lineDateTime = getDate(parts[2]).getTime();
                if (isCompatibleDate(lineDateTime, after, before))
                {
                    int task = Integer.valueOf(parts[3].split(" ")[1]);
                    map.put(task, getNumberOfSuccessfulAttemptToSolveTask(task,after, before));
                }
            }
        }
        return map;
    }

    @Override
    public Set<Object> execute(String query) {
        Set<Object> uniqueelements = new HashSet<>();
        Set<Date> uniquedate = new HashSet<>();
        Set<Date> uniquestatus = new HashSet<>();
        switch (query){
            case("get ip"):
                    for (String line : linesList) {
                    String[] parts = line.split("\\t");
                        uniqueelements.add(parts[0]);
                    }
                break;
            case("get user"):
                for (String line : linesList) {
                    String[] parts = line.split("\\t");
                    uniqueelements.add(parts[1]);
                }
                break;
            case("get date"):
                for (String line : linesList) {
                    String[] parts = line.split("\\t");
                    uniquedate.add(getDate(parts[2]));
                }
                break;
            case("get event"):
                for (String line : linesList) {
                    String[] parts = line.split("\\t");
                    uniqueelements.add(Event.valueOf(parts[3].split(" ")[0]));
                }
                break;
            case("get status"):
                for (String line : linesList) {
                    String[] parts = line.split("\\t");
                    uniqueelements.add(Status.valueOf(parts[4]));
                }
                break;
            default:
                break;

        }

        if(query.equals("get date")) {
            uniqueelements.clear();
            uniqueelements.addAll(uniquedate);
        }
        return uniqueelements;
    }
}