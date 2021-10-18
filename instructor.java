import java.util.*;
import java.lang.*;

public class instructor implements User{

    private String curr_ins;
    

    private Scanner sc = new Scanner(System.in);
    private Scanner scan = new Scanner(System.in); 

    public static lecture lec = new lecture();
    public static assessment as = new assessment();
    
    public static HashMap<String,HashMap> comment = new HashMap<>();

    public instructor(String ins)
    {
        this.curr_ins = ins;        
        
    }

    @Override
    public String current()
    {
        return curr_ins;
    }

    @Override
    public void menu(int opt)
    {
        
        Program pg = new Program();
    
        System.out.print("\nINSTRUCTOR MENU\n");
        System.out.print("1. Add class material \n");
        System.out.print("2. Add assessments \n");
        System.out.print("3. View lecture materials \n");
        System.out.print("4. View assessments \n");
        System.out.print("5. Grade assessments \n");
        System.out.print("6. Close assessment \n");
        System.out.print("7. View comments \n");
        System.out.print("8. Add comments \n");
        System.out.print("9. Logout \n");

        int cho = sc.nextInt();

        if(cho == 1)
        {
            System.out.print("\n1. Add Lecture Slide");
            System.out.print("\n2. Add Lecture Video\n");
            int c = sc.nextInt();

            if(c == 1)
            {
                lec.addslide(opt);
                menu(opt);
            } 

            else if(c == 2)
            {
                lec.addvideo(opt);
                menu(opt);
            }

            else
            {
                System.out.println("Wrong option");
                System.exit(0);
            }
        }
        
        else if(cho == 2)
        {
            System.out.println("1. Add Assignment");
            System.out.println("2. Add Quiz");
            int c = sc.nextInt();

            if(c == 1)
            {
                as.add_assignment(opt);
                menu(opt);
            }

            else if(c == 2)
            {
                as.add_quiz(opt);
                menu(opt);
            }
            
            else
            {
                System.out.println("Wrong option");
                System.exit(0);
            }
        }

        else if(cho == 3)
        {
            view_material(opt);
        }

        else if(cho == 4)
        {
            view_assessments(opt);
            System.out.println("Welcome I" + opt);
            menu(opt);
        }

        else if(cho == 5)
        {
            System.out.println("List of assessments");
            view_assessments(opt);
            as.grade_assessments(opt);
            System.out.println("Welcome I"+opt);
            menu(opt);
        }

        else if(cho == 6)
        {
            System.out.println("List of open assignments");
            view_assessments(opt);
            as.close_assessment();
            System.out.println("Welcome I" + opt);
            menu(opt);
        }

        else if(cho == 7)
        {
            view_comments();
            menu(opt);
        }

        else if(cho == 8)
        {
            add_comments(opt);
            menu(opt);
        }

        else if(cho == 9)
        {
            Main.main_menu(pg);
        }
    }

    @Override
    public void view_material(int opt)
    {
        instructor.lec.viewslide();
        instructor.lec.viewvideo();
        System.out.println("Welcome I" + opt);
        menu(opt);
    }

    @Override
    public void view_assessments(int opt)
    {
        as.view_all();
    }

    @Override
    public void view_comments()
    {
        for(HashMap.Entry<String,HashMap> trav : comment.entrySet())
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
        System.out.print("\nEnter comment: ");
        String com = scan.nextLine();
        String stf = "I" + opt;

        HashMap<String,Date> co = new HashMap<>();
        
        long millis=System.currentTimeMillis(); 
        java.util.Date date=new java.util.Date(millis);

        co.put(stf, date);
        comment.put(com, co);
    }
    
}
