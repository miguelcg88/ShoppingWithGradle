package Tests;

import com.sun.org.apache.xerces.internal.impl.xs.util.XSInputSource;
import org.omg.Messaging.SyncScopeHelper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exceptions {

//    check expeption, se puede manejar con throw o try & catch, el padre es  EXCEPTION class
//        ejm
//     catch (Exception e)
//    {
//        System.out.println("Arithmetic exception division by zero");
//    }
public void getData()  {
    try{
        File f = new File("D:\\Read.txt");
        FileReader fr = new FileReader(f);
        int i = 8;
        int j = 0;
        int k = i/j;
        System.out.println(k);
       // System.out.println(fr.read());
        System.out.println("Start");
    }
    catch (FileNotFoundException e)
    {
       System.out.println("File not found in that path");
    }
    catch (ArithmeticException e)
    {
        System.out.println("Arithmetic exception division by zero");
    }
    finally {
        System.out.println("End finally block");
    }
  }

  //Throw es para lanzar una EXCEPTION manualmente
    public void getData2(int a){
       if (a<10)
           throw (new ArithmeticException());
    }

    public void forDebugging(){
        int i = 8;
        int j = 0;
        int k = i/j;
        System.out.println(k);
        System.out.println("error");
    }
}

