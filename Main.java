import java.util.*;

public class Main{
    
    public static void main(String[] args)
    {        
        Program pg = new Program();
        //User us = new User();
        main_menu(pg);
    }

    public static void main_menu(Program pg)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("1. Enter as instructor \n");
        System.out.print("2. Enter as student \n");
        System.out.print("3. Exit\n");

        int ch = sc.nextInt();

        HashMap<Integer,User> choice = new HashMap<>();

        if(ch == 1)
        {
            choice = pg.get_ins();
            
            
            for(HashMap.Entry<Integer,User> trav : choice.entrySet())
            {
                System.out.println(trav.getKey() + " " + trav.getValue().current());
            }

            System.out.print("Choose id: ");
            int opt = sc.nextInt();

            System.out.println("\nWelcome I" + opt);

            for(HashMap.Entry<Integer,User> trav : choice.entrySet())
            {
                int x = trav.getKey();
                if(x==opt)
                {
                    User in = trav.getValue();
                    in.menu();
                }
            }

        }

        if(ch == 2)
        {
            choice = pg.get_stu();
            
            System.out.print("\nStudents\n");

            for(HashMap.Entry<Integer,User> trav : choice.entrySet())
            {
                System.out.println(trav.getKey() + " " + trav.getValue().current());
            }

            System.out.print("\nChoose id: ");
            int opt = sc.nextInt();

            System.out.println("\nWelcome S" + opt);

            for(HashMap.Entry<Integer,User> trav : choice.entrySet())
            {
                int x = trav.getKey();
                if(x==opt)
                {
                    User st = trav.getValue();
                    st.menu();
                }
            }
        }
    }
}


