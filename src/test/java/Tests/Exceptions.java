package Tests;

import org.omg.Messaging.SyncScopeHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exceptions {

    //check expeption, se puede manejar con throw o try & catch, el padre es  EXCEPTION class
public void getData()  {
    try{
        File f = new File("D:\\Read.txt");
        FileReader fr = new FileReader(f);
       // System.out.println(fr.read());
        System.out.println("Start");
    }
    catch (FileNotFoundException e)
    {
       System.out.println("File not found in that path");
    }
    System.out.println("End");
  }
}
