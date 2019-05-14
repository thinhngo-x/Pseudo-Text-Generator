class HMap
{
    EntryList[] t;
    int size;
    
    HMap(int n)
    {
        t = new EntryList[n];
    }
    
    HMap()
    {
        t = new EntryList[20];
    }
    
    WordList find(Prefix key)
    {
        EntryList pt = t[key.hashCode(t.length)];
        while(pt != null )
        {
            if(pt.head.key.hashCode() == key.hashCode()) return(pt.head.value);
            pt = pt.next;
            
        }
        return(null);
    }
    
    void addSimple(Prefix key, String w)
    {
        boolean found = false;
        int n = key.hashCode(t.length);
        if(find(key) != null) find(key).addLast(w);
        else
        {
            if(t[n] == null) t[n] = new EntryList(new Entry(key, new WordList(new Node(w, null))), null);
            else
            {
                EntryList pt = t[n];
                while(pt.next != null)
                {
                    pt = pt.next;
                }
                pt.next = new EntryList(new Entry(key, new WordList(new Node(w, null))), null);
            }
            size++;
        }
    }
    
    void add(Prefix key, String w)
    {
        boolean found = false;
        int n = key.hashCode(t.length);
        if(find(key) != null) find(key).addLast(w);
        else
        {
            if(t[n] == null) t[n] = new EntryList(new Entry(key, new WordList(new Node(w, null))), null);
            else
            {
                EntryList pt = t[n];
                while(pt.next != null)
                {
                    pt = pt.next;
                }
                pt.next = new EntryList(new Entry(key, new WordList(new Node(w, null))), null);
            }
            size++;
            if(size >= t.length*3/4) rehash(t.length*2);
        }
    }
    
    void addLastEntry(Entry w, int n)
    {
        if(t[n] == null) t[n] = new EntryList(w, null);
        else
        {
            EntryList pt = t[n];
            while(pt.next != null)    pt = pt.next;
            pt.next = new EntryList(w, null);
        }
    }
    
    void rehash(int n)
    {
        HMap hmap = new HMap(n);
        hmap.size = this.size;
        for(int i=0; i<t.length; i++)
        {
            EntryList pt = t[i];
            while(pt!=null)
            {
                Prefix key = pt.head.key;
                WordList value = pt.head.value;
                hmap.addLastEntry(new Entry(key, value), key.hashCode(n));
                pt = pt.next;
            }
        }
        
    }
}



















