// "static void main" must be defined in a public class.
import java.util.*;
public class Main {
    public static void main(String[] args) 
    {

        ArrayList<String> al=new ArrayList<>();
        //Test Cases // yes im here...cool
        al.add("avc qqhsh sds art");
        al.add("avc shsh art");
        al.add("avc 98 12");
        al.add("ddf kindle bhai");
        al.add("abc1 kindle bhai");
        al.add("sjdk dssasd chikoo ant");
        al.add("avc 198 12");
        ArrayList<String> result=new ArrayList<>(solve(al));
        for(int i=0;i<result.size();i++)
        {
          System.out.println(result.get(i));
        }
    }
    
    public static List<String> solve(ArrayList<String> l)
    {
            ArrayList<String> al =new ArrayList<String>();
            ArrayList<Prior> temp=new ArrayList<>();
            ArrayList<String> numAl =new ArrayList<String>();
            for(int i=0;i<l.size();i++)
            {
                String k=l.get(i);
                int ind=k.indexOf(' ');
                String key=k.substring(0,ind);
                String value=k.substring(ind+1);
  
                if(value.charAt(0)>='0'&& value.charAt(0)<='9')
                    numAl.add(key+" "+value);
                else  
                temp.add(new Prior(key,value));
            }
            Collections.sort(temp); 
            
            
            for(Prior p:temp)
            {
              String stringfinal=p.key+" "+p.value;
              //System.out.println(stringfinal);
              al.add(stringfinal);
            }
            for(String i:numAl)
              al.add(i);
            return al;
    }
}

class Prior implements Comparable<Prior>
{
    String key;
    String value;
    public Prior(String key,String value)
    {
        this.key=key;
        this.value=value;
    }
    public int compareTo(Prior pt)
    {
      if(value.compareTo(pt.value)<0)
        return -1;
      else if (value.compareTo(pt.value)>0)
        return 1;
      else
      {
        if(key.compareTo(pt.key)<0)
          return -1;
        else if(key.compareTo(pt.key)>0)
          return 1;
          else
            return 0;
      }
    }
}