package gamesys.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileExercise {

    public boolean checkIsInputFileExists(String path){
        if(path == null || path.isEmpty()) return false;
        File inputFile = new File(path);
        return inputFile.exists();
    }

    public void reverseAllWordsInFile(String path) throws IOException {
        String reversed = Files.readAllLines(Paths.get(path)).stream()
                .flatMap(line -> Arrays.asList(line.split(" +")).stream())
                .map(word -> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
        List<String> listOfReversedWords = Arrays.asList(reversed.split(" "));
        Collections.reverse(listOfReversedWords);
        Files.write(Paths.get(prepareReversedFileName(path)),String.join(" ", listOfReversedWords).getBytes());
    }

    private String prepareReversedFileName(String path) {
        int index = path.indexOf(".");
        String sourceFileNameWithoutExt = path.substring(0,index);
        String sourceFileExt = path.substring(index);
        StringBuffer sb = new StringBuffer(sourceFileNameWithoutExt).append("_reversed").append(sourceFileExt);
        return sb.toString();
    }

}
