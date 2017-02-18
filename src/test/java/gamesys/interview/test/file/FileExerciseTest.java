package gamesys.interview.test.file;

import gamesys.file.FileExercise;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileExerciseTest {

    FileExercise fileExercise = null;

	@Before
	public void setUp() throws IOException, URISyntaxException {
		fileExercise = new FileExercise();
	}

    @Test
    public void testFileExistWithCorrectPath() {
        String path = "src/main/resources/META-INF/files/samplefile.txt";		;
        Assert.assertEquals(true, fileExercise.checkIsInputFileExists(path));

    }

    @Test
    public void shouldReturnFalseWhenInValidFilePath() {
        String path = "src/main/resources/META-INF/samplefile.txt";		;
        Assert.assertEquals(false, fileExercise.checkIsInputFileExists(path));
    }

    @Test
    public void shouldCreateDestinationFileAndContentShouldbeReversed() throws IOException{
        String path = "src/main/resources/META-INF/files/samplefile.txt";
        fileExercise.reverseAllWordsInFile(path);

        String destFile = "src/main/resources/META-INF/files/samplefile_reversed.txt";
        List<String> s = Files.readAllLines(Paths.get(destFile));
        Assert.assertEquals("desrever eb ot sdrow elpmas emos sniatnoc elif sihT", s.get(0));
    }

	@Test
	public void testFileCDontentReversed() {

	}

    @After
    public void tearDown() {
        fileExercise = null;
    }

}
