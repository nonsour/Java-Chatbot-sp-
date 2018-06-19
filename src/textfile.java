import java.io.*;
// reads a txt files

public class textfile{
    private String path;
public textfile(String file_path){
    path = file_path;
}
 public String [] Openfile() throws IOException{   
    FileReader fr = new FileReader(path);
    BufferedReader textReader = new BufferedReader(fr);
            int numberOfLines = readFile();
            String[] textData = new String[numberOfLines];
            int i;

            for (i = 0; i < numberOfLines; i++) {
                textData[i] = textReader.readLine();
            }
            textReader.close();
        return textData;
};
int readFile() throws IOException {
    FileReader file_to_read = new FileReader(path);
    BufferedReader bf = new BufferedReader(file_to_read);
    String aline;
    int numberoflines = 0;
    while ((aline = bf.readLine()) != null){
        numberoflines++;
    } bf.close();
    return numberoflines;
    }
}









  