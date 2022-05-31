package LLD.notificationService;

public class TextMessage implements NotificationMessage {

    NotificationChannel channel;

    public TextMessage(NotificationChannel channel){
        this.channel=channel;
    }

    @Override
    public void sendNotification() {
        System.out.println("Notification is of type text");
        channel.send();
    }
}
