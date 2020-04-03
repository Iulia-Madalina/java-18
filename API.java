public class API {
    public static void main(String[] args) {

        Phone samsungGalaxyC9 = new SamsungGalaxyC9("gold", "metal", "9904682471854");
        Phone iPhone4 = new IPhone4("white", "plastic", "351756051523999");
        Phone iPhone11 = new IPhone11("black", "metal", "990000862471854");
        Phone samsungGalaxySII = new SamsungGalaxySII("blue", "plastic", "356938035643809");


        System.out.println("<------- Samsung Galaxy C9 --------->");
        samsungGalaxyC9.addContact(new Contact("112", "servicii", "urgenta"));
        samsungGalaxyC9.addContact(new Contact("0757066737", "Raicu", "Madalina"));
        samsungGalaxyC9.addContact(new Contact("0765432198", "Popescu", "Andrei"));
        samsungGalaxyC9.listContacts();

        System.out.println("<------- Iphone 4 --------->");
        iPhone4.call("0757066737");
        iPhone4.viewHistory();


        System.out.println("<------- Samsung Galaxy SII --------->");
        samsungGalaxySII.sendMessage("0757066737", "Ce mai faci?");
        samsungGalaxySII.sendMessage("0757066737", "Unde esti?");
        samsungGalaxySII.sendMessage("0757066737", "Cand ajungi?");
        samsungGalaxySII.sendMessage("0757066737", "Ne vedem la 3.");
        samsungGalaxySII.sendMessage("112", "Hai sa vorbim la telefon!");
        samsungGalaxySII.sendMessage("112", "Care este problema?");
        samsungGalaxySII.sendMessage("112", "Suntem la usa.");
        samsungGalaxySII.listMessages("112");

        System.out.println("<------- Samsung Iphone 11 --------->");
        //valid number test
        iPhone11.call("113");
        //batterylife test
        for (int i=0; i < 10; i++){
            iPhone11.call("112");
        }





    }

}
