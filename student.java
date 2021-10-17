import java.util.*;

public class student implements User{

    private String curr_stu;

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
    public void menu(){

        Scanner sc = new Scanner(System.in);
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
        
        if(cho == 7)
        {
            Main.main_menu(pg);
        }


    }

    @Override
    public void view_comments()
    {
        //aaa
    }

    @Override
    public void add_comments()
    {
        //aaa
    }    
}