package ru.netology.core.homework03.task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String gamesPath = "./src/main/java/ru/netology/core/homework03/Games";
        StringBuilder log = new StringBuilder();

        File gamesDir = new File(gamesPath);

        //создаем базовые директории
        File srcDir = new File(gamesDir, "src");
        File resDir = new File(gamesDir, "res");
        File savegamesDir = new File(gamesDir, "savegames");
        File tempDir = new File(gamesDir, "temp");

        //создаем директории с помощью метода createDir (избегаем спагетти-кода)
        //и записываем лог
        createDir(srcDir, log);
        createDir(resDir, log);
        createDir(savegamesDir, log);
        createDir(tempDir, log);

        // по условию задачи : src/main и src/test
        File mainDir = new File(srcDir, "main");
        createDir(mainDir, log);

        File testDir = new File(srcDir, "test");
        createDir(testDir, log);


        // main/Main.java и main/Utils.java
        File mainJava = new File(mainDir, "Main.java");
        File utilsJava = new File(mainDir, "Utils.java");

        //создаем файлы в директории через метод createFile
        createFile(mainJava, log);
        createFile(utilsJava, log);

        // res/drawables, res/vectors, res/icons
        File drawablesDir = new File(resDir, "drawables");
        File vectorsDir = new File(resDir, "vectors");
        File iconsDir = new File(resDir, "icons");

        //создаем директории с помощью метода createDir и записываем лог
        createDir(drawablesDir, log);
        createDir(vectorsDir, log);
        createDir(iconsDir, log);


        // temp/temp.txt
        File tempTxt = new File(tempDir, "temp.txt");
        createFile(tempTxt, log);

        //записываем лог в temp.txt
        try (FileWriter writer = new FileWriter(tempTxt)) {
            writer.write(log.toString());
        } catch (IOException e) {
            System.out.println("Не удалось записать лог в temp.txt: " + e.getMessage());
        }
    }

    //создаем метод createDir для однотипных операций. избегаем "спагетти-код".
    //метод пытается создать директорию на диске и записывает результат в log
    public static void createDir(File dir, StringBuilder log) {
        if (dir.mkdirs()) {
            log.append("Каталог создан: ").append(dir.getPath()).append('\n');
        } else {
            log.append("Каталог НЕ создан (возможно уже существует): ").append(dir.getPath()).append('\n');
        }

    }


    //метод пытается создать файл в директории и записывает результат в log
    public static void createFile(File file, StringBuilder log) {
        try {
            if (file.createNewFile()) {
                log.append("Файл создан: ").append(file.getPath()).append('\n');
            } else {
                log.append("Файл НЕ создан (возможно уже существует): ").append(file.getPath()).append('\n');
            }
        } catch (IOException e) {
            log.append("ОШИБКА при создании файла: ").append(file.getPath()).append(" | ").append(e.getMessage()).append('\n');
        }
    }
}



