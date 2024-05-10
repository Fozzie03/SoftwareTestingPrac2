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
        if (index >= this.size) throw(new IllegalArgumentException("Invalid Index:" + index));
        return this.elementData[index];
    }

    /**
     *  @return The Array in a formatted string
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
     * @param index Desired Index of Array
     * @param element Element to be inserted
     * @return Previous element at location index.
     */
    public String set(int index, String element) {
        if (index >= size) throw(new IllegalArgumentException("Invalid Index: " + index));
        String temp = this.elementData[index];
        this.elementData[index] = element;
        return temp;
    }

    /**
     * @return Number of elements in array
     */
    public int size() {
        return this.size;
    }
}

