public class ListStack implements StackInterface {

    StackNode top;
    int size = 0;

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public Object peek() {
        if (isEmpty()) return null;
        return top.object;
    }

    @Override
    public Object pop() {
        if (isEmpty()) return null;

        Object poppedItem = top.object;
        top = top.below;
        size--;

        return poppedItem;
    }

    @Override
    public boolean push(Object object) {
        StackNode newNode = new StackNode(object);
        newNode.below = top;
        top = newNode;
        size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean search(Object object) {
        StackNode current = top;
        while (current != null) {
            if (current.object != null && current.object.equals(object)) {
                return true;
            } else if (current.object == null && object == null) {
                return true;
            }
            current = current.below;
        }
        return false;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        StackNode current = top;

        while (current != null) {
            sb.append(current.object);
            if (current.below != null) {
                sb.append(", ");
            }
            current = current.below;
        }
        sb.append("]");
        return sb.toString();
    }
}