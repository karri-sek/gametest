package gamesys.interview.test.file;

import gamesys.file.FileExercise;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class FileExerciseTest {

    FileExercise fileExercise = null;

	@Before
	public void setUp() throws IOException, URISyntaxException {
		fileExercise = new FileExercise();
	}

	@Test
	public void testFileExist() {

	}

	@Test
	public void testFileCDontentReversed() {

	}

    @After
    public void tearDown() {
        fileExercise = null;
    }

}
