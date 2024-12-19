package pl.edu.wszib.mromasze;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Zadanie 1
        System.out.println("Podaj liczby oddzielone spacjami dla zadania 1:");
        String input1 = scanner.nextLine();
        List<Integer> liczby1 = Arrays.stream(input1.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        zadanie1(liczby1);

        // Zadanie 2
        System.out.println("Podaj liczby oddzielone spacjami dla zadania 2:");
        String input2 = scanner.nextLine();
        List<Integer> liczby2 = Arrays.stream(input2.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        zadanie2(liczby2);

        // Zadanie 3
        System.out.println("Podaj stringi oddzielone spacjami dla zadania 3:");
        String input3 = scanner.nextLine();
        List<String> slowa = Arrays.asList(input3.split(" "));
        zadanie3(slowa);

        scanner.close();
    }

    private static void zadanie1(List<Integer> liczby) {
        double srednia = liczby.stream()
                .filter(n -> n % 10 != 9 && n % 10 != 7)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);

        System.out.println("Średnia: " + srednia);
    }

    private static void zadanie2(List<Integer> liczby) {
        List<Integer> wynik = liczby.stream()
                .map(n -> n * n + 9)
                .filter(n -> !String.valueOf(n).contains("9"))
                .collect(Collectors.toList());

        System.out.println("Wynik: " + wynik);
    }

    private static void zadanie3(List<String> slowa) {
        List<String> wynik = slowa.stream()
                .map(s -> s + "y")
                .filter(s -> !s.contains("yy"))
                .collect(Collectors.toList());

        System.out.println("Wynik: " + wynik);
    }
}
