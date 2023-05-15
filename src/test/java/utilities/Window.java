package utilities;

import java.util.Set;

public class Window {

    private static String mainWindow;
    public static void switchToSecondWindow() {
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
         mainWindow=Driver.getDriver().getWindowHandle();
        if (windowHandles.size() < 2) {
            System.out.println("No multiple window found");
        }else{
            for(String windowID:windowHandles){
                if(!windowID.equals(mainWindow)){
                    Driver.getDriver().switchTo().window(windowID);
                }
            }
        }
    }

    public static void switchToMainWindow() {
        if (mainWindow != null) {
            Driver.getDriver().switchTo().window(mainWindow);
        }
    }

    public static void switchToWindow(String title){
        mainWindow=Driver.getDriver().getWindowHandle();
        Set<String> windowHandles=Driver.getDriver().getWindowHandles();
        if(windowHandles.size()<2){
            System.out.println("No multiple window found");
        }else{
            for(String windowId:windowHandles){
                Driver.getDriver().switchTo().window(windowId);
                if(title.equals(Driver.getDriver().getTitle())){
                    break;
                }
            }
        }
    }
}
