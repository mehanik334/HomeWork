package denisenko.hw9;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class StreamMinMax {

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        final Object max = stream.max(order);
        final Object min = stream.min(order);
        minMaxConsumer.accept(min != null ? (T) min : null, max != null ? (T) max : null);

    }
}
