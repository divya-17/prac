package LLD.notificationService;

public class SMS implements NotificationChannel {

    @Override
    public void send() {
        System.out.println("Sending SMS");
    }
}
