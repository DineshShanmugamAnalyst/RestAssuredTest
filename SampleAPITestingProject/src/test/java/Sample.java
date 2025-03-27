
import com.inputpojo.TagOne;
import com.pojo.*;
import com.test.Student;
import com.test.TaskFive;
import com.test.TaskTwo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class Sample {

    @Test
    public void testMethod() {
        System.out.println("Hello, TestNG!");
    }

    @Test
    public void testCreatePet() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        Category category = new Category(1, "Dogs");
       Tag tag = new Tag(1, "Bulldog");

        ArrayList<String> photoUrls = new ArrayList<>();
        photoUrls.add("https://example.com/dog1.jpg");
        photoUrls.add("https://example.com/dog2.jpg");

        ArrayList<Tag> tags = new ArrayList<>(Arrays.asList(tag));

        //    Add_New_Pet_Input_Pojo pet = new Add_New_Pet_Input_Pojo(1, category, "doggie", photoUrls, tags, "available");

        Add_New_Pet p1 = Add_New_Pet.builder().id(1).name("tom").build();

        Response response = given()
                .contentType(ContentType.JSON)
                .body(p1)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();

        // Assertions
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("name"), "tom");
    }

    @Test
    public void getListUsers() throws IOException {

        // String schema = new String(Files.readAllBytes(Paths.get("src/test/resources/schemavalidation.json")));

        RestAssured.baseURI = "https://reqres.in/api";
        Response response = given()
                .queryParam("page", 2)
                .contentType(ContentType.JSON)
                .when()
                .get("/users")
                .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemavalidation.json"))
                .statusCode(200)
                .log().all()
                .extract()
                .response();
        System.out.println("Response: " + response.asString());
    }

    @Test
    public void averageCarPrice() {

        double average = MockData.getCars()
                .stream()
                .mapToDouble(p -> p.price)
                .average()
                .orElse(0);
        System.out.println("Average Car Price: $" + average);
    }

    @Test
    public void understandingFilter() {

        List<Car> cars = MockData.getCars();

        // Predicate<Car> carPredicate = car -> car.getPrice() < 20000;

        List<Car> carsFiltered = cars.stream()
                .filter(car -> car.getPrice() <= 25000)
                .collect(Collectors.toList());

        carsFiltered.forEach(System.out::println);

        // Printing the number of cars that match the condition
        System.out.println("Total cars under $20,000: " + carsFiltered.size());
    }

    @Test
    public void distinctNumber() {
        List<Integer> numbers = List.of(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5);

        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        assertEquals(5, distinctNumbers.size());

        System.out.println(distinctNumbers);
    }

    @Test
    public void minNumberExample() {
        List<Integer> numbers = List.of(10, 5, 20, 3, 2, 8, 15);

        // Using naturalOrder() to find the minimum number
        Optional<Integer> minNumber = numbers.stream()
                .max(Comparator.naturalOrder());

        System.out.println("Result" + minNumber.get());

//        // Handling Optional safely
//        minNumber.ifPresentOrElse(
//                num -> System.out.println("Minimum number: " + num),
//                () -> System.out.println("List is empty!")
//        );
    }

    @Test
    public void maxNumberExample() {
        List<Integer> numbers = List.of(10, 5, 20, 3, 2, 8, 15);

        // Using naturalOrder() to find the minimum number
        Optional<Integer> maxNumber = numbers.stream()
                .max(Comparator.naturalOrder());

        // Handling Optional safely
        maxNumber.ifPresentOrElse(
                num -> System.out.println("Maximum number: " + num),
                () -> System.out.println("List is empty!")
        );
    }

    @Test
    public void calculateBonus() {
        ArrayList<Employee> emp = new ArrayList<Employee>();
        emp.add(new Employee("Pradeep", 50000, "Male"));
        emp.add(new Employee("Vicky", 30000, "Male"));
        emp.add(new Employee("Ajith", 40000, "Male"));
        emp.add(new Employee("Vijay", 20000, "Male"));
        emp.add(new Employee("Sethupathi", 60000, "Male"));


        Function<Employee, Integer> fn = employee -> (employee.salary * 10) / 100;

        Predicate<Integer> p1 = b -> b >= 5000;

        Consumer<Employee> c = empl -> {
            System.out.println(empl.name);
            System.out.println(empl.salary);
            System.out.println(empl.gender);

        };

        for (Employee e : emp) {

            int bonus = fn.apply(e);

            if (p1.test(bonus)) {

                c.accept(e);
                System.out.println("Employee bonus is" + bonus);
            }
        }
    }


    public void Practice() {

        List<Integer> li = Arrays.asList(1, 2, 3, 4, 5, 6);

        Predicate<Integer> predicate = i -> i % 2 == 0;

        li.stream().filter(predicate).collect(Collectors.toList());

        for (Integer l : li) {


        }

    }


    @Test
    public void testProgram() {
        String[] words = {"Apple", "Orange", "Banana"};

        List<String> sortedList = Arrays.stream(words)
                .sorted(Comparator.comparingInt(String::length)
                        .reversed()
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());

        System.out.println(sortedList);
    }


    @Test
    public void program1() {

        String[] words = {"Orange", "Cat", "Banana", "Apple"};

        Arrays.stream(words)
                .sorted(Comparator.comparing(String::length)
                        .reversed()
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(e -> System.out.println(e));
    }

    @Test
    public void program2() {

        // Find and print all duplicate numbers using Streams.

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5, 6, 1, 7, 8, 6);
        Set<Integer> seen = new HashSet<>();
        numbers.stream().filter(n -> !seen.add(n))
                .forEach(n -> System.out.println(n));
    }

    @Test
    public void program4() {


        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 40, 45, 56, 71, 32, 41, 87, 99, 102, 100, 365, 21);
        Map<String, List<Integer>> evenOddMap = numbers.stream()
                .collect(Collectors.groupingBy(n -> (n % 2 == 0) ? "Even" : "Odd"));

        evenOddMap.forEach((key, value) -> System.out.println(key + " -> " + value));


    }

    @Test
    public void program12() {


        List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 25);


        Optional<Integer> min = numbers.stream().min(Comparator.naturalOrder());
        Optional<Integer> max = numbers.stream().max(Comparator.naturalOrder());

        System.out.println(min + "Numbers are " + max);

        numbers.stream().filter(n -> n != min.get() && n != max.get())
                .forEach(System.out::println);
    }

    @Test
    public void program11() {
        // Flatten the values into a single list of integers using Streams.
        Map<String, List<Integer>> data = Map.of(
                "Group1", List.of(1, 2, 3),
                "Group2", List.of(4, 5, 6),
                "Group3", List.of(7, 8, 9)
        );

        List<Integer> list =
                data.values().stream().flatMap(n -> n.stream())
                        .collect(Collectors.toList());
        System.out.println(list);


    }


    @Test
    public void program8() {

        // 8) Merge both lists into one list without duplicates using Streams.
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7, 2);

        list1.addAll(list2);

        Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void program7() {  // Mostc Repeated

        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "banana");
        Map<String, Long> collect = words.stream().collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        collect.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(entry -> System.out.println(entry.getKey() + "--->" + entry.getValue()));
    }

    @Test
    public void program9() {

        List<String> words = Arrays.asList("apple", "banana", "lemon", "cherry", "banana", "lemon", "banana");

        Map<String, Long> collect = words.stream().collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        List<Map.Entry<String, Long>> collect1 = collect.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).collect(Collectors.toList());

        System.out.println(collect1.get(1));

        if (collect1.size() > 1) {
            System.out.println(collect1.get(1));
        }
    }

    @Test
    public void program3() {

        String str = "I am working for Indium Software and I am currently learning streams.";

        Map<Character, Integer> charCount = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !Character.isWhitespace(c))
                .collect(Collectors.groupingBy(c -> c, Collectors.collectingAndThen(Collectors.counting(), n -> n.intValue())));

        System.out.println(charCount);
    }

    @Test
    public void programtwo() {

        ArrayList<TaskTwo> emp = new ArrayList<TaskTwo>();
        emp.add(new TaskTwo("Pradeep", 60000));
        emp.add(new TaskTwo("Vicky", 70000));
        emp.add(new TaskTwo("Ajith", 80000));
        emp.add(new TaskTwo("Vijay", 40000));

        emp.stream()
                .filter(n -> n.salary > 50000)
                .sorted(Comparator.comparingDouble(TaskTwo::getSalary).reversed())
                .forEach(System.out::println);
    }


    @Test
    public void programFive() {

        ArrayList<TaskFive> emp = new ArrayList<TaskFive>();
        emp.add(new TaskFive("Pradeep", "Mechanical"));
        emp.add(new TaskFive("Vicky", "Ece"));
        emp.add(new TaskFive("Ajith", "Cse"));
        emp.add(new TaskFive("Vijay", "Eee"));

        Map<String, Long> collect = emp.stream().collect(Collectors.groupingBy(TaskFive::getDepartment, Collectors.counting()));
        System.out.println(collect);
    }

    @Test
    public void programTen() {

        ArrayList<Student> stu = new ArrayList<Student>();
        stu.add(Student.builder().name("Pradeep").subject("Maths").marks(90).build());
        stu.add(Student.builder().name("Rajesh").subject("Maths").marks(80).build());

        stu.add(Student.builder().name("Vicky").subject("Science").marks(80).build());
        stu.add(Student.builder().name("Ashok").subject("Science").marks(70).build());

        stu.add(Student.builder().name("Ajith").subject("English").marks(70).build());
        stu.add(Student.builder().name("Murali").subject("English").marks(60).build());

        Map<String, Optional<Student>> collect = stu.stream().collect(Collectors
                .groupingBy(Student::getSubject, Collectors
                        .maxBy(Comparator.comparingInt(Student::getMarks))));
        collect.entrySet().forEach(System.out::println);

    }

    @Test
    public void findLongestSubString() {

        String s = "geeksforgeeks";

        Set<Character> charSet = new HashSet<Character>();

        int[] left = {0}, maxLen = {0};

        // Use IntStream.range(0, s.length()) to iterate over the string.

        IntStream.range(0, s.length()).forEach(right -> {

            while (!charSet.add(s.charAt(right))) {

                charSet.remove(s.charAt(left[0]++)); // If a duplicate is found, remove characters from left until unique.
            }

            maxLen[0] = Math.max(maxLen[0], right - left[0] + 1); // Update maxLen[0] dynamically

        });

        System.out.println(maxLen[0]);


    }

    @Test
    public void lengthOfLongestSubstringTest() {

        String s = "geeksforgeeks";

        String s1 = IntStream.range(0, s.length())                  // 1️⃣ Iterate over all start indices
                .mapToObj(i -> IntStream.range(i, s.length())   // 2️⃣ Iterate over all end indices
                        .mapToObj(j -> s.substring(i, j))       // 3️⃣ Extract substring from i to j
                )
                .flatMap(stream -> stream)           // 4️⃣ Flatten stream of streams into a single stream of substrings
                .filter(sub -> sub.chars().distinct().count() == sub.length()) // 5️⃣ Keep substrings with unique characters
                .max(Comparator.comparing(String::length))        // 6️⃣ Find the longest substring
                .orElse("");                                // 7️⃣ Default to empty string if no valid substring is found

        System.out.println(s1);
        System.out.println(s1.length());
    }


}


