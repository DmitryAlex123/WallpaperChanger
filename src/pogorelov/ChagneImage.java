package pogorelov;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.W32APIOptions;
import controller.wallChangerController;
import model.NumPath;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.TimerTask;

public class ChagneImage extends TimerTask {

    ArrayList<File> folderItemsList = wallChangerController.getList();

    Random random = new Random();
    static int reload;

    public void run() {
        int i = random.nextInt(folderItemsList.size());
        if (reload == i){
            i = random.nextInt(folderItemsList.size());
        }
        String path = folderItemsList.get(i).getPath();
        User32.INSTANCE.SystemParametersInfo(0x0014, 0, path , 1);
        reload = i;
    }

    public interface User32 extends Library {
        User32 INSTANCE = Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);
        boolean SystemParametersInfo (int one, int two, String s ,int three);
    }
}
