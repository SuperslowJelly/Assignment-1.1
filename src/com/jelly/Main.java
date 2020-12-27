package com.jelly;

import java.lang.reflect.Array;

public class Main {

    public static void append(StringBuilder s, final char[] C, final byte L) {
        char c;
        if (C.length == 0 && (c = (Character) Array.get(C, 0)) == '\n') // If a new line is requested:
            s.append(new String(new char[1]).replace('\u0000', c)); // Add a new line.
        else if (C.length == 0 && (c = (Character) Array.get(C, 0)) == ' ')  // If spacing is requested:
            s.append(new String(new char[L]).replace('\u0000', c)); // Append a block of L spaces.
        else {
            for (byte i = 0; i < C.length; i++) // If the above optionals aren't requested, assume intention to append a block of characters
                s.append(new String(new char[L]).replace('\u0000', (Character) Array.get(C, i))); // Append a block of L characters
        }
    }

    public static String constructWord(final String W, final byte L) {
        StringBuilder w = new StringBuilder();
        for (byte i = 0; i < 9; i++) { // Repeat 9 times, as the height of the word is 9 lines.
            for (byte p = 0; p < W.length(); p++) {
                char c = W.toUpperCase().charAt(p); // c = The current character.
                if (c == 'H') { // Construct each line of an H.
                    if (i <= 2) append(w, new char[] {c, ' ', c}, L);
                    else if (i <= 4) append(w, new char[] {c, c, c}, L);
                    else append(w, new char[] {c, ' ', c}, L);
                    append(w, new char[] {' '}, L);
                } else if (c == 'E') { // Construct each line of an E.
                    if (i <= 1) append(w, new char[] {c, c, c}, L);
                    else if (i == 2) append(w, new char[] {c, ' ', ' '}, L);
                    else if (i <= 4) append(w, new char[] {c, c, ' '}, L);
                    else if (i <= 6) append(w, new char[] {c, ' ', ' '}, L);
                    else append(w, new char[] {c, c, c}, L);
                    append(w, new char[] {' '}, L);
                } else if (c == 'L') { // Construct each line of an L.
                    if (i <= 6) append(w, new char[] {c, ' ', ' '}, L);
                    else append(w, new char[] {c, c, c}, L);
                    append(w, new char[] {' '}, L);
                } else if (c == 'O') { // Construct each line of an O.
                    if (i <= 1) append(w, new char[] {c, c, c}, L);
                    else if (i <= 6) append(w, new char[] {c, ' ', c}, L);
                    else append(w, new char[] {c, c, c}, L);
                    append(w, new char[] {' '}, L);
                } else if (c == 'R') { // Construct each line of an R.
                    if (i <= 1) append(w, new char[] {c, c, c}, L);
                    else if (i <= 3) append(w, new char[] {c, ' ', c}, L);
                    else if ( i<= 4) append(w, new char[] {c, c, c}, L);
                    else if ( i<= 6) append(w, new char[] {c, c, ' '}, L);
                    else append(w, new char[] {c, ' ', c}, L);
                    append(w, new char[] {' '}, L);
                }
            }
            append(w, new char[]{'\n'}, (byte) 1); // Continue to the next line.
        }
        return w.toString(); // Return the completed string.
    }

    public static void main(String[] args) {
        final String word = "lollero"; // Enter your word here (Note: Acceptable characters are limited to 'H', 'E', 'L', 'O'. Program can be easily adapted to include more using the technique outlined above).
        final byte blockLength = 4; // Enter the horizontal length of each block of characters, a letter is made up of 3 blocks, and a space is made up of 1 block.
        System.out.print(constructWord(word, blockLength)); // Use the constructWord method to print based on the above arguments.
    }
}
