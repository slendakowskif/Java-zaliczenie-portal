package App;

public enum Departament {
    SALES("Sprzedaż"),
    ADMINISTRATION("Administracja"),
    FINANCE("Finanse"),
    IT_SUPPORT("Wsparcie IT"),
    IT_SECURITY("Bezpieczeństwo IT"),
    IT_ADMINISTRATION("Administracja IT");

    private String name;

    Departament(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}