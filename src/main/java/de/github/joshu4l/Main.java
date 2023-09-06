package de.github.joshu4l;


public class Main {
    public static void main(String[] args) {
        String input = "Hallo";
        String reversed = reverseString(input);
        System.out.println(reversed); // Gibt "ollaH" aus

        String input2 = "hannah";
        if (isPalindrome(input2)) {
            System.out.println(input2 + " ist ein Palindrom.");
        } else {
            System.out.println(input2 + " ist kein Palindrom.");
        }

        int n = 10; // Anzahl der gewünschten Primzahlen
        int[] primeNumbers = generateFirstNPrimes(n);

        System.out.println("Die ersten " + n + " Primzahlen sind:");
        for (int prime : primeNumbers) {
            System.out.print(prime + " ");
        }

    }

    public static String reverseString(String input) {
        // Erstelle einen leeren StringBuilder, um das umgekehrte Ergebnis aufzubauen.
        StringBuilder reversed = new StringBuilder();

        // Durchlaufe die Zeichenkette rückwärts und füge jeden Buchstaben zum StringBuilder hinzu.
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }

        // Konvertiere den StringBuilder zurück in eine Zeichenkette und gib ihn zurück.
        return reversed.toString();
    }


    public static boolean isPalindrome(String input) {
        // Entferne Leerzeichen und konvertiere die Zeichenkette in Kleinbuchstaben, um Groß-/Kleinschreibung zu ignorieren.
        String cleanInput = input.replaceAll("\\s+", "").toLowerCase();

        // Initialisiere zwei Zeiger: einen am Anfang und einen am Ende der Zeichenkette.
        int left = 0;
        int right = cleanInput.length() - 1;

        // Vergleiche die Zeichen von beiden Enden, während sich die Zeiger in Richtung Mitte bewegen.
        while (left < right) {
            if (cleanInput.charAt(left) != cleanInput.charAt(right)) {
                // Wenn die Zeichen nicht übereinstimmen, handelt es sich nicht um ein Palindrom.
                return false;
            }
            left++;
            right--;
        }

        // Wenn der gesamte Vergleich erfolgreich war, handelt es sich um ein Palindrom.
        return true;
    }

    public static int[] generateFirstNPrimes(int n) {
        int[] primes = new int[n];
        int count = 0; // Anzahl der gefundenen Primzahlen
        int number = 2; // Die Zahl, die wir überprüfen, ob sie eine Primzahl ist

        while (count < n) {
            if (isPrime(number)) {
                primes[count] = number;
                count++;
            }
            number++;
        }

        return primes;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

}


