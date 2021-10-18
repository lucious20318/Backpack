import java.util.*;

public class student implements User{

    private String curr_stu;
    private Scanner sc = new Scanner(System.in);
    private Scanner scan = new Scanner(System.in);

    public static assessment a0 = new assessment();
    public static assessment a1 = new assessment();
    public static assessment a2 = new assessment();

    public student (String stu)
    {
        this.curr_stu = stu;    
    }

    @Override
    public String current()
    {
        return curr_stu;
    }

    @Override
    public void menu(int opt){

        
        Program pg = new Program();
        

        System.out.print("\nSTUDENT MENU\n");
        System.out.print("1. View lecture materials \n");
        System.out.print("2. View assessments \n");
        System.out.print("3. Submit assessments \n");
        System.out.print("4. View grades \n");
        System.out.print("5. View comments \n");
        System.out.print("6. Add comments \n");
        System.out.print("7. Logout \n");
        
        int cho = sc.nextInt();
        
        if (cho == 1)
        {
            view_material(opt);
        }

        else if (cho == 2)
        {
            view_assessments(opt);
        }

        else if (cho == 3)
        {
            if(opt==0){
                a0.submit_assessment(opt);
                System.out.println("Welcome S0");
                menu(opt);
            }
            else if(opt == 1)
            {
                a1.submit_assessment(opt);
                System.out.println("Welcome S1");
                menu(opt);
            }
            else if(opt == 2)
            {
                a2.submit_assessment(opt);
                System.out.println("Welcome S2");
                menu(opt);
            }
            else
            {
                System.exit(0);
            }
        }

        else if (cho == 4)
        {
            if(opt==0)
            {
                a0.view_grades();
                System.out.println("Welcome S" + opt);
                menu(opt);
            }
            else if(opt ==1)
            {
                a1.view_grades();
                System.out.println("Welcome S" + opt);
                menu(opt);
            }
            else if(opt == 2)
            {
                a2.view_grades();
                System.out.println("Welcome S" + opt);
                menu(opt);
            }
            else
            {
                System.exit(0);
            }
        }

        else if(cho == 5)
        {
            view_comments();
            menu(opt);
        }

        else if (cho == 6)
        {
            add_comments(opt);
            menu(opt);
        }

        else if(cho == 7)
        {
            Main.main_menu(pg);
        }


    }

    @Override
    public void view_material(int opt)
    {
        instructor.lec.viewslide();
        instructor.lec.viewvideo();
        System.out.println("Welcome S" + opt);
        menu(opt);
    }
 
    @Override
    public void view_assessments(int opt)
    {
        instructor.as.view_all();
        System.out.println("Welcome S" + opt);
        menu(opt);
    }    

    @Override
    public void view_comments()
    {
        for(HashMap.Entry<String,HashMap> trav : instructor.comment.entrySet())
        {
            HashMap<String,Date> travmap = new HashMap<>();

            travmap = trav.getValue();

            for(HashMap.Entry<String,Date> ite : travmap.entrySet())
            {
                Date x = new Date();
                x = ite.getValue();
    
                System.out.println(trav.getKey() + " - " + ite.getKey());
                System.out.println(x);
            }

            System.out.println();
        }
    }


    @Override
    public void add_comments(int opt)
    {
        System.out.println("Enter comment: ");
        String com = scan.nextLine();
        String stf = "S" + opt;

        HashMap<String,Date> co = new HashMap<>();
        
        long millis=System.currentTimeMillis(); 
        java.util.Date date=new java.util.Date(millis);

        co.put(stf, date);
        instructor.comment.put(com, co);
    }   
}
