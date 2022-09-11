public class Fighter {
    String name;
    double maxDamage;
    double damage;
    double health;
    double weight;
    double dodge;

    Fighter(String name,double maxDamage,double health,double weight,double dodge){
        this.name=name;
        this.maxDamage=maxDamage;       //Rastgele oluşan hasarın olabileceği max degeri belirliyor.
        this.damage=Math.random()*100; //Dövüşçünün vuracağı hasar rastgele belirleniyor.
        this.health=health;
        this.weight=health;
        this.dodge=dodge;
    }


    public double hit(Fighter foe) {
        System.out.println("------------");
        if(this.damage<=this.maxDamage){
            System.out.println(this.name + " => " + foe.name + " " +  this.damage + " hasar vurdu.");
        }
        else if(this.damage>this.maxDamage){
            this.damage=this.maxDamage;//Rastgele belirlenen hasar maximum değerden fazla ise hasarı max değere eşitliyor.
            System.out.println(this.name + " => " + foe.name + " " +  this.maxDamage + " hasar vurdu.");
        }
        

        if (foe.dodge()) {
            System.out.println(foe.name + " gelen hasarı savurdu.");
            return foe.health;
        }

        if (foe.health - this.damage < 0)
            return 0;

        return foe.health - this.damage;
    }

    public boolean dodge() {
        double randomValue = Math.random() * 100;  //0.0 to 99.9
        return randomValue <= this.dodge;
    }
}
