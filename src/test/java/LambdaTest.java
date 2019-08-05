import com.suidl.test.Bird;
import com.suidl.test.BirdKeeper;
import com.suidl.test.NewBird;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaTest {
    @Test
    public void innerClassTest() {
        BirdKeeper birdKeeper = new BirdKeeper();

        birdKeeper.fly((a) -> {
            a = a + "aaa";
            System.out.println(a);
            return "";
        }, "name");

    }

    @Test
    public void streamTest() {
        List<NewBird> birds = new ArrayList<>();
        NewBird newBird = new NewBird();
        newBird.setName("a");
        birds.add(newBird);
        Stream<NewBird> stream = birds.stream();
        stream.forEach((bird) -> {
            bird.setName("b");
            System.out.println(bird.getName());
        });
        System.out.println(newBird.getName());
        //List<com.suidl.test.NewBird> returnBirds = stream.collect(Collectors.toList());
        //System.out.println(returnBirds);


        List<String> strList = new ArrayList<>();
        strList.add("111");
        strList.add("222");
        strList.add("333");
        strList.add("444");
        strList.add("5551234567890");

        Stream<String> strStream = strList.stream();
        strStream.map((str) ->{
            return str.substring(2);
        });
        Stream<String> longWord = strStream.filter((str) -> str.length() > 9);


        //long count  = longWord.count();
        List<String> longList = longWord.collect(Collectors.toList());
        System.out.println(longList);
    }

    @Test
    public void timeTest() {
        Instant now = Instant.now();
        System.out.println(now);
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZonedDateTime paris = zonedDateTime.withZoneSameInstant(ZoneId.of("Europe/Paris"));
        System.out.println(zonedDateTime);
        System.out.println(paris);

        localDate.atStartOfDay();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_WEEK_DATE;
        System.out.println(dateTimeFormatter.format(localDateTime));
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        System.out.println(dayOfWeek);

    }

    @Test
    public void optionalTest() {
        Object param = null;
//        Objects.requireNonNull(param);
        Optional optional = Optional.ofNullable(param);
        System.out.println(optional.isPresent());
        List<Object> resultList = new ArrayList<>();
        optional.ifPresent(resultList::add);
        Object object = optional.orElse(new Object());
    }

    @Test
    public void should_() {
        //given
        Thread t = new Thread(() -> System.out.println("111"));
        //when
        t.start();
        //then

    }

    @Test
    public void should() {
        Bird newBird = new NewBird();
        String name = newBird.getName();
        System.out.println(name);

    }
}
