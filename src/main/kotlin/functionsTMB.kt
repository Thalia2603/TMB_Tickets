/**
 *function that asks user for their option, prints options, validates data and returns the option
 * @author Thalia2603
 * @since 04/01/2024
 * @return userOption value of option
 */
fun mainMenuOpcions():Int{
    var userOption=readIntMenu( "Quin bitllet desitja adquirir?" +
            "\n1 - Bitllet senzill" +
            "\n2 - TCasual" +
            "\n3 - TUsual" +
            "\n4 - TFamiliar" +
            "\n5 - TJove",
        pMin = 1, pMax = 5)
    return userOption
}
/**
 *This method asks user zone, prints zone, validates input and returns zone
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @return userZoneInput value of the zone user chooses
 */
fun zoneMenu():Int{
    val userZoneInput=readIntMenu("A quina zona vol viatjar?\n1\n2\n3",1, 3)
    return userZoneInput
}
/**
 *This method gets the base price of ticket, adds the zone price increment to the base price , and returns the final sum of ticket
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @param pUserOption value of ticket option
 * @param pZone value of the zone
 * @return priceFinal final price of ticket (with decimals)
 */
fun calculatePricePerTicket(pUserOption:Int ,pZone:Int):Float{
    val basePrice=getBasePriceTicket(pUserOption)
    val priceFinal=addZonePrice(basePrice, pZone)
    return priceFinal
}
/**
 *This method gets the base price of the ticket chosen by user from an array that contains all prices
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @param pUserOption value of ticket option
 * @return basePriceTicket base price of ticket
 */
fun getBasePriceTicket(pUserOption:Int):Float{
    var stilShoppingBoolean=false
    val pricesPerOption= floatArrayOf(2.40f,11.35f,40.00f,10.00f,80.00f)
    val basePriceTicket=(pricesPerOption[pUserOption-1])//this makes pUserOption match teh index of ticket in pricesPerOption
    return basePriceTicket
}
/**
*This method asks the user if they want to continue shopping (si/no) and returns boolean
* @author Thalia2603, annacano0
* @since 04/01/2024
* @return stillShopBoolean true/false
*/
fun stillShooping():Boolean{
    var stillShopBoolean=readStringSiNo("Vols seguir comprant? (si/no)")
    return stillShopBoolean
}
/**
 *This adds zone supplement to the base price of ticket and returns final price
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @param pBasePrice base price of ticket
 * @param pZone zone chosen by user
 * @return finalPriceTicket final sum of price for ticket
 */
fun addZonePrice(pBasePrice:Float, pZone:Int):Float{
    
    var finalPriceTicket=pBasePrice//initial price doesn't change if zone==1
    if (pZone==3){
        finalPriceTicket=(finalPriceTicket*1.8443).round(2)//if zone is 3, the price is multiplied by 1.8443 to get total
    }
    else if (pZone==2){
        finalPriceTicket=(finalPriceTicket*1.3125).round(2)//if zone is 2, the price is multiplied by 1.3125 to get total
    }
    return (finalPriceTicket)
}
/**
 *This method adds the ticket options chosen by user to three mutable lists, organized by ticket names, ticket zones, ticket prices.
 * This will make the data more manageable
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @param pUserOption value of ticket chosen (later transformed to name)
 * @param pUserZone value of ticket zone
 * @param pUserPrice value of ticket price
 * @param pNames MutableList with all ticket names
 * @param pZones MutableList with all ticket zones
 * @param pPrices MutableList with all ticket prices
 */
fun addUserOptionToReceipt(pUserOption:Int,
                           pUserZone:Int,
                           pUserPrice:Float,
                           pNames:MutableList<String>,
                           pZones:MutableList<Int>,
                           pPrices:MutableList<Float>){
    val ticketNamesList=arrayOf("Bitllet Senzill", "TCasual", "TUsual", "TFamiliar","TJove")
    val ticketName=ticketNamesList[pUserOption-1]
    //we add the user ticket to the mutable lists
    pNames.add(ticketName)
    pZones.add(pUserZone)
    pPrices.add(pUserPrice)
}
/**
 *This method gets all the options added by user to the three ticket lists and prints them with the format of a receipt (message)
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @param pNames MutableList with all ticket names
 * @param pZones MutableList with all ticket zones
 * @param pPrices MutableList with all ticket prices
 */
fun printTicketLists(pNames:MutableList<String>, pZones:MutableList<Int>, pPrices:MutableList<Float>){
    var printTicket=readStringSiNo("Desitja tiquet? (si/no)")
    if (printTicket){
        println("___________TIQUET__________")
        for (i in 0..pNames.size-1){
            println(pNames[i]+" Zona "+pZones[i]+ " - Preu: "+ pPrices[i]+"€")//printa todos los tiquets añadidos a las listas mutables
        }
        println("___________________________")
    }

}
/**
 *This method prints message with the price of the added ticket
 * @author Thalia2603, annacano0
 * @since 04/01/2024
 * @param pPrice price of added (current) ticket
 */
fun printAddedTicket(pPrice:Float){
    println("El preu del bitllet es "+pPrice+"€")
}

fun payment(pPrices:MutableList<Float>){
    var totalPayment=0.0f
    for (i in 0..pPrices.size-1){
        totalPayment+=pPrices[i]
    }
    println("Ha comprat "+pPrices.size+" bitllets, ha de pagar "+totalPayment+"€")

}
fun showMoneyMenu(){
    println("----------------------------")
    println("Sel.leccioni amb què vol pagar")
    println("1 - 50€")
    println("2 - 20€")
    println("3 - 10€")
    println("4 - 5€")
    println("5 - 2€")
    println("6 - 1€")
    println("7 - 0.50€")
    println("8 - 0.20€")
    println("9 - 0.10€")
    println("10 - 0.05€")
}

fun moneyMenuOptions(listOfMoney: MutableList<Int>):MutableList<Int>{
    showMoneyMenu()
    var option: Int
    do {
        println()
        option =readIntMenu("Amb què pagarà (introdueixi 0 per sortir): ", 1,5)

        if (option != 0) {
            listOfMoney.add(option)
        }
    } while (option != 0)
    return listOfMoney
}

fun priceTransform(listOfMoney:MutableList<Int>):Double{
    val price=0
    var sumPrice=0.0
    for (i in listOfMoney){
        when (listOfMoney[i]){
            1 -> price==50
            2 -> price==20
            3 -> price==10
            4 -> price==5
            5 -> price==2
            6 -> price==1
            7 -> price.toDouble() ==0.50
            8 -> price.toDouble() ==0.20
            9 -> price.toDouble() ==0.10
            10 -> price.toDouble() ==0.05
        }
        sumPrice+=price
    }
    return sumPrice.toDouble()
}

fun change(sumPrice:Double,totalPayment:Float){
    val priceReturn=totalPayment-sumPrice
    println("El seu canvi és de $priceReturn")
}