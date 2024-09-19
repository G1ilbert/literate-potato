package Packgage;

import java.util.Iterator;

public class NameRepository implements Containers {
    String[] names = {"John", "May", "Ryan"};

    public Iterator getIterator() {
        return new Iterator() {
            int index = 0;

            public boolean hasNext() {
                return index < names.length;
            }

            public String next() {
                if (this.hasNext()) {
                    return names[index++];
                }
                return null;
            }

            public void remove() {
            }
        };
    }
}
