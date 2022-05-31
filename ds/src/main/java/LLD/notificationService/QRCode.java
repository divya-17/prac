package LLD.notificationService;

/*
Bridge design pattern is used.
 */
public class QRCode implements NotificationMessage {

    NotificationChannel channel;

    public QRCode(NotificationChannel channel){
        this.channel=channel;
    }
    @Override
    public void sendNotification() {
        System.out.println("Message is of type QRcode. ");
        channel.send();
    }
}
