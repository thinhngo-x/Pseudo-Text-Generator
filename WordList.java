class WordList
{
    Node content;
    
    WordList()
    {
        content = null;
    }
    
    WordList(Node cont)
    {
        content = cont;
    }
    
    WordList(String[] t)
    {
        if(t.length == 0) content = null;
        else
        {
            content = new Node(t[0], null);
            Node pt = content;
            for(int i = 1; i < t.length; i++)
            {
                pt.next = new Node(t[i], null);
                pt = pt.next;
            }
        }
    }
    
    String[] toArray()
    {
        int length = length();
        String[] rs = new String[length()];
        Node pt = content;
        for(int i = 0; i < length; i++)
        {
            rs[i] = pt.head;
            pt = pt.next;
        }
        return(rs);
    }
    
    int length()
    {
        return(Node.length(content));
    }
    
    String print()
    {
        return(Node.printNodes(content));
    }
    
    void addFirst(String w)
    {
        content = new Node(w, content);
    }
    
    void addLast(String w)
    {
        Node.addLast(w, content);
    }
    
    String removeFirst()
    {
        if(content == null) return null;
        String rs = content.head;
        content = content.next;
        return(rs);
    }
    
    String removeLast()
    {
        if(content == null) return null;
        String rs = content.head;
        if(content.next == null)
        {
            content = null;
            return(rs);
        }
        Node pt = content;
        while(pt.next.next != null)
        {

            pt = pt.next;
        }
        rs = pt.next.head;
        pt.next = null;
        return(rs);
        
    }
    
    void insert(String s)
    {
        content = Node.insert(s, content);
    }
    
    void insertionSort()
    {
        content = Node.insertionSort(content);
    }
    
    void mergeSort()
    {
        Node alt = null;
        while(content != null)
        {
            Node l1 = new Node(removeFirst(), null);
            alt = Node.merge(l1, alt);
        }
        content = alt;
    }
    
    static WordList foobar = new WordList(new String[]{"foo", "bar", "baz"});
    public static void main(String[] args)
    {
        System.out.println(foobar.length());
        System.out.println(foobar.print());  
        System.out.println(foobar.removeFirst());
        System.out.println(foobar.removeLast());
        foobar.addFirst("baz1");
        foobar.addFirst("baz2");
        foobar.addFirst("baz3");
        foobar.addFirst("baz4");
        foobar.addFirst("baz5");
        System.out.println(foobar.print());
        System.out.println(foobar.removeFirst());
        System.out.println(foobar.removeLast());
        System.out.println(foobar.removeLast());
        
        foobar.addLast("baz");
        System.out.println(foobar.print());      
    }
}
