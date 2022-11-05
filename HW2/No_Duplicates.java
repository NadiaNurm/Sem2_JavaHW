
import java.util.Collection;
import java.util.HashSet;


// Реализуйте метод, который на вход получает любую коллекцию и возвращает коллекцию уже без дубликатов.
public class No_Duplicates {
    Collection collection;
    public static HashSet  make_set(Collection collection){
        HashSet new_collection = new HashSet(collection);
        return new_collection;
    }
}


