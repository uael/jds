package org.uael;

import org.uael.jds.BinaryTree;

public class Morse {
    private final static BinaryTree<Character> morse = new BinaryTree<>(
        ' ',
        'T', 'E',
        'M', 'N', 'A', 'I',
        'O', 'G', 'K', 'D', 'W', 'R', 'U', 'S',
        ' ', ' ', 'Q', 'Z', 'Y', 'C', 'X', 'B', 'J', 'P', ' ', 'L', ' ', 'F', 'V', 'H'
    );

    public static String decode(String msg) {
        if (msg.isEmpty()) {
            return "";
        }
        int next = msg.indexOf('/');
        int space = msg.indexOf(' ');
        if (next >= 0) {
            if (space >= 0 && space < next) {
                return decodeChar(msg.substring(0, space)) + " " +
                    decode(msg.substring(space + 1));
            }
            return decodeChar(msg.substring(0, next)) +
                decode(msg.substring(next + 1));
        }
        return decodeChar(msg) + "";
    }

    private static char decodeChar(String sequence, BinaryTree<Character>.Node node) {
        if (sequence.isEmpty()) {
            return node.value;
        }
        switch (sequence.charAt(0)) {
            case '-':
                if (node.left() == null) {
                    return '\u0000';
                }
                return decodeChar(sequence.substring(1), node.left());
            case '.':
                if (node.right() == null) {
                    return '\u0000';
                }
                return decodeChar(sequence.substring(1), node.right());
            default:
                return '\u0000';
        }
    }

    public static char decodeChar(String sequence) {
        return decodeChar(sequence, morse.root);
    }

    public static String encode(Character c) {
        return encode(c, morse.root);
    }

    private static String encode(Character c, BinaryTree<Character>.Node morse) {
        if (morse == null) return "X";
        if (morse.value == c) return "";
        String left = encode(c, morse.left());
        if (left != null) {
            if (left.isEmpty()) return "-";
            if (left.charAt(left.length() - 1) != 'X') return "-" + left;
        }
        String right = encode(c, morse.right());
        if (right != null) {
            if (right.isEmpty()) return ".";
            if (right.charAt(right.length() - 1) != 'X') return "." + right;
        }
        return null;
    }

    public static String encode(String words) {
        if (words.isEmpty()) {
            return "";
        }
        char c = words.charAt(0);
        if (c == ' ') {
            return " " + encode(words.substring(1));
        }
        String next = encode(words.substring(1));
        return encode(c) + (next.isEmpty() || next.charAt(0) == ' ' ? "" + next : "/" + next);
    }
}
