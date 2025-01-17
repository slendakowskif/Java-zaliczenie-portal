package App;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Company> companies = Utils.initData();
        boolean done = false;

        while (!done) {
            System.out.println("Dostępne operacje:");
            System.out.println("1 - Wybierz firmę");
            System.out.println("0 - Zakończ program");
            System.out.println();

            int choice = Utils.inputInt("Wybierz operację: ");

            switch (choice) {
                case 1:
                    for (int i = 0; i < companies.size(); i++) {
                        System.out.println((i + 1) + " - " + companies.get(i).getName());
                    }
                    int companyChoice = Utils.inputInt("Wybierz firmę: ") - 1;
                    if (companyChoice >= 0 && companyChoice < companies.size()) {
                        manageCompany(companies.get(companyChoice));
                    } else {
                        Utils.printAnswer("Nieprawidłowy wybór firmy.");
                    }
                    break;
                case 0:
                    Utils.printAnswer("Do zobaczenia");
                    done = true;
                    break;
                default:
                    Utils.printAnswer("Podano błędną wartość, spróbuj jeszcze raz");
            }
        }
    }

    private static void manageCompany(Company company) {
        boolean done = false;

        while (!done) {
            System.out.println("Panel zarządzania firmą: " + company.getName());
            System.out.println("1 - Wyświetl pracowników");
            System.out.println("2 - Dodaj pracownika");
            System.out.println("3 - Wyświetl pracowników według działu");
            System.out.println("4 - Wyświetl działy");
            System.out.println("0 - Powrót");
            System.out.println();

            int choice = Utils.inputInt("Wybierz operację: ");

            switch (choice) {
                case 1:
                    Utils.printAnswer(company.getEmployees().toString());
                    break;
                case 2:
                    String name = Utils.inputString("Podaj imię: ");
                    String surname = Utils.inputString("Podaj nazwisko: ");
                    String dept = Utils.inputString("Podaj dział (SALES, ADMINISTRATION, IT_SUPPORT, IT_SECURITY, IT_ADMINISTRATION): ");
                    try {
                        Departament department = Departament.valueOf(dept.toUpperCase());
                        company.addEmployee(name, surname, department);
                        Utils.printAnswer("Dodano pracownika: " + name + " " + surname);
                    } catch (IllegalArgumentException e) {
                        Utils.printAnswer("Nieprawidłowy dział. Spróbuj ponownie.");
                    }
                    break;
                case 3:
                    String departmentFilter = Utils.inputString("Podaj nazwę działu: ");
                    try {
                        Departament department = Departament.valueOf(departmentFilter.toUpperCase());
                        List<Employee> filteredEmployees = company.getEmployees().stream()
                                .filter(e -> e.getDepartament() == department)
                                .toList();
                        Utils.printAnswer("Pracownicy w dziale " + department.getName() + ":\n" + filteredEmployees);
                    } catch (IllegalArgumentException e) {
                        Utils.printAnswer("Nie znaleziono działu o podanej nazwie.");
                    }
                    break;
                case 4:
                    company.displayDepartments();
                    break;
                case 0:
                    done = true;
                    break;
                default:
                    Utils.printAnswer("Podano błędną wartość, spróbuj jeszcze raz");
            }
        }
    }
}
