package com.company;

public class Main {
    Player p1;
    Player p2;
    Main(Player p1, Player p2){
        this.p1=p1;
        this.p2=p2;
    }

    public void ArenaWithItem(){
        Player attacker = this.p1;
        Player defense = this.p2;
        Player temp;

        while (true){
            System.out.println(attacker.getName() + " Menyerang " + defense.getName());
            attacker.attackWithItem(defense);
            temp=attacker;
            defense.tampilStat();
            attacker.tampilStat();

            if(defense.isDeath()){
                defense.cekLife();
                break;
            }

            attacker=defense;
            defense=temp;
        }
    }

    public void ArenaNoItem(){
        Player attacker = this.p1;
        Player defense = this.p2;
        Player temp;

        while (true){
            System.out.println(attacker.getName() + " Menyerang " + defense.getName());
            attacker.attack(defense);
            temp=attacker;
            defense.tampilStat();
            attacker.tampilStat();

            if(defense.isDeath()){
                defense.cekLife();
                break;
            }

            attacker=defense;
            defense=temp;
        }
    }

    public static void main(String[] args) {
        //No.1
        Player Dark = new Player("Dark", "player", 500);
        Player Slime = new Player("Slime", "monster", 100);

        //No.2 tampilan nama,type,dan healthpoint

//        Dark.tampilStat(1);
//        Slime.tampilStat(2);

        //No.3 Skenario Utama
//        System.out.println("Dark menyerang Slime");
//        Dark.attack(Slime);
//        Dark.tampilStat(1);
//        Slime.tampilStat(2);
//
//        System.out.println("Slime menyerang Dark");
//        Slime.attack(Dark);
//        Dark.attack(Slime);
//        Dark.tampilStat(1);
//        Slime.tampilStat(2);

//cek kehidupan

//        Dark.cekLife();
//        Slime.cekLife();

        //No.5
        Main battle = new Main(Dark,Slime);
       // battle.ArenaNoItem();

        //No.I
//        Dark.attack(Slime);
//        Slime.tampilStat();
//        Slime.healingSpell();
//        Slime.tampilStat();
        //No.II
        Dark.collectItem();
        Slime.collectItem();
        Dark.level=1;
        Dark.attackWithItem(Slime);
        Dark.tampilStat();
        Slime.tampilStat();
//        battle.ArenaWithItem();







    }
}
