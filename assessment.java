import java.lang.reflect.Array;
import java.util.*;

import org.graalvm.compiler.lir.amd64.AMD64HotSpotHelper;

public class assessment 
{
    private HashMap<String, Integer> assign = new HashMap<>();
    private HashMap<String, Integer> open_a = new HashMap<>();

    private ArrayList<String> quizq = new ArrayList<>();
    private ArrayList<String> open_q = new ArrayList<>();

    private HashMap<Integer,HashMap> pend = new HashMap<>();
    private HashMap<String, Integer> ques_quiz = new HashMap<>();
    private HashMap<Integer,Integer> mark = new HashMap<>();

    private HashMap<String,ArrayList> grades = new HashMap<>();

    private ArrayList<String> ungraded = new ArrayList<>();

    private HashMap<String,Integer> submission = new HashMap<>();

    private Scanner scan = new Scanner(System.in);
    private Scanner sc = new Scanner(System.in);
    
    public static int id = 0;
    public static HashMap<String,Integer> subs = new HashMap<>();

    public void add_assignment(int opt)
    {
        System.out.print("\nEnter problem statement:");
        String str = scan.nextLine();

        System.out.print("\nEnter max marks: ");
        int marks = sc.nextInt();

        assign.put(str, marks);
        open_a.put(str, marks);
        mark.put(id, marks);
        pend.put(id, assign);

        student.a0.assign.put(str,marks);
        student.a0.pend.put(id,assign);

        student.a1.assign.put(str,marks);
        student.a1.pend.put(id,assign);

        student.a2.assign.put(str,marks);
        student.a2.pend.put(id,assign);
        
        id = id + 1;

        System.out.println("Welcome I" + opt);
    }

    public void add_quiz(int opt)
    {
        System.out.print("\nEnter quiz question: ");
        String ques = scan.nextLine();

        quizq.add(ques);
        open_q.add(ques);

        ques_quiz.put(ques,0);

        pend.put(id, ques_quiz);
        student.a0.pend.put(id,ques_quiz);
        student.a1.pend.put(id,ques_quiz);
        student.a2.pend.put(id,ques_quiz);

        id = id + 1;

        System.out.println("Welcome I" + opt);
    }

    public void view_all()
    {
        int id = 0;

        for(HashMap.Entry<String,Integer> trav : open_a.entrySet())
        {
            System.out.println("ID: " + id + " Assignment: " + trav.getKey() + " Max Marks: " + trav.getValue());
            id = id + 1;
            System.out.println("--------------------------");
        }

        id = assign.size();
        
        for(String s : open_q)
        {
            System.out.println("ID: " + id + " Question: " + s);
            id = id + 1;
            System.out.println("--------------------------");
        }
    }

    public void submit_assessment(int opt)
    {
        if(pend.size() == 0)
        {
            System.out.println("No pending assignments");
        }
        else
        {
            System.out.println("Pending assessments");

            HashMap<Integer,String> check = new HashMap<>();
            
            for(HashMap.Entry<Integer,HashMap> trav : pend.entrySet())
            {
                HashMap<String,Integer> ite = new HashMap<>(); 
                ite = trav.getValue();

                for(HashMap.Entry<String,Integer> ele : ite.entrySet())
                {
                    if(ele.getValue()==0)
                    {
                        System.out.println("ID: " + trav.getKey() + " Question: " + ele.getKey());
                        check.put(trav.getKey(), ele.getKey());
                    }
                    else
                    {
                        System.out.println("ID: " + trav.getKey() + " Assignment: " + ele.getKey() + " Max Marks:" + ele.getValue());
                        check.put(trav.getKey(), "Assignment");
                    }
                } 
            }

            System.out.print("\nEnter ID of assessment: ");
            int id = sc.nextInt();

            for(HashMap.Entry<Integer,String> trav : check.entrySet())
            {
                if(trav.getKey() == id)
                {

                    if(trav.getValue().equals("Assignment"))
                    {
                        System.out.println("Enter filename of assignment: ");
                        String filename = scan.nextLine();

                        String extension;
                
                        if(filename.length()>4)
                        {
                            extension = filename.substring(filename.length()-4);
                        }
                        else
                        {
                            extension = filename;
                        }
                
                        if (extension.equals(".zip") || extension.equals(".mp4"))
                        {
                            submission.put(filename,id);
                            ungraded.add(filename);
                            subs.put("S"+opt,id);
                            pend.remove(id);
                        }
                    }   

                    else
                    {
                        System.out.print("\n" + trav.getValue());
                        String answer = scan.nextLine();

                        submission.put(answer, id);
                        subs.put("S"+opt,id);
                        pend.remove(id);
                    }
                }
            }
            
        }
    }

    public void grade_assessments(int opt)
    {
        System.out.println("Enter ID of assessment to view submissions: ");
        int sub_id = sc.nextInt();

        System.out.println("Choose ID from these ungraded submissions: ");
        
        int i = 0;
        for(HashMap.Entry<String,Integer> trav : subs.entrySet())
        {
            if (trav.getValue() == sub_id)
            {
                System.out.println();
                System.out.print(i + ". " + trav.getKey());
            }
        } 

        System.out.println();
        int choice = sc.nextInt();

        if(choice == 0)
        {
            for(HashMap.Entry<String,Integer> trav : student.a0.submission.entrySet())
            {
                if (trav.getValue() == sub_id)
                {
                    System.out.println("Submission: " + trav.getKey());
                    System.out.println("--------------------------");

                    System.out.println("Max Marks: " + instructor.as.mark.get(sub_id));

                    System.out.print("Marks Scored: ");
                    int score = sc.nextInt();

                    ArrayList<Integer> score_prof = new ArrayList<>();
                    score_prof.add(score);
                    score_prof.add(opt);

                    student.a0.grades.put(trav.getKey(), score_prof);
                    student.a0.ungraded.remove(new String(trav.getKey()));

                }
            }
        }

        else if(choice == 1)
        {
            for(HashMap.Entry<String,Integer> trav : student.a1.submission.entrySet())
            {
                if (trav.getValue() == sub_id)
                {
                    System.out.println("Submission: " + trav.getKey());
                    System.out.println("--------------------------");

                    System.out.println("Max Marks: " + instructor.as.mark.get(sub_id));

                    System.out.print("Marks Scored: ");
                    int score = sc.nextInt();

                    ArrayList<Integer> score_prof = new ArrayList<>();
                    score_prof.add(score);
                    score_prof.add(opt);

                    student.a1.grades.put(trav.getKey(), score_prof);
                    student.a1.ungraded.remove(new String(trav.getKey()));

                }
            }
        }
        
        else if(choice == 2)
        {
            for(HashMap.Entry<String,Integer> trav : student.a2.submission.entrySet())
            {
                if (trav.getValue() == sub_id)
                {
                    System.out.println("Submission: " + trav.getKey());
                    System.out.println("--------------------------");

                    System.out.println("Max Marks: " + instructor.as.mark.get(sub_id));

                    System.out.print("Marks Scored: ");
                    int score = sc.nextInt();

                    ArrayList<Integer> score_prof = new ArrayList<>();
                    score_prof.add(score);
                    score_prof.add(opt);

                    student.a2.grades.put(trav.getKey(), score_prof);
                    student.a2.ungraded.remove(new String(trav.getKey()));

                }
            }
        }
        
        else
        {
            System.out.println("Wrong choice");
            System.exit(0);
        }
    }

    public void close_assessment()
    {
        System.out.print("\nEnter ID of assignment to close: ");
        int close_id = sc.nextInt();

        for(HashMap.Entry<Integer,HashMap> trav : pend.entrySet())
        {
            if(trav.getKey() == close_id)
            {
                HashMap<String, Integer> ele = new HashMap<>();

                ele = trav.getValue();

                for(HashMap.Entry<String,Integer> ite : ele.entrySet())
                {
                    if(ite.getValue() == 0)
                    {
                        open_q.remove(new String(ite.getKey()));
                        student.a0.pend.remove(close_id);
                        student.a1.pend.remove(close_id);
                        student.a2.pend.remove(close_id);
                    }
                    else
                    {
                        open_a.remove(ite.getKey());
                        student.a0.pend.remove(close_id);
                        student.a1.pend.remove(close_id);
                        student.a2.pend.remove(close_id);
                    }
                }
            }
        }
    }

    public void view_grades()
    {
        System.out.println("Graded Submissions");

        for(HashMap.Entry<String,ArrayList> trav : grades.entrySet())
        {
            ArrayList<Integer> ite = new ArrayList<>();
            ite = trav.getValue();

            System.out.println("Submission: " + trav.getKey());
            System.out.println("Marks scored: " + ite.get(0));
            System.out.println("Graded by: I" + ite.get(1));
        }

        System.out.println("-----------------------");

        System.out.println("Ungraded Submissions");
        for(String a: ungraded)
        {
            System.out.println("Submission: " + a);
        }
        System.out.println("-----------------------");
    }
}
