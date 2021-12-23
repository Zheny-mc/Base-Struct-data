package Task11;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class MySet<T> {
    //объединение
    //addAll - Добавляет все элементы в указанной коллекции
    // в этот набор, если они еще не присутствуют
    public Set<T> union(Set<Set<T>> sets) {
        return sets.stream().reduce(new HashSet<>(),
                (s1, s2) -> {
                    s1.addAll(s2);
                    return s1;
                });
    }

    //пересечение
    //retainAll - удаляет из этой коллекции все ее элементы,
    // которые не содержатся в указанной коллекции.
    public Optional<HashSet<T>> intersection(Set<Set<T>> sets) {
        return sets.stream().map(HashSet::new).reduce(
                (s1, s2) -> {
                    s1.retainAll(s2);
                    return s1;
                });
    }
}
