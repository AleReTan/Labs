package ru.vsu;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MainMatrix {

    private static void randomMatrix(final int[][] matrix) {
        final Random random = new Random();  // Генератор случайных чисел.

        for (int row = 0; row < matrix.length; ++row)           // Цикл по строкам матрицы.
            for (int col = 0; col < matrix[row].length; ++col)  // Цикл по столбцам матрицы.
                matrix[row][col] = random.nextInt(100);         // Случайное число от 0 до 100.
    }

    private static void printMatrix(final FileWriter fileWriter,
                                    final int[][] matrix) throws IOException {
        boolean hasNegative = false;  // Признак наличия в матрице отрицательных чисел.
        int maxValue = 0;      // Максимальное по модулю число в матрице.

        // Вычисляем максимальное по модулю число в матрице и проверяем на наличие отрицательных чисел.
        for (final int[] row : matrix) {  // Цикл по строкам матрицы.
            for (final int element : row) {  // Цикл по столбцам матрицы.
                int temp = element;
                if (element < 0) {
                    hasNegative = true;
                    temp = -temp;
                }
                if (temp > maxValue)
                    maxValue = temp;
            }
        }

        // Вычисление длины позиции под число.
        int len = Integer.toString(maxValue).length() + 1;  // Одно знакоместо под разделитель (пробел).
        if (hasNegative)
            ++len;  // Если есть отрицательные, добавляем знакоместо под минус.

        // Построение строки формата.
        final String formatString = "%" + len + "d";

        // Вывод элементов матрицы в файл.
        for (final int[] row : matrix) {  // Цикл по строкам матрицы.
            for (final int element : row)  // Цикл по столбцам матрицы.
                fileWriter.write(String.format(formatString, element));

            fileWriter.write("\n");  // Разделяем строки матрицы переводом строки.
        }
    }

    private static void printAllMatrix(final String fileName,
                                       final int[][] firstMatrix,
                                       final int[][] secondMatrix,
                                       final int[][] resultMatrix) {
        try (final FileWriter fileWriter = new FileWriter(fileName, false)) {
            fileWriter.write("First matrix:\n");
            printMatrix(fileWriter, firstMatrix);

            fileWriter.write("\nSecond matrix:\n");
            printMatrix(fileWriter, secondMatrix);

            fileWriter.write("\nResult matrix:\n");
            printMatrix(fileWriter, resultMatrix);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[][] multiplyMatrix(final int[][] firstMatrix,
                                          final int[][] secondMatrix) {
        final int rowCount = firstMatrix.length;             // Число строк результирующей матрицы.
        final int colCount = secondMatrix[0].length;         // Число столбцов результирующей матрицы.
        final int sumLength = secondMatrix.length;           // Число членов суммы при вычислении значения ячейки.
        final int[][] result = new int[rowCount][colCount];  // Результирующая матрица.

        for (int row = 0; row < rowCount; ++row) {  // Цикл по строкам матрицы.
            for (int col = 0; col < colCount; ++col) {  // Цикл по столбцам матрицы.
                int sum = 0;
                for (int i = 0; i < sumLength; ++i)
                    sum += firstMatrix[row][i] * secondMatrix[i][col];
                result[row][col] = sum;
            }
        }

        return result;
    }

    private static int[][] multiplyMatrixMT(final int[][] firstMatrix,
                                            final int[][] secondMatrix,
                                            int threadCount) {

        final int rowCount = firstMatrix.length;             // Число строк результирующей матрицы.
        final int colCount = secondMatrix[0].length;         // Число столбцов результирующей матрицы.
        final int[][] result = new int[rowCount][colCount];  // Результирующая матрица.

        final int cellsForThread = (rowCount * colCount) / threadCount;  // Число вычисляемых ячеек на поток.
        int firstIndex = 0;  // Индекс первой вычисляемой ячейки.
        final MultiplierThread[] multiplierThreads = new MultiplierThread[threadCount];  // Массив потоков.

        // Создание и запуск потоков.
        for (int threadIndex = threadCount - 1; threadIndex >= 0; --threadIndex) {
            int lastIndex = firstIndex + cellsForThread;  // Индекс последней вычисляемой ячейки.
            if (threadIndex == 0) {
                /* Один из потоков должен будет вычислить не только свой блок ячеек,
                   но и остаток, если число ячеек не делится нацело на число потоков. */
                lastIndex = rowCount * colCount;
            }
            multiplierThreads[threadIndex] = new MultiplierThread(firstMatrix, secondMatrix, result, firstIndex, lastIndex);
            multiplierThreads[threadIndex].start();
            firstIndex = lastIndex;
        }

        // Ожидание завершения потоков.
        try {
            for (final MultiplierThread multiplierThread : multiplierThreads)
                multiplierThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result;
    }


    final static int FIRST_MATRIX_ROWS = 100;
    final static int FIRST_MATRIX_COLS = 100;
    final static int SECOND_MATRIX_ROWS = FIRST_MATRIX_COLS;
    final static int SECOND_MATRIX_COLS = 100;

    public static void main(String[] args) {
        final int[][] firstMatrix = new int[FIRST_MATRIX_ROWS][FIRST_MATRIX_COLS];    // Первая (левая) матрица.
        final int[][] secondMatrix = new int[SECOND_MATRIX_ROWS][SECOND_MATRIX_COLS];  // Вторая (правая) матрица.

        randomMatrix(firstMatrix);
        randomMatrix(secondMatrix);

        final int[][] resultMatrixMT = multiplyMatrixMT(firstMatrix, secondMatrix, Runtime.getRuntime().availableProcessors());

        // Проверка многопоточных вычислений с помощью однопоточных.
        final int[][] resultMatrix = multiplyMatrix(firstMatrix, secondMatrix);

        for (int row = 0; row < FIRST_MATRIX_ROWS; ++row) {
            for (int col = 0; col < SECOND_MATRIX_COLS; ++col) {
                if (resultMatrixMT[row][col] != resultMatrix[row][col]) {
                    System.out.println("Error in multithreaded calculation!");
                    return;
                }
            }
        }

        printAllMatrix("Matrix.txt", firstMatrix, secondMatrix, resultMatrixMT);
    }

}
