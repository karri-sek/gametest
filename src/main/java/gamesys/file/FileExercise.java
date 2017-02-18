package gamesys.file;

import java.io.File;

public class FileExercise {

    public boolean checkIsInputFileExists(String path){
        if(path == null || path.isEmpty()) return false;
        File inputFile = new File(path);
        return inputFile.exists();
    }

}
