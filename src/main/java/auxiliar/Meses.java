package auxiliar;

public class Meses {

    private static final String[] meses = new String[]{"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};

    public static String getMes(int i) {
        return meses[i - 1];
    }
}
