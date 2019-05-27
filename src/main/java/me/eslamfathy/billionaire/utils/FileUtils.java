package me.eslamfathy.billionaire.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

    public List<String> getSavedFiles(String folderPath) throws IOException {
        if (isFolderExists(folderPath)) {
            try (Stream<Path> paths = Files.walk(Paths.get(folderPath))) {
                return paths.filter(Files::isRegularFile).map(Path::getFileName).map(Path::toString)
                            .map(s -> s.replace(Constants.SAVED_FILES_EXTENSION, ""))
                            .collect(Collectors.toList());
            }
        }
        return new ArrayList<>();
    }

    public void save(Object object, String folderPath, String fileName) throws IOException {
        if (!isFolderExists(folderPath)) {
            createDirectory(folderPath);
        }
        try (FileOutputStream fileOut = new FileOutputStream(folderPath + fileName)) {
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(object);
            }
        }
    }

    public void delete(String folderPath, String fileName) throws IOException {
        if (isFolderExists(folderPath)) {
            Path path1 = Paths.get(folderPath + fileName);
            Files.delete(path1);
        }
    }

    public Optional<Object> load(String folderPath, String fileName) throws IOException, ClassNotFoundException {
        if (isFolderExists(folderPath)) {
            try (FileInputStream fileIn = new FileInputStream(folderPath + fileName)) {
                try (ObjectInputStream in = new ObjectInputStream(fileIn)) {
                    return Optional.ofNullable(in.readObject());
                }
            }
        }
        return Optional.ofNullable(null);
    }

    public String getSaveFileName(String fileName) {
        return fileName + Constants.SAVED_FILES_EXTENSION;
    }

    public boolean isFolderExists(String path) {
        Path folderPath = Paths.get(path);
        return Files.exists(folderPath);
    }

    public void createDirectory(String path) throws IOException {
        Path folderPath = Paths.get(path);
        Files.createDirectories(folderPath);
    }

    public void deleteFolder(String path) throws IOException {
        Path folderPath = Paths.get(path);
        Files.walk(folderPath)
             .sorted(Comparator.reverseOrder())
             .map(Path::toFile)
             .forEach(File::delete);
    }
}
