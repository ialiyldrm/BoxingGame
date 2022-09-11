public class Match {
    Fighter f1;
    Fighter f2;
    int minWeight;
    int maxWeight;


    Match(Fighter f1,Fighter f2,int minWeight,int maxWeight){
        this.f1=f1;
        this.f2=f2;
        this.minWeight=minWeight;
        this.maxWeight=maxWeight;
    }


    public void run(){             //boks bu kod dizisinde olacak.Önce sikletlerini kontrol ediyoruz.
        if(isCheck()){
            int round=1;
            while(this.f1.health>0 && this.f2.health>0){
                System.out.println("======== " + round + ".ROUND ===========");
                double whoIsStart=Math.random()*100; //ilk kimin dövüşe başlayacağını %50 olasılık ile hesaplanması
                if(whoIsStart<=50){
                    f2.health = f1.hit(f2);
                    if (isWin()){
                        break;
                    }
                    f1.health = f2.hit(f1);
                    if (isWin()){
                    break;
                    }
                }else{
                    
                    f1.health = f2.hit(f1);
                    if (isWin()){
                        break;
                    }
                    f2.health = f1.hit(f2);
                    if (isWin()){
                    break;
                    }
                }
                printScore();
                round++;

            }

        }else{
            System.out.println("Sporcuların sikletleri uymuyor!");
        }
    }


    public boolean isCheck(){//Oyuncuların sikletlerini kontol ettiğimiz metod.
        return((this.f1.weight >= minWeight && this.f1.weight <=maxWeight)&&(this.f2.weight >= minWeight && this.f2.weight <=maxWeight));
    }

    
    public boolean isWin() {
        if (f1.health == 0) {
            System.out.println("Maçı Kazanan : " + f2.name);
            return true;
        } else if (f2.health == 0){
            System.out.println("Maçı Kazanan : " + f1.name);
            return true;
        }

        return false;
    }


    public void printScore() {
        System.out.println("------------");
        System.out.println(f1.name + " Kalan Can \t:" + f1.health);
        System.out.println(f2.name + " Kalan Can \t:" + f2.health);
    }

}
