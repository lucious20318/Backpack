import java.util.*;

public class lecture
{
    private HashMap<String, ArrayList> slides = new HashMap<>();
    private HashMap<String, ArrayList> video = new HashMap<>();
    private HashMap<String, Date> time = new HashMap<>();
    
    private Scanner sc = new Scanner(System.in);
    private Scanner scan = new Scanner(System.in);

    public void addslide(int opt)
    {
        ArrayList<String> arr = new ArrayList<>();

        System.out.print("\nEnter topic of slides: ");
        String topic = scan.nextLine();

        System.out.print("Enter number of slides: ");
        int numb = sc.nextInt();

        System.out.print("Enter content of slides");
        System.out.println();
        
        String cont;
        for(int i=1; i<=numb; i++)
        {
            System.out.print("Content of slide " + i +":");
            cont = scan.nextLine();
            arr.add(cont);
        }

        long millis=System.currentTimeMillis(); 
	    java.util.Date date=new java.util.Date(millis);

        arr.add("I"+opt);
        slides.put(topic, arr);
        time.put(topic, date);

        System.out.println("Welcome I" + opt);
    }

    public void addvideo(int opt)
    {
        ArrayList<String> arr = new ArrayList<>();

        System.out.print("\nEnter topic of video: ");
        String topic = scan.nextLine();

        System.out.print("\nEnter filename or video: ");
        String file = scan.next();

        String extension;

        if(file.length()>4)
        {
            extension = file.substring(file.length()-4);
        }
        else
        {
            extension = file;
        }

        if (extension.equals(".zip") || extension.equals(".mp4"))
        {
            arr.add(file);
            arr.add("I"+opt);

            long millis=System.currentTimeMillis(); 
	        java.util.Date date=new java.util.Date(millis);

            video.put(topic, arr);
            time.put(topic, date);
            System.out.println("Welcome I" + opt);

        }
        else
        {
            System.out.println("The format is not valid");
            return;
        }

    }


    public void viewslide()
    {
        System.out.println("Enter\n\n");

        for(HashMap.Entry<String,ArrayList> trav : slides.entrySet())
        {
            ArrayList<String> travlist = new ArrayList<>();
            travlist = trav.getValue();
            System.out.println("Title: " + trav.getKey());
            
            int no = 0;
            for(int i=0; i<travlist.size()-1;i++)
            {
                no = i +1;
                System.out.println("Slide " + no + ": " + travlist.get(i));
            }

            int y = travlist.size()-1;

            System.out.println("Number of slides: " + y);
            System.out.println("Date of upload" + time.get(trav.getKey()));
            System.out.println("Uploaded by: " + travlist.get(no));
        }
        System.out.println();
    }

    public void viewvideo()
    {
        for(HashMap.Entry<String,ArrayList> trav : video.entrySet())
        {
            ArrayList<String> travlist = new ArrayList<>();
            travlist = trav.getValue();
            System.out.print("Title of video: " + trav.getKey());
            
            System.out.println("Video file: " + travlist.get(0));
            System.out.println("Date of upload" + time.get(trav.getKey()));
            System.out.println("Uploaded by: " + travlist.get(1));

        }
    }        
}
