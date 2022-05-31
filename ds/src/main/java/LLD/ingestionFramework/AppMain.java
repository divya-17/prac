package LLD.ingestionFramework;

public class AppMain {

    public static void main(String[] args) {

        OnPremiseStorage onPremiseStorage = new OnPremiseStorage();
        IngestToDatabase ingestDataObjForOnPremis = onPremiseStorage.getInstanceOfSource("FILE");

        ingestDataObjForOnPremis.ingestData();

        CloudStorage cloudStorage = new CloudStorage();
        IngestToDatabase ingestToDatabaseObjForCloud = cloudStorage.getInstanceOfSource("API");
        ingestToDatabaseObjForCloud.ingestData();;
    }

}
