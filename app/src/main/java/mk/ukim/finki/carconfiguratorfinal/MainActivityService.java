package mk.ukim.finki.carconfiguratorfinal;


import java.util.List;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Classes.MercedesClasses;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Country.ConfigurationCountries;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.Model.Model;
import mk.ukim.finki.carconfiguratorfinal.RetrofitClasses.ModelDetails.Configuration;
import mk.ukim.finki.carconfiguratorfinal.StrategyPattern.CarEngineService;
import mk.ukim.finki.carconfiguratorfinal.StrategyPattern.FuelEconomyService;
import mk.ukim.finki.carconfiguratorfinal.StrategyPattern.NetPriceService;
import mk.ukim.finki.carconfiguratorfinal.StrategyPattern.NumberOfSeatsService;
import mk.ukim.finki.carconfiguratorfinal.StrategyPattern.PriceService;
import mk.ukim.finki.carconfiguratorfinal.StrategyPattern.TopSpeedService;

public class MainActivityService {

    /***
     * This is not a typical service that works in the background, its more of a helper class for the MainActivity.
     * We used the strategy pattern here so that ic SubService (All the variables) can implement the same method, but override it
     * by there own needs.
     */

    //Variables
    private CarEngineService carEngineService;
    private FuelEconomyService fuelEconomyService;
    private TopSpeedService topSpeedService;
    private NumberOfSeatsService numberOfSeatsService;
    private PriceService priceService;
    private NetPriceService netPriceService;

    //Initialization of the variables that are needed so the service class can work
    public MainActivityService(){
        carEngineService = new CarEngineService();
        fuelEconomyService = new FuelEconomyService();
        topSpeedService = new TopSpeedService();
        numberOfSeatsService = new NumberOfSeatsService();
        priceService = new PriceService();
        netPriceService = new NetPriceService();
    }

    //Creating array with the api key as the only element
    public String[] createArray(String api_key){
        String[] list = new String[1];
        list[0] = api_key;
        return list;
    }

    //Converting a list to array, this method gets a list and turns it into an array, main purpose is for the tasks input data.
    public String[] convertListToArray(List<String> list){
        String[] strings = new String[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            strings[i] = list.get(i);
        }
        return strings;
    }

    //Formatting a link, split the link on the character '?' and return the first half
    public String formatLink(String link){
        String[] split_link = link.split("\\?");
        return split_link[0] + "/";
    }

    //StringBuilders (Not in usage)
   /* public StringBuilder carTopSpeed(List<String> names, List<String> values){
        return topSpeedService.createString(names,values);
    }

    public StringBuilder carFuelEconomy(List<String> names, List<String> values){
        return fuelEconomyService.createString(names, values);
    }

    public StringBuilder carEngineString(List<String> names, List<String> values) {
        return carEngineService.createString(names, values);
    }*/

    //Creating lists
    //createNamesCarEngine is a method in the carEngineService it creates a list of names.
    public List<String> createNamesCarEngine(){
        return carEngineService.createNames();
    }

    //createValuesCarEngine is a method in the carEngineService it creates a list of values from data in the Configuration object carConfiguration.
    public List<String> createValuesCarEngine(Configuration carConfiguration){
        return carEngineService.createValues(carConfiguration);
    }

    //createNamesFuelEconomy is a method in the fuelEconomyService it creates a list of names.
    public List<String> createNamesFuelEconomy(){
        return fuelEconomyService.createNames();
    }

    //createValuesFuelEconomy is a method in the fuelEconomyService it creates a list of values from data in the Configuration object carConfiguration.
    public List<String> createValuesFuelEconomy(Configuration carConfiguration){
        return fuelEconomyService.createValues(carConfiguration);
    }

    //createNamesTopSpeed is a method in the topSpeedService it creates a list of names.
    public List<String> createNamesTopSpeed(){
        return topSpeedService.createNames();
    }

    //createValuesTopSpeed is a method in the topSpeedService it creates a list of values from data in the Configuration object carConfiguration.
    public List<String> createValuesTopSpeed(Configuration carConfiguration){
        return topSpeedService.createValues(carConfiguration);
    }

    //createNamesNumberOfSeats is a method in the numberOfSeatsService it creates a list of names.
    public List<String> createNamesNumberOfSeats(){
        return numberOfSeatsService.createNames();
    }

    //createValuesNumberOfSears is a method in the numberOfSeatsService it create a list of values that collected from the Configuration object carConfiguration.
    public List<String> createValuesNumberOfSeats(Configuration carConfiguration){
        return numberOfSeatsService.createValues(carConfiguration);
    }

    //createNamesPrice is a method in the priceService it returns a list of names;
    public List<String> createNamesPrice(){
        return priceService.createNames();
    }

    //createValuesPrice is a method in the priceService it returns a list of values that are collected from the Configuration object carConfiguration.
    public List<String> createValuesPrice(Configuration carConfiguration){
        return priceService.createValues(carConfiguration);
    }

    //createNamesNetPrice is a method in the netPriceService that returns a list of names
    public List<String> createNamesNetPrice(){
        return netPriceService.createNames();
    }

    //createValuesNetPrice is a method in the netPriceService that returns a list of values collected from the Configuration object carConfiguration
    public List<String> createValuesNetPrice(Configuration carConfiguration){
        return netPriceService.createValues(carConfiguration);
    }

    //Finding objects

    //findModel is a function that has 2 input parameters modelName and modelList
    //modelName is a string with the model of car name
    //modelList is a list of object from Model class
    //it returns an object of the Model class
    public Model findModel(String modelName, List<Model> modelList){
        for(Model model: modelList)
            if(model.getModelName().equals(modelName))
                return model;
        return null; //It never gets to this point, because the modelName must always be in the modelList.
    }

    //findCountryObjectByClass is a function with 2 input parameters name and list_classes
    //name is the class name that we are searching
    //list_classes is the list of object from the MercedesClasses
    //it returns an object of the MercedesClasses
    public MercedesClasses findCountryObjectByClass(String name, List<MercedesClasses> list_classes){
        for(MercedesClasses object: list_classes)
            if(name.equals(object.getClassName()))
                return object;
        return null;
    }

    //findCountryObject is a function with 2 input parameters name and list_country
    //name is the country name that we are searching
    //list_countries is the list of object from the ConfigurationCountries
    //it returns an object of the ConfigurationCountries
    public ConfigurationCountries findCountryObject(String name, List<ConfigurationCountries> list_countries){
        for (ConfigurationCountries item : list_countries)
            if (item.getCountry().equals(name))
                return item;
        return null;
    }

}
