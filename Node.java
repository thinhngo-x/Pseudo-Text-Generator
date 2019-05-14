class Node
{
    String head;
    Node next;
    
    Node(String h, Node n)
    {
        this.head = h;
        this.next = n;
    }
    
    static int length(Node l)
    {
        
        int count = 0;
        Node i = l;
        while(i != null)
        {
            i = i.next;
            count++;
        }
        return(count);
        
    }
    
    static int length_rec(Node l)
    {
        if(l == null) return 0;
        return(length_rec(l.next)+1);
    } 
    
    static String printNodes(Node l)
    {
        String s = "[";
        while(l != null)
        {
            s += l.head;
            if(l.next != null) s += ", ";
            l = l.next;
        }
        s += "]";
        return(s);
    }
    
    static void addLast(String s, Node l)
    {
//        if(l.next == null) l.next = new Node(s,null);
//        else addLast(s, l.next);
        while(l.next != null)
        {
            l = l.next;
        }
        l.next = new Node(s, null);
    }
    
    static Node copy(Node l)
    {
        if(l == null) return(null);
        Node rs = new Node(l.head, null);
        Node pt = rs;
        while(l.next != null)
        {
            pt.next = new Node(l.next.head, null);
            l = l.next;
            pt = pt.next;
        }
        return(rs);
    }
    
    static Node insert(String s, Node l)
    {
        Node rs = copy(l);
        Node pt = rs;
        if(rs == null) return(new Node(s, null));
        do
        {
//            System.out.println("test");
            if(pt.head.compareTo(s) > 0)
            {
                String mid = pt.head;
                pt.head = s;
                s = mid;
            }
            if(pt.next == null)
            {
                pt.next = new Node(s, null);
                pt = pt.next;
            }
            pt = pt.next;
        } while(pt != null);
        
        return(rs);
    }
    
    static Node insertionSort(Node l)
    {
        Node rs = null;
        while(l != null)
        {
//            System.out.println("line");
            rs = insert(l.head, rs);
            l = l.next;
        }
        return(rs);
    }
    
    static Node merge(Node l1, Node l2)
    {
        if(l2 == null) return l1;
        if(l1 == null) return l2;
        l1 = copy(l1); l2 = copy(l2);
        if(l1.head.compareTo(l2.head) > 0)
        {
            Node pt = l2;
            while(pt.next != null)
            {
                pt = pt.next;
            }
            pt.next = l1;
            return(l2);
        }
        else
        {
            Node pt = l1;
            while(pt.next != null)
            {
                pt = pt.next;
            }
            pt.next = l2;
            return(l1);
        }
        
    }
    
    
    public static void main(String[] args)
    {
        Node test = new Node("dodo", new Node("bobo", new Node("bebe", null)));
        System.out.println(length_rec(test));
        System.out.println(length(test));
        System.out.println(printNodes(test));
        addLast("gg", test);
        System.out.println(printNodes(test));
        Node copie = copy(test);
        addLast("test", copie);
        System.out.println(printNodes(test));
        System.out.println(printNodes(copie));
        System.out.println(printNodes(insertionSort(test)));
    }
}
