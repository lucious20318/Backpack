import java.util.*;

public class instructor implements User{

    private String curr_ins;

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
    public void menu(){
        
        Scanner sc = new Scanner(System.in);
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

        if(cho == 9)
        {
            Main.main_menu(pg);
        }
    }

    @Override
    public void view_comments(){
        //aaa
    }

    @Override
    public void add_comments(){
        //aaa
    }
    
}