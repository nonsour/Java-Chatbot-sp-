
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.text.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
//future projects
//implement a calculator
//make it so that write to file
//make it able to add new commands
//make it output accordingly for oo

@SuppressWarnings("LeakingThisInConstructor") //remove the yellow pop ups
class Client extends JFrame implements ActionListener { //actionlisterner is for things like buttons and mouseclicks

    // These are the parts of the gui
    JScrollPane sp = new JScrollPane(ta);
    TextField tf;
    Label la;
    JButton a;
    Button d;
    public static JTextArea ta;
//setting the input
    public static String sl = "";
    Socket s = new Socket();
    int line = 0;
    File folder = new File("music");
    File[] listOfFiles = folder.listFiles();
//my 2d arrays for reference
    public static String clear[] = {"\n\n\n\n\n\n\n\n\n\n"};
    public static String nyan[] = {
        //1
        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + "`•.,¸,.•*¯`•.,¸,.•*|:¬¬¬¬¬¬::::|:^----^\n"
        + "`•.,¸,.•*¯`•.,¸,.•*|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰-O━━━━━━━━O-╯╰--O-O-╯\n",
        //2

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + "•.,¸,.•*¯`•.,¸,.•*`|:¬¬¬¬¬¬::::|:^----^\n"
        + "•.,¸,.•*¯`•.,¸,.•*`|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰O-━━━━━━━O--╯╰-O-O--╯\n",
        //3

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + ".,¸,.•*¯`•.,¸,.•*`•|:¬¬¬¬¬¬::::|:^----^\n"
        + ".,¸,.•*¯`•.,¸,.•*`•|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰-O━━━━━━━━O-╯╰--O-O-╯\n",
        //4

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + ",¸,.•*¯`•.,¸,.•*`•.|:¬¬¬¬¬¬::::|:^----^\n"
        + ",¸,.•*¯`•.,¸,.•*`•.|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰O-━━━━━━━O--╯╰-O-O--╯\n",
        //5

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + "¸,.•*¯`•.,¸,.•*`•.,|:¬¬¬¬¬¬::::|:^----^\n"
        + "¸,.•*¯`•.,¸,.•*`•.,|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰-O━━━━━━━━O-╯╰--O-O-╯\n",
        //6

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + ",.•*¯`•.,¸,.•*`•.,¸|:¬¬¬¬¬¬::::|:^----^\n"
        + ",.•*¯`•.,¸,.•*`•.,¸|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰-O━━━━━━━━O-╯╰-O-O--╯\n",
        //7

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + ".•*¯`•.,¸,.•*`•.,¸,|:¬¬¬¬¬¬::::|:^----^\n"
        + ".•*¯`•.,¸,.•*`•.,¸,|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰-O━━━━━━━━O-╯╰--O-O-╯\n",
        //8
        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + ",¸,.•*¯`•.,¸,.•*`•.|:¬¬¬¬¬¬::::|:^----^\n"
        + ",¸,.•*¯`•.,¸,.•*`•.|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰O-━━━━━━━O--╯╰-O-O--╯\n",
        //9

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + "¸,.•*¯`•.,¸,.•*`•.,|:¬¬¬¬¬¬::::|:^----^\n"
        + "¸,.•*¯`•.,¸,.•*`•.,|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰-O━━━━━━━━O-╯╰--O-O-╯\n",
        //10

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + ",.•*¯`•.,¸,.•*`•.,¸|:¬¬¬¬¬¬::::|:^----^\n"
        + ",.•*¯`•.,¸,.•*`•.,¸|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰-O━━━━━━━━O-╯╰-O-O--╯\n",
        //11

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + ".•*¯`•.,¸,.•*`•.,¸,|:¬¬¬¬¬¬::::|:^----^\n"
        + ".•*¯`•.,¸,.•*`•.,¸,|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰-O━━━━━━━━O-╯╰--O-O-╯\n",
        //13
          ",__,.....,__,......╭¬¬¬¬¬━━━━━━╮\n"
        + "•*¯`•.,¸,.•*`•.,¸,.|:¬¬¬¬¬¬::::|:^----^\n"
        + "•*¯`•.,¸,.•*`•.,¸,.|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + ".....--\"\"-....--\"-╰-O━━━━━━━━O-╯╰-O-O--╯\n",
          //14
          
        "__,.....,__,......,╭¬¬¬¬¬━━━━━━╮\n"
        + "*¯`•.,¸,.•*`•.,¸,.•|:¬¬¬¬¬¬::::|:^----^\n"
        + "*¯`•.,¸,.•*`•.,¸,.•|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "....--\"\"-....--\"-.╰-O━━━━━━━━O-╯╰--O-O-╯\n",
        //15
          "_,.....,__,......,_╭¬¬¬¬¬━━━━━━╮\n"
        + "¯`•.,¸,.•*`•.,¸,.•*|:¬¬¬¬¬¬::::|:^----^\n"
        + "¯`•.,¸,.•*`•.,¸,.•*|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "...--\"\"-....--\"-..╰-O━━━━━━━━O-╯╰-O-O--╯\n",
          
          //end of loop
          ",.....,__,......,__╭¬¬¬¬¬━━━━━━╮\n"
        + "`•.,¸,.•*`•.,¸,.•*¯|:¬¬¬¬¬¬::::|:^----^\n"
        + "`•.,¸,.•*`•.,¸,.•*¯|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "..--\"\"-....--\"-...╰-O━━━━━━━━O-╯╰-O-O--╯\n",
        
          //1
        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + "`•.,¸,.•*¯`•.,¸,.•*|:¬¬¬¬¬¬::::|:^----^\n"
        + "`•.,¸,.•*¯`•.,¸,.•*|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰-O━━━━━━━━O-╯╰--O-O-╯\n",
        //2

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + "•.,¸,.•*¯`•.,¸,.•*`|:¬¬¬¬¬¬::::|:^----^\n"
        + "•.,¸,.•*¯`•.,¸,.•*`|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰O-━━━━━━━O--╯╰-O-O--╯\n",
        //3

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + ".,¸,.•*¯`•.,¸,.•*`•|:¬¬¬¬¬¬::::|:^----^\n"
        + ".,¸,.•*¯`•.,¸,.•*`•|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰-O━━━━━━━━O-╯╰--O-O-╯\n",
        //4

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + ",¸,.•*¯`•.,¸,.•*`•.|:¬¬¬¬¬¬::::|:^----^\n"
        + ",¸,.•*¯`•.,¸,.•*`•.|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰O-━━━━━━━O--╯╰-O-O--╯\n",
        //5

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + "¸,.•*¯`•.,¸,.•*`•.,|:¬¬¬¬¬¬::::|:^----^\n"
        + "¸,.•*¯`•.,¸,.•*`•.,|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰-O━━━━━━━━O-╯╰--O-O-╯\n",
        //6

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + ",.•*¯`•.,¸,.•*`•.,¸|:¬¬¬¬¬¬::::|:^----^\n"
        + ",.•*¯`•.,¸,.•*`•.,¸|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰-O━━━━━━━━O-╯╰-O-O--╯\n",
        //7

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + ".•*¯`•.,¸,.•*`•.,¸,|:¬¬¬¬¬¬::::|:^----^\n"
        + ".•*¯`•.,¸,.•*`•.,¸,|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰-O━━━━━━━━O-╯╰--O-O-╯\n",
        //8
        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + ",¸,.•*¯`•.,¸,.•*`•.|:¬¬¬¬¬¬::::|:^----^\n"
        + ",¸,.•*¯`•.,¸,.•*`•.|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰O-━━━━━━━O--╯╰-O-O--╯\n",
        //9

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + "¸,.•*¯`•.,¸,.•*`•.,|:¬¬¬¬¬¬::::|:^----^\n"
        + "¸,.•*¯`•.,¸,.•*`•.,|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰-O━━━━━━━━O-╯╰--O-O-╯\n",
        //10

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + ",.•*¯`•.,¸,.•*`•.,¸|:¬¬¬¬¬¬::::|:^----^\n"
        + ",.•*¯`•.,¸,.•*`•.,¸|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰-O━━━━━━━━O-╯╰-O-O--╯\n",
        //11

        ".,__,.....,__,.....╭¬¬¬¬¬━━━━━━╮\n"
        + ".•*¯`•.,¸,.•*`•.,¸,|:¬¬¬¬¬¬::::|:^----^\n"
        + ".•*¯`•.,¸,.•*`•.,¸,|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "-.....--\"\"-....--\"╰-O━━━━━━━━O-╯╰--O-O-╯\n",
        //13
          ",__,.....,__,......╭¬¬¬¬¬━━━━━━╮\n"
        + "•*¯`•.,¸,.•*`•.,¸,.|:¬¬¬¬¬¬::::|:^----^\n"
        + "•*¯`•.,¸,.•*`•.,¸,.|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + ".....--\"\"-....--\"-╰-O━━━━━━━━O-╯╰-O-O--╯\n",
          //14
          
        "__,.....,__,......,╭¬¬¬¬¬━━━━━━╮\n"
        + "*¯`•.,¸,.•*`•.,¸,.•|:¬¬¬¬¬¬::::|:^----^\n"
        + "*¯`•.,¸,.•*`•.,¸,.•|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "....--\"\"-....--\"-.╰-O━━━━━━━━O-╯╰--O-O-╯\n",
        //15
          "_,.....,__,......,_╭¬¬¬¬¬━━━━━━╮\n"
        + "¯`•.,¸,.•*`•.,¸,.•*|:¬¬¬¬¬¬::::|:^----^\n"
        + "¯`•.,¸,.•*`•.,¸,.•*|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "...--\"\"-....--\"-..╰-O━━━━━━━━O-╯╰-O-O--╯\n",
          
          //end of loop
          ",.....,__,......,__╭¬¬¬¬¬━━━━━━╮\n"
        + "`•.,¸,.•*`•.,¸,.•*¯|:¬¬¬¬¬¬::::|:^----^\n"
        + "`•.,¸,.•*`•.,¸,.•*¯|:¬¬¬¬¬¬::::||｡◕‿‿◕｡|\n "
        + "..--\"\"-....--\"-...╰-O━━━━━━━━O-╯╰-O-O--╯\n",
          
          
    };

    //guessing what the user will input
    public String sIndata[][] = {
        //vairiations of greeting
        {"hi",
            "hello",
            "good day",
            "Whats up",
            "sup"
        },
        //bye
        {"bye",
            "exit",
            "goodbye",
            "gtg",
            "im leaving",
            "cya"
        },
        //query wargame centre
        {"tell me about the wargame centre",
            "wargame centre?",
            "can you tell me anything about sp wargame centre",
            "can you tell me anything about sp wargame centre?",
            "anything about wargame centre?",
            "anything about wargame centre"

        },
        //query about sp
        {"tell me about sp",
            "sp?",
            "sp",
            "why should i pick sp",
            "what is so special about sp?",
            "why should i pick sp?"},
        //query dism
        {"tell me about dism",
            "Dism?",
            "cybersecurity course",
            "what is dism about?"},
        // what can you do
        {"what can you do?",
            "tell me about your functions",
            "help",
            "what can you do?",
            "what are your functions"
        },
        //query 
        {
            "what is a chatbot",
            "what are chatbots",
            "what is a chatbot?"
        },
        {
            "dmit",
            "tell me about dmit",
            "school of digital media and information technology"
        },
        {
            "commands",
            "command",
            "cmd",
            "help",
            
        }

    };
    // responsed to those inputs
    public String resdata[][] = {
        //response to greeting
        {"Hi, I'm DISM Chatbot, whitehat (0.0)/",
            "Hello to you too",
            "你好",
            "こんにちは"},
        //bye
        {"bye",
            "exit",
            "goodbye"},
        {"Just as soldiers are trained in the firing ranges before going onto the battle field, the new Cyber Wargame Centre will use cyber war-gaming approach to train our students in dealing with real-world security scenarios such as intrusion detection, incident response, forensics analysis and conducting remedial actions to mitigate the risks."
            + " Students build up their competence in effective teamwork, resourcefulness and working under pressure - key soft-skills of infocomm security professionals in the industry."
        },
        //intro sp

        {"This is Singapore polytechnic, the best polytechnic in singapore.  ;D",
            "SP is located at Dover Mrt, convenient for students all over singapore, enabling easy access",
            "Singapore Poly sports the highest number of ccas accross all tiertiery"

        },
        //qeury about dism 
        {"DISM is the Diploma in Infocomm security Management",
            "Being a DISM student gives you the competitive edge for a boost in your future studies and career.You can look forward to an interesting curriculum that covers offensive attacks, defensive methods and investigative skills."
        },
        //what can you do?
        {"I can provide you information about sp, dmit and dism",
            "What do you want me to do?",
            "many things, many many things",
            " -I can give you your computer name and ipaddress \n -I can play music with !start (name of song file) \n -I can google stuff for you with google (thing you google)",
            "I can tell you about dism, dmit and sp, just ask about them "
        },
        //query
        {"I'm a chatbot, duh",
            "I chat, what do you expect",
            "a computer program designed to simulate conversation with human users, especially over the Internet."

        },
        {
            "DMIT's history:JSIST was established in December 1980, by the Singapore Economic Development Board(EDB) as a cooperation project between Singapore and Japanese Governments."
        },
        
        {"-hi\n"+
         "-google (name of thing)\n"+
         "-nyancat\n"+
         "-when does sp open?\n"+
         "-!start (music file name) to play song\n"+
         "-ipaddress\n"+
         "-time\n"+
         "-date\n"+
         "-!add ques (question)\n"+
         "-!add ans (answer)\n"+
         "-open port (adds user created questions to question pool\n"+
         "-close port (removes user created questions from question pool"+
            "tempadd (allows adding of temporary questions)"
        }
    };

   String ans = null;
    ques nil = new ques("", "");

    static boolean exit = false;
    String que = null;
    String inar = "";
    String resar = "";
    boolean manythings = false;
    boolean things = false;
    static boolean bQuitProgram = false;
    public boolean setLineWrap = true;
    boolean tilted = false;
    boolean tempadding = false;
    boolean tempo = false;
    String sIn;
    String sOut;
    java.util.ArrayList<ques> qq = new ArrayList<>();
    Client() {
        addWindowListener(
                new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.out.println("Program closed!");
                dispose();
                System.exit(0);
            }
        }
        );
        tf = new TextField();
        tf.setBounds(40, 480, 680, 60);
        la = new Label("Whitehat Chatbot");
        la.setBounds(50, 100, 250, 20);
        d = new Button("Find IP");
        d.setBounds(50, 30, 60, 30);
        d.addActionListener(this);
        ta = new JTextArea();
        ta.setBounds(40, 40, 680, 400);
        a = new JButton("Enter");
        a.setBounds(760, 480, 100, 60);
        a.addActionListener(this);
        
        add(sp);
        add(ta);
        add(tf);
        add(la);
        add(a);

        ta.setLineWrap(true);
        ta.setWrapStyleWord(true);
        
        ta.setEditable(false);
        setSize(960, 600);
        setLayout(null);
        setVisible(true);
        ta.append(resdata[0][0] + "\n");
        setBackground(Color.PINK);

        /*    java.awt.EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
        toFront();
        
    }
});*/
        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                sl = tf.getText();

                int bye = ThreadLocalRandom.current().nextInt(0, 3);
                int r1 = ThreadLocalRandom.current().nextInt(0, 4);
                {

                    ta.append(">" + sl + "\n");
                    tf.setText("");
                    line = 1 + line;
                }

                boolean found = false;
                int chat = 0;
                int arrays = 0;
                //This 8 pieces of shit run my entire code

                for (arrays = 0; !found && arrays != sIndata.length; arrays++) {
                    for (int chats = 0; !found && chats != sIndata[arrays].length; chats++) {
                        if (sl.equalsIgnoreCase(sIndata[arrays][chats])) {
                            try{
                            chat = resdata[arrays].length;
                            int ops = ThreadLocalRandom.current().nextInt(0, chat);
                            ta.append(resdata[arrays][(ops)] + "\n");
                            found = true;
                            line = 2 + line;
                            }catch (Exception arrayout){System.out.println("answer not found");}
                        };
                    };
                };
                
                if (sl.equalsIgnoreCase("clear")) {
                    try{
                            ta.setText(null);
                            line = 0;
                        } catch (Exception f) {
                        }
                };

                if (line > 30) {
                    do {
                        try {

                            int end = ta.getLineEndOffset(0);
                            ta.replaceRange("", 0, end);
                            line = line - 1;
                        } catch (Exception f) {
                        }
                    } while (line > 30);
                };

                if (sl.contains("google")) {
                    String go = sl.replaceAll("google", "");
                    go = go.trim();
                    go = go.replaceAll(" ", "%20");
                    String goo = go;
                    try {
                        Runtime.getRuntime().exec(new String[]{"cmd", "/c", "start chrome https://www.google.com.sg/search?q=" + goo});
                    } catch (IOException q) {
                    };

                }
                //wacko =questions
                //wack = answers
                java.util.ArrayList<String> wack = new ArrayList<String>();
                java.util.ArrayList<String> wacko = new ArrayList<String>();
                try {
                    textfile file = new textfile("question.txt");
                    String[] questions = file.Openfile();
                    wacko = new ArrayList<String>(Arrays.asList(questions));
                    textfile filt = new textfile("answer.txt");
                    String[] answers = filt.Openfile();
                    wack = new ArrayList<String>(Arrays.asList(answers));
                } catch (IOException s) {
                };
                int rescrack = wack.size();
                int incrack = wacko.size();
                if (manythings == true) {
                    for (int addons = 0; things = true && addons != wacko.size(); addons++) {
                        if (sl.contains(wacko.get(addons))) {
                            try {
                                ta.append(wack.get(addons) + "\n");
                            } catch (ArrayIndexOutOfBoundsException exception) {
                                ta.append("Sorry, output not available");
                            }
                            line = 2 + line;
                        };
                        things = true;
                    };
                };

                if (sl.contains("open port")) {
                    manythings = true;
                    ta.append("error located on layer 8 \n" + manythings + "\n");
                }
                if (sl.contains("close port")) {
                    manythings = false;
                    ta.append("error located on layer 8 resolved \n" + manythings + "\n");
                }

                if (sl.contains("!add ques")) {
                    try {

                        inar = sl.replaceAll("!add ques", "");
                        inar = inar.trim();
                        ta.append("added " + inar + " question: index " + wacko.size() + "\n");
                        BufferedWriter in = new BufferedWriter(new FileWriter("question.txt", true));
                        in.append(inar);  //Replace with the string 
                        in.newLine();                                     //you are trying to write  
                        in.close();
                        line = line + 1;
                    } catch (IOException f) {
                        System.out.println("Exception ");
                    }
                } else if (sl.contains("!ans")) {
                    String ansadd = sl.replaceAll("!ans", "");
                    ansadd = ansadd.trim();

                } //answers
                else if (sl.contains("!add ans")) {
                    try {
                        resar = sl.replaceAll("!add ans", "");
                        resar = resar.trim();
                        ta.append("added " + resar + " answer: index " + wack.size() + "\n");
                        BufferedWriter in = new BufferedWriter(new FileWriter("answer.txt", true));
                        in.append(resar);  //Replace with the string 
                        in.newLine();                                     //you are trying to write  
                        in.close();
                        line = line + 1;
                    } catch (IOException f) {
                        System.out.println("Exception ");
                    }

                }
             

                if (sl.contains("!start")) {
                    String lilt = sl.replaceAll("!start", "");
                    lilt = lilt.trim();

                    try {
                        muse.mate(lilt);
                    } catch (Exception q) {
                        System.out.println("file not found");
                    }
                    line = line + 1;
                };

                if (sl.contains("adding ques")) {
                    que = sl.replaceAll("adding answer", "");
                    ans = sl.replaceAll("adding ques", "");

                }
                if (sl.contains("adding answer")) {

                    System.out.println(ans);

                };
                //ipaddress
                String ip = "";
                String host = "";
                String ipv = "";
                String local = "local";
                try {

                    ip = java.net.InetAddress.getLocalHost().getHostAddress();
                } catch (UnknownHostException ex) {
                    System.out.println(ex);
                }
                if (sl.equalsIgnoreCase("ipad")) {
                    ta.append(ip + "\n");

                } else if (sl.equalsIgnoreCase("ipaddress")) {
                    try {
                        InetAddress address = InetAddress.getLocalHost();
                        String hostIP = address.getHostAddress();
                        String hostName = address.getHostName();
                        ta.append("IP: " + hostIP + "\n" + "Name: " + hostName + "\n");
                    } catch (UnknownHostException ex) {
                        System.out.println(ex);

                    }
                };

                if (sl.equalsIgnoreCase("music")) {
                    ta.append("No songs found");
                    for (int i = 0; i < listOfFiles.length; i++) {
                        if (listOfFiles[i].isFile()) {
                            ta.append((i + 1) + "." + listOfFiles[i].getName());
                        } else {
                            ta.append("No songs found");
                        }
                    }
                }

                //log of chat (write to file)
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter("log.txt", true));
                    out.append(sl + "\n");  //Replace with the string 
                    out.newLine();                                     //you are trying to write  
                    out.close();
                } catch (IOException f) {
                    System.out.println("Exception ");
                }

                //nyan cat
                if (sl.equalsIgnoreCase("nyancat")) {
                    try {
                        Clip clip = null;
                        File in = new File("nyansound.wav");
                        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(in);
                        clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                        for (int ny = 0; ny < nyan.length; ny++) {
                            System.out.println("\n\n\n\n\n");
                            System.out.println(nyan[ny]);
                            TimeUnit.MILLISECONDS.sleep(330);
                            System.out.print(clear[0]);
                        }
                        clip.drain();
                    } catch (Exception nootnoot) {
                        ta.append("nyancat not found");
                    }
                }
                if (sl.equalsIgnoreCase("time")) {
                    DateFormat time = new SimpleDateFormat("HH:mm:ss");
                    Calendar cal = Calendar.getInstance();

                    ta.append(time.format(cal.getTime()) + "\n");
                    line = line + 1;

                }
                if (sl.contains("sp open")) {

                    Calendar calt = Calendar.getInstance();
                    int open = calt.get(Calendar.HOUR_OF_DAY);
                    if ((open > 7) && (open < 23)) {
                        ta.append("Singapore polytechnic is open.\n");
                    } else {
                        ta.append("Singapore polytechnic is closed. It opens at 7 and closes at 11\n");
                    }

                    line = line + 1;
                }
                if (sl.equalsIgnoreCase("date")) {
                    DateFormat date = new SimpleDateFormat("yyyy/MM/dd");
                    Calendar cale = Calendar.getInstance();
                    ta.append(date.format(cale.getTime()) + "\n");
                    line = line + 1;
                }
                if (tempo == true){
                 sOut = sl;   
                 ta.append("added "+ sOut +"\n");  
                 tempo = false;
                   ta.append("type save to save,else type tempadd to redo\n"); 
                }
                if( tempadding == true){
                   sIn = sl;
                   ta.append("added "+ sIn +"\n");
                   tempadding = false;
                   tempo = true;
                   ta.append("Now Accepting input for Tempory answers\n");  
                }
                if (sl.equalsIgnoreCase("tempadd")){
                tempadding = true;
                ta.append("Accepting string for temporary question \n");
            };
            if (sl.equalsIgnoreCase("save")){
                if ((sOut != "") && (sIn != "")){
                   ques tar = new ques(sIn,sOut);
                   qq.add(tar);
                   String testmaster = qq.get(qq.size()).getwn();
                   ta.append(testmaster+"\n");
                   String tesmaster = qq.get(qq.size()).getsns();
                   ta.append(tesmaster+"\n");
                }
                   else if (sIn == ("")){
                      ta.append("Your question is blank \n"
                                + "tempadd to redo from the start\n");
                   } 
                   else if (sOut == ("")){
                      ta.append("Your answer is blank \n"
                              + "tempadd to redo from the start\n");
                      
                           }  
                
            }
            for(int perps =0;perps<qq.size();perps++ ){
                if(sl.equalsIgnoreCase(qq.get(perps).getwn()))
                {
                    ta.append(qq.get(perps).getsns()+"\n");
                    
                }
                
                
            }
                things = false;

                sl = "";
                line = line + 1;
            }
        };
        tf.addActionListener(action);
        a.addActionListener(action);

    }

    public static void main(String args[]) throws IOException {

        Client gui = new Client();
        gui.setTitle("Whitehat Chatbot");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
