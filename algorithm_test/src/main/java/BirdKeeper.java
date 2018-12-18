import java.util.function.Function;

public class BirdKeeper {
    public void fly(Function function, String name) {
        function.apply(name);
    }
}
