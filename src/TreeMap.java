Associates the specified value with the specified key in this map. If the map previously contained a mapping for the key, the old value is replaced.
Parameters:
key key with which the specified value is to be associated
value value to be associated with the specified key
Returns:
the previous value associated with key, or null if there was no mapping for key. (A null return can also indicate that the map previously associated null with key.)
Throws:
java.lang.ClassCastException if the specified key cannot be compared with the keys currently in the map
java.lang.NullPointerException if the specified key is null and this map uses natural ordering, or its comparator does not permit null keys
526 
527     public V More ...put(K key, V value) {
528         Entry<K,V> t = root;
529         if (t == null) {
530             // TBD:
531             // 5045147: (coll) Adding null to an empty TreeSet should
532             // throw NullPointerException
533             //
534             // compare(key, key); // type check
535             root = new Entry<K,V>(key, value, null);
536             size = 1;
537             modCount++;
538             return null;
539         }
540         int cmp;
541         Entry<K,V> parent;
542         // split comparator and comparable paths
543         Comparator<? super K> cpr = comparator;
544         if (cpr != null) {
545             do {
546                 parent = t;
547                 cmp = cpr.compare(key, t.key);
548                 if (cmp < 0)
549                     t = t.left;
550                 else if (cmp > 0)
551                     t = t.right;
552                 else
553                     return t.setValue(value);
554             } while (t != null);
555         }
556         else {
557             if (key == null)
558                 throw new NullPointerException();
559             Comparable<? super K> k = (Comparable<? super K>) key;
560             do {
561                 parent = t;
562                 cmp = k.compareTo(t.key);
563                 if (cmp < 0)
564                     t = t.left;
565                 else if (cmp > 0)
566                     t = t.right;
567                 else
568                     return t.setValue(value);
569             } while (t != null);
570         }
571         Entry<K,V> e = new Entry<K,V>(key, value, parent);
572         if (cmp < 0)
573             parent.left = e;
574         else
575             parent.right = e;
576         fixAfterInsertion(e);
577         size++;
578         modCount++;
579         return null;
580     }
