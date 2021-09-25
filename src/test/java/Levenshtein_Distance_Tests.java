import levenshtein.constants.Constants;
import levenshtein.io.FileReader;
import levenshtein.service.DistanceCalculator;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class Levenshtein_Distance_Tests {

    public static String dictionary_content = null;

    @Before
    public void readFile() throws IOException {

        dictionary_content = FileReader.readFileAsString(Constants.DICTIONARY_PATH);

        assertNotNull(dictionary_content);
    }

    @Test
    public void calculate_Distance_Test_1() {

        int distance = DistanceCalculator.distance("para", "yara");

        assertEquals(1, distance);
    }

    @Test
    public void calculate_Distance_Test_2() {

        int distance = DistanceCalculator.distance("berkecanozgur", "bozgur");

        assertEquals(7, distance);
    }

    @Test
    public void calculate_Distance_Test_3() {

        int distance = DistanceCalculator.distance("gazi", "giza");

        assertEquals(2, distance);
    }

    @Test
    public void calculate_Distance_Test_4() {

        int distance = DistanceCalculator.distance("trabzon", "trampet");

        assertEquals(4, distance);
    }
}
