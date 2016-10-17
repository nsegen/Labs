import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        // Для считывания воспользуемся классом Scanner
        Scanner scanner = new Scanner(System.in);
        // Для того, чтобы целая часть вещественного числа
        // отделялась от дробной точкой, а не запятой,
        // необходимо установить русский Locale
        scanner.useLocale(new Locale("Russian"));

        // Для вывода - классом PrintWriter
        PrintWriter printWriter = new PrintWriter(System.out);

        // Считываем размер вводимой матрицы
        int size;
        System.out.println("Enter size: ");
        size = scanner.nextInt();

        // Будем хранить матрицу в векторе, состоящем из
        // векторов вещественных чисел
        double[][] matrix = new double[size][size + 1];

        // Матрица будет иметь размер (size) x (size + 1),
        // c учетом столбца свободных членов
        System.out.println("Enter matrix: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size + 1; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Считываем необходимую точность решения
        double eps;
        System.out.println("Enter eps: ");
        eps = scanner.nextDouble();

        // Введем вектор значений неизвестных на предыдущей итерации,
        // размер которого равен числу строк в матрице, т.е. size,
        // причем согласно методу изначально заполняем его нулями
        double[] previousVariableValues = new double[size];
        for (int i = 0; i < size; i++) {
            previousVariableValues[i] = 0.0;
        }

        // Будем выполнять итерационный процесс до тех пор,
        // пока не будет достигнута необходимая точность
        int iter = 0;
        while (true) {
            iter++;
            // Введем вектор значений неизвестных на текущем шаге
            double[] currentVariableValues = new double[size];

            // Посчитаем значения неизвестных на текущей итерации
            // в соответствии с теоретическими формулами
            for (int i = 0; i < size; i++) {
                // Инициализируем i-ую неизвестную значением
                // свободного члена i-ой строки матрицы
                currentVariableValues[i] = matrix[i][size];

                int j=0;

                while(j<i) {
                    currentVariableValues[i] -= matrix[i][j] * currentVariableValues[j];
                    j++;
                }

                // Вычитаем сумму по всем отличным от i-ой неизвестным
                for (;j < size; j++) {

                    if (i != j) {
                        currentVariableValues[i] -= matrix[i][j] * previousVariableValues[j];
                    }
                }

                // Делим на коэффициент при i-ой неизвестной
                currentVariableValues[i] /= matrix[i][i];
            }

            // Посчитаем текущую погрешность относительно предыдущей итерации
            double error = 0.0;

            for (int i = 0; i < size; i++) {
                error += Math.abs(currentVariableValues[i] - previousVariableValues[i]);
            }

            // Если необходимая точность достигнута, то завершаем процесс
            if (error < eps) {
                break;
            }

            // Переходим к следующей итерации, так
            // что текущие значения неизвестных
            // становятся значениями на предыдущей итерации
            previousVariableValues = currentVariableValues;;
        }
        System.out.println(iter);

        // Выводим найденные значения неизвестных
        for (int i = 0; i < size; i++) {
            printWriter.print(previousVariableValues[i] + " ");
        }

        // После выполнения программы необходимо закрыть
        // потоки ввода и вывода
        scanner.close();
        printWriter.close();
    }
}