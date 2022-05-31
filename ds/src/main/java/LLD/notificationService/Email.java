package LLD.notificationService;

public class Email implements NotificationChannel
{
    @Override
    public void send() {
        System.out.println("Sending email ");
    }
}
