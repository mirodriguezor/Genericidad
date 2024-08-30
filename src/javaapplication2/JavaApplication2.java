package javaapplication2;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class JavaApplication2 {

    public static void main(String[] args) {
        ArrayList<String> userArray = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Pair<Integer, String> userData;
        Pair<Date, String> userDataSecondary;
        Pair<ArrayList, String> userInfo;

        Scanner scanner = new Scanner(System.in);
        String name = "";
        int age = 0;
        String birthdayString = "";
        String eps = "";
        Date birthday;

        while (true) {
            try {
                System.out.println("Ingrese su nombre:");
                name = scanner.nextLine();
                System.out.println("Ingrese su edad:");
                age = Integer.valueOf(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un valor numerico en edad.");
            }
        }

        while (true) {
            try {
                System.out.println("Ingrese su fecha de nacimiento (dd/MM/yyyy):");
                birthdayString = scanner.nextLine();
                System.out.println("Ingrese su EPS:");
                eps = scanner.nextLine();
                birthday = dateFormat.parse(birthdayString);
                break;
            } catch (Exception e) {
                System.out.println("Debe ingresar una fecha valida (dd/MM/yyyy)"
                        + "dia-mes-anio");
            }
        }

        userData = new Pair<Integer, String>(age, name);
        userDataSecondary = new Pair<Date, String>(birthday, eps);
        userArray.add(userData.toString());
        userArray.add(userDataSecondary.toString());

        userInfo = new Pair<ArrayList, String>(userArray, name);

        while (true) {
            try {
                System.out.println("Ingrese su nombre para validar la informacion,"
                        + " cero para salir:");
                name = scanner.nextLine();
                String nameValidate = userData.getSecond();

                if (name.equalsIgnoreCase(nameValidate)) {
                    System.out.println(userInfo.getFirst());
                    break;
                } else if (name.equals("0")) {
                    break;
                } else {
                    System.out.println("Su nombre no esta registrado");
                }
            } catch (Exception e) {
                System.out.println("Debe ingresar una fecha valida (dd/MM/yyyy)"
                        + "dia-mes-anio");
            }
        }

    }

}
