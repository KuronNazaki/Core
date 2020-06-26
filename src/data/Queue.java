package data;

public class Queue {

    char queue[];
    int putLocation, getLocation;

    Queue (int size) {
        queue = new char[size + 1];
        putLocation = getLocation = 0;
    }

    public void putCharacter (char character) {
        if (putLocation == queue.length - 1) {
            System.out.println("-- The queue is full --");
            return;
        }

        putLocation++;
        queue[putLocation] = character;
    }
}
