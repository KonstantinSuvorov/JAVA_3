/* Сортировка слиянием на Java */
class MergeSort {
    // Слияние двух массивов в один arr[].
    // Первый подмассив arr[l..m]
    // Второй подмассив arr[m+1..r]
    void merge(int arr[], int left, int mid, int right) {
        // рассчитываем размер подмассивов
        int n1 = mid - left + 1;
        int n2 = right - mid;

        /* Инициализируем временные массивы */
        int Left[] = new int[n1];
        int Right[] = new int[n2];

        /* Копируем элементы во временные маcсивы */
        for (int i = 0; i < n1; ++i)
            Left[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            Right[j] = arr[mid + 1 + j];

        /* Объединяем временные массивы */

        // Начальные индексы подмассивов
        int i = 0, j = 0;

        // Начальный индекс объединенного массива
        int k = left;
        while (i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                arr[k] = Left[i];
                i++;
            } else {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }

        /* Копируем элементы из левого подмассива */
        while (i < n1) {
            arr[k] = Left[i];
            i++;
            k++;
        }

        /* Копируем элементы из правого подмассива */
        while (j < n2) {
            arr[k] = Right[j];
            j++;
            k++;
        }
    }

    // Слияние отсортированных массивов
    void sort(int arr[], int left, int right) {
        if (left < right) {
            // Ищем значение индекса среднего элемента
            int mid = (left + right) / 2;

            // Сортируем левую и правую половинки
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            // Объединяем отсортированные половинки
            merge(arr, left, mid, right);
        }
    }

    /* Вспомогательная функция для печати массива arr */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
            System.out.println();
    }

    // Управляющая программа
    public static void main(String args[]) {
        int arr[] = { 89, 25, 7, 1, 12, 6, 33 };
        
        /* Вывод на экран исходного массива */
        System.out.println("Исходный массив:");
        printArray(arr);
        
       /* Вызов методов сортировки и слияния */
        MergeSort mergedArr = new MergeSort();
        mergedArr.sort(arr, 0, arr.length - 1);
        
        /* Вывод на экран отсортированного массива */
        System.out.println("Сортированный массив:");
        printArray(arr);
    }
}