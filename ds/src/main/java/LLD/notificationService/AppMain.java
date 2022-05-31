package LLD.notificationService;

/*
Illustration of bridge design pattern.
Need to design notification service that supports following send channels:

1- SMS
2- Email
3- Whatsapp

It also supports following types of messages:

1- Text
2- QR code.

 */
public class AppMain {


    public static void main(String[] args) {

        SMS smsChannel = new SMS();
        Email emailChannel = new Email();
        WhatsApp whatsApp = new WhatsApp();


        TextMessage textMessage = new TextMessage(smsChannel);
        textMessage.sendNotification();
        System.out.println();

        TextMessage textMessage1 = new TextMessage(emailChannel);
        textMessage1.sendNotification();
        System.out.println();


        QRCode qrCode = new QRCode(whatsApp);
        qrCode.sendNotification();
    }

}
