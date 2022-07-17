import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

public class main {
    public static void main(String[] args) {
        String saveFilePath = "D:\\";

        LocalTime now;

        DateTimeFormatter formatter;
        String formateNow;
        //파일명을 시간 수치를 더하여 저장
        String saveFileName;
        String saveFileExtension = "png";

        int minute;
        while(true) {
            now = LocalTime.now();
            minute = now.getMinute();
            try {
                if(minute == 40) {
                    //쓰레드는 나중에 사용예제 작성
                    formatter = DateTimeFormatter.ofPattern("HH_mm_ss");
                    formateNow = now.format(formatter);
                    saveFileName = "capture"+formateNow;
                    System.out.println(saveFileName);
                    CaptureProcess(saveFilePath, saveFileName, saveFileExtension);
                }else if(minute == 30) {
                    formatter = DateTimeFormatter.ofPattern("HH_mm_ss");
                    formateNow = now.format(formatter);
                    saveFileName = "capture"+formateNow;
                    System.out.println(saveFileName);
                    CaptureProcess(saveFilePath, saveFileName, saveFileExtension);
                }
                System.out.println("현재 시간 : " + minute);
                TimeUnit.SECONDS.sleep(60);
            }catch (Exception e) {
                System.out.println(e);
            }


        }
        
        //시간을 불러오는 변수
        
        //시간을 불러오는 변수의 수치를 확인하여 캡쳐 메서드 실행


    }

    private static void CaptureProcess(String saveFilePath, String saveFileName, String saveFileExtension) {
        try {
            Robot robot = new Robot();
            Rectangle rectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage image = robot.createScreenCapture(rectangle);
            image.setRGB(0,0,100);

            File file = new File(saveFilePath+saveFileName+"."+saveFileExtension);
            ImageIO.write(image, saveFileExtension, file);
            System.out.println("-------------캡쳐 완료 되었습니다------------"+saveFileName);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
