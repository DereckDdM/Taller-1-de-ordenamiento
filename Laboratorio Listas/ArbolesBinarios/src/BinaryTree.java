import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTree {

    TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public void insertRoot(Object data) {
        if (root == null) root = new TreeNode(data);
    }

    public TreeNode search(Object data) {
        return buscarNodo(root, data);
    }

    private TreeNode buscarNodo(TreeNode t, Object val) {
        if (t == null) return null;
        if (t.data.equals(val)) return t;
        TreeNode izq = buscarNodo(t.left, val);
        return (izq != null) ? izq : buscarNodo(t.right, val);
    }

    public boolean insertLeft(Object parent, Object data) {
        TreeNode padre = search(parent);
        if (padre != null && padre.left == null) {
            padre.left = new TreeNode(data);
            return true;
        }
        return false;
    }

    public boolean insertRight(Object parent, Object data) {
        TreeNode padre = search(parent);
        if (padre != null && padre.right == null) {
            padre.right = new TreeNode(data);
            return true;
        }
        return false;
    }

    public void buildTree(Scanner scanner) {
        System.out.print("Raiz: ");
        String r = scanner.nextLine().trim();
        if (r.isEmpty() || r.equals("-")) return;

        root = new TreeNode(r);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode actual = q.poll();

            System.out.print("Hijo izquierdo de " + actual.data + ": ");
            String izq = scanner.nextLine().trim();
            if (!izq.isEmpty() && !izq.equals("-")) {
                actual.left = new TreeNode(izq);
                q.add(actual.left);
            }

            System.out.print("Hijo derecho de " + actual.data + ": ");
            String der = scanner.nextLine().trim();
            if (!der.isEmpty() && !der.equals("-")) {
                actual.right = new TreeNode(der);
                q.add(actual.right);
            }
        }
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Árbol vacío.");
            return;
        }
        mostrarArbol(root, "", true);
    }

    private void mostrarArbol(TreeNode n, String prefijo, boolean ultimo) {
        if (n == null) return;
        System.out.println(prefijo + (ultimo ? "└── " : "├── ") + n.data);
        String subPrefijo = prefijo + (ultimo ? "    " : "│   ");
        if (n.left != null && n.right != null) {
            mostrarArbol(n.left, subPrefijo, false);
            mostrarArbol(n.right, subPrefijo, true);
        } else if (n.left != null) {
            mostrarArbol(n.left, subPrefijo, true);
        } else if (n.right != null) {
            mostrarArbol(n.right, subPrefijo, true);
        }
    }

    public String preorder() {
        StringBuilder sb = new StringBuilder();
        pre(root, sb);
        return sb.toString().trim();
    }

    private void pre(TreeNode n, StringBuilder sb) {
        if (n == null) return;
        sb.append(n.data).append(" ");
        pre(n.left, sb);
        pre(n.right, sb);
    }

    public String inorder() {
        StringBuilder sb = new StringBuilder();
        in(root, sb);
        return sb.toString().trim();
    }

    private void in(TreeNode n, StringBuilder sb) {
        if (n == null) return;
        in(n.left, sb);
        sb.append(n.data).append(" ");
        in(n.right, sb);
    }

    public String postorder() {
        StringBuilder sb = new StringBuilder();
        post(root, sb);
        return sb.toString().trim();
    }

    private void post(TreeNode n, StringBuilder sb) {
        if (n == null) return;
        post(n.left, sb);
        post(n.right, sb);
        sb.append(n.data).append(" ");
    }

    public int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int balanceFactor(TreeNode node) {
        if (node == null) return 0;
        return height(node.right) - height(node.left);
    }

    public boolean isBalanced() {
        return chequearBalance(root);
    }

    private boolean chequearBalance(TreeNode n) {
        if (n == null) return true;
        int fe = balanceFactor(n);
        if (fe < -1 || fe > 1) return false;
        return chequearBalance(n.left) && chequearBalance(n.right);
    }

    public List<Object> unbalancedNodes() {
        List<Object> lista = new ArrayList<>();
        buscarDesbalance(root, lista);
        return lista;
    }

    private void buscarDesbalance(TreeNode n, List<Object> res) {
        if (n == null) return;
        int fe = balanceFactor(n);
        if (fe < -1 || fe > 1) res.add(n.data);
        buscarDesbalance(n.left, res);
        buscarDesbalance(n.right, res);
    }

    public void printBalanceFactors() {
        if (root == null) {
            System.out.println("Árbol vacío.");
            return;
        }
        mostrarFactores(root, "", true);
    }

    private void mostrarFactores(TreeNode n, String prefijo, boolean ultimo) {
        if (n == null) return;
        System.out.println(prefijo + (ultimo ? "└── " : "├── ") + n.data + " (FE: " + balanceFactor(n) + ")");
        String subPrefijo = prefijo + (ultimo ? "    " : "│   ");
        if (n.left != null && n.right != null) {
            mostrarFactores(n.left, subPrefijo, false);
            mostrarFactores(n.right, subPrefijo, true);
        } else if (n.left != null) {
            mostrarFactores(n.left, subPrefijo, true);
        } else if (n.right != null) {
            mostrarFactores(n.right, subPrefijo, true);
        }
    }

    public TreeNode rotateRight(TreeNode node) {
        TreeNode aux = node.left;
        TreeNode t2 = aux.right;
        aux.right = node;
        node.left = t2;
        return aux;
    }

    public TreeNode rotateLeft(TreeNode node) {
        TreeNode aux = node.right;
        TreeNode t2 = aux.left;
        aux.left = node;
        node.right = t2;
        return aux;
    }

    public TreeNode rotateLeftRight(TreeNode node) {
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    public TreeNode rotateRightLeft(TreeNode node) {
        node.right = rotateRight(node.right);
        return rotateLeft(node);
    }

    public void balance() {
        System.out.println("--- Árbol antes de balancear ---");
        printBalanceFactors();

        List<Object> desbalanceados = unbalancedNodes();
        System.out.println("Nodos que requieren balanceo: " + desbalanceados);

        while (!isBalanced()) {
            root = procesarBalance(root);
        }

        System.out.println("\n--- Árbol balanceado (AVL) ---");
        printBalanceFactors();
    }

    private TreeNode procesarBalance(TreeNode n) {
        if (n == null) return null;

        n.left = procesarBalance(n.left);
        n.right = procesarBalance(n.right);

        int fe = balanceFactor(n);

        if (fe < -1) {
            if (balanceFactor(n.left) <= 0) {
                return rotateRight(n);
            } else {
                return rotateLeftRight(n);
            }
        }
        if (fe > 1) {
            if (balanceFactor(n.right) >= 0) {
                return rotateLeft(n);
            } else {
                return rotateRightLeft(n);
            }
        }
        return n;
    }
}
