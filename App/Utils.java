package App;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Company> initData() {
        List<Company> companies = new ArrayList<>();

        Company company1 = new Company("Super Firma");
        company1.addEmployee("Jan", "Testowy", Departament.SALES);
        company1.addEmployee("Kazimierz", "Przykładowy", Departament.ADMINISTRATION);
        company1.addEmployee("Maria", "Demo", Departament.IT_SUPPORT);

        Company company2 = new Company("Tech Solutions");
        company2.addEmployee("Anna", "Bezpieczna", Departament.IT_SECURITY);
        company2.addEmployee("Piotr", "Adminowy", Departament.IT_ADMINISTRATION);

        companies.add(company1);
        companies.add(company2);

        return companies;
    }

    public static void printBanner(String text) {
        String border = "+" + "-".repeat(text.length() + 2) + "+";
        System.out.println(border);
        System.out.println("| " + text + " |");
        System.out.println(border);
    }

    public static void printAnswer(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static int inputInt(String message) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print(message);
            return input.nextInt();
        } catch (InputMismatchException e) {
            printAnswer("Podano błędną wartość, spróbuj jeszcze raz");
            return inputInt(message);
        }
    }

    public static String inputString(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextLine();
    }
}