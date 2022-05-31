package LLD.notificationService;

public class WhatsApp implements NotificationChannel {

    @Override
    public void send() {
        System.out.println("Sending whatsapp");
    }
}
