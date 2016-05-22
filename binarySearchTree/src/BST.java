
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class BST<T extends Comparable<? super T>> implements BSTInterface<T> {
    // DO NOT ADD OR MODIFY INSTANCE VARIABLES.
    private BSTNode<T> root;
    private int size;

    /**
     * A no argument constructor that should initialize an empty BST.
     */
    public BST() {
        root = null;
        size = 0;
    }

    /**
     * Initializes the BST with the data in the Collection. The data in the BST
     * should be added in the same order it is in the Collection.
     *
     * @param data the data to add to the tree
     * @throws java.lang.IllegalArgumentException if data or any element
     * in data is null
     */
    public BST(Collection<T> data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        }
        for (T dt: data) {
            add(dt);
        }
    }

    @Override
    public void add(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        }

        if (root == null) {
            BSTNode<T> a = new BSTNode<>(data);
            a.setLeft(null);
            a.setRight(null);
            root = a;
            size++;
        }
        if (!contains(data)) {
            addNode(data, root, null, 0);
            size++;
        }

    }

    /**
     *
     * @param data data want to add
     * @param cur current node
     * @param pre previous node
     * @param sequence whether cur>pre or vice versa
     * @return data in the added node
     */


    private BSTNode<T> addNode(T data, BSTNode<T> cur, BSTNode<T> pre,
                               int sequence) {
        if (cur == null) {
            BSTNode<T> a = new BSTNode<T>(data);
            if (sequence == -1) {
                pre.setLeft(a);
            } else {
                pre.setRight(a);
            }
            return a;
        } else {
            if (cur.getData().compareTo(data) > 0) {
                return (addNode(data, cur.getLeft(), cur, -1));
            } else if (cur.getData().compareTo(data) == 0) {
                return cur;
            } else {
                return (addNode(data, cur.getRight(), cur, 1));
            }
        }
    }

    /**
     *
     * @param data data want to remove
     * @param cur current node
     * @param pre previous node
     * @param sequence whether cur>pre or vice versa
     * @return data in the removed node
     */

    private T removeNode(T data, BSTNode<T> cur, BSTNode<T> pre, int sequence) {
        if (cur == null || cur.getData() == null) {
            return null;
        } else if (data.compareTo(cur.getData()) < 0) {
            return removeNode(data, cur.getLeft(), cur, -1);
        } else if (data.compareTo(cur.getData()) > 0) {
            return removeNode(data, cur.getRight(), cur, 1);
        } else {
            BSTNode<T> r = cur.getRight();
            BSTNode<T> l = cur.getLeft();
            T dt = cur.getData();
            if (r == null) {
                if (cur == root) {
                    root = l;
                } else if (l == null) {
                    if (sequence == 1) {
                        pre.setRight(null);
                    } else {
                        pre.setLeft(null);
                    }
                } else {
                    if (sequence == 1) {
                        pre.setRight(l);
                    } else {
                        pre.setLeft(l);
                    }
                }
            } else {
                if (l == null) {
                    if (cur == root) {
                        root = r;
                    } else {
                        if (sequence == 1) {
                            pre.setRight(r);
                        } else {
                            pre.setLeft(r);
                        }
                    }
                } else {
                    BSTNode<T> predecessor = l;
                    while (predecessor.getRight() != null) {
                        predecessor = predecessor.getRight();
                    }
                    T preddt = predecessor.getData();
                    cur.setData(preddt);
                    removeNode(preddt, l, cur, -1);
                    return dt;
                }
            }
            return dt;
        }
    }



    @Override
    public T remove(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        }
        if (!contains(data)) {
            throw new java.util.NoSuchElementException("no such element");
        }
        size--;
        return removeNode(data, root, null, 1);
    }

    @Override
    public T get(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        }
        if (getNode(data, root) != null) {
            return getNode(data, root);
        } else {
            throw new java.util.NoSuchElementException("no such element");
        }
    }

    /**
     *
     * @param data node's data want to find
     * @param cur current node
     * @return if data is in the tree, return the data of the found node
     */
    private T getNode(T data, BSTNode<T> cur) {
        if (cur == null) {
            return null;
        } else if (cur.getData().compareTo(data) == 0) {
            return cur.getData();
        } else if (cur.getData().compareTo(data) > 0) {
            return getNode(data, cur.getLeft());
        } else {
            return getNode(data, cur.getRight());
        }

    }




    @Override
    public boolean contains(T data) {
        if (data == null) {
            throw new java.lang.IllegalArgumentException("data cannot be null");
        }
        return containsNode(data, root);
    }


    /**
     *
     * @param data node's data want to find
     * @param cur current node
     * @return true of false if the tree has node of the data
     */
    private boolean containsNode(T data, BSTNode<T> cur) {
        if (cur == null) {
            return false;
        } else if (cur.getData().equals(data)) {
            return true;
        } else if (cur.getData().compareTo(data) > 0) {
            return containsNode(data, cur.getLeft());
        } else {
            return containsNode(data, cur.getRight());
        }
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public List<T> preorder() {
        return preorderNode(new ArrayList<T>(), root);
    }

    /**
     * add node recursively.
     * @param b the list need to add data in
     * @param a the node need to be added in
     * @return final b
     */
    private ArrayList<T> preorderNode(ArrayList<T> b, BSTNode<T> a) {
        if (a != null) {
            b.add(a.getData());
            preorderNode(b, a.getLeft());
            preorderNode(b, a.getRight());
        }
        return b;
    }

    @Override
    public List<T> postorder() {
        return postorderNode(new ArrayList<T>(), root);
    }

    /**
     * add node recursively.
     * @param b the list need to add data in
     * @param a the node need to be added in
     * @return final b
     */
    private ArrayList<T> postorderNode(ArrayList<T> b, BSTNode<T> a) {
        if (a != null) {
            postorderNode(b, a.getLeft());
            postorderNode(b, a.getRight());
            b.add(a.getData());
        }
        return b;
    }

    @Override
    public List<T> inorder() {
        return inorderNode(new ArrayList<T>(), root);
    }

    /**
     * add node recursively.
     * @param b the list need to add data in
     * @param a the node need to be added in
     * @return final b
     */
    private ArrayList<T> inorderNode(ArrayList<T> b, BSTNode<T> a) {
        if (a != null) {
            inorderNode(b, a.getLeft());
            b.add(a.getData());
            inorderNode(b, a.getRight());
        }
        return b;
    }

    @Override
    public List<T> levelorder() {
        List<T> list = new ArrayList<T>();
        ArrayList<BSTNode<T>> temp = new ArrayList<>();

        BSTNode<T> cur = root;
        if (cur == null) {
            return list;
        }

        while (temp.size() > 0 || cur == root) {
            list.add(cur.getData());
            if (cur.getLeft() != null) {
                temp.add(cur.getLeft());
            }
            if (cur.getRight() != null) {
                temp.add(cur.getRight());
            }
            temp.remove(cur);
            if (temp.size() > 0) {
                cur = temp.get(0);
            } else {
                cur = null;
            }
        }
        return list;

    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public int height() {
        return heightNode(-1, root);
    }

    /**
     *
     * @param h height of node a
     * @param a current node
     * @return overall height
     */
    private int heightNode(int h, BSTNode<T> a) {
        if (a == null) {
            return h;
        } else {
            h = Math.max(heightNode(h, a.getLeft()),
                    heightNode(h, a.getRight())) + 1;
            return h;
        }
    }

    /**
     * THIS METHOD IS ONLY FOR TESTING PURPOSES.
     * DO NOT USE IT IN YOUR CODE
     * DO NOT CHANGE THIS METHOD
     *
     * @return the root of the tree
     */
    public BSTNode<T> getRoot() {
        return root;
    }
}
