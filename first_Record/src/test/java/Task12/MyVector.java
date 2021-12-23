package Task12;

public class MyVector<E> {

    // =============================================== член Переменные ================================================= =====
    /*Массив внутри пакета*/
    private Object[] elements;

    /*Емкость по умолчанию линейной таблицы*/
    private static final int DEFAULT_CAPACITY = 16;

    /*База удвоена для расширения*/
    private static final double EXPAND_BASE = 1.5;

    /*Фактический размер внутреннего массива*/
    private int capacity;

    /*Фактический размер текущей линейной таблицы*/
    private int size;

    // ==================================================== = Метод строительства ==================================================== =======
    /*Метод построения по умолчанию без параметров*/
    public MyVector() {
        this.capacity = DEFAULT_CAPACITY;
        size = 0;
        // ::: Установить размер массива по умолчанию
        elements = new Object[capacity];
    }

    /**
     * Конструктор для установки начального размера внутреннего массива
     * @param емкость начальный размер внутреннего массива
     * */
    public MyVector(int capacity) {
        this.capacity = capacity;
        size = 0;
        // ::: установить размер массива
        elements = new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return (this.size == 0);
    }

    public int indexOf(E e) {
        // ::: определить, является ли текущий параметр нулевым
        if(e != null){
            // :::: Параметр не нулевой
            // ::: Сравнить спереди назад
            for(int i=0; i<this.size; i++){
                // ::: определить, равен ли текущий элемент параметру e
                if(e.equals(elements[i])){
                    // ::: Совпадение успешно, текущий индекс возвращается сразу
                    return i;
                }
            }
        }else{
            // ::: Параметр равен нулю
            // ::: Сравнить спереди назад
            for(int i=0; i<this.size; i++){
                // ::: определить, является ли текущий элемент нулевым
                if(this.elements[i] == null){
                    // ::: null, немедленно вернуть текущий индекс
                    return i;
                }
            }
        }

        // ::: В списке обхода не найдено эквивалентных элементов, и возвращается специальное значение «-1», указывающее, что оно не найдено
        return -1;
    }

    public boolean contains(E e) {
        // ::: повторно использовать метод indexOf, если он возвращает -1, он не существует, в противном случае он существует.
        return (indexOf(e) != -1);
    }

    /**
     * При вставке проверяйте нижний индекс за пределами
     * индекс индекса @param
     */
    private void rangeCheckForAdd(int index){
        // ::: Если индекс меньше 0 или больше значения размера, генерируется исключение
        // ::: Примечание: при вставке конец вектора может быть вставлен, поэтому (index == size) допустимо
        if(index > this.size || index < 0){
            throw new RuntimeException("index error  index=" + index + " size=" + this.size) ;
        }
    }

    /**
     * Нижний пограничный контроль
     * индекс индекса @param
     */
    private void rangeCheck(int index){
        // ::: Если индекс меньше 0 или больше или равен значению размера, выдается исключение
        if(index >= this.size || index < 0){
            throw new RuntimeException("index error  index=" + index + " size=" + this.size) ;
        }
    }

    /**
     * Внутренняя проверка расширения массива
     * */
    private void expandCheck(){
        // ::: Если текущее количество элементов = текущая емкость внутреннего массива
        if(this.size == this.capacity){
            // ::: необходимо расширить

            // ::: Сначала временно сохраняем ссылку на внутренний массив
            Object[] tempArray = this.elements;
            // ::: Текущий внутренний массив расширяется на некоторое кратное
            this.capacity = (int)(this.capacity * EXPAND_BASE);
            // ::: Внутренний массив указывает на новый массив с расширенной емкостью
            this.elements = new Object[this.capacity];

            // ::: Для удобства чтения кода используйте цикл for для копирования старого и нового массивов
            // ::: Советы: по сравнению с циклом for массовое копирование на основе системы System.arraycopy имеет более высокую эффективность выполнения при большом объеме данных внутреннего массива
            for(int i=0; i<tempArray.length; i++){
                this.elements[i] = tempArray[i];
            }
        }
    }

    public boolean add(E e) {
        // ::: Выполнить проверку раскрытия перед вставкой новых данных
        expandCheck();

        //; :: Вставить элемент в конец
        this.elements[this.size] = e;
        // ::: приращение размера
        this.size++;

        return true;
    }

    public void add(int index, E e) {
        // ::: При вставке проверяем индекс массива вне границ
        rangeCheckForAdd(index);
        // ::: Выполнить проверку раскрытия перед вставкой новых данных
        expandCheck();

        // ::: Элемент после нижнего индекса в позиции вставки перемещается на один бит назад (чтобы предотвратить перезапись данных и обеспечить порядок нижнего индекса данных в массиве)
        // ::: Советы: по сравнению с циклом for массовое копирование на основе системы System.arraycopy имеет более высокую эффективность выполнения при большом объеме данных внутреннего массива
        for(int i=this.size; i>index; i--){
            this.elements[i] = this.elements[i-1];
        }

        // ::: Вставить элемент "e" в позицию индекса индекса
        this.elements[index] = e;
        // ::: приращение размера
        this.size++;
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        // ::: Проверка границ подписчиков массива
        rangeCheck(index);

        // ::: Временно сохраняем элементы для удаления
        E willBeRemoved = (E)this.elements[index];

        // ::: Переместить данные после удаления позиции индекса на один бит вперед
        // ::: Советы: по сравнению с циклом for массовое копирование на основе системы System.arraycopy имеет более высокую эффективность выполнения при большом объеме данных внутреннего массива
        for(int i=index+1; i<this.size; i++){
            this.elements[i-1] = this.elements[i];
        }

        // ::: Поскольку данные перемещаются на один бит вперед, недействительная ссылка в конце списка освобождается, что повышает эффективность GC
        this.elements[(this.size - 1)] = null;
        // ::: уменьшение размера
        this.size--;

        // ::: вернуть удаленный элемент
        return willBeRemoved;
    }

    @SuppressWarnings("unchecked")
    public E set(int index, E e) {
        // ::: Проверка границ подписчиков массива
        rangeCheck(index);

        // ::: Сначала временно сохраняем ссылку на элемент в предыдущем индексе
        E oldValue = (E)this.elements[index];
        // ::: Установить элемент индекса индекса в параметре "e"
        this.elements[index] = e;

        // ::: вернуть замененный элемент
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        // ::: Проверка границ подписчиков массива
        rangeCheck(index);

        // ::: вернуть элемент, соответствующий нижнему индексу
        return (E)this.elements[index];
    }

    @Override
    public String toString(){
        // ::: пустой список
        if(this.isEmpty()){
            return "[]";
        }

        // ::: Используйте «[» в начале списка
        StringBuilder s = new StringBuilder("[");

        // ::: От первого до предпоследнего элемента
        for(int i=0; i<size-1; i++){
            // ::: Используйте «,» для разделения
            s.append(elements[i]).append(",").append(" ");
        }

        // ::: Последний элемент заканчивается на «]»
        s.append(elements[size - 1]).append("]");
        return s.toString();
    }
}