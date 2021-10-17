import java.util.*;

public class assessment 
{
    private HashMap<String, Integer> assign = new HashMap<>();
    private ArrayList<String> quizq = new ArrayList<>();

    private Scanner scan = new Scanner(System.in);
    private Scanner sc = new Scanner(System.in);

    public void add_assignment(int opt)
    {
        System.out.print("\nEnter problem statement:");
        String str = scan.nextLine();

        System.out.print("\nEnter max marks: ");
        int marks = sc.nextInt();

        assign.put(str, marks);

        System.out.println("Welcome I" + opt);
    }

    public void add_quiz(int opt)
    {
        System.out.print("\nEnter quiz question: ");
        String ques = scan.nextLine();
        quizq.add(ques);

        System.out.println("Welcome I" + opt);
    }

    public void view_all()
    {
        int id = 0;

        for(HashMap.Entry<String,Integer> trav : assign.entrySet())
        {
            System.out.println("ID: " + id + "Assignment" + trav.getKey() + " Max Marks: " + trav.getValue());
            id = id + 1;
            System.out.println("--------------------------");
        }

        id = assign.size();
        
        for(String s : quizq)
        {
            System.out.println("ID: " + id + "Question: " + s);
            id = id + 1;
            System.out.println("--------------------------");
        }
    }
}
