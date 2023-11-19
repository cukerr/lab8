package ad221myroniuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

// Generic-класс для работы с группами объектов
class ObjectGroup<T> {
    private List<T> objects;

    public ObjectGroup() {
        objects = new ArrayList<>();
    }

    public void addObject(T obj) {
        objects.add(obj);
    }

    public void removeObject(T obj) {
        objects.remove(obj);
    }

    public List<T> getObjects() {
        return objects;
    }

    // Метод для добавления коллекции объектов
    public void addCollection(List<? extends T> collection) {
        objects.addAll(collection);
    }

    // Generic-метод для перемешивания группы объектов
    public static <T> ObjectGroup<T> shuffleGroup(ObjectGroup<T> group) {
        ObjectGroup<T> shuffledGroup = new ObjectGroup<>();
        List<T> originalObjects = new ArrayList<>(group.getObjects());
        Collections.shuffle(originalObjects, new Random());
        shuffledGroup.addCollection(originalObjects);
        return shuffledGroup;
    }
}

public class Main {
    public static void main(String[] args) {
        ObjectGroup<Integer> integerGroup = new ObjectGroup<>();
        integerGroup.addObject(1);
        integerGroup.addObject(2);
        integerGroup.addObject(3);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.1);
        doubleList.add(2.2);
        doubleList.add(3.3);


        ObjectGroup<Double> doubleGroup = new ObjectGroup<>();
        doubleGroup.addCollection(doubleList); // Корректное добавление

        ObjectGroup<Double> shuffledDoubleGroup = ObjectGroup.shuffleGroup(doubleGroup);
        System.out.println("Shuffled Double Group: " + shuffledDoubleGroup.getObjects());
    }
}
