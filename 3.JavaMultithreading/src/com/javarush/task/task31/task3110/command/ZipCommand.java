package com.javarush.task.task31.task3110.command;
import com.javarush.task.task31.task3110.ZipFileManager;
import com.javarush.task.task31.task3110.ConsoleHelper;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command {
    @Override
    public void execute() throws Exception {

    }
    public ZipFileManager getZipFileManager() throws Exception{
    ConsoleHelper.writeMessage("Введите полный путь файла архива");
    Path fullPath = Paths.get(ConsoleHelper.readString());
    return new ZipFileManager(fullPath);
    }
}
