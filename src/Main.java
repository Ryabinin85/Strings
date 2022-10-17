/**
 * Strings
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(task1());
        System.out.println(task2());
        System.out.println(task3());
        task4("Ivanov Ivan Ivanovich");
        System.out.println(task5());
        System.out.println(task6());
        System.out.println(task7());
    }
    public static String task1() {
        String firstName = "Ivanov";
        String middleName = "Ivan";
        String lastName = "Ivanovich";
        return "ФИО сотрудника — " + firstName + " " + middleName + " " + lastName;
    }
    public static String task2() {
        String fullName = "Ivanov Ivan Ivanovich";
        return "Данные ФИО сотрудника для заполнения отчета — " + fullName.toUpperCase();
    }
    public static String task3() {
        String fullName = "Иванов Семён Семёнович";
        return "Данные ФИО сотрудника —  " + fullName.replace("ё", "е");
    }

    public static String task4(String fullName) {
            /*  Ф. И. О. сотрудника: “Ivanov Ivan Ivanovich”;
            строка fullName — для хранения Ф. И. О. сотрудника в формате фамилия - имя - отчество;
            переменная firstName — для хранения имени;
            переменная middleName — для хранения отчества;
            переменная lastName — для хранения фамилии.
            Решите задание с помощью метода substring().
            Результат программы выведите в формате:
            “Имя сотрудника — …”
            “Фамилия сотрудника — …”
            “Отчество сотрудника — ...”
            Критерии оценки
            – При изменении содержания строки результат программы выполняется.
            – Программа решена с помощью метода substring().
            – Результат программы выведен в консоль согласно условиям задачи..*/

        /* первый способ */
        String firstName = fullName.substring(fullName.indexOf(" "), fullName.lastIndexOf(" "));
        String middleName = fullName.substring(fullName.lastIndexOf(" "));
        String lastName = fullName.substring(0, fullName.indexOf(" "));

        /* второй способ */
        String[] splitFullName = fullName.split(" ");
        String firstName2 = splitFullName[1];
        String middleName2 = splitFullName[2];
        String lastName2 = splitFullName[0];

        /* вывод */
        System.out.printf("Имя сотрудника — %s\n", firstName);
        System.out.printf("Фамилия сотрудника — %s\n", lastName);
        System.out.printf("Отчество сотрудника — %s\n", middleName);
        return null;
    }

    public static String task5() {
            /*Периодически данные в наших регистрах заполняются неверно, и Ф. И. О.
            сотрудников записывают со строчных букв.
            Такую оплошность нужно исправить, написав программу, которая преобразует написанное
            со строчных букв Ф. И. О. в правильный формат.
            В качестве исходных данных используйте строку fullName c данными “ivanov ivan ivanovich“,
            которые нужно преобразовать в “Ivanov Ivan Ivanovich”.
            Выведите результат программы в консоль в формате: “Верное написание Ф. И. О. сотрудника с заглавных букв — …”
            Критерии оценки
            – Применен метод, меняющий написание данных строки.
            – При изменении содержания строки результат программы выполняется.
            – Результат программы выведен в консоль согласно условиям задачи.*/

        String fullName = "ivanov ivan ivanovich";

        String[] splitFullName = fullName.split(" ");
        String firstNameSpl = splitFullName[1];
        String middleNameSpl = splitFullName[2];
        String lastNameSpl = splitFullName[0];

        String firstName = firstNameSpl.substring(0,1).toUpperCase() + firstNameSpl.substring(1);
        String middleName = middleNameSpl.substring(0,1).toUpperCase() + middleNameSpl.substring(1);
        String lastName = lastNameSpl.substring(0,1).toUpperCase() + lastNameSpl.substring(1);

        String correctFullName = lastName + " " + firstName + " " + middleName;
        return "Верное написание Ф. И. О. сотрудника с заглавных букв — \n" + correctFullName;
    }
    public static String task6() {
            /*Имеется две строки.
            Первая: "135"
            Вторая: "246"
            Соберите из двух строк одну, содержащую данные "123456".
            Использовать сортировку нельзя.
            Набор чисел задан для понимания позиций, которые они должны занять в итоговой строке.
            Выведите результат в консоль в формате: “Данные строки — ….”
            :sos: Подсказка
            Следует использовать StringBuilder.
            Критерии оценки
            – Применен метод, меняющий написание данных строки.
            – При изменении содержания строки результат программы выполняется.
            – Результат программы выведен в консоль согласно условиям задачи.*/
        String string1 = "024688642";
        String string2 = "1357975310000000000";
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        int length = Math.min(string1.length(), string2.length());

        /* первый способ */
        stringBuilder1.append("Данные строки — ");
        for (int i = 0; i < length; i++) {
            stringBuilder1
                    .append(string1, i, (i + 1))
                    .append(string2, i, (i + 1));
        }
        System.out.println();

        /* второй способ */
        stringBuilder2.append("Данные строки — ");
        for (int i = 0; i < length; i++) {
            stringBuilder2
                    .append(string1.charAt(i))
                    .append(string2.charAt(i));
        }

        /* Если строки разной длины */
        if (string1.length() > string2.length()) {
            stringBuilder1.append(string1, length, string1.length());
            stringBuilder2.append(string1, length, string1.length());
        }
        else {
            stringBuilder1.append(string2, length, string2.length());
            stringBuilder2.append(string2, length, string2.length());
        }

        return stringBuilder2.toString();
    }
    public static String task7() {
            /*Дана строка из букв английского алфавита "aabccddefgghiijjkk".
            Нужно найти и напечатать буквы, которые дублируются в строке.
            Обратите внимание, что строка отсортирована, т. е. дубли идут друг за другом.
            В итоге в консоль должен быть выведен результат программы: "acdgijk".
            Критерии оценки
            – Данные в строке отсортированы корректно.
            – При изменении содержания строки результат программы выполняется.
            – Результат программы выведен в консоль согласно условиям задачи.*/
        String string = "aabccddefgghiijjkk";
        StringBuilder stringBuilder = new StringBuilder();

        char[] charArray = string.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i+1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j])
                    stringBuilder.append(charArray[j]);
            }
        }
        return stringBuilder.toString();
    }
}
