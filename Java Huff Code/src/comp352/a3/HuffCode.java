package comp352.a3;





import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HuffCode {
    private static class Node implements Comparable<Node> {
        char character;
        int frequency;
        Node left;
        Node right;

        public Node(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Node other) {
            if (this.frequency == other.frequency) {
            	return this.character - other.character;
            }
            return this.frequency - other.frequency;
        }
    }

    private static class HuffmanTree {
        private Node root;
        private String[] huffmanCodes;

        public HuffmanTree(int[] frequencies) {
            buildTree(frequencies);
            huffmanCodes = new String[128];
            generateHuffmanCodes(root, "");
        }

        private void buildTree(int[] frequencies) {
            Node[] nodes = new Node[128];
            for (int i = 0; i < 128; i++) {
                if (frequencies[i] > 0 || i == ' ' || i == ',' || i == '\n') {
                    nodes[i] = new Node((char) i, frequencies[i]);
                }
            }

            while (true) {
                int min1 = Integer.MAX_VALUE;
                int min2 = Integer.MAX_VALUE;
                int index1 = -1;
                int index2 = -1;

                for (int i = 0; i < 128; i++) {
                    if (nodes[i] != null) {
                        if (nodes[i].frequency < min1) {
                            min2 = min1;
                            index2 = index1;
                            min1 = nodes[i].frequency;
                            index1 = i;
                        } else if (nodes[i].frequency < min2) {
                            min2 = nodes[i].frequency;
                            index2 = i;
                        }
                    }
                }

                if (index2 == -1 && index1 != -1) {
                    root = nodes[index1];
                    break;
                }


                Node left = nodes[index1];
                Node right = nodes[index2];

                Node parent = new Node('\0', left.frequency + right.frequency);
                parent.left = left;
                parent.right = right;

                nodes[index1] = parent;
                nodes[index2] = null;
            }
        }

        private void generateHuffmanCodes(Node node, String code) {
            if (node.left == null && node.right == null) {
                huffmanCodes[node.character] = code;
                return;
            }

            generateHuffmanCodes(node.left, code + "0");
            generateHuffmanCodes(node.right, code + "1");
        }

        public String[] getHuffmanCodes() {
            return huffmanCodes;
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Error number arguments!");
            System.exit(1);
        }

        String filename = args[0];
        String command = args[1];

        try {
            int[] frequencies = calculateFrequencies(filename);
            HuffmanTree huffmanTree = new HuffmanTree(frequencies);

            if (command.equals("encode")) {
                encodeText(huffmanTree);
            } else if (command.equals("decode")) {
                decodeSequence(huffmanTree);
            } else {
                System.err.println("Invalid command: " + command);
                System.exit(1);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
            System.exit(1);
        }
    }

    private static int[] calculateFrequencies(String filename) throws IOException {
        int[] frequencies = new int[128];

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();

                for (char c : line.toCharArray()) {
                    frequencies[c]++;
                }
            }
        }

        return frequencies;
    }

    private static void encodeText(HuffmanTree huffmanTree) {
        String line = System.console().readLine();
        line = line.toLowerCase();

        StringBuilder encoded = new StringBuilder();
        String[] huffmanCodes = huffmanTree.getHuffmanCodes();

        for (char c : line.toCharArray()) {
            if (c < 128 && huffmanCodes[c] != null) {
                String code = huffmanCodes[c];
                encoded.append(code);
            }
        }

        System.out.println(encoded.toString());
    }

    private static void decodeSequence(HuffmanTree huffmanTree) {
        String sequence = System.console().readLine();

        Node current = huffmanTree.root;
        StringBuilder decoded = new StringBuilder();

        for (char c : sequence.toCharArray()) {
            if (c == '0') {
                if (current.left != null) {
                    current = current.left;
                }
            } else if (c == '1') {
                if (current.right != null) {
                    current = current.right;
                }
            }

            if (current.left == null && current.right == null) {
                decoded.append(current.character);
                current = huffmanTree.root;
            }
        }

        System.out.println(decoded.toString());
    }
}

