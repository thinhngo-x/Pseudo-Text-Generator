class Bovary
{
    static HMap buildTable(String[] files, int n)
    {
        HMap table = new HMap();
        for(int i=0; i<files.length; i++)
        {
            WordReader wr = new WordReader(files[i]);
            Prefix key = new Prefix(n);
            for(String w = wr.read(); w != null; w=wr.read())
            {
                table.add(key, w);
                key = key.addShift(w);
                System.out.println("Adding "+w+" ...");
            }
            table.add(key, Prefix.end);
        }
        return(table);
    }
    
    static String randomPick(Prefix key, HMap t)
    {
        WordList value = t.find(key);
        int taille = value.length();
        String[] val = value.toArray();
        double n = Math.random() * (double)taille;
        return(val[(int) n]);
    }
    
    static void generate(HMap t, int n)
    {
        Prefix key = new Prefix(n);
        for(String w = randomPick(key, t); !w.equals(Prefix.end); w = randomPick(key, t))
        {
            if(w.equals(Prefix.par))
            {
                System.out.println(w);
                System.out.print("\n");
            }
            else    System.out.print(w+" ");
            key = key.addShift(w);
        }
        
    }
    
    public static void main(String[] args)
    {
        String[] files = new String[35];
        for(int i=1; i<=35; i++)
        {
            if(i<10) files[i-1] = "bovary/0"+i+".txt";
            else files[i-1] ="bovary/"+i+".txt";
        }
        int n = 10;
        HMap t = buildTable(files, n);
        generate(t, n);
    }
}
