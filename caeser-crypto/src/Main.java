import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What do you want to do");
        System.out.println("Type 1 to encrypt a clear message.");
        System.out.println("Type 2 for decrypt an encrypted message");
        System.out.println("Type 3 to crack the key, if you have the encrypted and decrypted message");
        System.out.print("Mode: ");
        initCrypting(Integer.parseInt(reader.readLine()));

        reader.close();
    }

    public static void initCrypting(int mode) throws IOException {
        BufferedReader enterType = new BufferedReader(new InputStreamReader(System.in));
        String clearMessage;
        String encryptMessage;
        int key;

        if (mode > 0 && mode < 4) {
            if (mode == 1) {
                System.out.println("Encrypting mode");
                System.out.print("Clear message: ");
                clearMessage = enterType.readLine();
                System.out.println("Choose a key between 1 and 25");
                System.out.print("key: ");
                key = Integer.parseInt(enterType.readLine());
                System.out.println(encrypting(clearMessage, key));
            }
            if (mode == 2) {
                System.out.println("Decrypting mode");
                System.out.print("Encrypted message:");
                encryptMessage = enterType.readLine();
                System.out.println("Which key was used?");
                System.out.print("Key: ");
                key = Integer.parseInt(enterType.readLine());
                System.out.println(decrypting(encryptMessage, key));
            }
            if (mode == 3) {
                System.out.println("Cracking mode");
                System.out.print("Clear message: ");
                clearMessage = enterType.readLine();
                System.out.print("Encrypted message: ");
                encryptMessage = enterType.readLine();
                System.out.println("The key is: " + cracking(clearMessage, encryptMessage));
            }
        } else {
            System.out.println("Not existing mode entered.");
            System.out.println("Program was closed");
        }
    }

    public static String encrypting(String message, int key) {
        int buffer = 0;
        char endChar = 'a';
        String endWord = "";
        String endString = "";
        message = message.toUpperCase();
        HashMap<Integer, Character> alphabet = new HashMap<>(setAlphabet());
        String[] mSplit = message.split(" ");

        for (String w : mSplit) {       // every word
            char[] cSplit = w.toCharArray();
            for (char c : cSplit) {     // every char
                for (Map.Entry<Integer, Character> map : alphabet.entrySet()){
                    if (map.getValue() == c) {
                        buffer = (map.getKey() + key) % 26;
                        break;
                    }
                }
                for (Map.Entry<Integer, Character> map : alphabet.entrySet()){
                    if (map.getKey() == buffer) {
                        endChar = map.getValue();
                        break;
                    }
                }
                endWord = endWord + endChar;
            }
            endString = endString + endWord + " ";
            endWord = "";
            }
        return endString;
    }



    public static String decrypting(String message, int key) {
        int buffer = 0;
        char endChar = 'a';
        String endWord = "";
        String endString = "";
        message = message.toUpperCase();
        HashMap<Integer, Character> alphabet = new HashMap<>(setAlphabet());
        String[] mSplit = message.split(" ");

        for (String w : mSplit) {       // every word
            char[] cSplit = w.toCharArray();
            for (char c : cSplit) {     // every char
                for (Map.Entry<Integer, Character> map : alphabet.entrySet()){
                    if (map.getValue() == c) {
                        buffer = (map.getKey() - key);
                        buffer = (buffer < 0) ? (26 - (buffer * (-1))) : (buffer % 26);
                        break;
                    }
                }
                for (Map.Entry<Integer, Character> map : alphabet.entrySet()){
                    if (map.getKey() == buffer) {
                        buffer = 0;
                        endChar = map.getValue();
                        break;
                    }
                }
                endWord = endWord + endChar;
            }
            endString = endString + endWord + " ";
            endWord ="";
        }
        return endString;

    }

    public static int cracking(String clear, String encrypted) {
        int buffer1 = 0;
        int buffer2 = 0;
        int key;
        clear = clear.toUpperCase();
        encrypted = encrypted.toUpperCase();
        HashMap<Integer, Character> alphabet = new HashMap(setAlphabet());
        char[] clearSplit = clear.toCharArray();
        char[] enSplit = encrypted.toCharArray();

        for (Map.Entry<Integer, Character> map : alphabet.entrySet()) {
            if (clearSplit[0] == map.getValue()) {
                buffer1 = map.getKey();
                break;
            }
        }
        for (Map.Entry<Integer, Character> map : alphabet.entrySet()) {
            if (enSplit[0] == map.getValue()) {
                buffer2 = map.getKey();
                break;
            }
        }
        key = buffer2 - buffer1;
        key = (key < 0) ? (26 - (key * (-1))) : (key);


        return key;

    }
  
    public static HashMap setAlphabet() {
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(0, 'A');
        map.put(1, 'B');
        map.put(2, 'C');
        map.put(3, 'D');
        map.put(4, 'E');
        map.put(5, 'F');
        map.put(6, 'G');
        map.put(7, 'H');
        map.put(8, 'I');
        map.put(9, 'J');
        map.put(10, 'K');
        map.put(11, 'L');
        map.put(12, 'M');
        map.put(13, 'N');
        map.put(14, 'O');
        map.put(15, 'P');
        map.put(16, 'Q');
        map.put(17, 'R');
        map.put(18, 'S');
        map.put(19, 'T');
        map.put(20, 'U');
        map.put(21, 'V');
        map.put(22, 'W');
        map.put(23, 'X');
        map.put(24, 'Y');
        map.put(25, 'Z');



        return map;
    }


}
