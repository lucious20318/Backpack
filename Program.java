import java.util.HashMap;

public class Program {

    private HashMap<Integer, User> stu = new HashMap<>();
    private HashMap<Integer, User> ins = new HashMap<>();

    public Program()
    {
        student S0 = new student("S0");
        student S1 = new student("S1");
        student S2 = new student("S2");

        stu.put(0,S0);
        stu.put(1,S1);
        stu.put(2,S2);

        instructor I0 = new instructor("I0");
        instructor I1 = new instructor("I1");

        ins.put(0, I0);
        ins.put(1, I1);
    }

    public HashMap<Integer,User> get_stu()
    {
        return stu;
    }
    
    public HashMap<Integer,User> get_ins()
    {
        return ins; 
    }
}