/**
 * Class that simulates a list for storing Strings.
 *
 * @author << your name goes here >>
 * @version << version number here >>
 */
public class StringList {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 4;

    /**
     * The amount to grow this {@code StringList} when {@code grow()} is called.
     */
    private static final int GROW = 5;
    /**
     * The size of the {@code StringList} (the number of elements it contains).
     */
    private int size = 0;
    /**
     * The array buffer into which the elements of the {@code StringList} are stored.
     */
    private String[] elementData;

    /**
     *
     */
    public StringList() {
        this.elementData = new String[DEFAULT_CAPACITY];
    }

    /**
     * @param capacity size of list
     */
    public StringList(int capacity) {
        this.elementData = new String[capacity];
    }

    /**
     * @return The new Array
     */
    public String[] grow() {
        String[] temp = new String[elementData.length];
        elementData = new String[temp.length + GROW];
        return elementData;
    }

    /**
     * @param element Element to be added to array
     * @return Whether the concatenation was a success.
     */
    public boolean add(String element) {
        if (this.size == this.elementData.length - 1) {
            grow();
        }
        this.elementData[this.size++] = element;
        return true;
    }

    /**
     * @param index Index of desired string in array
     * @return String at position of index.
     */
    public String get(int index) {
        if (index >= this.size) throw (new IllegalArgumentException("Invalid Index:" + index));
        return this.elementData[index];
    }

    /**
     * @return The Array in a formatted string
     */
    public String toString() {
        if (this.size == 0) return "List is empty: []";
        String builder = "Printing List: [";
        for (String item : this.elementData) {
            builder = builder.concat(item + ", ");
        }
        builder = builder.concat("]");
        return builder;
    }

    /**
     * @param element String to scan for.
     * @return Boolean, whether it is in the array
     */
    public boolean contains(String element) {
        for (String item : this.elementData) {
            if (item.equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param element String to scan for.
     * @return Position in array
     */
    public int indexOf(String element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param index   Desired Index of Array
     * @param element Element to be inserted
     * @return Previous element at location index.
     */
    public String set(int index, String element) {
        if (index >= size) throw (new IllegalArgumentException("Invalid Index: " + index));
        String temp = this.elementData[index];
        this.elementData[index] = element;
        return temp;
    }

    /**
     * Inserts element into index and shifts every subsequent item up.
     *
     * @param index   location of new item
     * @param element item to be added
     */
    public void add(int index, String element) {
        if (index >= size) throw (new IllegalArgumentException("Invalid Index: " + index));
        for (int i = size - 1; i >= index; i--) {
            this.elementData[i] = this.elementData[i - 1];
        }
        this.elementData[index] = element;
    }

    /**
     * Removes and returns item from index, shifting every subsequent item down.
     *
     * @param index position where item is to be removed
     * @return removed item
     */
    public String remove(int index) {
        if (index >= size) throw (new IllegalArgumentException("Invalid Index: " + index));
        String hold = this.elementData[index];
        for (int i = index; i < size; i++) {
            this.elementData[i] = this.elementData[i + 1];
        }
        return hold;
    }

    /**
     * Removes first occurrence of specified element from the list.
     *
     * @param element element to be removed
     * @return whether an item was removed
     */
    public boolean remove(String element) {
        int index = this.indexOf(element);
        if (index != -1) {
            this.remove(index);
            return true;
        }
        return false;
    }

    /**
     * Empties the StringList.
     */
    public void clear() {
        this.size = 0;
        this.elementData = new String[DEFAULT_CAPACITY];
    }

    /**
     * @return If StringList is empty.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * @return Number of elements in array
     */
    public int size() {
        return this.size;
    }

    /**
     * Returns the index of the last occurrence of an element.
     *
     * @param element item to be searched
     * @return Last occurrence of an element
     */
    public int lastIndexOf(String element) {
        int index = this.indexOf(element);
        if (index != -1) {
            for (int i = index; i < this.size; i++) {
                if (this.elementData[i].equals(element)) index = i;
            }
        }
        return index;
    }

    /**
     * Returns a sublist of parent StringList.
     * @param fromIndex Starting Position
     * @param toIndex Finishing Position
     * @return Sublist
     */
    public StringList subList(int fromIndex, int toIndex) {
        if (toIndex < fromIndex) throw (new IllegalArgumentException("Indices out of order"));
        if (fromIndex >= size) throw (new IllegalArgumentException("Invalid index: " + fromIndex));
        if (toIndex >= size) throw (new IllegalArgumentException("Invalid index: " + toIndex));

        StringList subList = new StringList(toIndex - fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            subList.add(this.elementData[i]);
        }
        return subList;
    }

    /**
     * Removes items from given range.
     * @param fromIndex Start index of range
     * @param toIndex End index of range
     */
    public void removeRange(int fromIndex, int toIndex) {
        if (toIndex < fromIndex) throw (new IllegalArgumentException("Indices out of order"));
        if (fromIndex >= size) throw (new IllegalArgumentException("Invalid index: " + fromIndex));
        if (toIndex >= size) throw (new IllegalArgumentException("Invalid index: " + toIndex));
        for (int i = 0; i < toIndex - fromIndex; i++) {
            if (toIndex + i < this.size) {
                this.elementData[fromIndex + i] = this.elementData[toIndex + 1];
            } else this.elementData[i] = null;
        }
    }

    /**
     * Compares this StringList to given StringList.
     * @param s1 given StringList
     * @return Whether the StringLists match
     */
    public boolean equals(StringList s1) {
        boolean matching = true;
        for (int i = 0; i < size && i < s1.size() && matching; i++) {
            matching = this.elementData[i].equals(s1.elementData[i]);
        }
        return matching;
    }

    /**
     * @return This object as an array
     */
    public String[] toArray() {
        return this.elementData;
    }
}
