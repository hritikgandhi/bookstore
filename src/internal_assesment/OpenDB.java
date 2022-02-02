package internal_assesment;
import java.awt.*;
import java.io.File;
import java.io.IOException;
 
public class OpenDB 
{
 
    public void open() throws IOException {
        
        File file = new File("C:\\Users\\Hritik Gandhi\\OneDrive\\Netbeans\\Internal_Assesment\\db1.accdb");
        if(!Desktop.isDesktopSupported()){
            System.out.println("Desktop is not supported");
            return;
        }
         
        Desktop desktop = Desktop.getDesktop();
        if(file.exists()) desktop.open(file);
    }
 
}
