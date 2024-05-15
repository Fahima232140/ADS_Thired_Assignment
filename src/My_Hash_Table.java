public class My_Hash_Table<K, V> {
    private class Hash_Node<K, V>{
        private K key;
        private V value;
        private Hash_Node<K, V> next;

        public Hash_Node(K key, V value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private Hash_Node<K, V>[] chain_Array;
    private int M = 11;
    private int size = 0;

    public My_Hash_Table(){
        chain_Array = new Hash_Node[M];
    }

    public My_Hash_Table(int M){
        this.M = M;
        chain_Array = new Hash_Node[M];
    }

    public int getSize(){
        return size;
    }

    private int hash(K key){
        int result = 0;

        result = (31 * result + key.hashCode());

        return result;
    }

    public void put(K key, V value){
        int i = get_Index(key);
        int hashCodeOfKey = hash(key);

        Hash_Node<K, V> temp = new Hash_Node<K, V>(key, value);

        if(chain_Array[i] == null){
            chain_Array[i] = temp;
            size++;
            return;
        }

        Hash_Node<K, V> head = chain_Array[i];

        while (head != null){
            if(hash(head.key) == hashCodeOfKey){
                head.value = value;
                return;
            }
            head = head.next;
        }

        head = chain_Array[i];
        temp.next = head;
        chain_Array[i] = temp;
        size++;
    }

    public K get_Key(V value){

        for(int i = 0; i < M; i++){
            Hash_Node<K, V> head = chain_Array[i];
            while (head != null){
                if(head.value.equals(value)){
                    return head.key;
                }
                head = head.next;
            }
        }

        return null;
    }

    public V get(K key){
        int index = get_Index(key);
        int hashCodeOfKey = hash(key);

        Hash_Node<K, V> head = chain_Array[index];

        while (head != null){
            if(hash(head.key) == hashCodeOfKey){
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public V Removing(K key){
        int index = get_Index(key);
        int hashCodeOfKey = hash(key);

        Hash_Node<K, V> head = chain_Array[index];
        Hash_Node<K, V> prev = null;

        while(head != null){
            if(hash(head.key) == hashCodeOfKey){
                break;
            }
            prev = head;
            head = head.next;
        }

        if(head == null){
            return null;
        }
        if(prev != null){
            prev.next = head.next;
        } else {
            chain_Array[index] = head.next;
        }

        size--;
        return head.value;
    }

    public boolean contains(V value){

        for(int i = 0; i < M; i++){
            Hash_Node<K, V> head = chain_Array[i];

            while(head != null){
                if(head.value.equals(value)){
                    return true;
                }
                head = head.next;
            }
        }

        return false;
    }

    private int get_Index(K key){
        int comput_index = hash(key) % M;
        if(comput_index < 0){
            comput_index = comput_index * -1;
        }
        return comput_index;
    }
}



