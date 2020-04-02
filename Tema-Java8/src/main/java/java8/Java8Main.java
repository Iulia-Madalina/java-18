package java8;

import javax.swing.text.html.Option;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8Main {
    //I made it 'global'. that's the only way I know to use it in 2 or more methods :(
    public static Set<String> randomString = new HashSet<>();

    public static void main(String[] args) {

        // 1) Create and Add 5 different instances of an object in a list.
        List<Flower> flowerList = Arrays.asList(
                new Flower("Magnolia", "white", 6, 45, 30),
                new Flower("Lilac", "purple", 72, 12, 40),
                new Flower("Peony", "pink", 13, 60, 20),
                new Flower("Sunflower", "yellow", 54, 200, 90),
                new Flower("Rose", "red", 45, 75, 60)
        );


        System.out.println("The list of flowers which name starts with 'M' and contains letter 'a' is: "
                + startsWithMContainsA(flowerList, "M", "a") + "\n");

        System.out.println("The flower with the least living time is: "
                + minimumLifeTime(flowerList) + "\n");

        System.out.println("The 'Max' String of the 5 generated is: "
                + maxOfRandomStrings(5) + "\n");

        System.out.println("The map of random integers and their last 2 numbers: "
                + mapOfRandomIntegersAndTheirSquaredNumber(5) + "\n");

        System.out.println("How many values of the map are greater than 10: "
                + howManyAreGreaterThanTen() + "\n");


        sortRandomStringsSetInReverseOrder(randomString);

        System.out.println(sortFlowersByHeight(flowerList) + "\n");


        System.out.println("How many flowers from the list have even number of petals: "
                + countOfEvenNumberOfPetals(flowerList) + "\n");

        System.out.println("The shortest String from the set is: " + shortestString() + "\n");

        System.out.println("And last, but not least: *THE OPTIONAL*: ");
        optionalExample();
    }

    /**
     * 11)
     * I needed to create another set because all the random ones are length 10. For some reason it printed me one of
     * them, even though they have equal length.
     * <p>
     * I think the easiest, maybe fastest way to find the shortest string by length is by using the min method that use
     * an Comparator. I think it takes the shortest code to resolve and it's the first idea that popped in mind.
     * Plus, all I needed was to create the set and the return, the rest is from java.util
     * <p>
     * If they have the same length the result is the "min" one after comparing character with character
     *
     * @return the shortest string in the set
     */
    private static String shortestString() {
        Set<String> newSetToCompareByLength = new HashSet<>();
        newSetToCompareByLength.add("a2");
        newSetToCompareByLength.add("a1");
        newSetToCompareByLength.add("abc");
        newSetToCompareByLength.add("abcd");
        newSetToCompareByLength.add("abcde");

        return newSetToCompareByLength.stream()
                .min(Comparator.comparing(String::length))
                .get();

    }

    /**
     * 10)
     * So I wrapped a new instance of type flower, printed it. I tried to wrap a null, without the ofNullable method it
     * throws the NullPointerException, that's why it's useful, if the value is null, it returns an empty Optional.
     * I then wrapped an null with the ofNullable method the printed it.
     * <p>
     * Optional as the definition says it's a class that encapsulate on value even if it's null. it's like a container/box
     * that can hold just only one object, or it's EMPTY
     * I think the Optional class, as it's name suggest stands for: it's not mandatory to use it, but it sure does help.
     * We use the Optional class to avoid getting the NullPointerException. It's really useful when you need to check
     * more than one variable if it's null, and instead of writing nested ifs end elses, you wrap the variable in an
     * Optional then check if it's empty or if is Presents with the same name methods
     */
    private static void optionalExample() {

        //it's highlighted. I do see that it's present. I wrote it :))
        Optional<Flower> optionalOfInstance = Optional.ofNullable(new Flower("Carnation", "pink", 40, 60, 60));
        if (optionalOfInstance.isPresent()) {
            System.out.println("Optional if isPresent checks out: " + optionalOfInstance);
        }

        //I emptied it to see what it prints
        optionalOfInstance = Optional.empty();
        System.out.println("The emptied one: " + optionalOfInstance);


        //this throws a NullPointerException that's why we use ofNullable method below
//        Optional<String> optionalNull = Optional.of(null);
//        System.out.println(optionalNull);

        // the method ofNullable returns an optional of specified values, otherwise, it returns an empty Optional
        Optional<String> optionalOfNullable = Optional.ofNullable(null);
        System.out.println("With ofNullable method: " + optionalOfNullable);
    }

    /**
     * 9)
     *
     * @param flowers the list of filtered instances by numberOfPetals
     * @return how many instances' field (numberOfPetals) "match" my condition (if it's an even number)
     */
    private static long countOfEvenNumberOfPetals(List<Flower> flowers) {
        return flowers.stream().filter(x -> x.getNumberOfPetals() % 2 == 0).count();
    }


    /**
     * 8)
     * I chose to sort my list by height field then printed it
     *
     * @param flowers the list that I want to sort
     * @return the sorted list
     */
    private static List<Flower> sortFlowersByHeight(List<Flower> flowers) {
        return flowers.stream().sorted(Comparator.comparing(Flower::getHeight)).collect(Collectors.toList());

    }

    /**
     * 7)
     * I printed all the random strings from the set in reverse order using the reverseOrder() method.
     * As you can see, the "max" string from the forth problem (maxOfRandomStrings method) is the first one printed.
     * Also, I tested it myself with a set of easier to understand strings before implementing
     *
     * @param randomString the set of random strings generated below
     */
    private static void sortRandomStringsSetInReverseOrder(Set<String> randomString) {

        System.out.println("The reverse sorted strings are: ");
        randomString.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

        System.out.println("\n");
    }

    /**
     * 6)
     * I used the model from the map below, then with a filter, counted the values greater than 10
     *
     * @return count the number of values of the map that are greater than 10
     */
    private static long howManyAreGreaterThanTen() {
        Map<Integer, Integer> map = mapOfRandomIntegersAndTheirSquaredNumber(5);

        System.out.println("The new map made for counting the values that are greater than 10: " + map);
        return map.entrySet().stream().filter(mapp -> mapp.getValue() > 10).count();

    }

    /**
     * 5)
     * I created a list of size(num) of random integers, then collect the tens+ones of these integers into a new list then collect/put
     * the 2 lists in a map
     *
     * @param num the number of random integers I wanted in the list
     * @return Map<Integer, Integer> where the key is a random integer and the value is the ten+one of the random integer
     * because the random integers' exponential are too big to manipulate
     */
    private static Map<Integer, Integer> mapOfRandomIntegersAndTheirSquaredNumber(int num) {

        List<Integer> lista1 = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < num; i++) {
            lista1.add(random.nextInt());
        }

        List<Integer> lista2 = lista1.stream().map(number -> number % 100).collect(Collectors.toList());

        return IntStream.range(0, lista1.size())
                .collect(
                        HashMap::new,
                        (m, i) -> m.put(lista1.get(i), lista2.get(i)),
                        Map::putAll
                );

    }

    /**
     * 4)
     * I generated random strings from 65, the value of 'A' in ASCII to 122, the value of 'z'.
     * In ASCII the lowest character from the alphabet is a capital, and the biggest is a lowercase,
     * So the maximum string is the one with the biggest sum of characters parsed (translated) into integers.
     * Most probably the maximum string here has more lowercase characters or anyway, the biggest sum.
     * (int)str1.charAt(i) – (int)str2.charAt(i)
     * So you can calculate the sum of characters of each string, the find the maximum, or, as above, you can compare
     * one string with another by substracting them. if the result is > 0 means the first string is bigger, if it's 0,
     * means they are equal, and if the result is < 0 means the second string is bigger.
     *
     * @param num the number of random string I wanted to generate
     * @return maximOfRandomString the maxim string of the ones generated
     */
    private static String maxOfRandomStrings(int num) {

        int leftLimit = 65; // letter 'A'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;

        // public Set<String> randomString = new HashSet<>();

        Random random = new Random();

        // Sorry, but I needed a FOR to add in the set 5 generated strings
        for (int i = 0; i < num; i++) {
            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)

                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            randomString.add(generatedString);
        }

        return randomString.stream()
                .max(Comparator.comparing(String::valueOf))
                .get();

    }

    /**
     * 3)
     * I found the "min" using a custom comparing criteria of choice
     * in this case, the minimum of days in the life of a flower
     * sad
     *
     * @param input the list
     * @return the element of the list that has the minimum number of petals
     */
    private static Flower minimumLifeTime(List<Flower> input) {

        return input.stream().min(Comparator.comparing(Flower::getLifeTimeInDays)).get();
    }

    /**
     * 2)
     * This method filters the elements that start with "M" and contains the letter 'a'
     * then add those filtered elements into a set
     *
     * @param input     the list to filter
     * @param startWith string of a letter
     * @param contains  string of a letter
     * @return filtered the list after the filters were applied
     */
    private static Set<Flower> startsWithMContainsA(List<Flower> input, String startWith, String contains) {

        return input
                .stream()
                .filter(x -> x.getName().startsWith(startWith))
                .filter(x -> x.getName().contains(contains))
                .collect(Collectors.toSet());


    }

}
