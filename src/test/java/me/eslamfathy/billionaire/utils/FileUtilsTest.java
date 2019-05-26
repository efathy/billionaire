package me.eslamfathy.billionaire.utils;

import me.eslamfathy.billionaire.model.GameContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class FileUtilsTest {

    private static final String FILE_NAME = "Joe";
    private FileUtils fileUtils = new FileUtils();

    @Before
    public void setUp() {
        try {
            fileUtils.createDirectory(Constants.SAVE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try {
            fileUtils.deleteFolder(Constants.SAVE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isSaveFolderExists() {
        assertTrue(fileUtils.isFolderExists(Constants.SAVE_PATH));
    }

    @Test
    public void getEmptySavedFiles() throws IOException {
        List<String> savedFiles = fileUtils.getSavedFiles(Constants.SAVE_PATH);
        assertTrue(savedFiles.isEmpty());
    }

    @Test
    public void saveAndCheckSavedFiles() throws IOException {
        fileUtils.save(new GameContext(), Constants.SAVE_PATH, fileUtils.getSaveFileName(FILE_NAME));
        List<String> savedFiles = fileUtils.getSavedFiles(Constants.SAVE_PATH);
        assertFalse(savedFiles.isEmpty());
        fileUtils.delete(Constants.SAVE_PATH, fileUtils.getSaveFileName(FILE_NAME));
    }

    @Test(expected = IOException.class)
    public void loadNotFound() throws IOException, ClassNotFoundException {
        fileUtils.load(Constants.SAVE_PATH, fileUtils.getSaveFileName(FILE_NAME));
    }

    @Test
    public void loadFound() throws IOException, ClassNotFoundException {
        fileUtils.save(new GameContext(), Constants.SAVE_PATH, fileUtils.getSaveFileName(FILE_NAME));
        Optional<Object> object = fileUtils.load(Constants.SAVE_PATH, fileUtils.getSaveFileName(FILE_NAME));
        assertTrue(object.isPresent());
        assertNotNull((GameContext) object.get());
        fileUtils.delete(Constants.SAVE_PATH, fileUtils.getSaveFileName(FILE_NAME));
    }

    @Test
    public void getSaveFileName() {
        assertEquals("Joe.bil", fileUtils.getSaveFileName(FILE_NAME));
    }
}