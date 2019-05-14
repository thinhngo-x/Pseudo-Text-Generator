class Prefix
{
    String[] t;
    final static String start = "<START>", end = "<END>", par = "<PAR>";
    Prefix(int n)
    {
        t = new String[n];
        for(int i=0; i<n; i++)
        {
            t[i] = start;
        }
    }
    
    Prefix(String[] s)
    {
        t = new String[s.length];
        for(int i=0; i<s.length; i++)
        {
            t[i] = s[i];
        }
    }
    
    static boolean eq(Prefix p1, Prefix p2)
    {
        if(p1.t.length != p2.t.length) return(false);
        for(int i=0; i<p1.t.length; i++)
        {
            if(p1.t[i] != p2.t[i])
                return(false);
        }
        return(true);
    }
    
    Prefix addShift(String w)
    {
        int n = t.length;
        Prefix rs = new Prefix(t);
        for(int i=0; i<n-1; i++)
        {
            rs.t[i] = t[i+1];
        }
        rs.t[n-1] = w;
        return(rs);
    }
        
    public int hashCode()
    {
        int n = t.length;
        int h = 0;
        for(int i=0; i<n; i++)
        {
            h = 37*h + t[i].hashCode();
        }
        return(h);
    }
    
    int hashCode(int n)
    {
        int h = hashCode();
        if(h < 0) return((-h) % n);
        return(h % n);
    }
    
    public static void main(String[] args)
    {
       System.out.println("ab".hashCode());
    }
}
