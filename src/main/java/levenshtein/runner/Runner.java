package levenshtein.runner;

import levenshtein.constants.Constants;
import levenshtein.io.FileReader;
import levenshtein.service.DistanceCalculator;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Runner {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String text = FileReader.readFileAsString(Constants.DICTIONARY_PATH);

        System.err.println(Constants.DICTIONARY_CONTENT_TEXT + ": \n" + text);
        System.out.println(Constants.WORD_WHAT_YOU_SEARCH_TEXT + ": ");

        String keyword = sc.nextLine();
        String[] datas = text.split(" ");
        List<Integer> dist = new ArrayList<>();

        for (String s : datas) {
            dist.add(DistanceCalculator.distance(s, keyword));
        }

        Collections.sort(dist);
        System.out.print(Constants.DID_YOU_MEAN_TEXT + ": ");

        StringBuilder sb = new StringBuilder();

        for (String datum : datas) {
            if (DistanceCalculator.distance(datum, keyword) == dist.get(0)) {
                sb.append(datum).append(" ");
            }
        }
        System.out.println(Arrays.stream(sb.toString().toLowerCase().split(" ")).distinct().collect(Collectors.joining(" ")));
        sc.close();
    }
}
