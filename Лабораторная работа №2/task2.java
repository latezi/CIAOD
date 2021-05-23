public static class Map<K, V> {

    class MapNode<K, V> {

        K key;
        V value;
        MapNode<K, V> next;

        public MapNode(K key, V value)
        {
            this.key = key;
            this.value = value;
            next = null;
        }
    }
    ArrayList<MapNode<K, V> > buckets;
    int size;
    int numBuckets;
    final double DEFAULT_LOAD_FACTOR = 0.75;
    public Map()
    {
        numBuckets = 5;
        buckets = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
        System.out.println("HashMap созданный");
        System.out.println("\n" + "Количество пар на Map: " + size);
        System.out.println("Размер Map: " + numBuckets);
        System.out.println("Коэффициент нагрузки по умолчанию : " + DEFAULT_LOAD_FACTOR + "\n");
    }

    private int getBucketInd(K key)
    {
        int hashCode = key.hashCode();
        return (hashCode % numBuckets);
    }

    public void insert(K key, V value)
    {
        int bucketInd = getBucketInd(key);
        MapNode<K, V> head = buckets.get(bucketInd);
          /*  while (head != null) {

                // Если уже присутствует, значение обновляется
                if (head.key.equals(key)) {
                    head.value = value;
                    return;
                }
                head = head.next;
            }*/

        MapNode<K, V> newElementNode = new MapNode<K, V>(key, value);
        head = buckets.get(bucketInd);
        newElementNode.next = head;
        buckets.set(bucketInd, newElementNode);
        System.out.println("Пара (" + key + ", " + value + ") вставлено успешно.\n");
        size++;
        
        double loadFactor = (1.0 * size) / numBuckets;

        System.out.println("Текущий коэффициент нагрузки = " + loadFactor);

        if (loadFactor > DEFAULT_LOAD_FACTOR) {
            System.out.println(loadFactor + " больше, чем " + DEFAULT_LOAD_FACTOR);
            System.out.println("Поэтому повторное хеширование будет выполнено.\n");
            // Rehash
            rehash();
            System.out.println("Новый размер для Map: " + numBuckets + "\n");
        }
        System.out.println("Количество пар в Map: " + size);
        System.out.println("Размер Map: " + numBuckets + "\n");
    }
    private void rehash() {
        System.out.println("\nНачало рехеширования\n");
        ArrayList<MapNode<K, V> > temp = buckets;
        buckets = new ArrayList<MapNode<K, V> >(2 * numBuckets);

        for (int i = 0; i < 2 * numBuckets; i++) {
            // Initialised to null
            buckets.add(null);
        }
        size = 0;
        numBuckets *= 2;

        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                K key = head.key;
                V val = head.value;
                insert(key, val);
                head = head.next;
            }
        }
        System.out.println("\nРехеширование закончилось\n");
    }

    public void printMap() {
        ArrayList<MapNode<K, V> > temp = buckets;
        System.out.println("Построенный HashMap:");
        for (int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            while (head != null) {
                System.out.println("ключ = " + head.key + ", значение = " + head.value);
                head = head.next;
            }
        }
        System.out.println();
    }
}

public static class HashNode<K, V> {
    K key;
    V value;

    HashNode<K, V> next;

    public HashNode(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
}

public static class Map2<K, V> {
    private ArrayList<HashNode<K, V>> bucketArray;
    private int numBuckets;
    private int size;
    
    public Map2() {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;
        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        index = index < 0 ? index * -1 : index;
        return index;
    }
    
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key))
                break;
            prev = head;
            head = head.next;
        }
        if (head == null)
            return null;
        size--;
        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);

        return head.value;
    }
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }
        return null;
    }
    
    public void add(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode
                = new HashNode<K, V>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
        if ((1.0 * size) / numBuckets >= 0.7) {
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }
}