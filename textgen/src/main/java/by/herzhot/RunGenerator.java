package by.herzhot;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RunGenerator {


    public static void main(String[] args) throws URISyntaxException, IOException {

        String resourceName = "a.txt";
        StringBuilder stringBuilder = new StringBuilder();
        List<String> strings = null;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        System.out.println("Classloader: " + classloader);
        testInputstream(classloader.getResourceAsStream(resourceName));
        URL resourceURL = classloader.getResource(resourceName);
        System.out.println("URL: " + resourceURL);
        URI resourceURI = null;
        Path resourcePath = null;
        if (resourceURL != null) {
            resourceURI = resourceURL.toURI();
            System.out.println("URI: " + resourceURI);
            resourcePath = Paths.get(resourceURI);
        }
        if (resourcePath != null) {
            try {
                System.out.println("Path: " + resourcePath);
                strings = Files.readAllLines(resourcePath, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        Pattern pattern = Pattern.compile("(\\s||\\()[а-я]+\\s*\\.\\s*-?[а-я&&[^А-Я]][а-я]*\\.?");
        Pattern pattern = Pattern.compile("[А-Я]?[а-я]+\\.?\\-[а-я]+\\-?\\.?");
        Set<String> stringMatches = new LinkedHashSet<>();

        if (strings != null) {
            for (String s : strings) {
                storeResult(pattern, stringMatches, s);

//            stringBuilder.append(System.getProperty("line.separator"));
            }
        }
        stringMatches.forEach(System.out::println);
     }

    private static void storeResult(Pattern pattern, Set stringMatches, String inputString) {
        Matcher matcher = pattern.matcher(inputString);
        while (matcher.find()) {
//            stringBuilder.append(inputString.substring(matcher.start(), matcher.end()));
//            stringBuilder.append(System.getProperty("line.separator"));
            stringMatches.add(inputString.substring(matcher.start(), matcher.end()).trim());
        }
    }

    private static void testInputstream(InputStream stream) throws IOException {
        Reader reader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        System.out.println(bufferedReader.readLine());
    }

}
