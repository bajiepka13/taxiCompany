
/**
 * Created by skydock on 21.07.2016.
 */
public class Main {

    public Main(){}

    public static void main(String[] args) {

        /* загружаемся из файла по-умолчанию */
        Controller.initTaxiPark();

        /* запускаем фабрику */
        Controller.createCarFrmFactory();

        /* сохраняемся в файл по-умолчанию */
        Controller.saveTaxiPark();

    }
}
